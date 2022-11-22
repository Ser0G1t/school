package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="students")
public class Student<T> extends CoreEntity<Student,Teacher> {

    public Student(){};

    private String fieldOfStudy;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name="students_teachers",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="teacher_id")
    )

    private Set<Teacher> teachers;

    @Override
    public Student update(Student student) {
        setName(student.getName());
        setLastName(student.getLastName());
        setAge(student.getAge());
        setEmail(student.getEmail());
        setFieldOfStudy(student.getFieldOfStudy());
        return student;
    }

    @Override
    public Set<Teacher> getCollection() {
        return getTeachers();
    }
    @Override
    public void addToCollection(Teacher teacher){
        this.getTeachers().add(teacher);
        teacher.getStudents().add(this);
    }
    @Override
    public void removeFromCollection(Teacher teacher) {
        this.getTeachers().remove(teacher);
        teacher.getStudents().remove(this);
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

}
