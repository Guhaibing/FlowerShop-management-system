package flowershop.entity;
/**
 * ���ﳵ��Ϣ��
 * ����δ�����Ԥ���Ļ�����Ϣ
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import flowershop.dao.*;

public class cart extends basedao{
	
	public String cid; //����ID
	public String oid;  //����ID
	public String fname; //��������
	public int    fnum;  //��������
	public double sum;   //�����ܼ�
	public String fid;   //�û�ID
	
	Map<String, cart> Cartss = new HashMap<String, cart>();
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	public cart() {
			cid=null;
			oid=null;
			fname=null;
			fnum=0;
			sum=0;
			fid=null;
		
	}


	
}