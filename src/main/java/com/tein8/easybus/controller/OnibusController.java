package com.tein8.easybus.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tein8.easybus.model.Onibus;
import com.tein8.easybus.service.OnibusService;


@RestController
@RequestMapping("/api/onibus")
public class OnibusController {

    @Autowired
    private OnibusService service;
    
    @GetMapping
    @Cacheable("onibus")
    public Page<Onibus> index(@PageableDefault(size = 5) Pageable pageable){
        return service.listAll(pageable);
    }

    @PostMapping
    @PreAuthorize("authenticated()")
    public ResponseEntity<Onibus> create(@RequestBody @Valid Onibus onibus){
        service.save(onibus);
        return ResponseEntity.status(HttpStatus.CREATED).body(onibus);
    }

    @GetMapping("{cdOnibus}")
    public ResponseEntity<Onibus> show(@PathVariable Long cdOnibus){
        return ResponseEntity.of(service.getById(cdOnibus));
    }

    @DeleteMapping("{cdOnibus}")
    @PreAuthorize("hasRole('ADMIN')")
    @CacheEvict(value = "onibus", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long cdOnibus){

        Optional<Onibus> optional = service.getById(cdOnibus);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(cdOnibus);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{cdOnibus}")
    public ResponseEntity<Onibus> update(@PathVariable Long cdOnibus, @RequestBody @Valid Onibus newOnibus){
        Optional<Onibus> optional = service.getById(cdOnibus);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var onibus = optional.get();
        BeanUtils.copyProperties(newOnibus, onibus);
        onibus.setCdOnibus(cdOnibus);

        service.save(onibus);

        return ResponseEntity.ok(onibus);
    }
}
