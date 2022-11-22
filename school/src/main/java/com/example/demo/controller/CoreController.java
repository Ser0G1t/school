package com.example.demo.controller;


import com.example.demo.entity.CoreEntity;
import com.example.demo.repository.CoreRepository;
import com.example.demo.serviceImpl.CoreServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@MappedSuperclass
public abstract class CoreController<T extends CoreEntity, S extends CoreEntity> {
    private static final String CREATE="create";
    private static final String UPDATE="update";
    private static final String DELETE="delete/{id}";
    private static final String GET_ALL="get_all";
    private static final String FIND_BY_NAME_AND_LAST_NAME="find_by_name_and_last_name";
    private static final String ADD_TO_COLLECTION="{id}/add_to_collection/{secondaryId}";
    private static final String REMOVE_FROM_COLLECTION="{id}/remove_from_collection/{secondaryId}";
    private static final String GET_COLLECTION="{id}/get_collection";

    private final CoreServiceImpl<T,S> service;

    public CoreController(CoreRepository<T> coreRepository,CoreRepository<S> secondaryRepository){
       this.service=new CoreServiceImpl<T,S>(coreRepository, secondaryRepository){};
    }

    @PostMapping(CREATE)
    public ResponseEntity<T> create(@Valid @RequestBody T entity){
        return ResponseEntity.ok(service.create(entity));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<T> update(@Valid @RequestBody T entity){
        return ResponseEntity.ok(service.update(entity));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<T> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<List<T>> getAll(@RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String sort){
        return ResponseEntity.ok(service.getAll(pageNumber,pageSize,sort).getContent());
    }
    @GetMapping(FIND_BY_NAME_AND_LAST_NAME)
    public ResponseEntity<List<T>> findByNameAndLastName(@RequestParam String name, @RequestParam String lastName){
        return ResponseEntity.ok(service.findByNameAndLastName(name, lastName));
    }
    @PostMapping(ADD_TO_COLLECTION)
    public ResponseEntity<T> addToCollection(@PathVariable long id, @PathVariable long secondaryId){
        service.addToCollection(id,secondaryId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(REMOVE_FROM_COLLECTION)
    public ResponseEntity<T> removeFromCollection(@PathVariable long id, @PathVariable long secondaryId){
        service.removeFromCollection(id,secondaryId);
        return ResponseEntity.ok().build();
    }
    @GetMapping(GET_COLLECTION)
    public ResponseEntity<Set<T>> getCollection(@PathVariable long id){
        return ResponseEntity.ok().body(service.getCollection(id));
    }
}
