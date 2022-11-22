package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends CoreController<Teacher, Student> {

    public TeacherController(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        super(teacherRepository, studentRepository);
    }
}
