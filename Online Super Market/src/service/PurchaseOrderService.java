/**
 * 
 */
package service;

import java.sql.Time;

import java.util.List;
import model.PurchaseOrder;
import model.User;
import service.UserService;
import dao.PurchaseOrderDao;
import exception.ApplicationException;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class PurchaseOrderService {
    
	UserService userService = new UserService();
	PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
	public boolean addPurchaseOrder(String email, double total, String paymentType, boolean status, 
			Time createdAt, Time modifiedAt,int createdBy, int modifiedBy) throws ApplicationException {
		User user = userService.findUserByEmail(email);
		PurchaseOrder purchaseOrder = new PurchaseOrder(user, total, paymentType, status, createdAt,
				modifiedAt, createdBy, modifiedBy);
		return purchaseOrderDao.insertPurchaseOrder(purchaseOrder);
	}
	
	
	public List<PurchaseOrder> getPurchaseOrderDetails() throws ApplicationException {
		return purchaseOrderDao.retrievePurchaseOrderDetails();
	}	
}
