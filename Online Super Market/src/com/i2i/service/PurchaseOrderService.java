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
	PurchaseOrderDao purchaseOrderDao;
    
	public boolean addPurchaseOrder(User user, double total, String paymentType, boolean status, 
			int createdBy) throws ApplicationException {
        Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
        Timestamp modifiedAt = null;
        int modifiedBy = 0;
        PurchaseOrder purchaseOrder = new PurchaseOrder(user, total, paymentType, status, createdAt,
				modifiedAt, createdBy, modifiedBy);
		return purchaseOrderDao.insertPurchaseOrder(purchaseOrder);
	}
	
	
	public List<PurchaseOrder> getPurchaseOrderDetails() throws ApplicationException {
		return purchaseOrderDao.retrievePurchaseOrderDetails();
	}	
}
