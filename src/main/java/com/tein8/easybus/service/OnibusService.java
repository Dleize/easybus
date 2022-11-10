package com.tein8.easybus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tein8.easybus.model.Onibus;
import com.tein8.easybus.repository.OnibusRepository;



@Service
public class OnibusService {
    
    @Autowired
    OnibusRepository repository;

    public Page<Onibus> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public List<Onibus> listAll(){
        return repository.findAll();
    }

    public  List<Onibus> listCheio() {
        return repository.findCheio();
    }

    public List<Onibus> listNaoCheio() {
        return repository.findNaoCheio();
    }

    public void save(Onibus onibus) {
        repository.save(onibus);
    }

    public Optional<Onibus> getByCdOnibus(Long cdOnibus) {
        return repository.findById(cdOnibus);
    }

    public void deleteByCdOnibus(Long cdOnibus) {
        repository.deleteById(cdOnibus);
    }





}
