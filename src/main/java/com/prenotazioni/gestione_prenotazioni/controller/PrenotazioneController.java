package com.prenotazioni.gestione_prenotazioni.controller;

import com.prenotazioni.gestione_prenotazioni.dto.PrenotazioneDTO;
import com.prenotazioni.gestione_prenotazioni.entity.Prenotazione;
import com.prenotazioni.gestione_prenotazioni.service.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    public ResponseEntity<Prenotazione> createPrenotazione(@Valid @RequestBody PrenotazioneDTO prenotazioneDTO) {
        Prenotazione prenotazione = prenotazioneService.creaPrenotazione(
                prenotazioneDTO.getDipendenteId(),
                prenotazioneDTO.getViaggioId(),
                prenotazioneDTO.getDataRichiesta()
        );
        return ResponseEntity.ok(prenotazione);
    }
}
