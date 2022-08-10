package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.ApiResponse;
import uz.pdp.dto.CategoryDTO;
import uz.pdp.entity.Category;
import uz.pdp.repository.CategoryRepository;


import java.util.List;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    public List<Category> getAll() {
        return categoryRepository.findAll();
    }


    public ApiResponse save(CategoryDTO categoryDTO) {
        Category category=new Category();
        category.setName(categoryDTO.getName());
     categoryRepository.save(category);
     return new ApiResponse("Added Category!",true);
    }


    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(Math.toIntExact(id)).get();
    }


    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }


    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(Math.toIntExact(id));
    }
}