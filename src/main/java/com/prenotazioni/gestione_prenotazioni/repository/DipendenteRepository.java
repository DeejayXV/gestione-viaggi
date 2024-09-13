package com.prenotazioni.gestione_prenotazioni.repository;

import com.prenotazioni.gestione_prenotazioni.entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
}
