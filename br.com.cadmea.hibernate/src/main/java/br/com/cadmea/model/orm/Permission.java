package br.com.cadmea.model.orm;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cadmea.model.BaseEntityPersistent;

/**
 * @author Gilberto Santos
 *
 */
@Entity
@Table(name = "cadmea_user_permission")
@AttributeOverrides(@AttributeOverride(name = "id",
    column = @Column(name = "per_id", nullable = false)))
public class Permission extends BaseEntityPersistent {

  /**
   *
   */
  private static final long serialVersionUID = 6065307712935738823L;

  @NotNull
  @NotEmpty
  @Size(max = 45)
  @Column(name = "role", length = 45, nullable = false, unique = true)
  private String role;

  @ManyToMany(targetEntity = UserSystem.class, mappedBy = "permissions")
  @JsonIgnore
  private Set<UserSystem> users;

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Set<UserSystem> getUsers() {
    return users;
  }

  public void setUsers(Set<UserSystem> users) {
    this.users = users;
  }

}
