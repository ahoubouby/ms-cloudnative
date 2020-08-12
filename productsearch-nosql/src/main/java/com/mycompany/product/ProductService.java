package com.mycompany.product;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.product.dao.ProductRepository;
import com.mycompany.product.entity.Product;

@RestController
public class ProductService {

/*	@Autowired
	ProductRepository prodRepo ;*/

    Map<String, Product> products = new HashMap();

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable("id") String id) {
        return products.get(id);
    }

    @RequestMapping("/products")
    List<Product> getProductsForCategory(@RequestParam("id") int id) {

        return Collections.singletonList(products.get(id));
    }

    @PutMapping("/product/{id}")
    public void insertUpdateProduct(@RequestBody Product product) {

        // No Validations, the method will automatically do add or insert operation  
        products.put(product.getId(), product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@RequestBody Product product) {

        // No Validations
        products.remove(product.getId());
    }
}
