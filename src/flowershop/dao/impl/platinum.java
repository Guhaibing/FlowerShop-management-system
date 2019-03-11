package flowershop.dao.impl;

import flowershop.dao.discount;
import flowershop.entity.user;

/*
 * 白金会员类
 * 继承自用户类
 * 接口是折扣（白金会员打五折）
 */
public class platinum extends user implements discount{
	public platinum() {
		super();
		super.setType("Platinum member");
	}
	public platinum(String ucount,String upassword) {
		super(ucount, upassword, "Platinum member", 0.5);
	}
	@Override
	public void Buydiscount() {//折扣接口实现
		super.setDiscount(0.8);//白金会员打五折
		// TODO Auto-generated method stub
		
	}
	
     public void print() {
		
		System.out.println("会员账号\t会员等级");
		System.out.println(super.getUcount()+"\t"+super.getType());
	}
}