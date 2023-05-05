package com.example.order.Service;

import com.example.order.DAO.Goods;
import com.example.order.DAO.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepo goodsRepo;

    public void save(Goods good){
        Iterable<Goods> goods = goodsRepo.findAll();
        Long id = 0L;
        for (Goods g: goods) {
            if(g.getId() == id)
                id++;
        }
        goodsRepo.save(new Goods(id, good.getName(), good.getPrice()));
    }

    public void changedGood(Goods goods){
        if(goodsRepo.findByName(goods.getName()) != null){
            Goods good = goodsRepo.findByName(goods.getName());
            System.out.println(good);
            //  goodsRepo.deleteById(good.getId());
            goodsRepo.save(new Goods(good.getId(), goods.getName(), goods.getPrice()));
        }
    }

    public void deleteGood(Long id){
        if(goodsRepo.findById(id) != null){
            goodsRepo.deleteById(id);
        }
    }

    public List<Goods> getAll(){
        return StreamSupport.stream(goodsRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Goods getById(Long id){
        return goodsRepo.findById(id).get();
    }

}
