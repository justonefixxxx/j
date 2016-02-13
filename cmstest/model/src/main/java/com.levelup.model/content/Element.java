package com.levelup.model.content;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/6/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected Integer posX;
    protected Integer posY;
    protected String placeHolder;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }
}
