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
	//������������Ҫ���õľ�̬���ڱ���
	static Frame frame = new Frame("flower Shop");
	static Frame frame1 = new Frame("flower Shop");
	static Frame frame2 = new Frame("flower Shop");
	static Frame frame3 = new Frame("flower Shop");
	static JFrame frame20 = new JFrame("usersmenu");
	static JFrame frame201 = new JFrame("�����ʻ�");
	static JFrame frame202 = new JFrame("����");
	static JFrame frame30 =new JFrame("bossmenu");
	static JFrame ckaf = new JFrame("��ѯ���л������");
	static JFrame afks = new JFrame("���ӻ���");
	static JFrame addflnums = new JFrame("���ӻ���");
	static JFrame rdok = new JFrame("�������ۻ���");
	static JFrame rdon = new JFrame("���ٻ���");
	static JFrame chpr = new JFrame("�ı�۸�");
	static JFrame chpw = new JFrame("�޸�����");
	static JFrame frame22 = new JFrame("�û�ע��");
	//static Panel nn = new Panel();
//--------------------------------------------------------------
	public static void main(String[] args) {

		flowershopserviceimpl b = new flowershopserviceimpl();
		userserviceimpl u = new userserviceimpl();

	    b.Init();
	    flower f = new flower();
		String fid;//ID
		String fname;//����
		String fkind;//��������
	    double fprice;//���ļ�Ǯ
		int fstocksum;//��������,ʣ������
		int fsalesum;//��������
		boolean isOnsale;//���¼�
		//int select=0;//�Ƿ�Ҫ������һ��
		int num;//���ӻ���ٻ�������

        //�������к�ĳ�ʼ����frame
		frame.setSize(600,400);//���ڴ�С
		frame.setLocation(500,50);//����λ��

		frame.setLayout(null);//����������пؼ�
		frame.addWindowListener(new WindowAdapter(){//������������Ͻǵ�x�ɹرմ���
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
        //��ʼ����frame��������ť
		JButton button1 =new JButton("�ο͵�¼");
		JButton button2 =new JButton("�û���¼");
		JButton button3 =new JButton("�곤��¼");
		button1.setBounds(200,100,200,40);
		button2.setBounds(200,160,200,40);
		button3.setBounds(200,220,200,40);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.setVisible(true);//��ʾframe����


        //��ť���ο͵�½����ʵ��
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				closeThis();//�ر���һ������frame

				JFrame frame1 = new JFrame("�ο͵�¼");//�����µĴ���frame1
				frame1.setLayout(null);

                //�½����ڵİ�ť
				JButton buttonsee1 = new JButton("������Ϣ");
				JButton buttonsee2 = new JButton("�̵���Ϣ");
				JButton buttonback = new JButton("�˳�");




				frame1.setLocation(500,50);

				frame1.setSize(600,400);



                //��ť��λ��
				buttonsee1.setBounds(200,60,200,40);
				buttonsee2.setBounds(200,120,200,40);
				buttonback.setBounds(200,180,200,40);
				frame1.add(buttonsee1);
				frame1.add(buttonsee2);
				frame1.add(buttonback);
                
                //��ť��������Ϣ����ʵ��
				buttonsee1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent f){
						b.find();
						JTableTest A=new JTableTest(b.obj);//�����ݿ����Ϣ�Ա�����ʽ��ʾ
						
					}
				});
				//��ť���̵���Ϣ����ʵ��
				buttonsee2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent g){
						System.out.println("�����Ϊ���ֻ�Ա���ƽ��Ա���׽��Ա����ͨ��Ա�Լ���ͨ�û������лƽ��Ա�����ʻ���8�ۣ��׽��Ա��5�ۣ���ͨ��Ա�����ۣ���ͨ�û�������");
					}
				});
				//��ť���˳�����ʵ��
				buttonback.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent h){
						closeThis1();//�رմ���frame1
						frame.setVisible(true);//�ص�����frame
					}
				});
				


				frame1.setVisible(true);
			}

		});
        //��ť���û���¼����ʵ��
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){


				closeThis();

				JFrame frame2 = new JFrame("�û���¼");

				user user = null;//����һ����ʼ��user����

				frame2.setLayout(null);

				JLabel usersname = new JLabel("�û���:");
				JLabel password = new JLabel("����:");
				JTextField uu1 = new JTextField();
				JTextField p1 = new JTextField();
				JButton n1 = new JButton("��½");
				JButton n2 = new JButton("ע��");
				JButton n3 = new JButton("����");

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


                //��½��ť��ʵ��
				n1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent i){
						int temp = 0;
						//�ж�������û��Ƿ����
						if(u.isExistUser(uu1.getText(),p1.getText())){//uu1.getText()���ڻ�ȡ�û��ڿؼ�uu1����������ݣ�p1.getText()ͬ��
							System.out.println("right!");
							temp = 1;

						}
						//ͨ���ж�����if����Ƿ�ִ����ִ�д˴�if���
						if(temp==1){

							closeThis2();//�رմ���frame2

							frame20.setLayout(null);
							frame20.setLocation(500,50);

				              frame20.setSize(800,600);



                            //�û���½��ĸ��ְ�ť�Ķ���
				            JButton checkcbuyflower = new JButton("�鿴�ɹ����ʻ���Ϣ");
				            JButton buyflowerinCart = new JButton("�򻨼��빺�ﳵ");
				            JButton checkCart = new JButton("�鿴���ﳵ");

				            JButton bill = new JButton("����");
				            JButton checklevel = new JButton("�鿴��Ա��Ϣ�ȼ�");
				            JButton changepassword = new JButton("�޸�����");
				            JButton exit1 = new JButton("�˳�ϵͳ");


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

                            //���ְ�ť�Ĺ���ʵ��
				            checkcbuyflower.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.printFlower();//��ӡ�ɹ�����ʻ���Ϣ
									JTableTest A=new JTableTest(u.obj);//ͨ���������ʻ���Ϣ
				            	}
				            });
				            buyflowerinCart.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){

				            		frame201.setLayout(null);

				            		frame201.setLocation(500,50);
				            		frame201.setSize(600,400);
				            		JLabel buyinid = new JLabel("������ID��");
				            		JLabel buyinnumber = new JLabel("����������");
				            		JTextField bii = new JTextField();
				            		JTextField bin = new JTextField();
				            		JButton enter2 = new JButton("ȷ��");

				            		
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
				            				String fid = bii.getText();  //�����ַ�������fid���ڻ�ȡ�û������빺����ʻ���id
				            				int nUmber = Integer.parseInt(bin.getText());
				            				                             //�������ͱ���nUmber���ڻ�ȡ�û�������Ҫ���������
				            				
				            				u.addCar(u.getU().get(uu1.getText()),u.getB().searchID(fid),nUmber);
				            				                             //����������ʻ����빺�ﳵ

				            				
				            				
				            				closeThis201();

				            			}
				                    });




				            		frame201.setVisible(true);

				            	}
				            });
				            checkCart.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.printCar(u.getU().get(uu1.getText()));//��ӡ���ﳵ��Ϣ
				            	}
				            });
				            bill.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.pay(u.getU().get(uu1.getText()));//���ڽ��㹺�ﳵ
				            		frame202.setBounds(700,100,200,200);
				            		JButton enter3 = new JButton("���˳ɹ�");
				            		enter3.setBounds(60,60,40,40);

				            		frame202.add(enter3);

				            		frame202.setVisible(true);

				            	}
				            });
				            checklevel.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		u.getU().get(uu1.getText()).print();//��ӡ����ǰ�û��Ļ�Ա�ȼ�
				            	}
				            });
				            changepassword.addActionListener(new ActionListener(){
				            	public void actionPerformed(ActionEvent h){
				            		chpw.setLayout(null);
				            		chpw.setBounds(500,50,600,400);

				            		JLabel oldpw = new JLabel("����������룺");
				            		JLabel newpw = new JLabel("�����������룺");
				            		JLabel renewpw = new JLabel("���ٴ����������룺");
				            		JTextField oldPw = new JTextField();
				            		JTextField newPw = new JTextField();
				            		JTextField renewPw = new JTextField();
				            		JButton ensure6 = new JButton("ȷ��");

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
				            				                   //�����ַ�������password1���ڻ�ȡ�û�����ľ�����
				            				String password2 = newPw.getText();
				            				                   //�����ַ�������password2���ڻ�ȡ�û������������
				            				String password3 = renewPw.getText();
				            				                   //�����ַ�������password3���ڻ�ȡ�û��ٴ������������

                                            //�ж��û�����ľ������Ƿ���ϵ�ǰ�û�����
				            				if(!password1.equals(u.getU().get(uu1.getText()).getUpassword())) {
			    		                        System.out.println("���������룡");
			    	                        }
			    	                        else {
                                                //�ж��û���������������ٴ�������������Ƿ�һ��
			    		                        if(password2.equals(password3)) {
			    			                        u.changePass(u.getU().get(uu1.getText()), password2);//�����޸�����ĺ���
			    			                        System.out.print("�޸ĳɹ���");
			    			                       
			    		                        }
			    		                        else {
			    			                        System.out.println("���������룡");
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
                //ע�ᰴť��ʵ��
				n2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent f){
						closeThis20();

						frame22.setLayout(null);
						
						frame22.setBounds(500,50,600,400);

						JLabel zu1 = new JLabel("�û���:");
						JLabel zp1 = new JLabel("����:");
						JTextField zu2 = new JTextField();//�û������ע���˻�
						JTextField zp2 = new JTextField();//�û������ע������
						JButton ensure0 = new JButton("ȷ��");
						

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
			            		String nu = zu2.getText();//����nu��ȡ�û������ע���˺�
			            		String np = zp2.getText();//np��ȡ�û������ע������

			            		if(u.addUser(nu, np)) {//�ж�ע���˻��Ƿ����
			          			            		System.out.println("ע��ɹ�");  			
			            		}
			            		

			            	}
			            });
						
						frame22.setVisible(true);
						
					}
				});
				//����frame���ڵİ�ť
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
        //�곤��ť��ʵ��
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				closeThis1();


				JFrame frame3 = new JFrame("�곤��¼");

				frame3.setLayout(null);

				JLabel mpassword = new JLabel("����:");
				JTextField mp = new JTextField();

				JButton enter1 = new JButton("����");
				JButton backs = new JButton("�˳�");
				mpassword.setBounds(200,120,80,40);
				mp.setBounds(280,120,80,40);
				enter1.setBounds(200,200,60,40);
				backs.setBounds(320,200,60,40);

				frame3.add(mpassword);
				frame3.add(mp);
				frame3.add(enter1);
				frame3.add(backs);
                //��½�곤
				enter1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent k){
						int tp = 0;
						String pass1 = mp.getText();//��ȡ�û�����ĵ곤����
						//�ж��û�����ĵ곤�����Ƿ���ȷ
						if(pass1.equals(b.getBpassWord())){
							System.out.println("right!");
							tp = 1;
						}
						//ͨ���ж�����if����Ƿ�ִ�н���ִ�е�½��Ĺ���
						if(tp==1){
							closeThis3();
							frame30.setLayout(null);

							frame30.setBounds(500,50,600,400);


							JButton checkallflowers = new JButton("��ѯ���л������");
							JButton addkinds = new JButton("���ӻ���");
							JButton addnums = new JButton("���ӻ���");
							JButton reduceonsalekinds = new JButton("�������ۻ���");
							JButton reducenums = new JButton("���ٻ���");
							JButton changeprice = new JButton("�ı�۸�");
							JButton bestselling = new JButton("������ͳ��");
							JButton exit2 = new JButton("�˳�");

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

                            //�鿴�����ʻ���Ϣ
							checkallflowers.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();

									ckaf.setLayout(null);

									JButton showall = new JButton("��ʾȫ���ʻ���Ϣ");
									JButton fid = new JButton("�����ʻ�ID��ѯ");
									JButton fname = new JButton("�����ʻ����Ʋ�ѯ");
									JButton back1 = new JButton("����");

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
											b.find();//��ʾ�����ʻ���Ϣ
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
							//����ʻ�����
							addkinds.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();

									afks.setLayout(null);

									afks.setBounds(500,50,600,400);

									JLabel inputkinds = new JLabel("�����µĻ���ID:");
									JLabel aname = new JLabel("����:");
									JLabel akind = new JLabel("����:");
									JLabel aprice = new JLabel("�۸�:");
									JLabel anums = new JLabel("����:");
									JTextField ipk = new JTextField();
									JTextField ana = new JTextField();
									JTextField ak = new JTextField();
									JTextField ap = new JTextField();
									JTextField anu = new JTextField();
									JButton ensure1 = new JButton("ȷ��");

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

                                            
											int fsalesum = 0;//�¼����ʻ���Ĭ��������Ϊ0
									        boolean isOnsale = true;//�¼����ʻ���Ĭ��״̬Ϊ�ϼ�
									        double fprice = Double.parseDouble(ap.getText());//ǿ��ת������ȡ�¼����ʻ��ļ۸�
									        int fstocksum = Integer.parseInt(anu.getText());//ǿ��ת������ȡ�¼����ʻ�������

                                            //�����µ��ʻ�����
									        flower fnew = new flower(ipk.getText(),ana.getText(),ak.getText(),fprice,fstocksum,fsalesum,isOnsale);
									        b.add_kind(fnew);//�������ʻ�
									        frame30.setVisible(true);
										}
									});



									afks.setVisible(true);
								}
							});
							//�����ʻ�����
							addnums.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){

									closeThis30();

									addflnums.setLayout(null);

									addflnums.setBounds(500,50,600,400);

									JLabel aid = new JLabel("���ӻ���Id��");
									JLabel anumber = new JLabel("����������");
									JTextField caid = new JTextField();
									JTextField canumber = new JTextField();
									JButton ensure2 = new JButton("ȷ��");

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
											String fid = caid.getText();//��ȡ��Ҫ�����ʻ���id
											int num = Integer.parseInt(canumber.getText());//ǿ��ת������ȡ��Ҫ�����ʻ�������
											b.add_num(fid,num);//�����µ�����
											frame30.setVisible(true);
										}
									});

									addflnums.setVisible(true);
								}
							});
							//���������ʻ������¼�
							reduceonsalekinds.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){


									rdok.setLayout(null);
									rdok.setBounds(600,50,600,40);

									JLabel reid = new JLabel("�¼ܻ���ID��");

									JTextField reID = new JTextField("");
									JButton ensure3 = new JButton("ȷ��");

									reid.setBounds(200,10,80,40);
									reID.setBounds(300,10,80,40);
									ensure3.setBounds(300,60,80,40);

									rdok.add(reid);
									rdok.add(reID);
									rdok.add(ensure3);

									ensure3.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent f){
											closeThisrdok();
											b.changeIsonsale(false,reID.getText());//���øı�״̬�������¼��ʻ�
											frame30.setVisible(true);
								        }
								    });

									rdok.setVisible(true);
								}
							});
							//�����ʻ�����
							reducenums.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();
									rdon.setLayout(null);
									rdon.setBounds(600,50,600,400);

									JLabel renumid = new JLabel("���ٻ���ID��");
									JLabel renum = new JLabel("��������");
									JTextField renumID = new JTextField();
									JTextField reNum = new JTextField();

									JButton ensure4 = new JButton("ȷ��");

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
											flower fdel = new flower(); //�����µ��ʻ�����
											fdel = b.getFlowers().get(renumID.getText());//��ȡ��Ҫ���ٵ��ʻ�����
											int number = Integer.parseInt(reNum.getText());//��ȡ��Ҫ���ٵ�����
											b.del_num(renumID.getText(),number);//ִ�м��ٺ���
											frame30.setVisible(true);
								        }
								    });

									rdon.setVisible(true);
									
								}
							});
							//�ı��ʻ��۸�
							changeprice.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									closeThis30();
									chpr.setLayout(null);
									chpr.setBounds(600,50,600,400);

									JLabel chid = new JLabel("�ļۻ���ID��");
									JLabel chprice = new JLabel("�ı��ļ۸�");
									JTextField chID = new JTextField();
									JTextField chPrice = new JTextField();

									JButton ensure5 = new JButton("ȷ��");

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

											double fprice = Double.parseDouble(chPrice.getText());//��ȡ�ı��ļ۸�

											b.changePrice(fprice,chID.getText());//�ı�۸�
											frame30.setVisible(true);
								        }
								    });

									chpr.setVisible(true);
									
								}
							});
							//��ʾ��������ʻ�
							bestselling.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent f){
									System.out.println("����������Ϣ");
									Set<String> keys=b.bestSale().keySet();//ȡ������key�ļ���
									Iterator it=keys.iterator();//��ȡIterator����
									while(it.hasNext()){
										String key=(String)it.next();  //ȡ��key
										flower dog=(flower)b.bestSale().get(key);  //����keyȡ����Ӧ��ֵ
										dog.print();
									}
									keys.clear();
									
								}
							});
							//�˳��곤����
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
                //�˳��곤��½����
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


//���ڹرն����˾�̬�����Ĵ���
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