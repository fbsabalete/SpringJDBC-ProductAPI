package com.fernando.productapijdbc.service;

import com.fernando.productapijdbc.controller.exceptions.ObjectNotFoundException;
import com.fernando.productapijdbc.model.Produto;
import com.fernando.productapijdbc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll (){
        List<Produto> produtoList = new ArrayList<Produto>();
        repository.findAll().forEach(produtoList::add);
        return produtoList;
    }

    public Produto findById (long id){
        Optional<Produto> obj = repository.findById(id);
        return obj.isPresent() ? obj.get() : obj.orElseThrow(() -> new ObjectNotFoundException("Produto id="+id+" não encontrado"));
    }

    public List<Produto> findByNameOrDescriptionAndPrice(String description, Double minPrice, Double maxPrice){
        if(maxPrice == null) maxPrice = 100000D;
        if(minPrice == null) minPrice = 0d;
        if(description!=null) {
            description = "%" + description + "%";
            return repository.findByNameOrDescriptionAndPrice(description, minPrice, maxPrice);
        }
        return  repository.findByPrice(minPrice, maxPrice);
    }

    public Produto save (Produto product){
        return repository.save(product);
    }

    public Produto update (long id, Produto product){
        findById(id);
        product.setId(id);
        return repository.save(product);
    }

    public void delete(long id){
        findById(id);
        repository.deleteById(id);
    }


}
