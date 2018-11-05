package com.nf147.entity;

import java.math.BigDecimal;

public class Pet {
    private Integer pet_id;

    private Integer category_id;

    private String pet_name;

    private BigDecimal pet_price;

    private String pet_status;

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name == null ? null : pet_name.trim();
    }

    public BigDecimal getPet_price() {
        return pet_price;
    }

    public void setPet_price(BigDecimal pet_price) {
        this.pet_price = pet_price;
    }

    public String getPet_status() {
        return pet_status;
    }

    public void setPet_status(String pet_status) {
        this.pet_status = pet_status == null ? null : pet_status.trim();
    }
}