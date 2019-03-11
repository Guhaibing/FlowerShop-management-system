package flowershop.entity;

import flowershop.entity.flower;
import flowershop.entity.user;

/*
 * 消费信息类
 * 包含用户和购买的花和 数量
 */
public class consumption {
	
	private user user;  //用户信息
	private flower flower; //购买的花的信息
	private int num;// 购买数量是
	
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