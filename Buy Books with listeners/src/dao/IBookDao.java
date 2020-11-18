package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Book;

public interface IBookDao {
//get all distinct categories from the shop
	List<String> getAllCategories() throws SQLException;

	// get available books under selected category
	List<Book> getBooksByCategory(String categoryName) throws SQLException;

	// get selected book's details
	Book getBookDetails(int bookId) throws SQLException;
}
