package com.prenotazioni.gestione_prenotazioni.controller;

import com.prenotazioni.gestione_prenotazioni.entity.Dipendente;
import com.prenotazioni.gestione_prenotazioni.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }
}
