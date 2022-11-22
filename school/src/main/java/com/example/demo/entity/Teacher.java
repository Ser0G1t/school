package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="teachers")
public class Teacher extends CoreEntity<Teacher,Student> {

    public Teacher(){};

    private String subject;

    @ManyToMany(mappedBy = "teachers")
    @JsonIgnore
    private Set<Student> students;

    @Override
    public Teacher update(Teacher teacher) {
        setName(teacher.getName());
        setLastName(teacher.getLastName());
        setAge(teacher.getAge());
        setEmail(teacher.getEmail());
        setSubject(teacher.getSubject());
        return teacher;
    }

    @Override
    public Set<Student> getCollection() {
        return getStudents();
    }
    @Override
    public void addToCollection(Student student) {
        this.getStudents().add(student);
        student.getTeachers().add(this);
    }
    @Override
    public void removeFromCollection(Student student) {
        this.getStudents().remove(student);
        student.getTeachers().remove(this);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
