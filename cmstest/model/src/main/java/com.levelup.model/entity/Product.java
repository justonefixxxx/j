package com.levelup.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/29/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Product")
public class Product {

    private Long id;
    private String name;
    private String code;
    private String description;
    private Collection<Price> prices;
    private Boolean onSale = false;
    private Boolean onPromo = false;

    public Product() {
    }

    @Transient
    public Float getPromoPrice(){
        Float result = null;
        for (Price p: prices){
            switch (p.getPriceType()){
                case PROMO: {
                    result = p.getValue();
                    break;
                }
                case NET:
                case REGULAR:
                case SALE: {
                    break;
                }
            }
        }

        return result;
    }

    @Transient
    public Float getRegularPrice(){
        Float result = null;
        for (Price p: prices){
            switch (p.getPriceType()){
                case REGULAR: {
                    result = p.getValue();
                    break;
                }
                case NET:
                case PROMO:
                case SALE: {
                    break;
                }
            }
        }

        return result;
    }


    @Transient
    public Float getCurrentPrice(){
        Float result = null;
        for (Price p: prices){
            switch (p.getPriceType()){
                case PROMO: {
                    if (onPromo)
                        result = p.getValue();
                    break;
                }
                case NET:   {
                    break;
                }
                case REGULAR: {
                    if (!onPromo && !onSale) {
                        result = p.getValue();
                    }
                    break;
                }
                case SALE: {
                    if (onSale)
                        result = p.getValue();
                    break;
                }
            }
        }

        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(targetEntity = Price.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    public Collection<Price> getPrices() {
        return prices;
    }

    public void setPrices(Collection<Price> prices) {
        this.prices = prices;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Boolean getOnPromo() {
        return onPromo;
    }

    public void setOnPromo(Boolean onPromo) {
        this.onPromo = onPromo;
    }
}
