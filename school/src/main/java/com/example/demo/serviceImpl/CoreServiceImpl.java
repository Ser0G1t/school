package com.example.demo.serviceImpl;

import com.example.demo.entity.CoreEntity;
import com.example.demo.repository.CoreRepository;
import com.example.demo.service.CoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

public class CoreServiceImpl<T extends CoreEntity,S extends CoreEntity> implements CoreService<T> {
    private final CoreRepository<T> repository;
    private final CoreRepository<S> secondaryRepository;

    public CoreServiceImpl(CoreRepository<T> repository, CoreRepository<S> secondaryRepository){
        this.repository=repository;
        this.secondaryRepository = secondaryRepository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        T toUpdate=repository.findById(entity.getId())
                .orElseThrow(()->new NullPointerException("no value with this id"));
        toUpdate.update(entity);
        return repository.save(toUpdate);
    }

    @Override
    public void delete(long id) {
        T toDelete=repository.findById(id)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        repository.delete(toDelete);
    }

    @Override
    public Page<T> getAll(int pageNumber, int pageSize, String sort) {
        Pageable page=PageRequest.of(pageNumber,pageSize, Sort.by(sort));
        return repository.findAll(page);
    }

    @Override
    public List<T> findByNameAndLastName(String name, String lastName) {
        List<T> entities=repository.findByNameAndLastName(name,lastName);
        if(entities.isEmpty()){
            throw new NullPointerException("no value with this parameters");
        }
        return entities;
    }

    @Override
    public void addToCollection(long id, long secondaryId) {
       T baseEntity= repository.findById(id)
               .orElseThrow(()->new NullPointerException("no value with this id"));
       S secondaryEntity= secondaryRepository.findById(secondaryId)
               .orElseThrow(()->new NullPointerException("no value with this id"));
        baseEntity.addToCollection(secondaryEntity);
        repository.save(baseEntity);
    }

    @Override
    public void removeFromCollection(long id, long secondaryId) {
        T baseEntity= repository.findById(id)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        S secondaryEntity= secondaryRepository.findById(secondaryId)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        baseEntity.removeFromCollection(secondaryEntity);
        repository.save(baseEntity);
    }

    @Override
    public Set<T> getCollection(long id) {
        T entity=repository.findById(id)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        return entity.getCollection();
    }


}
