package LoginSecurities.LoginSecurity.Controller;


import LoginSecurities.LoginSecurity.Domain.User;
import LoginSecurities.LoginSecurity.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private userService service;

    @GetMapping("/signUp")
    public String register(@ModelAttribute("user") User theUser, Model model) {

        return"userSignUp";
    }
    @PostMapping("/signUp")
    public String userSignUp(@ModelAttribute("user") User theUser,Model model) {

        service.signUp(theUser);
        model.addAttribute("successMessage", "User Saved Succesful");

        return"userSignUp";
    }



    @GetMapping("/login")
    public String Login(@ModelAttribute("user") User users) {
        // Assuming User.login() returns null if credentials don't match
         return  "login";

    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User users) {
        // Assuming User.login() returns null if credentials don't match
        User userDetails = service.login(users.getEmail(), users.getPassword(), users.getRole());
        return  "userSignUp";

    }


    @GetMapping("/admin")
    public  String adminPage(){
        return "adminDashboard";
    }

    @GetMapping("/user")
    public  String userPage(){
        return "usersDashboard";
    }



}
