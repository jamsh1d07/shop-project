package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.ApiResponse;
import uz.pdp.dto.ProductDTO;
import uz.pdp.entity.Category;
import uz.pdp.entity.Product;
import uz.pdp.repository.CategoryRepository;
import uz.pdp.repository.ProductRepository;
import uz.pdp.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;



    public ApiResponse save(ProductDTO productDTO) {
        Product product =new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        Optional<Category> byId = categoryRepository.findById(productDTO.getCategoryId());
        Category category = byId.get();
        product.setCategory(category);
        productRepository.save(product);
        return new ApiResponse("Added Product!",true);
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }


    public Product getProductById(Integer id) {
        return productRepository.findById(Math.toIntExact(id)).get();
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    public void deleteProductById(Integer id) {
        productRepository.deleteById(Math.toIntExact(id));
    }
}
