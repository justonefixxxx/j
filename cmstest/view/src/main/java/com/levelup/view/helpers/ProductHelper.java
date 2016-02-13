package com.levelup.view.helpers;

import com.levelup.model.entity.Price;
import com.levelup.model.entity.PriceType;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/13/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProductHelper {

    public static Price createPrice(PriceType type, String value){
        Price resPrice = new Price();
        resPrice.setPriceType(type);
        try {
            resPrice.setValue(Float.parseFloat(value));
        } catch (NumberFormatException e){
            return null;
        }
        return resPrice;

    }
}
