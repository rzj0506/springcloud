package com.rzj.product.service.impl;

import com.rzj.common.pojo.Products;
import com.rzj.product.mapper.ProductMapper;
import com.rzj.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Products findById(Integer productId) {
        return productMapper.selectById(productId);
    }
}
