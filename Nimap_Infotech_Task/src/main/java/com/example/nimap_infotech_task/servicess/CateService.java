package com.example.nimap_infotech_task.servicess;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.example.nimap_infotech_task.Entity.Category;

@Service
public interface CateService {

	public Page<Category>  getAllCategoriesPageDetails(int page, int size,String sortby);

	public Category createCategory(Category category);

	public Category getCategoryById(Long id);

	public Category updateCategory(Long id, Category categoryDetails);

	public void deleteCategory(Long id);

	public List<Category> getCategories();
	

	public List<Category> getAllCategories(int page, int size,String sortby);
}
