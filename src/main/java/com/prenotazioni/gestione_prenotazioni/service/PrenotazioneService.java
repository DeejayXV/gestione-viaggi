package com.prenotazioni.gestione_prenotazioni.service;

import com.prenotazioni.gestione_prenotazioni.entity.Prenotazione;
import com.prenotazioni.gestione_prenotazioni.exception.PrenotazioneException;
import com.prenotazioni.gestione_prenotazioni.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
        Optional<Prenotazione> esistente = prenotazioneRepository
                .findByDipendenteIdAndDataRichiesta(prenotazione.getDipendente().getId(), prenotazione.getDataRichiesta());

        if (esistente.isPresent()) {
            throw new PrenotazioneException("Esiste già una prenotazione per questo dipendente nella data selezionata.");
        }

        return prenotazioneRepository.save(prenotazione);
    }
}
