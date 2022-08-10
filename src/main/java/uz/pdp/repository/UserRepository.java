package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Shop;
import uz.pdp.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
