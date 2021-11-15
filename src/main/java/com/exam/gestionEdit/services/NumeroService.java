package com.exam.gestionEdit.services;

import com.exam.gestionEdit.dtos.NumeroDTO;
import com.exam.gestionEdit.entities.Numero;
import com.exam.gestionEdit.repository.NumeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumeroService {

    @Autowired
    NumeroRepository numeroRepository;

    public List<Numero> recupererNumerosNonBoucles() {
        return numeroRepository.findNumeroByBoucleFalse();
    }

    public List<Numero> recupererNumerosBoucles(){
        return numeroRepository.findNumeroByBoucleTrue();
    }

    public List<Numero> recupererToutNumero(){
        return numeroRepository.findAll();
    }

    public Numero recupererNumero(int numero) {
        return numeroRepository.findById(numero).orElse(null);
    }

    public void creerNumero() {
        Numero numero = new Numero();
        numero.setBoucle(false);
        numeroRepository.save(numero);
    }

    public void publierNumero(NumeroDTO numeroDTO) {
        Numero numero = numeroRepository.findById(numeroDTO.getNum()).orElse(null);
        numero.setBoucle(true);
        numeroRepository.save(numero);
    }

}
