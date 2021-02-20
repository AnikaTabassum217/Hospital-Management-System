package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import repository.*;
import entity.*;

public class InsertMedicineFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, BrandNameLabel,ExpDateLabel,ProduceDateLabel,QuantityLabel;
	JTextField nameTF,BrandNameTF,ExpDateTF,ProduceDateTF,QuantityTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	
	Users user=null;
	
	public InsertMedicineFrame(Users user)
	{
		super("Insert Medicine Frame");
		
		this.setSize(400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Insert   Medicine");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 40, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 40, 100, 30);
		panel.add(nameTF);
		
		BrandNameLabel = new JLabel("Brand  Name");
		BrandNameLabel.setBounds(20, 90, 100, 30);
		panel.add(BrandNameLabel);
		
		BrandNameTF = new JTextField();
		BrandNameTF.setBounds(120, 90, 100, 30);
		panel.add(BrandNameTF);
		
		ExpDateLabel = new JLabel("Expired Date");
		ExpDateLabel.setBounds(20, 140, 100, 30);
		panel.add(ExpDateLabel);
		
		ExpDateTF = new JTextField();
		ExpDateTF.setBounds(120, 140, 100, 30);
		panel.add(ExpDateTF);
		
		ProduceDateLabel = new JLabel("Produce  Date");
		ProduceDateLabel.setBounds(20, 190, 100, 30);
		panel.add(ProduceDateLabel);
		
		ProduceDateTF = new JTextField();
		ProduceDateTF.setBounds(120, 190, 100, 30);
		panel.add(ProduceDateTF);
		
		QuantityLabel = new JLabel("Quantity");
		QuantityLabel.setBounds(20, 240, 100, 30);
		panel.add(QuantityLabel);
		
		QuantityTF = new JTextField();
		QuantityTF.setBounds(120, 240, 100, 30);
		panel.add(QuantityTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 300, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220, 300, 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(220, 350, 100, 30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);		
			
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			MedicineRepo m  = new MedicineRepo();
	
	         Medicine medicine = new Medicine();
			 
			medicine.setName(nameTF.getText());
			medicine.setBrandName((BrandNameTF.getText()));
			medicine.setExpDate(ExpDateTF.getText());
			medicine.setProduceDate(ProduceDateTF.getText());
			medicine.setQuantity(Integer.parseInt(QuantityTF.getText()));
		
			
			try{
				
				m.insertMedicine(medicine);	
			
			JOptionPane.showMessageDialog(this, "Medicine Inserted");
	
	        nameTF.setText("");
			BrandNameTF.setText("");
			ExpDateTF.setText("");
			ProduceDateTF.setText("");
			QuantityTF.setText("");
			
			}
			
			catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Medicine creation failed");
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
			EmployeeFrame ef = new EmployeeFrame(user);
			ef.setVisible(true);
			this.setVisible(false);			
		}				
		else{
			System.exit(0);
			}
	}
	
	
}