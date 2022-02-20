package com.henz.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.henz.data_access.CategoryDao;
import com.henz.data_access.PurchaseDao;
import com.henz.data_access.ShoeDao;
import com.henz.data_access.UserDao;
import com.henz.helper.FilterHelper;
import com.henz.helper.FormatHelper;
import com.henz.model.Category;
import com.henz.model.Purchase;
import com.henz.model.PurchaseCategoryDto;
import com.henz.model.Shoe;
import com.henz.model.ShoeCategoryDto;
import com.henz.model.User;

@Controller
public class MainController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ShoeDao shoeDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView showWelcomePage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		return mv;
	}
	
	@RequestMapping(value="user", method = RequestMethod.GET)
	public ModelAndView showUserPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		
		return mv;
	}
	
	@RequestMapping(value="admin", method = RequestMethod.GET)
	public ModelAndView showAdminPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		
		return mv;
	}

	@RequestMapping(value="admin/searchUser", method = RequestMethod.GET)
	public ModelAndView searchUserById(@RequestParam("username") String username) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("search",username);
		User user = this.userDao.findByName(username);
		
		if(user != null) {
			mv.addObject("user",user);
		}
		
		mv.setViewName("search-user");
		
		return mv;
	}
	
	@RequestMapping(value="admin/getAllUsers", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {
		
		ModelAndView mv = new ModelAndView();
		List<User> userList = this.userDao.getAllUsers();
		mv.addObject("userList",userList);
		
		mv.setViewName("get-all-users");
		
		return mv;
	}
	
	@RequestMapping(value="admin/products", method = RequestMethod.GET)
	public ModelAndView manageProducts() {
		
		ModelAndView mv = new ModelAndView();
		List<Shoe> shoeList = this.shoeDao.getAllShoes();
		List<ShoeCategoryDto> shoeCategoryList = new ArrayList<ShoeCategoryDto>();
		
		for(Shoe shoe: shoeList) {
			Category cat = this.categoryDao.getCategoryById(shoe.getCategory().getId());
			ShoeCategoryDto dto = new ShoeCategoryDto(shoe.getId(), shoe.getBrand(), shoe.getModel(), cat.getId(), cat.getText(), shoe.getPrice());
			shoeCategoryList.add(dto);
		}
		
		mv.addObject("shoeCategoryList",shoeCategoryList);
		
		mv.setViewName("products");
		
		return mv;
	}
	
	@RequestMapping(value="admin/products/productForm", method = RequestMethod.GET)
	public ModelAndView productForm(
			@RequestParam("shoeId") int shoeId,
			@RequestParam("shoeBrand") String shoeBrand,
			@RequestParam("shoeModel") String shoeModel,
			@RequestParam("categoryText") String categoryText,
			@RequestParam("price") int price,
			@RequestParam("categoryId") int categoryId
			) 
	{
	
		ModelAndView mv = new ModelAndView();
		
		ShoeCategoryDto shoeCategory = new ShoeCategoryDto(shoeId, shoeBrand, shoeModel, categoryId, categoryText, price);
		mv.addObject("shoeCategory",shoeCategory);
		
		List<Category> listWithAllCategories = this.categoryDao.getAllCategories();
		mv.addObject("listWithAllCategories",listWithAllCategories);
		
		mv.setViewName("product-edit");
		
		return mv;
	}
	
	@RequestMapping(value="admin/products/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(
			@RequestParam("shoeId") int shoeId,
			@RequestParam("shoeBrand") String shoeBrand,
			@RequestParam("shoeModel") String shoeModel,
			@RequestParam("price") int price,
			@RequestParam("categoryId") int categoryId
			) 
	{
	
		ModelAndView mv = new ModelAndView();
		
		Category cat = this.categoryDao.getCategoryById(categoryId);
		Shoe shoe = new Shoe();
		shoe.setId(shoeId);
		shoe.setBrand(shoeBrand);
		shoe.setModel(shoeModel);
		shoe.setPrice(price);
		shoe.setCategory(cat);
		
		this.shoeDao.update(shoe);
		
		mv.addObject("shoe",shoe);
		
		mv.setViewName("product-edit-success");
		
		return mv;
	}
	
	@RequestMapping(value="admin/purchaseFilter", method = RequestMethod.GET)
	public ModelAndView filterPurchases() {
		
		ModelAndView mv = new ModelAndView();
		List<Category> categoryList = this.categoryDao.getAllCategories();
		mv.addObject("categoryList", categoryList);
		
		mv.setViewName("purchase-filter");
		
		return mv;
	}
	
	@RequestMapping(value="admin/purchases", method = RequestMethod.GET)
	public ModelAndView seeFilteredPurchases(
			@RequestParam("dateFrom") String dateFrom,
			@RequestParam("dateTo") String dateTo,
			@RequestParam("categoryId") int categoryId
			) throws ParseException 
	{
		
		Predicate<Purchase> filterByCategory = null;
		Predicate<Purchase> filterByDateFrom = null;
		Predicate<Purchase> filterByDateTo = null;
		
		if(!dateFrom.equals("")) {
			String convertedDateFrom = FormatHelper.convertDateAsStringToAnotherFormat(FormatHelper.DATE_PATTERN_OF_HTML_FORM, FormatHelper.DATE_PATTERN_OF_DB, dateFrom);
			filterByDateFrom = FilterHelper.filterPurchasesAfterDateAndTime(convertedDateFrom);
		}
		
		if(!dateTo.equals("")) {
			String convertedDateTo = FormatHelper.convertDateAsStringToAnotherFormat(FormatHelper.DATE_PATTERN_OF_HTML_FORM, FormatHelper.DATE_PATTERN_OF_DB, dateTo);
			filterByDateTo = FilterHelper.filterPurchasesBeforeDateAndTime(convertedDateTo);
		}
		
		if(categoryId != -1) {
			filterByCategory = FilterHelper.filterPurchasesByCategory(categoryId);
		}
		
		@SuppressWarnings("rawtypes")
		Predicate [] filters = {filterByCategory,filterByDateFrom,filterByDateTo};
		
		List<Purchase> unfilteredListWithPurchases = this.purchaseDao.getAllPurchases();
		
		@SuppressWarnings("unchecked")
		List<Purchase> filteredListWithPurchases = FilterHelper.chainedFilter(unfilteredListWithPurchases, filters);
		
		/*for(Purchase p: filteredListWithPurchases) {
			System.out.println(p);
		}*/
		
		List<PurchaseCategoryDto> listWithPurchaseCategoryDto = new ArrayList<PurchaseCategoryDto>();
		
		for(Purchase p: filteredListWithPurchases) {
			Category c = this.categoryDao.getCategoryById(p.getFk_category_id());
			PurchaseCategoryDto dto = new PurchaseCategoryDto(p.getId(), p.getPurchase_date(), c.getText(), p.getFk_user_id());
			listWithPurchaseCategoryDto.add(dto);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("listWithPurchaseCategoryDto", listWithPurchaseCategoryDto);
		mv.setViewName("purchases");
		
		return mv;
	}
	
	@RequestMapping(value="admin/changePassword", method = RequestMethod.GET)
	public ModelAndView adminChangePwForm() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("admin-change-pw");
		
		return mv;
	}
	
	@RequestMapping(value="admin/passwordChangeValidation", method = RequestMethod.GET)
	public ModelAndView adminChangePwValidation(@RequestParam("newPassword") String newPassword) {
		
		//get current user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;

		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		
		User currentUser = this.userDao.findByName(username);
		currentUser.setPassword(new BCryptPasswordEncoder().encode(newPassword));
		this.userDao.update(currentUser);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("admin-change-pw-success");
		
		return mv;
	}
}
