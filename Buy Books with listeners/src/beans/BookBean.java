package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.BookDaoImpl;
import pojos.Book;

public class BookBean {
	private BookDaoImpl bookDao;
	// add a property to represent chosen category
	private String cat;
	// add a property to store cart
	private List<Integer> cart;
	// add a property to represent selected book ids
	private int[] bkId;
	//add a propert to save cart value
	private double total;

	public BookBean() throws Exception {
		System.out.println("in bk bean ctor");
		// create instance of book dao
		bookDao = new BookDaoImpl();
		// create empty cart
		cart = new ArrayList<>();

	}

	public void setBkId(int[] bkId) {
		System.out.println("in set bk id" + Arrays.toString(bkId));
		this.bkId = bkId;
	}

	public void setCat(String cat) {
		System.out.println("in set cat");
		this.cat = cat;
	}
	

	public double getTotal() {
		return total;
	}

	// B.L method for fetching category list from dao n pass it to JSP
	public List<String> getCategoryList() throws Exception {
		return bookDao.getAllCategories();
	}

	// B.L method for fetching books under a specific category
	public List<Book> fetchBooksByCategory() throws Exception {
		return bookDao.getBooksByCategory(cat);
	}

	// B.L method to popualate the cart
	public String populateCart() {
		System.out.println("in populate cart");
		for (int id : bkId)
			cart.add(id);
		System.out.println("cart " + cart);
		return "category";
	}

	// B.L method to get actual book details , whose ids are added in the cart
	public List<Book> getCartDetails() throws SQLException {
		List<Book> books = new ArrayList<>();
		total=0;
		for (int id : cart) // auto un boxing
		{
			Book b = bookDao.getBookDetails(id);
			books.add(b);
			total += b.getPrice();
		}
		return books;

	}
	//Add a B.L method to clean up dao
	public void cleanUp() throws Exception
	{
		bookDao.cleanUp();
	}

}
