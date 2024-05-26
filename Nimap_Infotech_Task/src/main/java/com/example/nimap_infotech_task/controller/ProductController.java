package com.example.nimap_infotech_task.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.nimap_infotech_task.Entity.Product;
import com.example.nimap_infotech_task.servicesimplementation.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(value="page",defaultValue = "0",required = false) int page,@RequestParam(value="size",defaultValue = "10",required = false)int size) {
    	
    
    	
    	
        return productService.getAllProducts(page, size);
        
        
    }
        

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    
    
    @GetMapping("all")
    public List<Product> getAllProduct() {
    	return productService.getAllProduct();
    }
    

    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
    	
    	System.out.println(product);
    	
        return productService.createProduct(product);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
