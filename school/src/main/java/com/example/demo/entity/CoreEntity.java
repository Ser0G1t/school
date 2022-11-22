package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.util.Set;

@MappedSuperclass
public abstract class CoreEntity<T,S> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Length(min=2, message = "name need to have at least 2 letters")
    private String name;
    private String lastName;
    @Min(value=18, message = "person need to be at least 18 years old")
    private int age;
    @Email(message = "bad email format")
    private String email;

    @JsonIgnore
    public abstract Set<S> getCollection();

    public abstract void addToCollection(S entity);

    public abstract void removeFromCollection(S entity);

    public abstract T update(T entity);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
