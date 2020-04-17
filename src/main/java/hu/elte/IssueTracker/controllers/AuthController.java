/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.controllers;

import hu.elte.IssueTracker.entities.User;
import hu.elte.IssueTracker.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author KeresztiKrisztián
 */
@Controller
public class AuthController {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String registerForm() {
    return "register";
  }

  @PostMapping("/register")
  public String register(User user, Model model) {
    Optional<User> oUser = userRepository.findByUsername(user.getUsername());
    if (oUser.isPresent()) {
      model.addAttribute("error", "Existing user name");
      return "register";
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setEnabled(true);
    user.setRole(User.Role.ROLE_USER);
    userRepository.save(user);
    return "redirect:/login";
  }
}
