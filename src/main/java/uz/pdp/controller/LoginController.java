package uz.pdp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.dto.UserDTO;
import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;
import uz.pdp.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String login(@ModelAttribute UserDTO userDTO) {
        if(userDTO.getEmail().equalsIgnoreCase("jamshid@gmail.com")&& userDTO.getPassword().equalsIgnoreCase("111")){
            return "adminPage";
        }

        for (User user : userRepository.findAll()) {

            if(user.getPassword().equals(userDTO.getPassword()) && user.getEmail().equals(userDTO.getEmail())){
              return "userPage";
            }
        }

        return "index";
    }


}
