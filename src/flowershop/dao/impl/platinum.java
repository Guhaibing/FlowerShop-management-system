package flowershop.dao.impl;

import flowershop.dao.discount;
import flowershop.entity.user;

/*
 * �׽��Ա��
 * �̳����û���
 * �ӿ����ۿۣ��׽��Ա�����ۣ�
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
	public void Buydiscount() {//�ۿ۽ӿ�ʵ��
		super.setDiscount(0.8);//�׽��Ա������
		// TODO Auto-generated method stub
		
	}
	
     public void print() {
		
		System.out.println("��Ա�˺�\t��Ա�ȼ�");
		System.out.println(super.getUcount()+"\t"+super.getType());
	}
}