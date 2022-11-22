package com.example.demo.repository;

import com.example.demo.entity.CoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CoreRepository <T extends CoreEntity> extends JpaRepository<T,Long> {
    List<T> findByNameAndLastName(String name, String lastName);
}
