package com.ccj.homework.homeworktest2.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 * Address
 */
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String addressName;

    @ManyToMany(mappedBy = "addresses")
    private Collection<User> users;

    public Address() {
        this.users = new ArrayList<User>();
    }
}
