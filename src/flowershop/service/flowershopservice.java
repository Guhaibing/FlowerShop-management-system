package flowershop.service;

import flowershop.entity.flower;

public interface flowershopservice {
	void add_kind(flower f);
	//增加花的种类
	void del_num(String id,int num);
	//减少花的数量
	void add_num(String id,int num);
	//增加某种鲜花数量
	void add_sale(String id,int num);
	//增加销售量
    void Init();
    //初始化商店的鲜花信息,使用HashMap初始化增加了一些花
    
	void changePrice(double fprice, String id);
     //改变鲜花的价格,fprice为传入的改变价格,id为要改变的花的id

	void changeIsonsale(int state, String id);
	//改变上下架的情况
	
	public void find();
	//查询所有花
	public flower searchID (String id);
	 // 按照花ID查找  
	
	public flower searchName(String name); 
	 //按照名称查找
}
