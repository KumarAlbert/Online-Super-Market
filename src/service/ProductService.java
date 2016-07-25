/**
 * 
 */
package service;

import java.sql.Time;
import java.util.List;
import model.Product;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class ProductService {
	
	ProductDao productDao = new ProductDao();
	public boolean addProduct(String name, String description,int subcategoryId,String imageUrl,
			int stock, double price, int createdBy, Time createdAt, int modifiedBy, Time modifiedAt ) {
		Product product = new Product(name, description, subcategoryId, imageUrl, stock, 
				createdBy, createdAt, updatedBy, updatedAt);
		return productDao.insertProduct(product);
	}
	
	public List<Product> getProductDetails() {
		return productDao.reteriveProductDetails();
	}
	
	public Product findProductByName(String name) {
		return productDao.searchProductByName(name);
	}
	
	public boolean modifyProductNameByName(String oldName, String newName, int modifiedBy, Time modifiedAt ) {
	    Product product = productDao.searchProductByName(oldName);
	    product.setName(newName);
	    product.setModifiedBy(modifiedBy);
	    product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct();
	}
	
	public boolean modifyProductDescriptionByName(String name, String description, int modifiedBy, Time modifiedAt ) {
	    Product product = productDao.searchProductByName(name);
	    product.setDescription(description);
	    product.setModifiedBy(modifiedBy);
	    product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct();
	}
	
	public boolean modifyProductImageUrlByName(String name, String imageUrl, int modifiedBy, Time modifiedAt ) {
	    Product product = productDao.searchProductByName(name);
	    product.setImageUrl(imageUrl);
	    product.setModifiedBy(modifiedBy);
	    product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct();
	}
	
	public boolean modifyProductStockByName(String name, int stock, int modifiedBy, Time modifiedAt ) {
	    Product product = productDao.searchProductByName(name);
	    product.setStock(stock);
	    product.setModifiedBy(modifiedBy);
	    product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct();
	}
	
	public boolean modifyProductPriceByName(String name, double price, int modifiedBy, Time modifiedAt ) {
	    Product product = productDao.searchProductByName(name);
	    product.setPrice(price);
	    product.setModifiedBy(modifiedBy);
	    product.setModifiedAt(modifiedAt);
	    return productDao.updateProduct();
	}
	
	public boolean removeProductByName(String name) {
		Product product = productDao.searchProductByName(name);
        return productDao.deleteProduct(product);
	}
}
