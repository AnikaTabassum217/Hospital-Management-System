package repository;

import java.lang.*;
import entity.*;
import interfaces.*;
import java.util.*;

public class MedicineRepo implements IMedicineRepo
{
	DatabaseConnection dbc = null;
	
	public MedicineRepo()
	{
		dbc = new DatabaseConnection();
	}
	public Medicine getMedicine(String ID)
	{
		Medicine medicine = null;
		String query = "   ";
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				medicine = new Medicine();
				
				medicine.setID(dbc.result.getInt("ID"));
				medicine.setName(dbc.result.getString("Name"));
				medicine.setBrandName(dbc.result.getString("BrandName"));				
				medicine.setExpDate(dbc.result.getString("ExpDate"));
				medicine.setProduceDate(dbc.result.getString("ProductDate"));
				medicine.setQuantity(dbc.result.getInt("Quantity"));
			}
		}
		  catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return medicine;
	}
	
	
     public void insertMedicine(Medicine m)
	{
String query = "INSERT INTO medicine_details (ID, Name, BrandName, ExpDate, ProduceDate,Quantity) VALUES (NULL,'"
 +m.getName()+"','"+m.getBrandName()+"','"+m.getExpDate()+"','"+m.getProduceDate()+"',"+m.getQuantity()+");";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			}
			dbc.closeConnection();
	}

	
		public void updateMedicine(Medicine m)
	{
			
		String query = "UPDATE  medicine_details SET Name='"+m.getName()+"',BrandName='"+m.getBrandName()
		+"',ExpDate ='"+m.getExpDate()+"',ProduceDate='"+m.getProduceDate()+"',Quantity="+m.getQuantity()
		+" WHERE  ID ="+m.getID()+";";
		
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);			
		}		
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		dbc.closeConnection();
	}

   public void deleteMedicine(String ID)
	{
		String query = "DELETE from medicine_details  WHERE ID='"+ID+"';";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		dbc.closeConnection();
	}

	
	/*public Medicine searchMedicine(String ID)
	{
		Medicine medicine = null;
		
		String query = "  "; 
		
		try
		{
			//System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				 medicine = new Medicine();
				
				medicine.setID(dbc.result.getInt("ID"));
				medicine.setName(dbc.result.getString("Name"));
				medicine.setBrandName(dbc.result.getString("BrandName"));				
				medicine.setExpDate(dbc.result.getString("ExpDate"));
				medicine.setProduceDate(dbc.result.getString("ProductDate"));
				medicine.setQuantity(dbc.result.getInt("Quantity"));			
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return medicine;
	}*/
}