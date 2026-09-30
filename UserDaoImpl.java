package in.soft.userDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.soft.Factory.ConnectionFactory;
import in.soft.entity.User;

public class UserDaoImpl implements UserDao {

    Connection con = ConnectionFactory.getConnection();
String result="";
    @Override
    public String insert(User user) {

        String result = null;

        int uid = user.getUid();
        String uname = user.getUname();
        float usal = user.getUsal();
        String uaddr = user.getUadd();

        try {

            Statement st = con.createStatement();

            String sql = "INSERT INTO user(uid, uname, salary, address) VALUES("
                    + uid + ", '" + uname + "', " + usal + ", '" + uaddr + "')";

            int row = st.executeUpdate(sql);

            if (row > 0) {
                result = "Data Inserted Successfully";
            } else {
                result = "Data Not Inserted";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User search(Integer uid) {
    	User user = new User();
    	try {
			Statement st = con.createStatement();
			
			String sql="select * from user where uid="+uid+"";
			ResultSet set = st.executeQuery(sql);
			System.out.println(set);
			
			boolean b = set.next();
			
			if(b==true) {
				user.setUid(set.getInt("uid"));
				user.setUname(set.getString("uname"));
				user.setUsal(set.getFloat("salary"));
				user.setUadd(set.getString("address"));	
			}
			else {
				user=null;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

        return user;
    }

    @Override
    public String update(User user) {
    	
    	int uid = user.getUid();
        String uname = user.getUname();
        float usal = user.getUsal();
        String uaddr = user.getUadd();
    	
    	try {
			Statement st = con.createStatement();
			
			String sql = "UPDATE user SET "
			        + "uname='" + uname + "', "
			        + "salary=" + usal + ", "
			        + "address='" + uaddr + "' "
			        + "WHERE uid=" + uid;
			
			
			
			boolean b = st.execute(sql);
			
			if(b==true) {
				result="Data update successfully";
			}
			else {
				result=null;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

        return result;
     
    }

    @Override
    public String delete(Integer uid) {
    	try {
			Statement st = con.createStatement();
			
			String sql="delete from user where uid="+uid+"";
			boolean b = st.execute(sql);
			
			
			
			
			if(b==true) {
				result="data delete successfully";
			}
			else {
				result=null;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

        return result;
    	
        
    }
}