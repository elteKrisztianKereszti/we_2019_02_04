/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.services;

import hu.elte.IssueTracker.entities.Issue;
import hu.elte.IssueTracker.repositories.IssueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KeresztiKrisztián
 */
@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;
       
    public Iterable<Issue> getAll() {
        return issueRepository.findAll();
    }
    
    public List<Issue> getAllByPlace(String place) {
        return issueRepository.findAllByPlace(place);
    }
}