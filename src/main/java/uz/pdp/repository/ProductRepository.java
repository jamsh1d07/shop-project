package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Product;
import uz.pdp.entity.Shop;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
