package flowershop.entity;
/**
 * 购物车信息类
 * 包含未付款的预定的花的信息
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import flowershop.dao.*;

public class cart extends basedao{
	
	public String cid; //订单ID
	public String oid;  //花的ID
	public String fname; //花的名称
	public int    fnum;  //花的数量
	public double sum;   //购买总价
	public String fid;   //用户ID
	
	Map<String, cart> Cartss = new HashMap<String, cart>();
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	public cart() {
			cid=null;
			oid=null;
			fname=null;
			fnum=0;
			sum=0;
			fid=null;
		
	}


	
}