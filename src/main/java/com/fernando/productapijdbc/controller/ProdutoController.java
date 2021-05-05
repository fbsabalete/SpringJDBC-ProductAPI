package com.fernando.productapijdbc.controller;

import com.fernando.productapijdbc.model.Produto;
import com.fernando.productapijdbc.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id){
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll (){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Produto>> findByNameOrDescriptionAndPrice (@RequestParam(required = false) String q,
                                                                          @RequestParam(required = false) Double minPrice,
                                                                          @RequestParam(required = false) Double maxPrice){
        return ResponseEntity.ok(produtoService.findByNameOrDescriptionAndPrice(q, minPrice, maxPrice));
    }

    @PostMapping
    public ResponseEntity<Produto> save (@RequestBody @Valid Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update (@PathVariable long id, @RequestBody @Valid Produto produto){
        return ResponseEntity.ok(produtoService.update(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable long id){
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
