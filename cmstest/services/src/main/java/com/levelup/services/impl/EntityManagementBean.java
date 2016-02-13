package com.levelup.services.impl;

import com.levelup.model.entity.Price;
import com.levelup.model.entity.Product;
import com.levelup.services.EntityManagementIf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/9/13
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class EntityManagementBean implements EntityManagementIf {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product getProductById(Long id) {
        Product result = em.find(Product.class, id);
        return  result;
    }

    @Override
    public Product createProduct(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
//        Product oldProduct = em.find(Product.class, product.getId());
//        oldProduct.setCode(product.getCode());
//        oldProduct.setDescription(product.getDescription());
//        oldProduct.setPrices(product.getPrices());
//        em.merge(oldProduct);
        em.merge(product);
        return product;
    }

    @Override
    public boolean deleteProduct(Product product) {
        em.remove(product);
        return true;
    }

    @Override
    public List<Product> findProductByName(String name) {
        Query query = em.createQuery("from Product as p where p.name = ?");
        query.setParameter(1,name);
        List<Product> result = query.getResultList();
        for (Product p: result){
            if (!p.getPrices().isEmpty()){
                Iterator<Price> iter = p.getPrices().iterator();
                iter.next();
            }
        }
        return  result;
    }

    @Override
    public List<Product> findProductByCode(String code) {
        Query query = em.createQuery("from Product as p where p.code = ?");
        query.setParameter(1,code);
        List<Product> result = query.getResultList();
        return  result;
    }

    @Override
    public List<Product> findProductsByPrice(Price price){
        Query query = em.createQuery("from Product as p join Price as pr where pr.value = ?");
        query.setParameter(1,price.getValue());
        List<Product> result = query.getResultList();
        return  result;
    }

    @Override
    public List<Product> findProductsByPriceType(Price price){
        Query query = em.createQuery("from Product as p join Price as pr where pr.priceType = ?");
        query.setParameter(1,price.getPriceType());
        List<Product> result = query.getResultList();
        return  result;
    }

    @Override
    public List<Price> getPricesByProduct(Product product){
        Query query = em.createQuery("select p.prices from Product as p where p.id = ?");
        query.setParameter(1,product.getId());
        List<Price> result = query.getResultList();
        return  result;
    }

    @Override
    public List<Product> getAllProducts(){
        Query query = em.createQuery("from Product as p ");
        List<Product> result = query.getResultList();
        for (Product p: result){
            if (!p.getPrices().isEmpty()){
                Iterator<Price> iter = p.getPrices().iterator();
                iter.next();
            }
        }
        return  result;
    }
}
