package com.levelup.model.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/29/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
*/
public enum PriceType {

    REGULAR("Regular price","RP"), PROMO("Promo price","PP"), SALE("Sale price","SP"), NET("Net price","NP");

    private String name;
    private String code;

    private PriceType(String name, String code) {
        this.name = name;
        this.code = code;
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

    public PriceType getTypeByName(String name){
        for (PriceType pt: PriceType.values()){
            if (pt.getName().equals(name)){
                return pt;
            }
        }
        return null;


    }

    public PriceType getTypeByCode(String code){
        for (PriceType pt: PriceType.values()){
            if (pt.getCode().equals(code)){
                return pt;
            }
        }
        return null;


    }

}
