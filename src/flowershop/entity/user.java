package flowershop.entity;
/**
 * 
 * �û���Ϣ��
 *�����û��ĸ��������Ϣ
 */
public class user {
	public String uid;  //�û�ID
	public String ucount;//�û���
	public String upassword;//�û�����
	public String Type;//�û���Ա����
	public double discount;//�ۿ�
	public double cash; //�˻����
	public int    score;//����ֵ
	

	public user(String ucount,String upassword,String Type,double discount) {
		this.ucount = ucount;
		this.upassword = upassword;
		this.Type = Type;
		this.discount = discount ;
	}	
	public user() {
		ucount = null;
		upassword = null;
		Type = null;
		setDiscount(1.0);
		cash=0;
		uid=null;
	}	
	public void GetCash(double cash) {
		this.cash=cash;
	}
	public String getUcount() {
		return ucount;
	}
	public void setUcount(String ucount) {
		this.ucount = ucount;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
    public  void print() {//��ӡ�û���Ϣ
		System.out.print(uid+"\t"+ucount+"\t"+upassword+"\t"+Type+"\t"+discount+"\t��"+cash+"\t���֣�"+score+"\t");
		if(Type=="��ͨ��Ա") {
			System.out.println("��ͨ��Ա");
		}
		else if(Type=="�ƽ��Ա"){
			System.out.println("�¼�"
					+ "");
		}
		else if(Type=="�׽��Ա"){
			System.out.println("�¼�"
					+ "");
		}
	}
}