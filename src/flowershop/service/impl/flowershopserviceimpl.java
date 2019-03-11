package flowershop.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import flowershop.dao.*;
import flowershop.service.*;
import flowershop.entity.*;


/*
 * 花店类
 * 包含花店管理的功能方法
 * 
 */
public class flowershopserviceimpl extends basedao implements flowershopservice{

	String bpassWord = "1";                                 //设置店长登陆密码，默认为123456789
	Map<String, flower> flowers = new HashMap<String, flower>();
	
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	
	public Object[][] obj = new Object[100][7];
	
	public flowershopserviceimpl() {
		Init();
	}
	
    public Map<String, flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(Map<String, flower> flowers) {
		this.flowers = flowers;
	}

	public String getBpassWord() {
		return bpassWord;
	}

	public void setBpassWord(String bpassWord) {
		this.bpassWord = bpassWord;
	}
	
	public void Init(){  //初始化商店的鲜花信息,使用HashMap初始化增加了一些花
		String flag=null;
		try {
		String preparedSql = "select * from flowers ";
		conn = getConn();// 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				flower flower = new flower();
				flower.fid=(rs.getString(1));
				flower.fname=(rs.getString(2));
				flower.fkind=(rs.getString(3));
				flower.fprice=(rs.getDouble(4));
				flower.fsalesum=(rs.getInt(5));
				flower.fstocksum=(rs.getInt(6));
				flower.isOnsale=(rs.getBoolean(7));
				flag=String.valueOf(flower.fid);
				flowers.put(flag,flower);
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

	@Override
	public void changePrice(double fprice, String id) {              //改变鲜花的价格,fprice为传入的改变价格,id为要改变的花的id
		String updateSql = "update flowers set fprice=? where fid=?";
		Object[] ownerParam = { fprice,id };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Init();
		//f.setFprice(fprice);// TODO Auto-generated method stub
		
	}

	@Override
	public void changeIsonsale(boolean b,String id) {             //改变上下架的情况
		String updateSql = "update flowers set isOnsale=? where fid=?";
		Object[] ownerParam = {b, id};	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Init();
	}// TODO Auto-generated method stub
	
	
	@Override
	public flower searchID (String id) {                               // 按照花ID查找  
		flower f = flowers.get(id);
			return f;
		
	}// TODO Auto-generated method stub
	
	@Override
	public flower searchName(String name) {                            //按照名称查找
		Set<String> keys=flowers.keySet();  
		for(String key:keys) {
			
			flower f = flowers.get(key);
		    if(name.equals(f.getFname())) {
		    	return f;
		    }
		}
		return null;// TODO Auto-generated method stub
	}		
	
	@Override
	public void find() {   //查询所有花
		int i=0;
		Set<String> keys=flowers.keySet();  
		for(String key:keys) {
			flower f = flowers.get(key);
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
		}// TODO Auto-generated method stub
		
	}
	
    public void add_num(String id,int num) {                            //增加库存量
    	flower f = flowers.get(id);
		String updateSql = "update flowers set fstocksum=? where fid=?";
		Object[] ownerParam = {(f.getFstocksum()+num), id};	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Init();
	}

    public void add_kind(flower f) {                                   //增加某种之前未曾出现的花
		String updateSql = "insert into flowers(fname,fkind,fprice,fsalenum,fstocksum,isOnsale) values (?,?,?,?,?,?)";
		Object[] ownerParam = {f.fname,f.fkind,f.fprice,f.fsalesum,f.fstocksum,f.isOnsale };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Init();
    }
   
    public void del_num(String id,int num) {                            //减少某种花的数量，减少num
    	flower f = flowers.get(id);
		String updateSql = "update flowers set fstocksum=? where fid=?";
		Object[] ownerParam = {(f.getFstocksum()-num), id};	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Init();
    }

	@Override
	public void add_sale(String id, int num) {                             //增加销售量
    	flower f = flowers.get(id);
		String updateSql = "update flowers set fsalenum=? where fid=?";
		Object[] ownerParam = {(f.fsalesum+num), id};	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Init();
		
	}
    
	public Map<String,flower> bestSale() {                                        //统计畅销花朵
		flower flower = new flower();
		Map<String, flower> flowerset = new HashMap<String, flower>();
		Set<String> keys=flowers.keySet();  
		for(String key:keys) {
			flower f = flowers.get(key);
		    if(f.getFsalesum()>flower.getFsalesum()) {
		    	flowerset.put(f.fid, f);
		    	flower.fsalesum=f.fsalesum;
		    }
		}
		return flowerset;
	}

	@Override
	public void changeIsonsale(int state, String id) {
		// TODO Auto-generated method stub
		
	}
    
}