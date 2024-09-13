package com.prenotazioni.gestione_prenotazioni.controller;

import com.prenotazioni.gestione_prenotazioni.entity.Dipendente;
import com.prenotazioni.gestione_prenotazioni.entity.Viaggio;
import com.prenotazioni.gestione_prenotazioni.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @GetMapping("/{id}/dipendenti")
    public ResponseEntity<Set<Dipendente>> getDipendenti(@PathVariable Long id) {
        Optional<Viaggio> optionalViaggio = viaggioRepository.findById(id);
        if (optionalViaggio.isPresent()) {
            Viaggio viaggio = optionalViaggio.get();
            return ResponseEntity.ok(viaggio.getDipendenti());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
