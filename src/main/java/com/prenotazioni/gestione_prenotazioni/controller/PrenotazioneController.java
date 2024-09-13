package com.prenotazioni.gestione_prenotazioni.controller;

import com.prenotazioni.gestione_prenotazioni.dto.PrenotazioneDTO;
import com.prenotazioni.gestione_prenotazioni.entity.Prenotazione;
import com.prenotazioni.gestione_prenotazioni.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataRichiesta(prenotazioneDTO.getDataRichiesta());
        // Altri campi vengono impostati nel servizio

        return prenotazioneService.creaPrenotazione(prenotazione);
    }
}
