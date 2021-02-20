package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repository.*;
import entity.*;

public class ManagerFrame extends JFrame implements ActionListener{
	
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton InsertEmployeebtn,UpdateEmployeebtn,SelectEmployeebtn,DeleteEmployeebtn,logoutbtn, Backbtn;
	JPanel panel;
	
	Users user=null;
	
	public ManagerFrame(Users user)
	{
		super("MANAGER - LoginFrame ");
		
		this.setSize( 350,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.user=user;
	
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		title = new JLabel("MANAGER");
		title.setBounds(100, 0, 150, 30);
		panel.add(title);
		
		InsertEmployeebtn=new JButton("Insert Employee");
		InsertEmployeebtn.setBounds(20,40,150,30);
		InsertEmployeebtn.addActionListener(this);
		panel.add(InsertEmployeebtn);
		
		UpdateEmployeebtn=new JButton("Update Employee");
		UpdateEmployeebtn.setBounds(20,90,150,30);
		panel.add(UpdateEmployeebtn);
		
		SelectEmployeebtn=new JButton("Select Employee");
		SelectEmployeebtn.setBounds(20,140,150,30);
		panel.add(SelectEmployeebtn);
		
		DeleteEmployeebtn=new JButton("Delete Employee");
		DeleteEmployeebtn.setBounds(20,190,150,30);
		DeleteEmployeebtn.addActionListener(this);
		panel.add(DeleteEmployeebtn);
		
		logoutbtn=new JButton("Logout");
		logoutbtn.setBounds(20,250,100,30);
		logoutbtn.addActionListener(this);
		panel.add(logoutbtn);
		
		Backbtn=new JButton("Back");
		Backbtn.setBounds(160,250,100,30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
	
	    if(command.equals(InsertEmployeebtn.getText()))
		{
			InsertEmployeeFrame ief = new InsertEmployeeFrame(user);
			ief.setVisible(true);
			this.setVisible(false);			
		}
		
		/*else if(command.equals(UpdateEmployeebtn.getText()))
		{
			UpdateEmployeeFrame uef = new UpdateEmployeeFrame(user);
			uef.setVisible(true);
			this.setVisible(false);			
		}*/
		
		else if(command.equals(DeleteEmployeebtn.getText()))
		{
			DeleteEmployeeFrame def = new DeleteEmployeeFrame(user);
			def.setVisible(true);
			this.setVisible(false);			
		}
	
	    /*else if(command.equals(SelectEmployeebtn.getText()))
		{
			SelectEmployeeFrame sef = new SelectEmployeeFrame(user);
			sef.setVisible(true);
			this.setVisible(false);			
		}*/
		
		 if(command.equals(logoutbtn.getText()))
		{
		    LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);	
		}
	    
		else if(command.equals(Backbtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}		
				
		else{}
	}	
}
		