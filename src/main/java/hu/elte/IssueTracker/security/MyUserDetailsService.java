/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.IssueTracker.security;

import hu.elte.IssueTracker.entities.User;
import hu.elte.IssueTracker.repositories.UserRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author KeresztiKrisztián
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private AuthenticatedUser authenticatedUser;

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> oUser = userRepository.findByUsername(username);
    if (!oUser.isPresent()) {
      throw new UsernameNotFoundException(username);
    }
    User user = oUser.get();
    authenticatedUser.setUser(user);
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
  }
}
