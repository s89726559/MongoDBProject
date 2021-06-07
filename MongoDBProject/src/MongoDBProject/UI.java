package MongoDBProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI {
	MongoDB m1=new MongoDB();
	
	JButton btn1 = new JButton("��id�d�߸��");
	JButton btn2 = new JButton("�d�ߥ������");
	JButton btn3 = new JButton("�s�W");
	JButton btn4 = new JButton("�R��");
	JButton btn5 = new JButton("�ק���B");
	
	//�s�W�Ϊ���J
    JTextField field1 = new JTextField(20);
    JTextField field2 = new JTextField(20);
    JTextField field3 = new JTextField(20);
    JTextField field4 = new JTextField(20);
    JTextField field5 = new JTextField(20);
    JTextField field6 = new JTextField(20);
    JTextField field7 = new JTextField(20);
    JTextField field8 = new JTextField(20);
    JTextField field9 = new JTextField(20);
    JTextField field10 = new JTextField(20);
	
	ButtonHandler handler =new ButtonHandler();
	
	public UI() {
		//JFrame
		JFrame window=new JFrame("�b��޲z�t��");
	    window.setBounds(0,0,450,320);
	    window.setLocationRelativeTo(null);
	    window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    
	    //Container
	    Container contentPane = window.getContentPane();
	    contentPane.setLayout(new GridLayout(5,1,1,1));
	    JPanel[] panel=new JPanel[5];
	    for(int i=0;i<5;i++) {
	    	panel[i]=new JPanel();
	    }
	    
	    
	    //Panel[0]
	    btn1.addActionListener(handler);
	    panel[0].add(btn1);
	    
	    //Panel[1]
	    btn2.addActionListener(handler);
	    panel[1].add(btn2);
	    
	    //Panel[2]
	    btn3.addActionListener(handler);
	    panel[2].add(btn3);
	    
	    //Panel[3]
	    btn4.addActionListener(handler);
	    panel[3].add(btn4);
	    
	    //Panel[4]
	    btn5.addActionListener(handler);
	    panel[4].add(btn5);
	    
	    contentPane.add(panel[0]);
        contentPane.add(panel[1]);
        contentPane.add(panel[2]);
        contentPane.add(panel[3]);
        contentPane.add(panel[4]);
	    
        
        window.setVisible(true);
        
	}
	
	public class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			if(event.getActionCommand()=="��id�d�߸��") {
				String id;
				id = JOptionPane.showInputDialog("�п�Jid");
				m1.findOne(id);
			}
			
			if(event.getActionCommand()=="�d�ߥ������") {
				m1.findAll();
			}
			
			if(event.getActionCommand()=="�s�W") {
				
				JFrame frame=new JFrame("�s�W���");
				frame.setBounds(0,0,450,450);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
			    //Container
			    Container contentPaneAdd = frame.getContentPane();
			    contentPaneAdd.setLayout(new GridLayout(11,1,1,1));
			    JPanel[] panel=new JPanel[11];
			    for(int i=0;i<11;i++) {
			    	panel[i]=new JPanel();
			    	panel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			    }
			    
			    JLabel label1=new JLabel("id");
			    JLabel label2=new JLabel("password");
			    JLabel label3=new JLabel("amount");
			    JLabel label4=new JLabel("name");
			    JLabel label5=new JLabel("birth");
			    JLabel label6=new JLabel("gender");
			    JLabel label7=new JLabel("address");
			    JLabel label8=new JLabel("telephone");
			    JLabel label9=new JLabel("mobile");
			    JLabel label10=new JLabel("email");
			    
			    JButton btnAdd = new JButton("�s�W���");
			    
			    field1.addActionListener(handler);
			    field2.addActionListener(handler);
			    field3.addActionListener(handler);
			    field4.addActionListener(handler);
			    field5.addActionListener(handler);
			    field6.addActionListener(handler);
			    field7.addActionListener(handler);
			    field8.addActionListener(handler);
			    field9.addActionListener(handler);
			    field10.addActionListener(handler);
			    
			    
			    panel[0].add(label1);
			    panel[0].add(field1);
			    panel[1].add(label2);
			    panel[1].add(field2);
			    panel[2].add(label3);
			    panel[2].add(field3);
			    panel[3].add(label4);
			    panel[3].add(field4);
			    panel[4].add(label5);
			    panel[4].add(field5);
			    panel[5].add(label6);
			    panel[5].add(field6);
			    panel[6].add(label7);
			    panel[6].add(field7);
			    panel[7].add(label8);
			    panel[7].add(field8);
			    panel[8].add(label9);
			    panel[8].add(field9);
			    panel[9].add(label10);
			    panel[9].add(field10);
			    panel[10].add(btnAdd);

			    contentPaneAdd.add(panel[0]);
		        contentPaneAdd.add(panel[1]);
		        contentPaneAdd.add(panel[2]);
		        contentPaneAdd.add(panel[3]);
		        contentPaneAdd.add(panel[4]);
		        contentPaneAdd.add(panel[5]);
		        contentPaneAdd.add(panel[6]);
		        contentPaneAdd.add(panel[7]);
		        contentPaneAdd.add(panel[8]);
		        contentPaneAdd.add(panel[9]);
		        contentPaneAdd.add(panel[10]);
			    
			    frame.setVisible(true);
			    
			    btnAdd.addActionListener(handler);
			    
			}
			
			
			if(event.getActionCommand()=="�s�W���") {
				//test
				//System.out.printf("%s \n",field1.getText());
				//System.out.printf("%d \n",Integer.parseInt(field3.getText()));
				
				m1.insert(field1.getText(), field2.getText(), Integer.parseInt(field3.getText()), field4.getText(), field5.getText(), field6.getText(), field7.getText(), field8.getText(), field9.getText(), field10.getText());
			}
			
			
			if(event.getActionCommand()=="�R��") {
				String id;
				id = JOptionPane.showInputDialog("�п�J�n�R����id");
				m1.deleteOne(id);
			}
			
			if(event.getActionCommand()=="�ק���B") {
				String id;
				int amount;
				id = JOptionPane.showInputDialog("�п�J�n�ק諸id");
				amount=Integer.parseInt(JOptionPane.showInputDialog("�п�J�n�ק諸���B"));
				m1.updateOne(id,amount);
			}
			
		}
	}
	
	
}
	
