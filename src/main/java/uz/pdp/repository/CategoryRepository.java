package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Category;
import uz.pdp.entity.Shop;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
