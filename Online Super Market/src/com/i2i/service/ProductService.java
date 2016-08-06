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
 * <h1> Product Service </h1>
 * <p> It provides product related services</p>
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
	
	/**
	 * <p> This method used to add product details.</p>
	 * @param name It holds product's name.
	 * @param description It holds product's description.
	 * @param subcategoryName It holds product's subcategory name.
	 * @param imageUrl It holds product's image url.
	 * @param stock It holds products's stock value.
	 * @param price It holds product's product's price.
	 * @param createdBy It holds id of who create this record.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean addProduct(String name, String description, String subcategoryName, String imageUrl, int stock,
			double price, int createdBy) throws ApplicationException {
		Subcategory subcategory = subcategoryService.findSubcategoryByName(subcategoryName);
        Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
        Timestamp modifiedAt = null;
        int modifiedBy = 0;
		Product product = new Product(name, description, subcategory, imageUrl, stock, price, createdBy,
				                      createdAt,modifiedBy ,modifiedAt);
		return productDao.insertProduct(product);
	}
	
	
	/**
	 * <p> This method used to get product details.</p>
	 * @return List It returns product list.
	 * @throws ApplicationException
	 */
	public List<Product> getProductDetails() throws ApplicationException{
		return productDao.retrieveProductDetails();
	}
	
	/**
	 * <p> This method used to find product details.</p>
	 * @param name It holds product name.
	 * @return product It returns product object.
	 * @throws ApplicationException
	 */
	public Product findProductByName(String name) throws ApplicationException{
		return productDao.searchProductByName(name);
	}
	
	/**
	 * <p> This method used to modify product's name.</p>
	 * @param oldName This holds product's old name.
	 * @param newName This holds product's new name. 
	 * @param modifiedBy This holds id of who modify product.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean modifyProductNameByName(String oldName, String newName, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(oldName);
	    product.setName(newName);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	/**
	 * <p> This method used to modify product's description. </p>
	 * @param name It holds product's name.
	 * @param description It holds product's description.
	 * @param modifiedBy This holds id of who modify product.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean modifyProductDescriptionByName(String name, String description, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setDescription(description);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	/**
	 * <p> This method used to modify product's image url. </p>
	 * @param name This holds product's name.
	 * @param imageUrl This holds product's image url.
	 * @param modifiedBy This holds id of who modify product.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean modifyProductImageUrlByName(String name, String imageUrl, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setImageUrl(imageUrl);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	/**
	 * <p> This method used to modify product's stock. </p>
	 * @param name This holds product's name.
	 * @param stock This holds product's stock.
	 * @param modifiedBy This holds id of who modify product.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean modifyProductStockByName(String name, int stock, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setStock(stock);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	/**
	 * <p> This method used to modify product's description. </p>
	 * @param name This holds product's name.
	 * @param price This holds product's price.
	 * @param modifiedBy This holds id of who modify product.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean modifyProductPriceByName(String name, double price, int modifiedBy) throws ApplicationException {
	    Product product = productDao.searchProductByName(name);
	    product.setPrice(price);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        product.setModifiedBy(0);
        product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct(product);
	}
	
	/**
	 * <p> This method used to delete product. </p>
	 * @param name This holds product's name.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean removeProductByName(String name) throws ApplicationException {
		Product product = productDao.searchProductByName(name);
        return productDao.deleteProduct(product);
	}
}