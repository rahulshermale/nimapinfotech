package com.example.nimap_infotech_task.servicesimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.nimap_infotech_task.Entity.Category;
import com.example.nimap_infotech_task.Entity.Product;
import com.example.nimap_infotech_task.exeption.ResourceNotFoundException;
import com.example.nimap_infotech_task.repository.CategoryRepository;
import com.example.nimap_infotech_task.repository.ProductRepository;
import com.example.nimap_infotech_task.servicess.ProdService;

import java.util.List;

@Service
public class ProductService implements ProdService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Product> getAllProducts(int page, int size) {

		if (page <= 0) {
			page = 0;
		} else {
			page--;
		}

		return productRepository.findAll(PageRequest.of(page, size));
	}

	public Product createProduct(Product product) {

		return productRepository.save(product);
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
	}

	public Product updateProduct(Long id, Product productDetails) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		Long categoryId = productDetails.getCategory().getId();
		
		
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		product.setCategory(category);

		// IMP

		//product.setCategory(productDetails.getCategory());
		// if we want to change category then used this method but all data have been
		// chanege.

//		System.err.println(productDetails.getCategory().getName());
//		System.err.println(productDetails.getCategory().getId());
//		System.err.println(productDetails.getCategory());
//		System.err.println(category.getName());

//        category.setName(productDetails.getCategory().getName());
//        category.setId(productDetails.getCategory().getId());
//       

		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

		productRepository.delete(product);
	}

	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}
}
