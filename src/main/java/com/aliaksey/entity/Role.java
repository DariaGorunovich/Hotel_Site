package com.aliaksey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{
    private Integer id;
    private String roleName;
    private Set<User> users = new HashSet<User>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", unique = true, nullable = false)
    public Integer getId() {
        return
    this.id;
}
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(name = "role_name", nullable = false, length = 45)
    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
