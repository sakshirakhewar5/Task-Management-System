package Task.Management.System.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Task.Management.System.example.Entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        // Check if the user exists in the list
        if (users.stream().anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password))) {
            model.addAttribute("username", username);
            return "tasks";
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again or register.");
            return "login";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {
        // Check if the username is already taken
        if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
            model.addAttribute("error", "Username already exists. Please choose a different one.");
            return "register";
        } else {
            users.add(user);
            model.addAttribute("username", user.getUsername());
            return "tasks";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        // You may also want to clear any authentication-related cookies or headers

        return "redirect:/login"; // Redirect to the login page
    }
}