package in.soft.Factory;

import in.soft.userDao.UserDao;
import in.soft.userDao.UserDaoImpl;

public class DaoFactory {
	private static UserDao userDao=null;
	static {
		userDao=new UserDaoImpl();
	       }
	public static UserDao getDao() {
		return userDao;
	}
}
