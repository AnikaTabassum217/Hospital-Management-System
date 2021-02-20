package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repository.*;
import entity.*;


public class DeleteEmployeeFrame extends JFrame implements ActionListener{
	
	JLabel title, IDLabel;
	JTextField IDTF;
	
	JButton submitBtn,Logoutbtn,Backbtn;
	JPanel panel;
	
	Users user=null;
	
	public DeleteEmployeeFrame(Users user)
	{
		super("Delete Employee Frame");
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Delete  Employee");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		IDLabel = new JLabel("ID");
		IDLabel.setBounds(20,40, 50, 30);
		panel.add(IDLabel);
		
		IDTF = new JTextField("");
		IDTF.setBounds(80,40, 100, 30);
		panel.add(IDTF);
					
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 100, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(180, 100, 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(180, 150, 100, 30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);		
					
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			UsersRepo ur = new UsersRepo();
			
			try{
				ur.deleteUser(IDTF.getText());					
		
				JOptionPane.showMessageDialog(this, "Employee deleted");
					
				IDTF.setText("");					
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Employee delete failed");
			}
		}
         else if(command.equals(Logoutbtn.getText()))
		{			
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);				
		}			
		else if(command.equals(Backbtn.getText()))
		{
			ManagerFrame mf = new ManagerFrame(user);
			mf.setVisible(true);
			this.setVisible(false);			
		}			
		else{
			System.exit(0);
			}
	}
			
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	