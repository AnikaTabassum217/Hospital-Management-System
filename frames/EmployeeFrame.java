  package frames;
  
  
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import repository.*;
import entity.*;

public class EmployeeFrame extends JFrame implements ActionListener{
	
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton InsertMedicinebtn,UpdateMedicinebtn,SelectMedicinebtn,DeleteMedicinebtn,logoutbtn, Backbtn;
	JPanel panel;
	
	Users user=null;
	
	public EmployeeFrame(Users user)
	{
		super("EMPLOYEE - LoginFrame ");
		
		this.setSize( 350,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		title = new JLabel("EMPLOYEE");
		title.setBounds(100, 0, 150, 30);
		panel.add(title);
		
		InsertMedicinebtn=new JButton("Insert Medicine");
		InsertMedicinebtn.setBounds(20,40,150,30);
		InsertMedicinebtn.addActionListener(this);
		panel.add(InsertMedicinebtn);
		
		UpdateMedicinebtn=new JButton("Update Medicine");
		UpdateMedicinebtn.setBounds(20,90,150,30);
		UpdateMedicinebtn.addActionListener(this);
		panel.add(UpdateMedicinebtn);
		
		SelectMedicinebtn=new JButton("Select Medicine");
		SelectMedicinebtn.setBounds(20,140,150,30);
		panel.add(SelectMedicinebtn);
		
		DeleteMedicinebtn=new JButton("Delete Medicine");
		DeleteMedicinebtn.setBounds(20,190,150,30);
		DeleteMedicinebtn.addActionListener(this);
		panel.add(DeleteMedicinebtn);
		
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
	
	     if(command.equals(InsertMedicinebtn.getText()))
		{
			InsertMedicineFrame imf = new InsertMedicineFrame(user);
			imf.setVisible(true);
			this.setVisible(false);			
		}
		
		else if(command.equals(UpdateMedicinebtn.getText()))
		{
			UpdateMedicineFrame umf = new UpdateMedicineFrame(user);
			umf.setVisible(true);
			this.setVisible(false);			
		}
		
		else if(command.equals(DeleteMedicinebtn.getText()))
		{
			DeleteMedicineFrame dmf = new DeleteMedicineFrame(user);
			dmf.setVisible(true);
			this.setVisible(false);			
		}
		
		/*else if(command.equals(SelectMedicinebtn.getText()))
		{
			SelectMedicineFrame smf = new SelectMedicineFrame(user);
			smf.setVisible(true);
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