package dao;

import java.sql.SQLException;

import pojos.*;

public interface ICustomerDao {
	Customer authenticateCustomer(String email, String pwd) throws SQLException;
}
