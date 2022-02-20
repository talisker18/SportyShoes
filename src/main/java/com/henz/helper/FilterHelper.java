package com.henz.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.henz.model.Purchase;

public final class FilterHelper {
	
	private FilterHelper() {
		
	}

	public static Predicate<Purchase> filterPurchasesAfterDateAndTime(String date){
		
		return purchase -> {
			SimpleDateFormat format = new SimpleDateFormat(FormatHelper.DATE_PATTERN_OF_DB);
			
			boolean purchaseIsAfter = false;
			
			try {
				Date purchaseDate = format.parse(purchase.getPurchase_date());
				Date filterDate = format.parse(date);
				purchaseIsAfter = purchaseDate.after(filterDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return purchaseIsAfter;
		};
	}
	
	public static Predicate<Purchase> filterPurchasesBeforeDateAndTime(String date){
		
		return purchase -> {
			SimpleDateFormat format = new SimpleDateFormat(FormatHelper.DATE_PATTERN_OF_DB);
			
			boolean purchaseIsBefore = false;
			
			try {
				Date purchaseDate = format.parse(purchase.getPurchase_date());
				Date filterDate = format.parse(date);
				purchaseIsBefore = purchaseDate.before(filterDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return purchaseIsBefore;
		};
	}
	
	public static Predicate<Purchase> filterPurchasesByCategory(int categoryId){		
		return purchase -> purchase.getFk_category_id() == categoryId;
	}
	
	//single filter
	public static <T> List<T> singleFilter(List<T> objects, Predicate<T> predicate) {
		return objects.stream().filter(predicate)
				.collect(Collectors.<T> toList());
	}
	
	//chained filters
	public static <T> List<T> chainedFilter(List<T> objects, Predicate<T> [] predicates) {
		Stream<T> stream = objects.stream();
		
		for(Predicate<T> pred: predicates) {
			if(pred != null) {
				stream = stream.filter(pred);
			}
		}
		
		return stream
				.collect(Collectors.<T> toList());
	}
}
