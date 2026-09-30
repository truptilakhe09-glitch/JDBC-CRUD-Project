package in.soft.Factory;

import in.soft.UserService.UserService;
import in.soft.UserService.UserServiceImple;

public class ServiceFactory {

	private static UserService userService =null;
	static {
	userService = new UserServiceImple();
	}
	
	public static UserService getService() 
	{
		return userService;
		
	}
	
}
