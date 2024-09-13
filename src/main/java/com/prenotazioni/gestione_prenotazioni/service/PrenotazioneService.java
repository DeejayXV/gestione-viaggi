package com.prenotazioni.gestione_prenotazioni.service;

import com.prenotazioni.gestione_prenotazioni.entity.Prenotazione;
import com.prenotazioni.gestione_prenotazioni.entity.Viaggio;
import com.prenotazioni.gestione_prenotazioni.entity.Dipendente;
import com.prenotazioni.gestione_prenotazioni.exception.PrenotazioneException;
import com.prenotazioni.gestione_prenotazioni.repository.PrenotazioneRepository;
import com.prenotazioni.gestione_prenotazioni.repository.ViaggioRepository;
import com.prenotazioni.gestione_prenotazioni.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Prenotazione creaPrenotazione(Long dipendenteId, Long viaggioId, LocalDate dataRichiesta) {

        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new PrenotazioneException("Dipendente non trovato."));

        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new PrenotazioneException("Viaggio non trovato."));

        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findByDipendenteIdAndDataRichiesta(dipendenteId, dataRichiesta);
        if (prenotazioneEsistente.isPresent()) {
            throw new PrenotazioneException("Il dipendente ha già una prenotazione per questa data.");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(dataRichiesta);

        return prenotazioneRepository.save(prenotazione);
    }
}
