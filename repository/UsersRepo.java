package repository;

import java.lang.*;
import java.util.*;
import entity.*;
import interfaces.*;

public class UsersRepo implements IUsersRepo
{
	DatabaseConnection dbc = null;
	
	public UsersRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public Users getUser(String name, String pass)
	{
		Users user = null;
		String query = "Select * from users where Name = '"+name+"' and Passward = '"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
			System.out.println("Query complete");
			while(dbc.result.next())
			{
				user = new Users();
				System.out.println("inside while");
				
				user.setID(dbc.result.getInt("ID"));
				user.setPassward(dbc.result.getString("Passward"));
				user.setAge(dbc.result.getInt("Age"));				
				user.setName(dbc.result.getString("Name"));	
				user.setType(dbc.result.getString("Type"));				
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	
	public void insertUser(Users u)
	{
		String query = "INSERT INTO users (ID, Name, Age, Passward, Type) VALUES (NULL,'"
						+u.getName()+"',"+u.getAge()+",'"+u.getPassward()+"','"+u.getType()+"');";
						
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		dbc.closeConnection();
	}
	
	
	public void updateUser(Users u)
	{
			
		String query = "UPDATE users SET Name = '" +u.getName()
						+"',Age = "+u.getAge()
						+",Passward = '"+u.getPassward()
						+"',Type = '"+u.getType()+"'  WHERE ID = " +u.getID()+";";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}
		dbc.closeConnection();
	}
	
	
	public void deleteUser(String Id)
	{
		String query = "DELETE from users  WHERE ID='"+Id+"';";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dbc.closeConnection();
	}
	
	
	/*public Users searchUser(String userId)
	{
		Users user = null;
		String query = "SELECT * FROM Users WHERE ID='"+userId+"';";  

		//System.out.println(query);		
		try
		{
			//System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				user = new Users();				
				user.setID(dbc.result.getInt("ID"));
				user.setPassward(dbc.result.getString("Passward"));
				user.setAge(dbc.result.getInt("Age"));				
				user.setName(dbc.result.getString("Name"));				
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}*/
	
	
	public String[][] getAllUserByType(String type)
	{
		List<Users> userList = new ArrayList();
		String query = "SELECT * FROM users WHERE Type='"+type+"';";  

		System.out.println(query);		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				Users user  = new Users();				
				user.setID(dbc.result.getInt("ID"));
				user.setAge(dbc.result.getInt("Age"));				
				user.setName(dbc.result.getString("Name"));		

				userList.add(user);		
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		
				Object obj[] = userList.toArray();
		String data[][] = new String [userList.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Users)obj[i]).getID()+"";			
			data[i][1] = ((Users)obj[i]).getName();
			data[i][2] = (((Users)obj[i]).getAge())+"";
		}
		return data;		
	}
}