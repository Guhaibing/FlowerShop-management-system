package flowershop.service;

import flowershop.entity.user;

public interface userservice {
	
	public void putin(user user,int num);
	//���붩����Ϣ,�����˻����
	
	public void pay(user user);
	//֧�����ﳵ�ڵ���Ʒ���ı仨�����������Ϣ����֮���ﳵ���
	
	public boolean isExistUser(String number, String passWord) ;
	//��½��֤
	
	public boolean isExistUser(String searchNumber);
	//�û��Ƿ����
	
	public boolean addUser(String number, String passWord ) ;
	//����µ��û� ����Ĭ��Ϊ��ͨ�û�
	
	public void changePass(user user,String password);
	//�����û�����
	
	public void printCar(user user);
	//��ӡ���ﳵ��Ϣ
	
	public void printFlower() ;
	//��ӡ�ϼܻ�����Ϣ��ֻ��ʾ�ɹ�����ʻ���Ϣ
	
}
