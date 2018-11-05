package com.nf147.entity;

public class Order {
    private Integer order_id;

    private Integer pet_id;

    private Integer user_id;

    private Integer order_quantity;

    private String order_shipDate;

    private String order_status;

    private byte[] order_complete;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(Integer order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getOrder_shipDate() {
        return order_shipDate;
    }

    public void setOrder_shipDate(String order_shipDate) {
        this.order_shipDate = order_shipDate == null ? null : order_shipDate.trim();
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status == null ? null : order_status.trim();
    }

    public byte[] getOrder_complete() {
        return order_complete;
    }

    public void setOrder_complete(byte[] order_complete) {
        this.order_complete = order_complete;
    }
}