package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.ApiResponse;
import uz.pdp.dto.CategoryDTO;
import uz.pdp.entity.Category;
import uz.pdp.repository.CategoryRepository;
import uz.pdp.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
@Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/crud")
    public String getHomePage(Model model){
        model.addAttribute("message","All Category");
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "category";
    }
    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("message","All Category");
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "category-show";
    }


    @GetMapping("/add")
    public String aptekaPage(Model model){

        List<Category> categoryList=categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        return "category";
    }

    @PostMapping("/add")
    public String saveApteka(@ModelAttribute CategoryDTO categoryDTO, Model model){
        ApiResponse response = categoryService.save(categoryDTO);
        model.addAttribute("message",response.getMessage());
        List<Category>categoryList=categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        return "category";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "edit_category";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable Integer id,
                                 @ModelAttribute("category") Category category,
                                 Model model) {
        Category existCategory = categoryService.getCategoryById(id);
        existCategory.setName(category.getName());
        categoryService.updateCategory(existCategory);
        model.addAttribute("message","Edited Category!");
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id,Model model) {
        categoryService.deleteCategoryById(id);
        model.addAttribute("message","Deleted Category!");
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "category";
    }
}
