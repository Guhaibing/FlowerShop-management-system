package flowershop.dao.impl;

import flowershop.dao.discount;
import flowershop.entity.user;

/*
 * ��ͨ��Ա��
 * �̳����û���
 * �ӿ����ۿۣ���ͨ��Ա�����ۣ�
 */
public class regularmem extends user implements discount{
	
	public regularmem() {
		super();
		super.setType("Regular member");
	}
	public regularmem(String ucount,String upassword) {
		super( ucount, upassword, "RegularMem member", 1.0);
	}
	@Override
	public void Buydiscount() {
		super.setDiscount(0.9);//��ͨ��Ա������
		// TODO Auto-generated method stub
		
	}
    public void print() {
		
		System.out.println("��Ա�˺�\t��Ա�ȼ�");
		System.out.println(super.getUcount()+"\t"+super.getType());
	}
}
