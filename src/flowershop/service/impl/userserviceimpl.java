package flowershop.service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import flowershop.dao.*;
import flowershop.entity.*;
import flowershop.dao.impl.*;
/*
 * 用户工具类 
 * 包含用户购买花朵等管理用户的方法
 */
public class userserviceimpl extends basedao{
	//Map<String, List<Consumption>> consumInfos = new HashMap<String, List<Consumption>>();//每个账户对应一个  结算单消费记录
	//Map<String, List<Consumption>> buyCar = new HashMap<String, List<Consumption>>();//购物车
	Map<String, user> u = new HashMap<String, user>();//用户信息
	Map<String, cart> Cartss = new HashMap<String, cart>();
	flowershopserviceimpl b = new flowershopserviceimpl();//花店信息
	cart c = new cart();

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句
	public Object[][] obj = new Object[100][7];
	private ResultSet rs = null; // 用户保存查询结果集
	private Map<String, List<consumption>> consumInfos;
	private Map<String, List<consumption>> buyCar;
	
	
	public 	Map<String, cart> Initcart() {
		Cartss.clear();
		try {
		String preparedSql = "select * from carts";
		conn = getConn();// 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				cart Carts = new cart();
				Carts.cid=(rs.getString(1));
				Carts.oid=(rs.getString(2));
				Carts.fid=(rs.getString(3));
				Carts.fname=(rs.getString(4));
				Carts.fnum=(rs.getInt(5));
				Carts.sum=(rs.getInt(6));
				Cartss.put(Carts.cid,Carts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return Cartss;
	}
	
	
	public void Inituser() {
		String flag=null;
		try {
		String preparedSql = "select * from users";
		conn = getConn();// 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				user Users = new user();
				Users.uid=(rs.getString(1));
				Users.ucount=(rs.getString(2));
				Users.upassword=(rs.getString(3));
				Users.cash=(rs.getDouble(4));
				Users.score=(rs.getInt(5));
				if(Users.score>500) {
					String updateSql = "update users set vipclass=? where fid=?";//插入订单信息
					Object[] ownerParam = {"白金会员",Users.uid };	
					int updateOwner = executeSQL(updateSql, ownerParam);
				}
				if(Users.score>200) {
					String updateSql = "update users set vipclass=? where fid=?";//插入订单信息
					Object[] ownerParam = {"黄金会员",Users.uid };	
					int updateOwner = executeSQL(updateSql, ownerParam);
				}
				Users.Type=(rs.getString(6));
				if(Users.Type.equals("白金会员")) {
					Users.discount=0.5;
				}
				if(Users.Type.equals("黄金会员")) {
					Users.discount=0.8;
				}
				if(Users.Type.equals("普通会员")) {
					Users.discount=1.0;
				}

				flag=String.valueOf(Users.uid);
				u.put(Users.ucount,Users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
	}
	
	public userserviceimpl() {//构造函数初始化增加了一些用户信息 利用HashMap

		Inituser();
		Initcart();
	}
	
	public boolean addCar(user user,flower flower,int num) {//加入购物车（改变商店的库存信息，但是只有在支付后才改变销售量）
		//Consumption c = new Consumption(user,flower,num);
		
		if(num>b.searchID(flower.getFid()).getFstocksum() || num<0) {
			System.out.println("库存不够或者输入有误");
			return false;
		}
		
		String updateSql = "insert into carts(oid,fid,fname,fnum,fsum) values (?,?,?,?,?)";//插入订单信息
		Object[] ownerParam = {user.uid,flower.fid,flower.fname,num,num*flower.fprice};	
		int updateOwner = executeSQL(updateSql, ownerParam);

		b.del_num(flower.fid, num);//减少对应订单记录数量
		b.add_sale(flower.fid, num);
		
		return true;
	}
	
	public void clearCar(user user) {//清空购物车
		String updateSql = "delete from carts where oid=?";//插入订单信息
		Object[] ownerParam = {user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Initcart();
	}
	
	public double sums(user user) {//计算购物车商品总价钱
		double sums=0;
		Set<String> keys=Cartss.keySet();  
		for(String key:keys) {
			cart f = Cartss.get(key);
		    if(f.oid.equals(user.uid)) {
		    	sums+=f.sum;
		    }
		}
		return sums;
	}
	
	public void putin(user user,int num) {
		String updateSql = "update users set cash=? where fid=?";//插入订单信息,减少账户金额
		Object[] ownerParam = {user.cash+num,user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Inituser();
	}
	
	public void pay(user user) {//支付购物车内的物品（改变花店库存和销售信息），之后购物车清空

		
		double less=sums(user)*user.discount;
		String updateSql = "update users set cash=? where fid=?";//插入订单信息,减少账户金额
		Object[] ownerParam = {(user.cash-less),user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		String updateSqlc = "update users set score=? where fid=?";//插入订单信息，增加积分
		Object[] ownerParamc = {(user.score+less),user.uid };	
		int updateOwnerc = executeSQL(updateSqlc, ownerParamc);
		this.clearCar(user);
		Inituser();
	}
	

	public boolean isExistUser(String number, String passWord) {//登陆认证
		if(isExistUser(number)) {
			if(u.get(number).getUpassword().equals(passWord)) {
				return true;
			}
		}
		return false;
	}
	
    public boolean isExistUser(String searchNumber) {//用户是否存在
		if(u.containsKey(searchNumber)) {
			return true;
		}
		return false;
	}
	
    public boolean addUser(String number, String passWord ) {//添加新的用户 这里默认为普通用户

		regularcus r = new regularcus(number,passWord);
		if(!isExistUser(number)) {
			String updateSql = "insert into users(username,pasword,score,cash,vipclass) values (?,?,?,?,?);";//插入订单信息
			Object[] ownerParam = {number,passWord,0,500,"普通会员"};	
			int updateOwner = executeSQL(updateSql, ownerParam);
			System.out.print("注册成功！");
			Inituser();
			return true;
		}
		else {
			System.out.print("用户名已存在！");
			return false;
		}
	}
	
    public void changePass(user user,String password) {//更改用户密码
		String updateSql = "update users set pasword=? where fid=?";//插入订单信息
		Object[] ownerParam = {password,user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Inituser();
	}

    public void printCar(user user) {//打印购物车信息
    	
    	Set<String> keys=Initcart().keySet(); 
		System.out.println("用户账号："+user.getUcount());
		System.out.println("鲜花名称\t鲜花个数\t总计"); 
		for(String key:keys) {
			cart f = Cartss.get(key);
		    if(f.oid.equals(user.uid)) {
				System.out.println(f.fname+"\t"+f.fnum+"\t"+f.sum);
		    }
		}
		System.out.println("打折后总计："+sums(user)*user.discount);
		
	}
    
    public void printFlower() {
    	int i=0;//打印上架花朵信息，只显示可购买的鲜花信息
    	Set<String> keys = b.getFlowers().keySet();
    	for(String key:keys) {
    		flower f = b.getFlowers().get(key);
    		if(f.isOnsale()) {
    			f.print();
                for (int j = 0; j < 7; j++)  
                {  
                    switch (j)  
                    {  
                    case 0:  
                        obj[i][j] = f.fid;  
                        break;  
                    case 1:  
                        obj[i][j] = f.fname;  
                        break;  
                    case 2:  
                        obj[i][j] = f.fkind;  
                        break;  
                    case 3:  
                        obj[i][j] = f.fprice;  
                        break;  
                    case 4:  
                        obj[i][j] = f.fstocksum;  
                        break;  
                    case 5:  
                        obj[i][j] = f.fsalesum;  
                        break;  
                    case 6:  
                        obj[i][j] = f.isOnsale;  
                        break;  
                    }
                   
                    
                }  
                i++;
    		}
    	}
    }
	
    public Map<String, List<consumption>> getConsumInfos() {
		return consumInfos;
	}
	
    public void setConsumInfos(Map<String, List<consumption>> consumInfos) {
		this.consumInfos = consumInfos;
	}
	
    public Map<String, List<consumption>> getBuyCar() {
		return buyCar;
	}
	
    public void setBuyCar(Map<String, List<consumption>> buyCar) {
		this.buyCar = buyCar;
	}
	
    public Map<String, user> getU() {
		return u;
	}
	
    public void setU(Map<String, user> u) {
		this.u = u;
	}
	
    public flowershopserviceimpl getB() {
		return b;
	}
	
    public void setB(flowershopserviceimpl b) {
		this.b = b;
	}

}