package com.example.demo.service;

import com.example.demo.entity.CoreEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface CoreService<T extends CoreEntity> {
    T create(T entity);
    T update(T entity);
    void delete(long id);
    Page<T> getAll(int pageNumber, int pageSize, String sort);
    List<T> findByNameAndLastName(String name, String lastName);
    void addToCollection(long id, long secondaryId);
    void removeFromCollection(long id, long secondaryId);
    Set<T> getCollection(long id);

}
