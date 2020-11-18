package dao;

import java.sql.*;
import static utils.DBUtils.fetchDBConnection;
import java.sql.SQLException;

import pojos.Customer;

public class CustomerDaoImpl implements ICustomerDao {
	private Connection cn;
	private PreparedStatement pst1;

	// constr
	public CustomerDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn
		cn = fetchDBConnection();//even if it's called multiple times , rets SAME connection instance
		/*
		 * cn = fetchDBConnection(); cn = fetchDBConnection(); cn = fetchDBConnection();
		 */
		pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
		System.out.println("cust dao created...");
	}

	@Override
	public Customer authenticateCustomer(String email, String pwd) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		// exec method : exec query
		System.out.println("cust dao : exec validation query");
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Customer(rst.getInt(1), rst.getDouble(2), email, rst.getString(4), pwd, rst.getDate(6),
						rst.getString(7));
		}
		return null;
	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		
		System.out.println("cust dao cleaned up....");
	}

}
