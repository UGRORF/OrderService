package com.example.order.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order_Line {
    @Id
    private Long id;
    private Long order_id;
    private Long goods_id;
    private Integer count;

    public Order_Line() {
    }

    public Order_Line(Long id, Long order_id, Long goods_id, Integer count) {
        this.id = id;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.count = count;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
