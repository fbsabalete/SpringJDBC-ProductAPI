package com.fernando.productapijdbc.repository;

import com.fernando.productapijdbc.model.Produto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    @Query("SELECT * FROM produto WHERE (LOWER(name) LIKE LOWER(:description) OR LOWER(description) LIKE LOWER(:description)) AND (price >= :minPrice AND price <= :maxPrice)")
    List<Produto> findByNameOrDescriptionAndPrice(@Param("description") String description,
                                                  @Param("minPrice") double minPrice,
                                                  @Param("maxPrice") double maxPrice);

    @Query("SELECT * FROM produto WHERE (price >= :minPrice AND price <= :maxPrice)")
    List<Produto> findByPrice(@Param("minPrice") double minPrice,
                              @Param("maxPrice") double maxPrice);

}
