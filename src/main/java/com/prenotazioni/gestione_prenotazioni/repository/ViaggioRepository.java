package com.prenotazioni.gestione_prenotazioni.repository;

import com.prenotazioni.gestione_prenotazioni.entity.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}
