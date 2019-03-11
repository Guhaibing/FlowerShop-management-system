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
 * �û������� 
 * �����û����򻨶�ȹ����û��ķ���
 */
public class userserviceimpl extends basedao{
	//Map<String, List<Consumption>> consumInfos = new HashMap<String, List<Consumption>>();//ÿ���˻���Ӧһ��  ���㵥���Ѽ�¼
	//Map<String, List<Consumption>> buyCar = new HashMap<String, List<Consumption>>();//���ﳵ
	Map<String, user> u = new HashMap<String, user>();//�û���Ϣ
	Map<String, cart> Cartss = new HashMap<String, cart>();
	flowershopserviceimpl b = new flowershopserviceimpl();//������Ϣ
	cart c = new cart();

	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���
	public Object[][] obj = new Object[100][7];
	private ResultSet rs = null; // �û������ѯ�����
	private Map<String, List<consumption>> consumInfos;
	private Map<String, List<consumption>> buyCar;
	
	
	public 	Map<String, cart> Initcart() {
		Cartss.clear();
		try {
		String preparedSql = "select * from carts";
		conn = getConn();// �õ����ݿ�����
		pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
		rs = pstmt.executeQuery(); // ִ��SQL���
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
		conn = getConn();// �õ����ݿ�����
		pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
		rs = pstmt.executeQuery(); // ִ��SQL���
			while (rs.next()) {
				user Users = new user();
				Users.uid=(rs.getString(1));
				Users.ucount=(rs.getString(2));
				Users.upassword=(rs.getString(3));
				Users.cash=(rs.getDouble(4));
				Users.score=(rs.getInt(5));
				if(Users.score>500) {
					String updateSql = "update users set vipclass=? where fid=?";//���붩����Ϣ
					Object[] ownerParam = {"�׽��Ա",Users.uid };	
					int updateOwner = executeSQL(updateSql, ownerParam);
				}
				if(Users.score>200) {
					String updateSql = "update users set vipclass=? where fid=?";//���붩����Ϣ
					Object[] ownerParam = {"�ƽ��Ա",Users.uid };	
					int updateOwner = executeSQL(updateSql, ownerParam);
				}
				Users.Type=(rs.getString(6));
				if(Users.Type.equals("�׽��Ա")) {
					Users.discount=0.5;
				}
				if(Users.Type.equals("�ƽ��Ա")) {
					Users.discount=0.8;
				}
				if(Users.Type.equals("��ͨ��Ա")) {
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
	
	public userserviceimpl() {//���캯����ʼ��������һЩ�û���Ϣ ����HashMap

		Inituser();
		Initcart();
	}
	
	public boolean addCar(user user,flower flower,int num) {//���빺�ﳵ���ı��̵�Ŀ����Ϣ������ֻ����֧����Ÿı���������
		//Consumption c = new Consumption(user,flower,num);
		
		if(num>b.searchID(flower.getFid()).getFstocksum() || num<0) {
			System.out.println("��治��������������");
			return false;
		}
		
		String updateSql = "insert into carts(oid,fid,fname,fnum,fsum) values (?,?,?,?,?)";//���붩����Ϣ
		Object[] ownerParam = {user.uid,flower.fid,flower.fname,num,num*flower.fprice};	
		int updateOwner = executeSQL(updateSql, ownerParam);

		b.del_num(flower.fid, num);//���ٶ�Ӧ������¼����
		b.add_sale(flower.fid, num);
		
		return true;
	}
	
	public void clearCar(user user) {//��չ��ﳵ
		String updateSql = "delete from carts where oid=?";//���붩����Ϣ
		Object[] ownerParam = {user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Initcart();
	}
	
	public double sums(user user) {//���㹺�ﳵ��Ʒ�ܼ�Ǯ
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
		String updateSql = "update users set cash=? where fid=?";//���붩����Ϣ,�����˻����
		Object[] ownerParam = {user.cash+num,user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Inituser();
	}
	
	public void pay(user user) {//֧�����ﳵ�ڵ���Ʒ���ı仨�����������Ϣ����֮���ﳵ���

		
		double less=sums(user)*user.discount;
		String updateSql = "update users set cash=? where fid=?";//���붩����Ϣ,�����˻����
		Object[] ownerParam = {(user.cash-less),user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		String updateSqlc = "update users set score=? where fid=?";//���붩����Ϣ�����ӻ���
		Object[] ownerParamc = {(user.score+less),user.uid };	
		int updateOwnerc = executeSQL(updateSqlc, ownerParamc);
		this.clearCar(user);
		Inituser();
	}
	

	public boolean isExistUser(String number, String passWord) {//��½��֤
		if(isExistUser(number)) {
			if(u.get(number).getUpassword().equals(passWord)) {
				return true;
			}
		}
		return false;
	}
	
    public boolean isExistUser(String searchNumber) {//�û��Ƿ����
		if(u.containsKey(searchNumber)) {
			return true;
		}
		return false;
	}
	
    public boolean addUser(String number, String passWord ) {//����µ��û� ����Ĭ��Ϊ��ͨ�û�

		regularcus r = new regularcus(number,passWord);
		if(!isExistUser(number)) {
			String updateSql = "insert into users(username,pasword,score,cash,vipclass) values (?,?,?,?,?);";//���붩����Ϣ
			Object[] ownerParam = {number,passWord,0,500,"��ͨ��Ա"};	
			int updateOwner = executeSQL(updateSql, ownerParam);
			System.out.print("ע��ɹ���");
			Inituser();
			return true;
		}
		else {
			System.out.print("�û����Ѵ��ڣ�");
			return false;
		}
	}
	
    public void changePass(user user,String password) {//�����û�����
		String updateSql = "update users set pasword=? where fid=?";//���붩����Ϣ
		Object[] ownerParam = {password,user.uid };	
		int updateOwner = executeSQL(updateSql, ownerParam);
		Inituser();
	}

    public void printCar(user user) {//��ӡ���ﳵ��Ϣ
    	
    	Set<String> keys=Initcart().keySet(); 
		System.out.println("�û��˺ţ�"+user.getUcount());
		System.out.println("�ʻ�����\t�ʻ�����\t�ܼ�"); 
		for(String key:keys) {
			cart f = Cartss.get(key);
		    if(f.oid.equals(user.uid)) {
				System.out.println(f.fname+"\t"+f.fnum+"\t"+f.sum);
		    }
		}
		System.out.println("���ۺ��ܼƣ�"+sums(user)*user.discount);
		
	}
    
    public void printFlower() {
    	int i=0;//��ӡ�ϼܻ�����Ϣ��ֻ��ʾ�ɹ�����ʻ���Ϣ
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