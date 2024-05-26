package com.example.nimap_infotech_task.servicesimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.nimap_infotech_task.Entity.Category;
import com.example.nimap_infotech_task.exeption.ResourceNotFoundException;
import com.example.nimap_infotech_task.repository.CategoryRepository;
import com.example.nimap_infotech_task.servicess.CateService;

import java.util.List;

@Service
public class CategoryService implements CateService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories(int page, int size, String sortby) {

		if (page <= 0) {
			page = 0;
		} else {
			page--;
		}

//		Pageable p = PageRequest.of(page, size,sortby);
		Pageable p = PageRequest.of(page, size, Sort.by(sortby).ascending());

		Page<Category> pagePost = categoryRepository.findAll(p);

		return pagePost.getContent();
	}

	public Page<Category> getAllCategoriesPageDetails(int page, int size, String sortby) {

		if (page <= 0) {
			page = 0;
		} else {
			page--;
		}

		return categoryRepository.findAll(PageRequest.of(page, size, Sort.by(sortby)));

	}

	public Category createCategory(Category category) {

		return categoryRepository.save(category);
	}

	public Category getCategoryById(Long id) {

		return categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
	}

	public Category updateCategory(Long id, Category categoryDetails) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
		category.setName(categoryDetails.getName());

		return categoryRepository.save(category);

	}

	public void deleteCategory(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));

		categoryRepository.delete(category);
	}

	public List<Category> getCategories() {
		
		return categoryRepository.findAll();
	}
}
