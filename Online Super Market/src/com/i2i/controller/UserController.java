package com.i2i.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.exception.ApplicationException;
import com.i2i.model.*;
import com.i2i.service.*;

@Controller 
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubcategoryService subcategoryService;
	
	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	private User user = null;
	private Cart cart = null;
	private List<Cart> cartList = null;
	private List<Product> products = null;
	private List<Product> productFilter = null;
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUserData(@ModelAttribute("user") User user,
		                        	   BindingResult result) { 
       try {
            java.sql.Timestamp time = new java.sql.Timestamp(new java.util.Date().getTime());
            user.setCreatedAt(time);
            user.setModifiedBy(101);
            user.setModifiedAt(time);
            System.out.println(user);
            userService.addUser(user);
	        System.out.println("Save User Data");
      }
        catch(ApplicationException e) {
            e.printStackTrace();        	
        }
	return new ModelAndView("login");
	} 
	
	@RequestMapping("/checkUser")
	public ModelAndView getUser(@ModelAttribute("user") User userFromLogin,
     	   BindingResult result)  {
		try {
			System.out.println("controller");
			user = userService.findUser(userFromLogin);
			Set<Role> roles = user.getRoles();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("user",user);
			if(null != user) {
			for (Role role : roles) {
				if("user".equals(role.getName())){
					return new ModelAndView("userHome",model);
				}
				else if ("admin".equals(role.getName())) {
					return new ModelAndView("adminHome",model);
				}
			}
			}
		} catch (ApplicationException e){
			return new ModelAndView("loginFail");
			}
		return null;
	}
	@RequestMapping("/singleFruit")
	public ModelAndView getBanana(@RequestParam("fruit") String fruit) {
		System.out.println(productService);
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			Product product = productService.findProductByName(fruit);
        	model.put("product", product);
			return new ModelAndView("product",model);
		} catch (ApplicationException e){
     	  }
		return null;
	}
	
	@RequestMapping(value= "/saveCart", method = RequestMethod.POST)
	public ModelAndView saveCart(@RequestParam("quantity") int quantity,@RequestParam("productPrice") double price ,
			@RequestParam("product") Object object) {
        try {
        	cart = new Cart();
        	String name = object.toString();
            java.sql.Timestamp time = new java.sql.Timestamp(new java.util.Date().getTime());
            cart.setCreatedAt(time);
            cart.setCreatedBy(000);
            Product product = productService.findProductByName(name);
            double total = quantity * price;
            cart.setTotalPrice(total);
            cart.setQuantity(quantity);
            Set<Cart> carts = new HashSet<Cart>();
        	cart.setProduct(product);
            carts.add(cart);
            product.setCarts(carts);
        	cartService.addCart(cart);
    		Map<String, Object> model = new HashMap<String, Object>();
        	if("Fruits".equals(cart.getProduct().getSubcategory().getName())){
        		model.put("productFilter", productFilter);
        		return new ModelAndView("productFilter",model);
        	}
        } catch (ApplicationException e) {
        	e.printStackTrace();
        }
        return null;
	}
	
	@RequestMapping("/cart")
	public ModelAndView getCart() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			cartList = cartService.getCartDetails();
			model.put("cart", cartList);
		return new ModelAndView("cart",model);
		} catch(ApplicationException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/removeCart")
	public ModelAndView removeCart(int cartId) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println(cartId);
			cart = cartService.findCartById(cartId);
			cartService.removeCart(cart);
			cartList = cartService.getCartDetails();
			model.put("cart", cartList);
			return new ModelAndView("cart",model);
		} catch(ApplicationException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/order")
	public ModelAndView placeOrder() {
		double total = 0;
		Map<String, Object> model = new HashMap<String, Object>();
		for(Cart cart : cartList){
			total = total + cart.getTotalPrice();
		}
		model.put("user",user);
		model.put("cart", cartList);
		model.put("total",total);
		return new ModelAndView("placeOrder",model);
	}
	
	@RequestMapping("/confirmOrder")
	public ModelAndView confirmOrder(@RequestParam("total") double total,@RequestParam("paymentType") String paymentType) {
		Boolean status = true;
		int createdBy = user.getId();
		Product product;
		String productName;
		int productQty;
		int productStock ;
		int modifiedBy = user.getId();
		try {
			purchaseOrderService.addPurchaseOrder(user, total, paymentType, status, createdBy,cartList);
			for(Cart cart : cartList) {
				product = cart.getProduct();
				productName = product.getName();
				productQty = cart.getQuantity();
				productStock = product.getStock();
				productStock = productStock - productQty;
				productService.modifyProductStockByName(productName, productStock ,modifiedBy);
			}
			return new ModelAndView("Success");
		} catch(ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method gets the category details to be inserted.
	 * @param name 
	 *    Name of the category.
	 * @return insertSubCategory
	 *    Redirects to insert Subcategory page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/categoryInsert",method = RequestMethod.POST)
	public ModelAndView insertCategory(@RequestParam("categoryName") String name) {
		try {
			int createdBy = user.getId();
            categoryService.addCategory(name, createdBy);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		 return new ModelAndView("insertSubcategory");
	}
	
	/**
	 * This method gets the subcategory details to be inserted.
	 * @param name 
	 *    Name of the category.
	 * @param subcategoryName 
	 *    Name of the subcategory.
	 * @return insertProduct
	 *    Redirects to insert product page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/subcategoryInsert",method = RequestMethod.POST)
	public ModelAndView insertSubcategory(@RequestParam("categoryName") String categoryName, 
		                           @RequestParam("subcategoryName") String subcategoryName) {
		try {
			int createdBy = user.getId();
			subcategoryService.addSubcategory(categoryName, subcategoryName , createdBy);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("insertProduct");
	} 

	/**
	 * This method gets the product details to be inserted.
	 * @param subcategoryName 
	 *    Name of the subcategory.
	 * @param productName 
	 *    Name of the product.
	 * @param description 
	 *    Description of the product.
	 * @param imageurl 
	 *    imageurl of the product.
	 * @param stock 
	 *    stock of the product.
	 * @param price 
	 *    price of the product.
	 * @return insertCategory
	 *    Redirects to insert category page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/productInsert",method = RequestMethod.POST)
	public ModelAndView insertProduct(@RequestParam("subcategoryName") String subcategoryName, @RequestParam("productName") String name,
		                          @RequestParam("description") String description, @RequestParam("imageUrl") String imageUrl,
		                          @RequestParam("stock") int stock , @RequestParam("price") double price) {
		try {
			int createdBy = user.getId();
			productService.addProduct(name, description, subcategoryName, imageUrl, stock, price, createdBy);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("insertCategory");
	} 
	
	/**
	 * This method lists the category details.
	 * @return viewCategories
	 *    Redirects to viewCategories page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/viewCategories")
	public ModelAndView viewCategories() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("category", categoryService.getCategoryDetails());
			return new ModelAndView("viewCategories", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("viewCategories", model);
	}
	
	/**
	 * This method lists the subcategory details.
	 * @return viewSubcategories
	 *    Redirects to viewSubcategories page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/viewSubcategories")
	public ModelAndView viewSubcategories() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("subcategory", subcategoryService.getSubcategoryDetails());
			return new ModelAndView("viewSubcategories", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("viewSubcategories", model);
	}
	
	/**
	 * This method lists the product details.
	 * @return viewProducts
	 *    Redirects to viewProducts page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/viewProducts")
	public ModelAndView viewProducts() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("product",productService.getProductDetails());
			return new ModelAndView("viewProducts", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("viewProducts", model);
	}
	
	/**
	 * This method updates the category details.
	 * @param oldName 
	 *    Existing name of the category.
	 * @param newName 
	 *    Name of the category to be updated.
	 * @return insertCategory
	 *    Redirects to insert category page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/categoryUpdate",method = RequestMethod.POST)
	public ModelAndView updateCategory(@RequestParam("existingCategoryName") String oldName, 
		                           @RequestParam("categoryName") String newName) {
		try {
			 int modifiedBy = user.getId();
			 categoryService.modifyCategoryNameByName(oldName, newName, modifiedBy);
			 return new ModelAndView("insertCategory");

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	} 

	/**
	 * This method updates the subcategory details.
	 * @param oldName 
	 *    Existing name of the subcategory.
	 * @param newName 
	 *    Name of the subcategory to be updated.
	 * @return insertSubCategory
	 *    Redirects to insert Subcategory page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/subcategoryUpdate",method = RequestMethod.POST)
	public ModelAndView updateSubcategory(@RequestParam("existingSubcategoryName") String oldName, 
		                           @RequestParam("subCategoryName") String newName) {
		try {
			int modifiedBy = user.getId();
			subcategoryService.modifySubcategoryNameByName(oldName, newName,modifiedBy);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("insertCategory");
	} 
	
	/**
	 * This method updates the product details.
	 * @param name 
	 *    Name of the product.
	 * @param newValue 
	 *    Product details to be updated.
	 * @param choice 
	 *    Property of the product which is chosen. 
	 * @return insertProduct
	 *    Redirects to insert product page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/productUpdate",method = RequestMethod.POST)
	public ModelAndView updateProduct(@RequestParam("productName") String name, @RequestParam("newValue") String newValue,
		                          @RequestParam("choice") String choice) {
		try {
			int modifiedBy = user.getId();
			switch(choice) {
				case "name":
					productService.modifyProductNameByName(name, newValue, modifiedBy);
					break;
				case "description":
					productService.modifyProductDescriptionByName(name, newValue, modifiedBy);
					break;
				case "imageUrl":
					productService.modifyProductImageUrlByName(name, newValue, modifiedBy);
					break;
				case "stock":
					int stock = Integer.parseInt(newValue);
					productService.modifyProductStockByName(name, stock, modifiedBy);
					break;
				case "price":
					double price = Double.parseDouble(newValue);
					productService.modifyProductPriceByName(name, price, modifiedBy);
					break; 
				}	
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
    return new ModelAndView("insertProduct");
	}
	
	/**
	 * This method deletes the category by its name.
	 * @param name
	 *    Name of the category to be deleted.
	 * @return updateCategory
	 *    Redirects to update category page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/categoryDelete",method = RequestMethod.POST)
	public ModelAndView deleteCategory(@RequestParam("categoryName") String name) {
		try {
			categoryService.removeCategoryByName(name);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("updateCategory");
	}

	/**
	 * This method deletes the subcategory by its name.
	 * @param name
	 *    Name of the subcategory to be deleted.
	 * @return updateSubcategory
	 *    Redirects to update subcategory page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/subcategoryDelete",method = RequestMethod.POST)
	public ModelAndView deleteSubcategory(@RequestParam("name") String name) {	
		try {
			subcategoryService.removeSubcategoryByName(name);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("updateSubcategory");
	}	

	/**
	 * This method deletes the product by its name.
	 * @param name
	 *    Name of the product to be deleted.
	 * @return insertProduct
	 *    Redirects to update insertProduct page.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
	 */
	@RequestMapping(value="/productDelete",method = RequestMethod.POST)
	public ModelAndView deleteProduct(@RequestParam("productName") String name) {
		try {
			System.out.println("deleteproduct");
			productService.removeProductByName(name);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("insertProduct");
	}




	
	@RequestMapping("/login")
	public ModelAndView redirect(@ModelAttribute("user") User user,
			BindingResult result) {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/register")
	public ModelAndView redirectToRegister(@ModelAttribute("user") User user,
			BindingResult result) {
		System.out.println(userService);
		return new ModelAndView("register");
	}
	
	@RequestMapping("/fruits")
	public ModelAndView redirectToFruits() {
		Map<String, Object> model = new HashMap<String, Object>();
		productFilter = new ArrayList<Product>();
		for(Product product : products) {
			Subcategory subcategory = product.getSubcategory();
			if("Fruits".equals(subcategory.getName())) {
				productFilter.add(product);
			}
		}
		model.put("productFilter", productFilter);
		return new ModelAndView("productFilter",model);
	}
	
	@RequestMapping("/vegtables")
	public ModelAndView redirectToVegtables() {
		Map<String, Object> model = new HashMap<String, Object>();
		productFilter = new ArrayList<Product>();
		for(Product product : products) {
			Subcategory subcategory = product.getSubcategory();
			if("Vegtables".equals(subcategory.getName())) {
				productFilter.add(product);
			}
		}
		model.put("productFilter", productFilter);
		return new ModelAndView("productFilter",model);
	}
	@RequestMapping("/imageScroll")
	public ModelAndView imageScroll() {
		return new ModelAndView("imageScroll");
	}
	
	@RequestMapping("/homepage")
	public ModelAndView homePage(@ModelAttribute("user") User user,
			BindingResult result) {
		return new ModelAndView("homePage");
	}
	
	@RequestMapping("/userHome")
	public ModelAndView userHomeForAdmin(@ModelAttribute("user") User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user",user);
		return new ModelAndView("userHome",model);
	}
	
	@RequestMapping("/home")
	public ModelAndView gethome(@ModelAttribute("user") User user,
			BindingResult result) {
		try {
			products = productService.getProductDetails();
		    return new ModelAndView("home");
		} catch(ApplicationException e){
			
		}
		return null;
	}
	

	@RequestMapping("/redirectCategoryInsert")
	public ModelAndView redirectToCategoryInsert() {
		Map<String, Object> model = new HashMap<String, Object>();
		try { 
			model.put("category", categoryService.getCategoryDetails());
			return new ModelAndView("insertCategory",model);
		} catch (ApplicationException e) {
			
		}
		return null;
	}

	@RequestMapping("/redirectSubcategoryInsert")
	public ModelAndView redirectToSubcategoryInsert() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("subcategory", subcategoryService.getSubcategoryDetails());
			return new ModelAndView("insertSubcategory",model);
		} catch(ApplicationException e){
			
		}
		return null;
	}
	
	@RequestMapping("/redirectProductInsert")
	public ModelAndView redirectToProductInsert() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("product",productService.getProductDetails());
			return new ModelAndView("insertProduct",model);
		} catch(ApplicationException e) {
			
		}
		return null;
	}
	@RequestMapping("/redirectCategoryUpdate")
	public ModelAndView redirectToCategoryUpdate() {
		Map<String, Object> model = new HashMap<String, Object>();
		try { 
			model.put("category", categoryService.getCategoryDetails());
			return new ModelAndView("updateCategory",model);
		} catch (ApplicationException e){
			
		}
		return null;
	}
	
	@RequestMapping("/redirectSubcategoryUpdate")
	public ModelAndView redirectToSubcategoryUpdate() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("subcategory", subcategoryService.getSubcategoryDetails());
			return new ModelAndView("updateSubcategory",model);
		} catch(ApplicationException e) {
			
		}
		return null;
	}
	
	@RequestMapping("/redirectProductUpdate")
	public ModelAndView redirectToProductUpdate() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("product",productService.getProductDetails());
			return new ModelAndView("updateProduct",model);
		} catch(ApplicationException e) {
			
		}
		return null;
	}
	
	@RequestMapping("/redirectCategoryDelete")
	public ModelAndView redirectToCategoryDelete() {
		Map<String, Object> model = new HashMap<String, Object>();
		try { 
			model.put("category", categoryService.getCategoryDetails());
			return new ModelAndView("deleteCategory",model);
		} catch (ApplicationException e) {
			
		}
		return null;
	}
	
	@RequestMapping("/redirectSubcategoryDelete")
	public ModelAndView redirectToSubcategoryDelete() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("subcategory", subcategoryService.getSubcategoryDetails());
			return new ModelAndView("deleteSubcategory",model);
		} catch (ApplicationException e) {
			
		}
		return null;
	}
	
	@RequestMapping("/redirectProductDelete")
	public ModelAndView redirectToProductDelete() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("product",productService.getProductDetails());
			return new ModelAndView("deleteProduct");
		} catch(ApplicationException e) {
			
		}
		return null;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		user = null;
		return new ModelAndView("home");
	}
	
	
}
