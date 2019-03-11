package flowershop.test;


import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import flowershop.service.JTableTest;
import flowershop.service.impl.*;
import flowershop.entity.*;




import java.util.Scanner;
//----------------------------------
import java.awt.Button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import java.awt.Label;

import java.awt.Panel;

import java.awt.TextField;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import flowershop.entity.flower;
import flowershop.service.impl.flowershopserviceimpl;
import flowershop.service.impl.userserviceimpl;

//----------------------------------------------------------
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



import java.util.Scanner;
//----------------------------------
import java.awt.Button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import java.awt.Label;

import java.awt.Panel;

import java.awt.TextField;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//----------------------------------------------------------
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class test {
//----------------------------------------------------------
	//程序运行所需要设置的静态窗口变量
	static Frame frame = new Frame("flower Shop");
	static Frame frame1 = new Frame("flower Shop");
	static Frame frame2 = new Frame("flower Shop");
	static Frame frame3 = new Frame("flower Shop");
	static JFrame frame20 = new JFrame("usersmenu");
	static JFrame frame201 = new JFrame("购买鲜花");
	static JFrame frame202 = new JFrame("结账");
	static JFrame frame30 =new JFrame("bossmenu");
	static JFrame ckaf = new JFrame("查询所有花的情况");
	static JFrame afks = new JFrame("增加花类");
	static JFrame addflnums = new JFrame("增加花数");
	static JFrame rdok = new JFrame("减少在售花类");
	static JFrame rdon = new JFrame("减少花数");
	static JFrame chpr = new JFrame("改变价格");
	static JFrame chpw = new JFrame("修改密码");
	static JFrame frame22 = new JFrame("用户注册");
	//static Panel nn = new Panel();
//--------------------------------------------------------------
	public static void main(String[] args) {

		flowershopserviceimpl b = new flowershopserviceimpl();
		userserviceimpl u = new userserviceimpl();

	    b.Init();
	    flower f = new flower();
		String fid;//ID
		String fname;//花名
		String fkind;//花的种类
	    double fprice;//花的价钱
		int fstocksum;//现有数量,剩余数量
		int fsalesum;//卖出数量
		boolean isOnsale;//上下架
		//int select=0;//是否要继续上一步
		int num;//增加或减少花的数量

        //程序运行后的初始窗口frame
		frame.setSize(600,400);//窗口大小
		frame.setLocation(500,50);//窗口位置

		frame.setLayout(null);//清除窗口所有控件
		frame.addWindowListener(new WindowAdapter(){//鼠标点击窗口右上角的x可关闭窗口
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
        //初始窗口frame的三个按钮
		JButton button1 =new JButton("游客登录");
		JButton button2 =new JButton("用户登录");
		JButton button3 =new JButton("店长登录");
		button1.setBounds(200,100,200,40);
		button2.setBounds(200,160,200,40);
		button3.setBounds(200,220,200,40);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.setVisible(true);//显示frame窗口


        //按钮“游客登陆”的实现
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				closeThis();//关闭上一个窗口frame

				JFrame frame1 = new JFrame("游客登录");//创建新的窗口frame1
				frame1.setLayout(null);

                //新建窗口的按钮
				JButton buttonsee1 = new JButton("花朵信息");
				JButton buttonsee2 = new JButton("商店信息");
				JButton buttonback = new JButton("退出");




				frame1.setLocation(500,50);

				frame1.setSize(600,400);



                //按钮的位置
				buttonsee1.setBounds(200,60,200,40);
				buttonsee2.setBounds(200,120,200,40);
				buttonback.setBounds(200,180,200,40);
				frame1.add(buttonsee1);
				frame1.add(buttonsee2);
				frame1.add(buttonback);
                
                //按钮“花朵信息”的实现
				buttonsee1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent f){
						b.find();
						JTableTest A=new JTableTest(b.obj);//将数据库的信息以表格的形式显示
						
					}
				});
				//按钮“商店信息”的实现
				buttonsee2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent g){
						System.out.println("花店分为四种会员：黄金会员、白金会员、普通会员以及普通用户，其中黄金会员购买鲜花打8折，白金会员打5折，普通会员不打折，普通用户不打折");
					}
				});
				//按钮“退出”的实现
				buttonback.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent h){
						closeThis1();//关闭窗口frame1
						frame.setVisible(true);//回到窗口frame
					}
				});
				


				frame1.setVisible(true);
			}

		});
        //按钮“用户登录”的实现
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){


				closeThis();

				JFrame frame2 = new JFrame("用户登录");

				user user = null;//定义一个初始的user对象

				frame2.setLayout(null);

				JLabel usersname = new JLabel("用户名:");
				JLabel password = new JLabel("密码:");
				JTextField uu1 = new JTextField();
				JTextField p1 = new JTextField();
				JButton n1 = new JButton("登陆");
				JButton n2 = new JButton("注册");
				JButton n3 = new JButton("返回");

				usersname.setBounds(200,80,100,40);
				password.setBounds(200,120,100,40);
				uu1.setBounds(250,80,100,30);
				p1.setBounds(250,120,100,30);
				n1.setBounds(140,240,80,40);
				n2.setBounds(240,240,80,40);
				n3.setBounds(340,240,80,40);
				frame2.add(usersname);
				frame2.add(password);
				frame2.add(uu1);
				frame2.add(p1);
				frame2.add(n1);
				frame2.add(n2);
                frame2.add(n3);


                //登陆按钮的实现
				n1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent i){
						int temp = 0;
						//判断输入的用户是否存在
						if(u.isExistUser(uu1.getText(),p1.getText())){//uu1.getText()用于获取用户在控件uu1中输入的内容，p1.getText()同上
							System.out.println("right!");
							temp = 1;

						}
						//通过判断上述if语句是否执行来执行此次if语句
						if(temp==1){

							closeThis2();//关闭窗口frame2

							frame20.setLayout(null);
							frame20.setLocation(500,50);

				              frame20.setSize(800,600);



                            //用户登陆后的各种按钮的定义
				            JButton checkcbuyflower = new JButton("查看可购买鲜花信息");
				            JButton buyflowerinCart = new JButton("买花加入购物车");
				            JButton checkCart = new JButton("查看购物车");

				            JButton bill = new JButton("结账");
				            JButton checklevel = new JButton("查看会员信息等级");
				            JButton changepassword = new JButton("修改密码");
				            JButton exit1 = new JButton("退出系统");


				            checkcbuyflower.setBounds(240,20,240,50);
				            buyflowerinCart.setBounds(240,90,240,50);
				            checkCart.setBounds(240,160,240,50);
				            bill.setBounds(240,230,240,50);
				            checklevel.setBounds(240,300,240,50);
				            changepassword.setBounds(240,370,240,50);
				            exit1.setBounds(240,440,240,50);
				            
				            frame20.add(checkcbuyflower);
				            frame20.add(buyflowerinCart);
				            frame20.add(checkCart);
				            frame20.add(bill);
				            frame20.add(checklevel);
				            frame20.add(changepassword);
				            frame20.add(exit1);

                            //各种按钮的功能实现
				            checkcbuyflower.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.printFlower();//打印可购买的鲜花信息
									JTableTest A=new JTableTest(u.obj);//通过表格输出鲜花信息
				            	}
				            });
				            buyflowerinCart.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){

				            		frame201.setLayout(null);

				            		frame201.setLocation(500,50);
				            		frame201.setSize(600,400);
				            		JLabel buyinid = new JLabel("所购花ID：");
				            		JLabel buyinnumber = new JLabel("购入数量：");
				            		JTextField bii = new JTextField();
				            		JTextField bin = new JTextField();
				            		JButton enter2 = new JButton("确定");

				            		
				            		buyinid.setBounds(160,40,80,40);
				            		buyinnumber.setBounds(160,80,80,40);
				            		bii.setBounds(220,40,80,30);
				            		bin.setBounds(220,80,80,30);
				            		enter2.setBounds(200,180,60,40);


				            		frame201.add(buyinid);
				            		frame201.add(buyinnumber);
				            		frame201.add(bii);
				            		frame201.add(bin);
				            		frame201.add(enter2);

				            		user user = null;

				            		enter2.addActionListener(new ActionListener(){
				            			public void actionPerformed(ActionEvent h){
				            				String fid = bii.getText();  //定义字符串变量fid用于获取用户输入想购买的鲜花的id
				            				int nUmber = Integer.parseInt(bin.getText());
				            				                             //定义整型变量nUmber用于获取用户输入想要购买的数量
				            				
				            				u.addCar(u.getU().get(uu1.getText()),u.getB().searchID(fid),nUmber);
				            				                             //将所购买的鲜花加入购物车

				            				
				            				
				            				closeThis201();

				            			}
				                    });




				            		frame201.setVisible(true);

				            	}
				            });
				            checkCart.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.printCar(u.getU().get(uu1.getText()));//打印购物车信息
				            	}
				            });
				            bill.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.pay(u.getU().get(uu1.getText()));//用于结算购物车
				            		frame202.setBounds(700,100,200,200);
				            		JButton enter3 = new JButton("结账成功");
				            		enter3.setBounds(60,60,40,40);

				            		frame202.add(enter3);

				            		frame202.setVisible(true);

				            	}
				            });
				            checklevel.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.getU().get(uu1.getText()).print();//打印出当前用户的会员等级
				            	}
				            });
				            changepassword.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		chpw.setLayout(null);
				            		chpw.setBounds(500,50,600,400);

				            		JLabel oldpw = new JLabel("请输入旧密码：");
				            		JLabel newpw = new JLabel("请输入新密码：");
				            		JLabel renewpw = new JLabel("请再次输入新密码：");
				            		JTextField oldPw = new JTextField();
				            		JTextField newPw = new JTextField();
				            		JTextField renewPw = new JTextField();
				            		JButton ensure6 = new JButton("确定");

				            		oldpw.setBounds(100,10,160,40);
				            		newpw.setBounds(100,60,160,40);
				            		renewpw.setBounds(100,110,160,40);
				            		oldPw.setBounds(270,10,160,40);
				            		newPw.setBounds(270,60,160,40);
				            		renewPw.setBounds(270,110,160,40);
				            		ensure6.setBounds(270,160,160,40);

				            		chpw.add(oldpw);
				            		chpw.add(newpw);
				            		chpw.add(renewpw);
				            		chpw.add(oldPw);
				            		chpw.add(newPw);
				            		chpw.add(renewPw);
				            		chpw.add(ensure6);

				            		ensure6.addActionListener(new ActionListener(){
				            			public void actionPerformed(ActionEvent h){

				            				closeThischpw();
				            				String password1 = oldPw.getText();
				            				                   //定义字符串变量password1用于获取用户输入的旧密码
				            				String password2 = newPw.getText();
				            				                   //定义字符串变量password2用于获取用户输入的新密码
				            				String password3 = renewPw.getText();
				            				                   //定义字符串变量password3用于获取用户再次输入的新密码

                                            //判断用户输入的旧密码是否符合当前用户密码
				            				if(!password1.equals(u.getU().get(uu1.getText()).getUpassword())) {
			    		                        System.out.println("请重新输入！");
			    	                        }
			    	                        else {
                                                //判断用户输入的新密码与再次输入的新密码是否一致
			    		                        if(password2.equals(password3)) {
			    			                        u.changePass(u.getU().get(uu1.getText()), password2);//调用修改密码的函数
			    			                        System.out.print("修改成功！");
			    			                       
			    		                        }
			    		                        else {
			    			                        System.out.println("请重新输入！");
			    		                        }
			    	
			    	                        }


				            	        }
				                    });



				            		chpw.setVisible(true);
				            	}
				            });
				            exit1.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		closeThis20();
				            	}
				            });




				            frame20.setVisible(true);
						}

					}
				});
                //注册按钮的实现
				n2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent f){
						closeThis20();

						frame22.setLayout(null);
						
						frame22.setBounds(500,50,600,400);

						JLabel zu1 = new JLabel("用户名:");
						JLabel zp1 = new JLabel("密码:");
						JTextField zu2 = new JTextField();//用户输入的注册账户
						JTextField zp2 = new JTextField();//用户输入的注册密码
						JButton ensure0 = new JButton("确定");
						

						zu1.setBounds(200,80,100,40);
						zp1.setBounds(200,120,100,40);
						zu2.setBounds(250,80,100,30);
						zp2.setBounds(250,120,100,30);
						ensure0.setBounds(250,240,80,40);
						
						frame22.add(zu1);
						frame22.add(zp1);
						frame22.add(zu2);
						frame22.add(zp2);
						frame22.add(ensure0);
						
						ensure0.addActionListener(new ActionListener(){
			            	public void actionPerformed(ActionEvent h){
			            		closeThisframe22();
			            		String nu = zu2.getText();//变量nu获取用户输入的注册账号
			            		String np = zp2.getText();//np获取用户输入的注册密码

			            		if(u.addUser(nu, np)) {//判断注册账户是否存在
			          			            		System.out.println("注册成功");  			
			            		}
			            		

			            	}
			            });
						
						frame22.setVisible(true);
						
					}
				});
				//返回frame窗口的按钮
                n3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent f){
						closeThis20();
						frame.setVisible(true);
					}
				});


				frame2.setLocation(500,50);

				frame2.setSize(600,400);





				frame2.setVisible(true);
			}

		});
        //店长按钮的实现
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				closeThis1();


				JFrame frame3 = new JFrame("店长登录");

				frame3.setLayout(null);

				JLabel mpassword = new JLabel("密码:");
				JTextField mp = new JTextField();

				JButton enter1 = new JButton("进入");
				JButton backs = new JButton("退出");
				mpassword.setBounds(200,120,80,40);
				mp.setBounds(280,120,80,40);
				enter1.setBounds(200,200,60,40);
				backs.setBounds(320,200,60,40);

				frame3.add(mpassword);
				frame3.add(mp);
				frame3.add(enter1);
				frame3.add(backs);
                //登陆店长
				enter1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent k){
						int tp = 0;
						String pass1 = mp.getText();//获取用户输入的店长密码
						//判断用户输入的店长密码是否正确
						if(pass1.equals(b.getBpassWord())){
							System.out.println("right!");
							tp = 1;
						}
						//通过判断上述if语句是否执行进而执行登陆后的功能
						if(tp==1){
							closeThis3();
							frame30.setLayout(null);

							frame30.setBounds(500,50,600,400);


							JButton checkallflowers = new JButton("查询所有花的情况");
							JButton addkinds = new JButton("增加花类");
							JButton addnums = new JButton("增加花数");
							JButton reduceonsalekinds = new JButton("减少在售花类");
							JButton reducenums = new JButton("减少花数");
							JButton changeprice = new JButton("改变价格");
							JButton bestselling = new JButton("畅销花统计");
							JButton exit2 = new JButton("退出");

							checkallflowers.setBounds(10,5,240,30);
							addkinds.setBounds(10,45,240,30);
							addnums.setBounds(10,85,240,30);
							reduceonsalekinds.setBounds(10,125,240,30);
							reducenums.setBounds(10,165,240,30);
							changeprice.setBounds(10,205,240,30);
							bestselling.setBounds(10,245,240,30);
							exit2.setBounds(10,285,240,30);

							frame30.add(checkallflowers);
							frame30.add(addkinds);
							frame30.add(addnums);
							frame30.add(reduceonsalekinds);
							frame30.add(reducenums);
							frame30.add(changeprice);
							frame30.add(bestselling);
							frame30.add(exit2);

                            //查看所有鲜花信息
							checkallflowers.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();

									ckaf.setLayout(null);

									JButton showall = new JButton("显示全部鲜花信息");
									JButton fid = new JButton("按照鲜花ID查询");
									JButton fname = new JButton("按照鲜花名称查询");
									JButton back1 = new JButton("返回");

									showall.setBounds(100,10,300,40);
									fid.setBounds(100,80,300,40);
									fname.setBounds(100,150,300,40);
									back1.setBounds(100,220,300,40);




									ckaf.add(showall);
									ckaf.add(fid);
									ckaf.add(fname);
									ckaf.add(back1);

									showall.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											b.find();//显示所有鲜花信息
											JTableTest A=new JTableTest(b.obj);
										}
									});
									fid.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
												
										}
									});
									fname.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
												
										}
									});
									back1.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											closeThisckaf();
											frame30.setVisible(true);
										}
									});



									ckaf.setBounds(500,50,600,400);
									ckaf.setVisible(true);

									
								}
							});
							//添加鲜花种类
							addkinds.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();

									afks.setLayout(null);

									afks.setBounds(500,50,600,400);

									JLabel inputkinds = new JLabel("输入新的花的ID:");
									JLabel aname = new JLabel("花名:");
									JLabel akind = new JLabel("种类:");
									JLabel aprice = new JLabel("价格:");
									JLabel anums = new JLabel("数量:");
									JTextField ipk = new JTextField();
									JTextField ana = new JTextField();
									JTextField ak = new JTextField();
									JTextField ap = new JTextField();
									JTextField anu = new JTextField();
									JButton ensure1 = new JButton("确定");

									inputkinds.setBounds(80,10,200,40);
									aname.setBounds(80,60,200,40);
									akind.setBounds(80,110,200,40);
									aprice.setBounds(80,160,200,40);
									anums.setBounds(80,210,200,40);
									ipk.setBounds(300,10,200,40);
									ana.setBounds(300,60,200,40);
									ak.setBounds(300,110,200,40);
									ap.setBounds(300,160,200,40);
									anu.setBounds(300,210,200,40);
									ensure1.setBounds(300,270,200,40);

									afks.add(inputkinds);
									afks.add(aname);
									afks.add(akind);
									afks.add(aprice);
									afks.add(anums);
									afks.add(ipk);
									afks.add(ana);
									afks.add(ak);
									afks.add(ap);
									afks.add(anu);
									afks.add(ensure1);

									ensure1.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											closeThisafks();

                                            
											int fsalesum = 0;//新加入鲜花的默认销售量为0
									        boolean isOnsale = true;//新加入鲜花的默认状态为上架
									        double fprice = Double.parseDouble(ap.getText());//强制转换，获取新加入鲜花的价格
									        int fstocksum = Integer.parseInt(anu.getText());//强制转换，获取新加入鲜花的数量

                                            //定义新的鲜花对象
									        flower fnew = new flower(ipk.getText(),ana.getText(),ak.getText(),fprice,fstocksum,fsalesum,isOnsale);
									        b.add_kind(fnew);//加入新鲜花
									        frame30.setVisible(true);
										}
									});



									afks.setVisible(true);
								}
							});
							//增加鲜花数量
							addnums.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){

									closeThis30();

									addflnums.setLayout(null);

									addflnums.setBounds(500,50,600,400);

									JLabel aid = new JLabel("增加花的Id：");
									JLabel anumber = new JLabel("增加数量：");
									JTextField caid = new JTextField();
									JTextField canumber = new JTextField();
									JButton ensure2 = new JButton("确定");

									aid.setBounds(100,10,80,40);
									anumber.setBounds(100,60,80,40);
									caid.setBounds(200,10,80,40);
									canumber.setBounds(200,60,80,40);
									ensure2.setBounds(200,110,80,40);

									addflnums.add(aid);
									addflnums.add(anumber);
									addflnums.add(caid);
									addflnums.add(canumber);
									addflnums.add(ensure2);

									ensure2.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											closeThisaddflnums();
											String fid = caid.getText();//获取想要增加鲜花的id
											int num = Integer.parseInt(canumber.getText());//强制转换，获取想要加入鲜花的数量
											b.add_num(fid,num);//加入新的数量
											frame30.setVisible(true);
										}
									});

									addflnums.setVisible(true);
								}
							});
							//减少在售鲜花，即下架
							reduceonsalekinds.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){


									rdok.setLayout(null);
									rdok.setBounds(600,50,600,40);

									JLabel reid = new JLabel("下架花的ID：");

									JTextField reID = new JTextField("");
									JButton ensure3 = new JButton("确定");

									reid.setBounds(200,10,80,40);
									reID.setBounds(300,10,80,40);
									ensure3.setBounds(300,60,80,40);

									rdok.add(reid);
									rdok.add(reID);
									rdok.add(ensure3);

									ensure3.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											closeThisrdok();
											b.changeIsonsale(false,reID.getText());//调用改变状态函数，下架鲜花
											frame30.setVisible(true);
								        }
								    });

									rdok.setVisible(true);
								}
							});
							//减少鲜花数量
							reducenums.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();
									rdon.setLayout(null);
									rdon.setBounds(600,50,600,400);

									JLabel renumid = new JLabel("减少花的ID：");
									JLabel renum = new JLabel("减少数量");
									JTextField renumID = new JTextField();
									JTextField reNum = new JTextField();

									JButton ensure4 = new JButton("确定");

									renumid.setBounds(200,10,80,40);
									renum.setBounds(200,60,80,40);
									renumID.setBounds(300,10,80,40);
									reNum.setBounds(300,60,80,40);
									ensure4.setBounds(300,110,80,40);

									rdon.add(renumid);
									rdon.add(renum);
									rdon.add(renumID);
									rdon.add(reNum);
									rdon.add(ensure4);

									ensure4.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											closeThisrdon();
											flower fdel = new flower(); //定义新的鲜花对象
											fdel = b.getFlowers().get(renumID.getText());//获取想要减少的鲜花对象
											int number = Integer.parseInt(reNum.getText());//获取想要减少的数量
											b.del_num(renumID.getText(),number);//执行减少函数
											frame30.setVisible(true);
								        }
								    });

									rdon.setVisible(true);
									
								}
							});
							//改变鲜花价格
							changeprice.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();
									chpr.setLayout(null);
									chpr.setBounds(600,50,600,400);

									JLabel chid = new JLabel("改价花的ID：");
									JLabel chprice = new JLabel("改变后的价格");
									JTextField chID = new JTextField();
									JTextField chPrice = new JTextField();

									JButton ensure5 = new JButton("确定");

									chid.setBounds(200,10,80,40);
									chprice.setBounds(200,60,80,40);
									chID.setBounds(300,10,80,40);
									chPrice.setBounds(300,60,80,40);
									ensure5.setBounds(300,110,80,40);

									chpr.add(chid);
									chpr.add(chprice);
									chpr.add(chID);
									chpr.add(chPrice);
									chpr.add(ensure5);

									ensure5.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											closeThischpr();

											double fprice = Double.parseDouble(chPrice.getText());//获取改变后的价格

											b.changePrice(fprice,chID.getText());//改变价格
											frame30.setVisible(true);
								        }
								    });

									chpr.setVisible(true);
									
								}
							});
							//显示最佳销量鲜花
							bestselling.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									System.out.println("畅销花朵信息");
									Set<String> keys=b.bestSale().keySet();//取出所有key的集合
									Iterator it=keys.iterator();//获取Iterator对象
									while(it.hasNext()){
										String key=(String)it.next();  //取出key
										flower dog=(flower)b.bestSale().get(key);  //根据key取出对应的值
										dog.print();
									}
									keys.clear();
									
								}
							});
							//退出店长窗口
							exit2.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									
									closeThis30();
									frame3.setVisible(true);
								}
							});


							frame30.setVisible(true);

						}
					}
				});
                //退出店长登陆窗口
				backs.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent f){
						closeThis3();
						frame.setVisible(true);
					}
				});



				frame3.setLocation(500,50);

				frame3.setSize(600,400);

				frame3.setVisible(true);
			}

		});
	}


//用于关闭定义了静态变量的窗口
	public static void closeThis(){
		frame.dispose();
	};
	public static void closeThis1(){
		frame1.dispose();
	};
	public static void closeThis2(){
		frame2.dispose();
	};
	public static void closeThis3(){
		frame3.dispose();
	};
	public static void closeThis20(){
		frame20.dispose();
	};
	public static void closeThis201(){
		frame201.dispose();
	};
	public static void closeThis30(){
		frame30.dispose();
	};
	public static void closeThisckaf(){
		ckaf.dispose();
	};
	public static void closeThisafks(){
		afks.dispose();
	};
	public static void closeThisaddflnums(){
		addflnums.dispose();
	};
	public static void closeThisrdok(){
		rdok.dispose();
	};
	public static void closeThisrdon(){
		rdon.dispose();
	};
	public static void closeThischpr(){
		chpr.dispose();
	};
	public static void closeThischpw(){
		chpw.dispose();
	};
	public static void closeThisframe22(){
		frame22.dispose();
	};


}	