/**
 * 
 */
package com.i2i.service;

import java.sql.Time;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.i2i.model.Product;
import com.i2i.model.Cart;
import com.i2i.service.ProductService;
import com.i2i.dao.CartDao;
import com.i2i.exception.ApplicationException;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */

@Service
public class CartService {
	@Autowired
	ProductService productService;
	@Autowired
	CartDao cartDao;
	public boolean addCart(Cart cart) throws ApplicationException {
		return cartDao.insertCart(cart);
	}
	
	public List<Cart> getCartDetails() throws ApplicationException {
		return cartDao.retrieveCartDetails();
	}
	public Cart findCartByOrderId(int orderId) throws ApplicationException {
		return cartDao.searchCartByOrderId(orderId);
	}
	
	public Cart findCartById(int id) throws ApplicationException {
		return cartDao.searchCartById(id);
	}
	
	public boolean modifyCartByOrderId(int orderId, Cart newCart) throws ApplicationException {
		Cart cart = cartDao.searchCartByOrderId(orderId);
		cart.setProduct(newCart.getProduct());
		cart.setQuantity(newCart.getQuantity());
		cart.setTotalPrice(newCart.getTotalPrice());
		return cartDao.updateCart(cart);
	}
	
	public boolean removeCart(Cart cart) throws ApplicationException {
		return cartDao.deleteCart(cart);
	}

}
