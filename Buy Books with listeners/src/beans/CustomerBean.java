package beans;

import java.sql.SQLException;

import dao.CustomerDaoImpl;
import pojos.Customer;

public class CustomerBean {
	//properties : non static , non transient data members
	//to represent clnt's info
	private String email,password;
	//JB manages DAO : to store DAO ref.
	private CustomerDaoImpl custDao;
	//to store the results of business action
	private Customer validatedCustomer;
	//add a property to store login status
	private String message;
	
	//In case of WC managing JB : MUST supply def constr
	public CustomerBean() throws Exception{
		System.out.println("in customer bean ctor");
		//instantiate DAO
		custDao=new CustomerDaoImpl();
	}
	//setters n getters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("in set em");
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("in set pass");
		this.password = password;
	}

	public CustomerDaoImpl getCustDao() {
		return custDao;
	}

	public void setCustDao(CustomerDaoImpl custDao) {
		this.custDao = custDao;
	}

	public Customer getValidatedCustomer() {
		return validatedCustomer;
	}

	public void setValidatedCustomer(Customer validatedCustomer) {
		this.validatedCustomer = validatedCustomer;
	}
	
	public String getMessage() {
		return message;
	}

	//B.L method for customer validation : public
	public String authenticateCustomer() throws SQLException
	{
		System.out.println("In B.L validate "+email+" "+password);
		//JB ---> DAO
		validatedCustomer=custDao.authenticateCustomer(email, password);
		if(validatedCustomer == null) {
			message="Invalid Login , Please retry";
			return "login";
		}
		message="Login Successful";
		return "category";//dyn navigational outcome
	}
	//Add a B.L method to clean up dao
		public void cleanUp() throws Exception
		{
			custDao.cleanUp();
		}
	
	

}
