package MongoDBProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;

public class Table {
	JFrame f;
	public Table(Object data[][]) {
	//Setup JFrame
	JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f=new JFrame("查詢結果");
    f.setSize(1000,1000);
    f.setLocationRelativeTo(null);
    Container cp=f.getContentPane();	
	//Build Elements
    
	String[] columns={"_id","password","amount","name","birth","gender","address","contact"};
	JTable jt=new JTable(data,columns);
    jt.setPreferredScrollableViewportSize(new Dimension(1000,1000));

    /* 調整欄寬尚未完成
    jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TableColumn col = jt.getColumnModel().getColumn(0);
    int width = 100;
    col.setPreferredWidth(width);
    */
    
    cp.add(new JScrollPane(jt),BorderLayout.CENTER);
    
    f.setVisible(true);
    //Close JFrame       
    }
}