package ru.cft.shift.intensive.template.repository.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("users")
public class Users {
  @PrimaryKey
  private String username;
  @Column
  private String login;
  @Column
  private String password;
  @Column
  private Set<String> roles = new HashSet<>();

  public Users() {
  }

  public Users(String username, String login, String password, Set<String> roles) {
    this.username = username;
    this.login = login;
    this.password = password;
    this.roles = roles;
  }

  public Users(String username, String login, String password) {
    this.username = username;
    this.login = login;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRoles() {
    return roles;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setRoles(Set<String> roles) {
    this.roles = roles;
  }
}
