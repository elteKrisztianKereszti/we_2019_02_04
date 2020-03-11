/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.controllers;

import hu.elte.IssueTracker.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author KeresztiKrisztián
 */
@Controller
@RequestMapping("/issues")
public class IssueController {
  @Autowired
  private IssueRepository issueRepository;
  
  @GetMapping("")
  public String getAll(Model model) {
    model.addAttribute("title", "Issue list");
    model.addAttribute("issues", issueRepository.findAll());
    return "list";
  }

}
