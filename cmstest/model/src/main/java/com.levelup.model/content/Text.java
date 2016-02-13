package com.levelup.model.content;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/6/13
 * Time: 12:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Text extends Element {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
