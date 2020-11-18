package com.app.shop;

import java.time.LocalDate;
import static com.app.library.ValidationRules.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.app.library.CustomeLibraryException;
import com.app.shop.Book;

public class Libray {
	public static void main(String[] args) throws CustomeLibraryException {
		try (Scanner sc = new Scanner(System.in);) {

			// a book created
			HashMap<String, Book> bookMap = new HashMap<>();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Please enter your choice");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter details");
						Book books = new Book(sc.next(), sc.nextInt(),
								LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()), sc.nextInt(),
								validateRating(sc.nextInt()), validateCategory(sc.next().toUpperCase()));
						Author e = new Author(sc.next(), sc.next());
						books.setAuthors(e);
						bookMap.put(books.getTitle(), books);
//						System.out.println(bookMap);
//						System.out.println(bookMap.size());
						break;

					default:
						break;
					}

				} catch (CustomeLibraryException c) {
					System.out.println(c);
				}

				catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}