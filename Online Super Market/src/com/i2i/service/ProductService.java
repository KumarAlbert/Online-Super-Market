/**
 * 
 */
package com.i2i.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.Product;
import com.i2i.model.Subcategory;
import com.i2i.service.SubcategoryService;
import com.i2i.dao.ProductDao;
import com.i2i.exception.ApplicationException;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Service("productService")
public class ProductService {
	
	@Autowired
	SubcategoryService subcategoryService;
	@Autowired
	ProductDao productDao;
	
	public boolean addProduct(String name, String description, String subcategoryName, String url, int stock,
			double price, int createdBy) throws ApplicationException {
		Subcategory subcategory = subcategoryService.findSubcategoryByName(subcategoryName);
        Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
        Timestamp modifiedAt = null;
        int modifiedBy = 0;
        String imageUrl = "images/"+url;
		Product product = new Product(name, description, subcategory, imageUrl, stock, price, createdBy,
				                      createdAt,modifiedBy ,modifiedAt);
		return productDao.insertProduct(product);
	}
	
	public List<Product> getProductDetails() throws ApplicationException{
		return productDao.retrieveProductDetails();
	}
	
	public Product findProductByName(String name) throws ApplicationException{
		return productDao.searchProductByName(name);
	}
	
	public boolean modifyProductNameByName(String oldName, String newName, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(oldName);
	    product.setName(newName);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	public boolean modifyProductDescriptionByName(String name, String description, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setDescription(description);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	public boolean modifyProductImageUrlByName(String name, String imageUrl, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setImageUrl(imageUrl);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	public boolean modifyProductStockByName(String name, int stock, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setStock(stock);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	public boolean modifyProductPriceByName(String name, double price, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setPrice(price);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	public boolean removeProductByName(String name) throws ApplicationException {
		Product product = productDao.searchProductByName(name);
        return productDao.deleteProduct(product);
	}
}