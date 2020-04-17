/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.repositories;

import hu.elte.IssueTracker.entities.Issue;
import hu.elte.IssueTracker.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KeresztiKrisztián
 */
@Repository
public interface IssueRepository extends CrudRepository<Issue, Integer> {
  public List<Issue> findAllByPlace(String place);
  public Iterable<Issue> findAllByUser(User user);
}
