/**
 * 
 */
package service;

import java.sql.Time;



import java.util.List;

import model.Product;
import model.Cart;
import service.ProductService;
import service.PurchaseOrderService;
import dao.CartDao;
import exception.ApplicationException;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class CartService {
	
	ProductService productService = new ProductService();
	PurchaseOrderService purchaseOrderService = new PurchaseOrderService();
	CartDao cartDao = new CartDao();
	public boolean addCart(int orderId, String productName, int quantity, double totalPrice,
			int createdBy, Time createdAt, int modifiedBy, Time modifiedAt) throws ApplicationException {
		Product product = productService.findProductByName(productName);
		Cart cart = new Cart(orderId, product, quantity, totalPrice, createdAt,
				modifiedAt, createdBy, modifiedBy);
		return cartDao.insertCart(cart);
	}
	
	public List<Cart> getCartDetails() throws ApplicationException {
		return cartDao.retrieveCartDetails();
	}
	public Cart findCartByOrderId(int orderId) throws ApplicationException {
		return cartDao.searchCartByOrderId(orderId);
	}
	
	public boolean modifyCartByOrderId(int orderId, Cart newCart) throws ApplicationException {
		Cart cart = cartDao.searchCartByOrderId(orderId);
		cart.setProduct(newCart.getProduct());
		cart.setQuantity(newCart.getQuantity());
		cart.setTotalPrice(newCart.getTotalPrice());
		return cartDao.updateCart(cart);
	}
	
	public boolean removeCartByOrderId(int orderId) throws ApplicationException {
		Cart cart = cartDao.searchCartByOrderId(orderId);
		return cartDao.deleteCart(cart);
	}

}
