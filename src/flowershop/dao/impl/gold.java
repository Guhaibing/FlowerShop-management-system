package flowershop.dao.impl;

import flowershop.dao.discount;
import flowershop.entity.user;

/*
 * 黄金会员类
 * 继承自用户类
 * 接口是折扣（黄金会员打八折）
 */
public class gold extends user implements discount{
	public gold() {
		super();
		super.setType("Gold member");
	}
	public gold(String ucount,String upassword) {
		super( ucount, upassword, "Gold member", 0.8);
	}
	@Override
	public void Buydiscount() {//折扣接口实现
		super.setDiscount(0.7);//黄金会员打八折
		// TODO Auto-generated method stub
		
	}
	public void print() {
		
		System.out.println("会员账号\t会员等级");
		System.out.println(super.getUcount()+"\t"+super.getType());
	}
	
}