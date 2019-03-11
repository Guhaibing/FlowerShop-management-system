package flowershop.entity;
/**
 * 
 * 用户信息类
 *包含用户的各项基本信息
 */
public class user {
	public String uid;  //用户ID
	public String ucount;//用户名
	public String upassword;//用户密码
	public String Type;//用户会员类型
	public double discount;//折扣
	public double cash; //账户金额
	public int    score;//积分值
	

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
    public  void print() {//打印用户信息
		System.out.print(uid+"\t"+ucount+"\t"+upassword+"\t"+Type+"\t"+discount+"\t余额："+cash+"\t积分："+score+"\t");
		if(Type=="普通会员") {
			System.out.println("普通会员");
		}
		else if(Type=="黄金会员"){
			System.out.println("下架"
					+ "");
		}
		else if(Type=="白金会员"){
			System.out.println("下架"
					+ "");
		}
	}
}