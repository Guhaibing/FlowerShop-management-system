package flowershop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class basedao {
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=flowerstore";
		  String userName="sa";
		  String userPwd="123123";
		try {
			Class.forName(driverName); // ע������
			conn = DriverManager.getConnection(dbURL, userName,userPwd); // ������ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // ��������
	}
	
	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param pstmt
	 *            PreparedStatement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		/* ���rs���գ��ر�rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���pstmt���գ��ر�pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���conn���գ��ر�conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	/**
	 * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
	 * 
	 * @param sql
	 *            Ԥ����� SQL ���
	 * @param param
	 *            Ԥ����� SQL ����еġ������������ַ�������
	 * @return Ӱ�������
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			// System.out.println(preparedSql);
			num = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}

	public void changeIsonsale(boolean b, String id) {
		// TODO Auto-generated method stub
		
	}
	
	
}