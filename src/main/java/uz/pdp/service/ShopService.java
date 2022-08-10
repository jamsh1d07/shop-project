package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;
}
