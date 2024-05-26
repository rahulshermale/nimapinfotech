package com.example.nimap_infotech_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.nimap_infotech_task.Entity.Category;
import com.example.nimap_infotech_task.servicesimplementation.CategoryService;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public List<Category> getCategories() {
		return categoryService.getCategories();

	}
	

	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);

	}

	@GetMapping("/page")
	public Page<Category> getAllCategoriesPageDetails(
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			@RequestParam(value = "sortby", defaultValue = "id", required = false) String sortby) {

		

		return categoryService.getAllCategoriesPageDetails(page, size, sortby);

	}

	@GetMapping
	public List<Category> getAllCategories(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			@RequestParam(value = "sortby", defaultValue = "id", required = false) String sortby) {
		
	
		return categoryService.getAllCategories(page, size, sortby);

	}

	@PostMapping
	public Category createCategory(@RequestBody Category category) {

		return categoryService.createCategory(category);
	}


	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
		return categoryService.updateCategory(id, categoryDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {

		categoryService.deleteCategory(id);
	}
}
