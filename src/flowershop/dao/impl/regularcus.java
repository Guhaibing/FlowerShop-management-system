package flowershop.dao.impl;

import flowershop.dao.discount;
import flowershop.entity.user;

/*
 * ��ͨ�û���
 * �̳����û���
 * �ӿ����ۿۣ���ͨ�û������ۣ�
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
		super.setDiscount(1.0);//��ͨ�û�������
		// TODO Auto-generated method stub
		
	}
    public void print() {
		
		System.out.println("��Ա�˺�\t��Ա�ȼ�");
		System.out.println(super.getUcount()+"\t"+super.getType());
	}
}
