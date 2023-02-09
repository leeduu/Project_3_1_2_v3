package Project_3_1_2_v3.Project_3_1_2_v3.controller;

import Project_3_1_2_v3.Project_3_1_2_v3.models.User;
import Project_3_1_2_v3.Project_3_1_2_v3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")   //показывает всех юзеров, по умолчанию
    public String showUsers(Model model) {
        model.addAttribute("showUsers", userService.showUsers());
    return "users";
    }

    @GetMapping("/show/{id}")   //показывает детали одного юзера
    public String showUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("showUser", userService.showUser(id));
        return "show";
    }

    @GetMapping("/new") //создание нового юзера
    public String newUserForm(Model model) {
        model.addAttribute("newUserForm", new User());
        return "new";
    }

    @PostMapping("/new")    //сохранение нового юзера и показ всех юзеров
    public String newUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}") //форма апдейта юзера
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("updateUser", userService.showUser(id));
        return("update");
    }

    @PatchMapping(value = "/update/{id}")   //апдейт юзера и показ всех юзеров
    public String update(@ModelAttribute("updatedUser") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/show/{id}")    //удаление юзера
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

//    @GetMapping("/error")
//    public String error() {
//        return "error";
//    }
}
