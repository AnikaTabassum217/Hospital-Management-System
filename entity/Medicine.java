package entity;

import java.lang.*;

public class Medicine{
	private int ID;
	private String Name;
	private String BrandName;
	private String ExpDate;
	private String ProduceDate;
	private int Quantity;
	
	public Medicine(){
		System.out.println("Empty-constructor");
	}
	
	public Medicine(int ID,String Name,String BrandName,String ExpDate,String ProduceDate,int Quantity){
		this.ID=ID;
		this.Name=Name;
		this.BrandName=BrandName;
		this.ExpDate=ExpDate;
		this.ProduceDate=ProduceDate;
		this.Quantity=Quantity;
	}
	
	public void setID(int ID){
		this.ID=ID;
	}
	public void setName(String Name){
		this.Name=Name;
	}
	public void setBrandName(String BrandName){
		this.BrandName=BrandName;
	}
	public void setExpDate(String ExpDate){
		this.ExpDate=ExpDate;
	}
	public void setProduceDate(String ProduceDate){
		this.ProduceDate=ProduceDate;
	}
	public void setQuantity(int Quantity){
		this.Quantity=Quantity;
	}
	public int getID(){
		return ID;
	}
	public  String getName(){
		return Name;
	}
	public String getBrandName(){
		return BrandName;
	}
	public String  getExpDate(){
		 return ExpDate;
	}
	public String getProduceDate(){
		return ProduceDate;
	}
	public int getQuantity(){
		return Quantity;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	