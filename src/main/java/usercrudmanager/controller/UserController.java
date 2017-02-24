package usercrudmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import usercrudmanager.model.UserStore;
import usercrudmanager.userService.UserService;

/**
 * Created by Kovalchuk Dmytro on 22.02.2017.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new UserStore());
        model.addAttribute("listUsers", this.userService.usersList());
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")UserStore userStore){
        if(userStore.getId() == 0){
            this.userService.add(userStore);
        }
        else this.userService.updateUser(userStore);
        return "redirect:/users";
    }

    @RequestMapping(value = "/remove{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "edit{id}")
    public String editUser(@PathVariable("id")int id, Model model){
        model.addAttribute("user", this.userService.getUser(id));
        model.addAttribute("list", this.userService.usersList());
        return "users";
    }

    @RequestMapping(value = "userData{id}")
    public String userData(@PathVariable("id")int id, Model model){
        model.addAttribute("user",this.userService.getUser(id));
        return "userData";
    }
}
