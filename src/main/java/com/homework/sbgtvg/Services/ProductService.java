package com.homework.sbgtvg.Services;

import com.homework.sbgtvg.Model.Product;
import com.homework.sbgtvg.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {



    public ProductService() {
        super();
    }



    public List<Product> findAll() {
        return ProductRepository.getInstance().findAll();
    }

    public Product findById(final Integer id) {
        return ProductRepository.getInstance().findById(id);
    }

}
