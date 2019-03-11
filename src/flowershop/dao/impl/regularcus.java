package flowershop.dao.impl;

import flowershop.dao.discount;
import flowershop.entity.user;

/*
 * 普通用户类
 * 继承自用户类
 * 接口是折扣（普通用户不打折）
 */
public class regularcus extends user implements discount{
	public regularcus() {
		super();
		super.setType("Regular custom");
	}
	public regularcus(String ucount,String upassword) {
		super(ucount, upassword, "RegularMem member", 1.0);
	}
	@Override
	public void Buydiscount() {
		super.setDiscount(1.0);//普通用户不打折
		// TODO Auto-generated method stub
		
	}
    public void print() {
		
		System.out.println("会员账号\t会员等级");
		System.out.println(super.getUcount()+"\t"+super.getType());
	}
}
