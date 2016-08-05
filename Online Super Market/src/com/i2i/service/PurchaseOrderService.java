/**
 * 
 */
package com.i2i.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.PurchaseOrder;
import com.i2i.model.User;
import com.i2i.model.Cart;
import com.i2i.dao.PurchaseOrderDao;
import com.i2i.exception.ApplicationException;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Service
public class PurchaseOrderService {
	
	@Autowired
	CartService cartService;
	@Autowired
	PurchaseOrderDao purchaseOrderDao;
    
	public boolean addPurchaseOrder(User user, double total, String paymentType, boolean status, 
			int createdBy,List<Cart> cartList) throws ApplicationException {
        Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
        Timestamp modifiedAt = null;
        int modifiedBy = 0;
        int count = 0;
        PurchaseOrder purchaseOrder = new PurchaseOrder(user, total, paymentType, status, createdAt,
				modifiedAt, createdBy, modifiedBy);
        purchaseOrderDao.insertPurchaseOrder(purchaseOrder);
        List<PurchaseOrder> purchaseOrders = getPurchaseOrderDetails();
        count = purchaseOrders.size();
        purchaseOrder.setId(count);
        for(Cart cart : cartList) {
            cart.setPurchaseOrder(purchaseOrder);
            cartService.modifyCart(cart);
        }
        return true;
	}
	
	
	public List<PurchaseOrder> getPurchaseOrderDetails() throws ApplicationException {
		return purchaseOrderDao.retrievePurchaseOrderDetails();
	}	
}
