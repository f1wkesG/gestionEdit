package com.exam.gestionEdit.repository;

import com.exam.gestionEdit.entities.Numero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NumeroRepository extends JpaRepository<Numero, Integer> {

    List<Numero> findNumeroByBoucleFalse();
    List<Numero> findNumeroByBoucleTrue();


}
