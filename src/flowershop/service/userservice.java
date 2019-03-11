package flowershop.service;

import flowershop.entity.user;

public interface userservice {
	
	public void putin(user user,int num);
	//插入订单信息,减少账户金额
	
	public void pay(user user);
	//支付购物车内的物品（改变花店库存和销售信息），之后购物车清空
	
	public boolean isExistUser(String number, String passWord) ;
	//登陆认证
	
	public boolean isExistUser(String searchNumber);
	//用户是否存在
	
	public boolean addUser(String number, String passWord ) ;
	//添加新的用户 这里默认为普通用户
	
	public void changePass(user user,String password);
	//更改用户密码
	
	public void printCar(user user);
	//打印购物车信息
	
	public void printFlower() ;
	//打印上架花朵信息，只显示可购买的鲜花信息
	
}
