package com.levelup.services;

import com.levelup.model.entity.Price;
import com.levelup.model.entity.Product;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/9/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface EntityManagementIf {
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(Product product);
    List<Product> findProductByName(String name);
    List<Product> findProductByCode(String code);
    List<Product> findProductsByPrice(Price price);
    List<Product> findProductsByPriceType(Price price);
    List<Price> getPricesByProduct(Product product);
    List<Product> getAllProducts();
}
