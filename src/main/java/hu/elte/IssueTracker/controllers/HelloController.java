/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.controllers;

import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author KeresztiKrisztián
 */
@Controller
public class HelloController {

  @GetMapping("/hello")
  public String index(Model model) {
    model.addAttribute("title", "Actor list");
    model.addAttribute("actors", Arrays.asList(
      "Brad Pitt",
      "Bruce Willis",
      "Benedict Cumberbatch"
    ));
    return "hello";
  }

}
