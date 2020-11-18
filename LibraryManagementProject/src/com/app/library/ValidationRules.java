package com.app.library;

import com.app.shop.Category;

public class ValidationRules {
	public static Category validateCategory(String category) throws CustomeLibraryException {
		return Category.valueOf(category);
	}

	public static int validateRating(int rating) throws CustomeLibraryException {
		if (rating > 5) {
			throw new CustomeLibraryException("Please give a rating between 1-5");
		}
		return rating;
	}
}
