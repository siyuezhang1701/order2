package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.core.Product;
import com.thoughtworks.api.infrastructure.mybatis.mappers.ProductMapper;
import com.thoughtworks.api.infrastructure.records.ProductRecord;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by syzhang on 7/13/16.
 */
public class ProductRepository implements com.thoughtworks.api.infrastructure.core.ProductRepository {
    @Inject
    ProductMapper productMapper;

    @Override
    public Product createProduct(Map info){
        String productId = nextIdentity();
        info.put("productId", productId);
        productMapper.save(info);

        return productMapper.findById(productId);
    }

    @Override
    public List<Product> find() {

        return productMapper.findProducts();
    }

    @Override
    public Product findById(String productId) {
        Map map = new HashMap<>();
        map.put("productId", "1");
        map.put("name", "apple");
        map.put("description", "red apple");
        map.put("price", 1.2);

        return new ProductRecord(map);
    }

    private String nextIdentity() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
