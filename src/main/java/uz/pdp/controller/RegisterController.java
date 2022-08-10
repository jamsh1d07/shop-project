package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.UserDTO;
import uz.pdp.service.ShopService;
import uz.pdp.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping
    public String add(@ModelAttribute UserDTO dto){
         userService.addUser(dto);
         return "index";
    }

}
