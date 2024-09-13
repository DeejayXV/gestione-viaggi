package com.prenotazioni.gestione_prenotazioni.repository;

import com.prenotazioni.gestione_prenotazioni.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    Optional<Prenotazione> findByDipendenteIdAndDataRichiesta(Long dipendenteId, LocalDate dataRichiesta);
}
