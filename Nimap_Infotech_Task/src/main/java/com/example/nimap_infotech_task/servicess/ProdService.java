package com.example.nimap_infotech_task.servicess;

import org.springframework.stereotype.Service;
import com.example.nimap_infotech_task.Entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;

@Service
public interface ProdService {

   

    public Page<Product> getAllProducts(int page, int size);

    public Product createProduct(Product product);

    public Product getProductById(Long id);

    public Product updateProduct(Long id, Product productDetails);

    public void deleteProduct(Long id);

	public List<Product> getAllProduct();
}
