package flowershop.service;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class JTableTest extends JFrame  
{  
  
    public JTableTest(Object[][] obj)  
    {  
        intiComponent(obj);  
    }  
  
    /** 
     * ��ʼ��������� 
     */  
    private void intiComponent(Object[][] obj)  
    {  
        /* 
         * ����JTable������ 
         */  
        String[] columnNames =  
        { "ID", "����", "����", "�۸�", "���", "����","�ϼ����"};  
  
        /* 
         * ��ʼ��JTable��������ֵ����������һģһ����ʵ��"�Կ���"ѧ���� 
         */  
        
          
          
        /* 
         * JTable������һ�ֹ��췽�� 
         */  
        JTable table = new JTable(obj, columnNames);  
        /* 
         * ����JTable����Ĭ�ϵĿ�Ⱥ͸߶� 
         */  
        TableColumn column = null;  
        int colunms = table.getColumnCount();  
        for(int i = 0; i < colunms; i++)  
        {  
            column = table.getColumnModel().getColumn(i);  
            /*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/  
            column.setPreferredWidth(100);  
        }  
        /* 
         * ����JTable�Զ������б��״̬���˴�����Ϊ�ر� 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(300, 200);  

          
          
        add(scroll);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.pack();  
    }  
  
} 