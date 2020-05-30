/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.controllers.rest;

import hu.elte.IssueTracker.entities.User;
import hu.elte.IssueTracker.repositories.UserRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KeresztiKrisztián
 */
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private UserRepository userRepository;

    private User getUser(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username).get();
    }

    @PostMapping("login")
    public ResponseEntity<User> login(Principal principal) {
        return ResponseEntity.ok(getUser(principal));
    }
}
