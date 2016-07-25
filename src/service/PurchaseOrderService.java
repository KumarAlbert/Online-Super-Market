/**
 * 
 */
package service;

import java.sql.Time;
import java.util.List;
import model.Cart;
import model.PurchaseOrder;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class PurchaseOrderService {

	public boolean addPurchaseOrder(int userId, double total, String paymentType, boolean status, 
			Time createdAt, Time modifiedAt,int createdBy, int modifiedBy) {
		PurchaseOrder purchaseOrder = new PurchaseOrder(userId, total, paymentType, 
				status, createdAt, modifiedAt, createdBy, modifiedBy);
		return purchaseOrderDao.insertPurchaseOrder(purchaseOrder);
	}
	
	public List<PurchaseOrder> getPurchaseOrderDetails() {
		return purchaseOrderDao.reterivePurchaseOrderDetails();
	}	
}
