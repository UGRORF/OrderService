package com.example.order.Controller;

import com.example.order.DAO.Goods;
import com.example.order.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({"/", "goods"})
public class GoodsController {
    @Autowired
    private GoodsService goodsService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Goods>> getGoods(){
        if(goodsService.getAll().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Goods>>(goodsService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Goods> getGoodById(@PathVariable Long id){
        if(id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(goodsService.getById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Goods>(goodsService.getById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Goods> addGood(@RequestBody Goods goods){
        HttpHeaders httpHeaders = new HttpHeaders();
        goodsService.save(goods);

        return new ResponseEntity<>(goods, httpHeaders, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Goods> changedGood(@RequestBody Goods goods){
        HttpHeaders httpHeaders = new HttpHeaders();
        System.out.println(goods);
        goodsService.changedGood(goods);


        return new ResponseEntity<>(goods, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Goods> deleteGood(@PathVariable Long id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        goodsService.deleteGood(id);

        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
