package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repository.*;
import entity.*;


public class LoginFrame extends JFrame implements ActionListener{
	
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn;
	JPanel panel;
	
	public LoginFrame()
	{
		super("PHARMACY MANAGMENT SYSTEM - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("");
		title.setBounds(300, 50, 350, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setEchoChar(' ');
		panel.add(passPF);
		
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UsersRepo ur = new UsersRepo();
			Users user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getType().equals("MANAGER")) {
					ManagerFrame mf = new ManagerFrame(user);
					mf.setVisible(true);
					this.setVisible(false);
				} else if(user.getType().equals("EMPLOYEE")) {
					EmployeeFrame ef = new EmployeeFrame(user);
					ef.setVisible(true);
					this.setVisible(false);
				} 
			}
		}
	}
}