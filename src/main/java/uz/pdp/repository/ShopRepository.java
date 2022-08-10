package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {

}
