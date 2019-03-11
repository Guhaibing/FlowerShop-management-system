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
     * 初始化窗体组件 
     */  
    private void intiComponent(Object[][] obj)  
    {  
        /* 
         * 设置JTable的列名 
         */  
        String[] columnNames =  
        { "ID", "花名", "花类", "价格", "库存", "销量","上架情况"};  
  
        /* 
         * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。 
         */  
        
          
          
        /* 
         * JTable的其中一种构造方法 
         */  
        JTable table = new JTable(obj, columnNames);  
        /* 
         * 设置JTable的列默认的宽度和高度 
         */  
        TableColumn column = null;  
        int colunms = table.getColumnCount();  
        for(int i = 0; i < colunms; i++)  
        {  
            column = table.getColumnModel().getColumn(i);  
            /*将每一列的默认宽度设置为100*/  
            column.setPreferredWidth(100);  
        }  
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(300, 200);  

          
          
        add(scroll);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.pack();  
    }  
  
} 