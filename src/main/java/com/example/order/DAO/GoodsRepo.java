package com.example.order.DAO;

import org.springframework.data.repository.CrudRepository;

public interface GoodsRepo extends CrudRepository<Goods, Long> {
    //Goods findById(String id);

    Goods findByName(String name);
}
