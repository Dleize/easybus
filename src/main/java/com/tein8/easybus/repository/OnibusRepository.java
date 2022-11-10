package com.tein8.easybus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tein8.easybus.model.Onibus;

public interface OnibusRepository extends JpaRepository<Onibus, Long> {
    
    @Query("SELECT o FROM Onibus o WHERE o.dsStatus = 'CHEIO'")
    List<Onibus> findCheio();

    @Query("SELECT o FROM Onibus o WHERE o.dsStatus <> 'CHEIO'")
    List<Onibus> findNaoCheio();

}
