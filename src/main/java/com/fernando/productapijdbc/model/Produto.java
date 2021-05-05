package com.fernando.productapijdbc.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Produto {

    @Id
    private long id;
    @Size(min=2, max = 255) @NotEmpty @NotNull
    private String name;
    @Size(min=2, max = 255) @NotEmpty @NotNull
    private String description;
    @NotNull @Positive
    private double price;

    public Produto() {
    }

    public Produto(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
