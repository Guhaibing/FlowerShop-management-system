package flowershop.dao.impl;

import flowershop.dao.discount;
import flowershop.entity.user;

/*
 * �ƽ��Ա��
 * �̳����û���
 * �ӿ����ۿۣ��ƽ��Ա����ۣ�
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
	public void Buydiscount() {//�ۿ۽ӿ�ʵ��
		super.setDiscount(0.7);//�ƽ��Ա�����
		// TODO Auto-generated method stub
		
	}
	public void print() {
		
		System.out.println("��Ա�˺�\t��Ա�ȼ�");
		System.out.println(super.getUcount()+"\t"+super.getType());
	}
	
}