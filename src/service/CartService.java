/**
 * 
 */
package service;

import java.sql.Time;
import java.util.List;

import model.Cart;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class CartService {
	
	public boolean addCart(int orderId, int productId, int quantity, double totalPrice,
			int createdBy, Time createdAt, int modifiedBy, Time modifiedAt) {
		Cart cart = new Cart(orderId, productId, quantity, totalPrice, createdAt, modifiedAt, createdBy, modifiedBy);
		return cartDao.insertCart(cart);
	}
	
	public Cart findCartByOrderId(int orderId) {
		return cartDao.searchCartByOrderId(orderId);
	}
	
	public boolean modifyCartByOrderId(int orderId, Cart newCart) {
		Cart cart = cartDao.searchCartByOrderId(orderId);
		cart.setProductId(newCart.getProductId());
		cart.setQuantity(newCart.getQuantity());
		cart.setTotalPrice(newCart.getTotalPrice());
		return cartDao.updateCart(cart);
	}
	
	public boolean removeCartByOrderId(int orderId) {
		Cart cart = cartDao.searchCartByOrderId(orderId);
		return cartDao.deleteCart(cart);
	}

}
