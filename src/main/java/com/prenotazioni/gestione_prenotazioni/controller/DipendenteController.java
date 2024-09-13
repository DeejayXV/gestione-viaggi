package com.prenotazioni.gestione_prenotazioni.controller;

import com.prenotazioni.gestione_prenotazioni.entity.Dipendente;
import com.prenotazioni.gestione_prenotazioni.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        Optional<Dipendente> dipendente = dipendenteRepository.findById(id);
        return dipendente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendenteDetails) {
        Optional<Dipendente> optionalDipendente = dipendenteRepository.findById(id);
        if (optionalDipendente.isPresent()) {
            Dipendente dipendente = optionalDipendente.get();
            dipendente.setNome(dipendenteDetails.getNome());
            dipendente.setCognome(dipendenteDetails.getCognome());
            dipendente.setEmail(dipendenteDetails.getEmail());
            dipendente.setUsername(dipendenteDetails.getUsername());
            dipendente.setImmagineProfilo(dipendenteDetails.getImmagineProfilo());
            return ResponseEntity.ok(dipendenteRepository.save(dipendente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        if (dipendenteRepository.existsById(id)) {
            dipendenteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
