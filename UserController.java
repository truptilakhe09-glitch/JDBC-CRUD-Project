package in.soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.soft.Factory.ServiceFactory;
import in.soft.UserService.UserService;
import in.soft.entity.User;

public class UserController {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		User user = new User();
		
		UserService service = ServiceFactory.getService();

		
		while(true)
			
		{
			System.out.println("******** perform crud Operation **********");
			System.out.println("To Insert user select 1 : Insert ");
			System.out.println("To search user select 2 : Search ");
			System.out.println("To Update user select 3 : Update ");
			System.out.println("To Delete user select 4 : Delete ");
			System.out.println("To Exit  select 5 : Exit ");
			
			System.out.println();
			Integer option;
			
			System.out.println("please select a Options [1,2,3,4,5]: ");
			option = Integer.parseInt(br.readLine());
			
			switch (option) {
			case 1: 
				
				
				System.out.println("****please enter a user details ****");
				
				System.out.print("enter the user ID  =   ");
				int uid = Integer.parseInt(br.readLine());
				
				System.out.print("enter the user Name  =");
				String uname = br.readLine();
				
				System.out.print("enter the user salary =");
				float usal = Float.parseFloat(br.readLine());
				
				System.out.print("enter the user address =");
				String uaddr = br.readLine();
				
				user.setUid(uid);
				user.setUname(uname);
				user.setUsal(usal);
				user.setUadd(uaddr);
				
				 String userInsert = service.userInsert(user);
				System.out.println(userInsert);
				
				break;
			
			case 2:
			    System.out.println("********* Search Operation ********");
			    System.out.print("Enter the User ID: ");

			    int id = Integer.parseInt(br.readLine());

			    User u = service.userSearch(id);

			    if (u != null) {
			        System.out.println("******* USER DETAILS *********");
			        System.out.println("User ID      = " + u.getUid());
			        System.out.println("User Name    = " + u.getUname());
			        System.out.println("User Salary  = " + u.getUsal());
			        System.out.println("User Address = " + u.getUadd());
			        System.out.println("===============================");
			    } else {
			        System.out.println("User Not Found...");
			    }

			    break;
			    
			    
			case 3:
			

			    System.out.println("*********** Update Operation ***************");

			    System.out.println("Enter the User ID:");
			    Integer d = Integer.parseInt(br.readLine());

			    User us = service.userSearch(d);

			    if (us != null) {

			        System.out.println("**** Please Enter New Details ****");

			        System.out.print("Enter User Name = ");
			        String name = br.readLine();

			        System.out.print("Enter User Salary = ");
			        float sal = Float.parseFloat(br.readLine());

			        System.out.print("Enter User Address = ");
			        String addr = br.readLine();

			        User newuser = new User();

			        newuser.setUid(d);
			        newuser.setUname(name);
			        newuser.setUsal(sal);
			        newuser.setUadd(addr);

			        String userUpdate = service.userUpdate(newuser);

			        System.out.println(userUpdate);

			    } else {

			        System.out.println("No Such User Found");

			    }

			    break;
			    
			case 4:
				System.out.println("*********** Update Operation ***************");

			    System.out.println("Enter the User ID:");
			    Integer dd = Integer.parseInt(br.readLine());

			    User ud = service.userSearch(dd);
			    
			    String userDelete = service.userDelete(dd);
			    System.out.println(userDelete);
			    
			    
			    
			    
			}
			}
	}
}

	


