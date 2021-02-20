package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import repository.*;
import entity.*;


public class InsertEmployeeFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, ageLabel,passwordLabel;
	JTextField nameTF,ageTF;
	JPasswordField passwordTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	
	Users user=null;
	
	public InsertEmployeeFrame(Users user)
	{
		super("Insert Employee Frame");
		
		this.setSize(350, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Insert    Employee");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 40, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 40, 100, 30);
		panel.add(nameTF);
		
		ageLabel = new JLabel("Age");
		ageLabel.setBounds(20, 90, 100, 30);
		panel.add(ageLabel);
		
		ageTF = new JTextField();
		ageTF.setBounds(120, 90, 100, 30);
		panel.add(ageTF);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 140, 100, 30);
		panel.add(passwordLabel);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(120, 140, 100, 30);
		panel.add(passwordTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 210, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220,210 , 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(220, 260, 100, 30);
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
	
	         Users user = new Users();
	
	        user.setName(nameTF.getText());
			user.setAge(Integer.parseInt(ageTF.getText()));
			user.setPassward(passwordTF.getText());
			user.setType("EMPLOYEE");
			
			try{
				ur.insertUser(user);							
				
				
				
				JOptionPane.showMessageDialog(this, "Employee created");
				
				nameTF.setText("");
				ageTF.setText("");
				passwordTF.setText("");
				
				} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Employee creation failed");
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