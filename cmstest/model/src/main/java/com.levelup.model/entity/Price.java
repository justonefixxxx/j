package com.levelup.model.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/29/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="Price")
public class Price {

    private Long id;
    private Float value;
    private PriceType priceType;

    public Price() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Enumerated(value = EnumType.STRING)
    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }
}
