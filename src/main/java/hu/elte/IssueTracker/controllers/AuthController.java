/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author KeresztiKrisztián
 */

@Controller
public class AuthController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }
  
}