package flowershop.entity;

import flowershop.entity.flower;
import flowershop.entity.user;

/*
 * ������Ϣ��
 * �����û��͹���Ļ��� ����
 */
public class consumption {
	
	private user user;  //�û���Ϣ
	private flower flower; //����Ļ�����Ϣ
	private int num;// ����������
	
	public consumption(user user,flower flower,int num) {
		this.setUser(user);
		this.setFlower(flower);
		this.num = num;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public flower getFlower() {
		return flower;
	}

	public void setFlower(flower flower) {
		this.flower = flower;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
}