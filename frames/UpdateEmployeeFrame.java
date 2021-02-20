package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repository.*;
import entity.*;

public class UpdateEmployeeFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, ageLabel,passwordLabel,updateLabel;
	JTextField nameTF,ageTF,updateTF;
	JPasswordField passwordTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	
	Users user=null;
	
	public UpdateEmployeeFrame(Users user)
	{
		super("Update Employee Frame");
		
		this.setSize(350, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Update    Employee");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		updateLabel = new JLabel("Update ID");
		updateLabel.setBounds(20, 40, 100, 30);
		panel.add(updateLabel);
		
		updateTF = new JTextField();
		updateTF.setBounds(120, 40, 100, 30);
		panel.add(updateTF);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 90, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 90, 100, 30);
		panel.add(nameTF);
		
		ageLabel = new JLabel("Age");
		ageLabel.setBounds(20, 140, 100, 30);
		panel.add(ageLabel);
		
		ageTF = new JTextField();
		ageTF.setBounds(120, 140, 100, 30);
		panel.add(ageTF);
		
		passwordLabel = new JLabel("Passward");
		passwordLabel.setBounds(20, 190, 100, 30);
		panel.add(passwordLabel);

		passwordTF = new JPasswordField();
		passwordTF.setBounds(120, 190, 100, 30);
		panel.add(passwordTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 240, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220,240 , 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(220, 280, 100, 30);
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
			
			user.setID(Integer.parseInt(updateTF.getText()));
			user.setName(nameTF.getText());
			user.setAge(Integer.parseInt(ageTF.getText()));
			user.setPassward(passwordTF.getText());
			
			user.setType("Employee");
			
				try{
				ur.updateUser(user);		
								
				JOptionPane.showMessageDialog(this, "Employee updated");	
				
				nameTF.setText("");
				ageTF.setText("");
				passwordTF.setText("");
				updateTF.setText("");	
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Employee update failed");
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
			ManagerFrame ef = new ManagerFrame(user);
			ef.setVisible(true);
			this.setVisible(false);			
		}
	}
	
}