/**
 * 
 */
package com.i2i.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.i2i.model.Cart;
import com.i2i.service.ProductService;
import com.i2i.dao.CartDao;
import com.i2i.exception.ApplicationException;
/**
 * <h1> Cart Service </h1>
 * <p> Cart Service class provides cart related services.</p>
 * @author Kumar Albert
 *
 * version 1.0
 * 
 * 
 */

@Service("cartService")
public class CartService {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartDao cartDao;
	
	/**
	 * <p> This method used to add cart to database </p>
	 * @param cart It holds cart object.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false. 
	 * @throws ApplicationException
	 */
	public boolean addCart(Cart cart) throws ApplicationException {
		return cartDao.insertCart(cart);
	}
	
	/**
	 * <p> This method is used to get cart details.</p>
	 * @return List. It returns cart details.
	 * @throws ApplicationException
	 */
	public List<Cart> getCartDetails() throws ApplicationException {
		return cartDao.retrieveCartDetails();
	}
	
	/**
	 * <p> This method is used to get required cart details. </p>
	 * @param id It holds cart id.
	 * @return Cart It returns Cart Object.
	 * @throws ApplicationException
	 */
	public Cart findCartById(int id) throws ApplicationException {
		return cartDao.searchCartById(id);
	}
	
	
	/**
	 * <p> This method is used to modify cart details.</p>
	 * @param cart It holds cart object.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false. 
	 * @throws ApplicationException
	 */
	public boolean modifyCart(Cart cart) throws ApplicationException {
		return cartDao.updateCart(cart);
	}
	
	/**
	 * <p> This method is used to delete cart details.</p>
	 * @param cart It holds cart object.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false. 
	 * @throws ApplicationException
	 */
	public boolean removeCart(Cart cart) throws ApplicationException {
		return cartDao.deleteCart(cart);
	}

}
