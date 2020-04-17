/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.controllers;

import hu.elte.IssueTracker.entities.Issue;
import hu.elte.IssueTracker.entities.Label;
import hu.elte.IssueTracker.entities.Message;
import hu.elte.IssueTracker.repositories.IssueRepository;
import hu.elte.IssueTracker.repositories.LabelRepository;
import hu.elte.IssueTracker.repositories.MessageRepository;
import hu.elte.IssueTracker.security.AuthenticatedUser;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author KeresztiKrisztián
 */
@Controller
@RequestMapping("/issues")
public class IssueController {

  @Autowired
  private AuthenticatedUser authenticatedUser;
  
  @Autowired
  private IssueRepository issueRepository;

  @Autowired
  private MessageRepository messageRepository;

  @Autowired
  private LabelRepository labelRepository;

  @GetMapping("")
  public String getAll(Model model) {
    model.addAttribute("title", "Issue list");
    model.addAttribute("issues", issueRepository.findAll());
    return "issue-list";
  }

  @GetMapping("/{id}")
  public String getIssue(@PathVariable Integer id, Message message, Model model) {
    Optional<Issue> dbIssue = issueRepository.findById(id);

    if (dbIssue.isEmpty()) {
      return "redirect:/issues";
    }

    Issue issue = dbIssue.get();

    model.addAttribute("title", issue.getTitle());
    model.addAttribute("issue", issue);
    model.addAttribute("message", message); // Add this line

    return "issue-detail";
  }

  @GetMapping("/new")
  public String addForm(Model model) {
    model.addAttribute("issue", new Issue());
    model.addAttribute("issueLabels", new ArrayList<Integer>());
    model.addAttribute("allLabels", labelRepository.findAll());

    return "issue-form";
  }

  @PostMapping("/new")
  public String addIssue(@Valid Issue issue, BindingResult bindingResult,
          @RequestParam(value = "labels", required = false) ArrayList<Integer> labels,
          Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("errors", bindingResult.getAllErrors());
      model.addAttribute("issueLabels", labels);
      model.addAttribute("allLabels", labelRepository.findAll());
      return "issue-form";
    }

    issue.setUser(authenticatedUser.getUser());
    issueRepository.save(issue);
    return "redirect:/issues";
  }

  @GetMapping("/{id}/edit")
  public String editForm(@PathVariable Integer id, Model model) {
    Optional<Issue> dbIssue = issueRepository.findById(id);

    if (dbIssue.isEmpty()) {
      return "redirect:/issues";
    }

    model.addAttribute("issue", issueRepository.findById(id).get());
    model.addAttribute("allLabels", labelRepository.findAll());

    List<Integer> issueLabels = new ArrayList<Integer>();
    for (Label label : dbIssue.get().getLabels()) {
      issueLabels.add(label.getId());
    }
    model.addAttribute("issueLabels", issueLabels);
    return "issue-form";
  }

  @PostMapping("/{id}/edit")
  public String editIssue(@PathVariable Integer id, @Valid Issue issue, BindingResult bindingResult,
          @RequestParam(value = "labels", required = false) ArrayList<Integer> labels,
          Model model) {
    Optional<Issue> dbIssue = issueRepository.findById(id);

    if (dbIssue.isEmpty()) {
      return "redirect:/issues";
    }

    if (bindingResult.hasErrors()) {
      model.addAttribute("errors", bindingResult.getAllErrors());
      model.addAttribute("allLabels", labelRepository.findAll());
      model.addAttribute("issueLabels", labels);
      return "issue-form";
    }

    issueRepository.save(issue);

    return "redirect:/issues";
  }

  @GetMapping("/{id}/delete")
  public String deleteIssue(@PathVariable Integer id) {
    try {
      issueRepository.deleteById(id);
    } catch (Exception e) {
    }
    return "redirect:/issues";
  }

  @PostMapping("/{id}/message")
  public String addMessage(@PathVariable Integer id, @Valid Message message, BindingResult bindingResult, Model model) throws Exception {
    if (bindingResult.hasErrors()) {
      return getIssue(id, message, model);
    }

    Issue issue = issueRepository.findById(id).get();
    message.setId(null);
    message.setIssue(issue);
    messageRepository.save(message);
    return "redirect:/issues";
  }
}
