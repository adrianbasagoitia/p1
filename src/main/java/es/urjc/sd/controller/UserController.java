package es.urjc.sd.controller;
/* ********************************************************************* */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.urjc.sd.database.UserRepository;
import es.urjc.sd.p1.User;

/* ********************************************************************* */
@Controller
public class UserController {
    /* Attributes */
    /**
     * Repository of users to work with the database.
     */
    @Autowired
    private UserRepository repo;

    /* ********************************************************************* */
    /* Methods */
    /**
     * Controller method to list all users in a screen.
     * @param model The model
     * @return The template users.html
     */
    @GetMapping("/user")
    public String userList(Model model){
        List<User> list = repo.findAll();
        model.addAttribute("userList", list);
        return "/user";
    }

    @GetMapping("/user")
    public String userDetail(Model model, int userId){

        return "/user/{id}";
    }


} // End Class UserController
