package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.ApiResponse;
import uz.pdp.dto.CategoryDTO;
import uz.pdp.dto.ProductDTO;
import uz.pdp.entity.Category;
import uz.pdp.entity.Product;
import uz.pdp.repository.CategoryRepository;
import uz.pdp.repository.ProductRepository;
import uz.pdp.service.ProductService;
import uz.pdp.service.ShopService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/crud")
    public String getHomePage(Model model){
        model.addAttribute("message","All Product Inform");
        model.addAttribute("productList",productRepository.findAll());
        return "product";
    }
    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("message","All Product Inform");
        model.addAttribute("productList",productRepository.findAll());
        return "product-show";
    }
    @GetMapping("/add")
    public String aptekaPage(Model model){

        List<Product> productList=productService.getAll();
        model.addAttribute("productList",productList);
        return "product";
    }

    @PostMapping("/add")
    public String saveApteka(@ModelAttribute ProductDTO productDTO, Model model){
        ApiResponse response = productService.save(productDTO);
        model.addAttribute("message",response.getMessage());
        List<Product> productList=productService.getAll();
        model.addAttribute("productList",productList);
        return "product";
    }

    @GetMapping("/edit/{id}")
    public String editProductsForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit_product";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id,
                                 @ModelAttribute("product") ProductDTO productDTO,
                                 Model model) {
        Product existProduct = productService.getProductById(id);
        Optional<Category> byId = categoryRepository.findById((int)productDTO.getCategoryId());

        Category category = byId.get();
        existProduct.setCategory(category);
        existProduct.setPrice(productDTO.getPrice());
        existProduct.setName(productDTO.getName());
        productService.updateProduct(existProduct);
        model.addAttribute("message","Edited Product!");
        model.addAttribute("productList",productRepository.findAll());
        return "product";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id,Model model) {
        productService.deleteProductById(id);
        model.addAttribute("message","Deleted Product!");
        model.addAttribute("productList",productRepository.findAll());
        return "product";
    }


}
