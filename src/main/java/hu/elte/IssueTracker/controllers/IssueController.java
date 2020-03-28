/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.controllers;

import hu.elte.IssueTracker.entities.Issue;
import hu.elte.IssueTracker.repositories.IssueRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("{id}")
  public String getIssue(@PathVariable Integer id, Model model) {
    Optional<Issue> dbIssue = issueRepository.findById(id);

    if (dbIssue.isEmpty()) {
      return "redirect:/issues";
    }

    Issue issue = dbIssue.get();

    model.addAttribute("title", issue.getTitle());
    model.addAttribute("issue", issue);
    return "issue";
  }

  @GetMapping("new")
  public String addForm(Model model) {
    model.addAttribute("issue", new Issue());

    return "issue-form";
  }

  @PostMapping("new")
  public String addIssue(@Valid Issue issue, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("errors", bindingResult.getAllErrors());
      return "issue-form";
    }

    issueRepository.save(issue);
    return "redirect:/issues";
  }

  @GetMapping("{id}/edit")
  public String editForm(@PathVariable Integer id, Model model) {
    Optional<Issue> dbIssue = issueRepository.findById(id);

    if (dbIssue.isEmpty()) {
      return "redirect:/issues";
    }

    model.addAttribute("issue", issueRepository.findById(id).get());
    return "issue-form";
  }

  @PostMapping("{id}/edit")
  public String editIssue(@PathVariable Integer id, @Valid Issue issue, BindingResult bindingResult, Model model) {
    Optional<Issue> dbIssue = issueRepository.findById(id);

    if (dbIssue.isEmpty()) {
      return "redirect:/issues";
    }

    if (bindingResult.hasErrors()) {
      model.addAttribute("errors", bindingResult.getAllErrors());
      return "issue-form";
    }

    issueRepository.save(issue);

    return "redirect:/issues";
  }
}
