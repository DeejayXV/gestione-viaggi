package com.prenotazioni.gestione_prenotazioni.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "viaggio_id", nullable = false)
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "dipendente_id", nullable = false)
    private Dipendente dipendente;

    private LocalDate dataRichiesta;
    private String note;
    private String preferenzaVolo;
    private String preferenzaAlloggio;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPreferenzaVolo() {
        return preferenzaVolo;
    }

    public void setPreferenzaVolo(String preferenzaVolo) {
        this.preferenzaVolo = preferenzaVolo;
    }

    public String getPreferenzaAlloggio() {
        return preferenzaAlloggio;
    }

    public void setPreferenzaAlloggio(String preferenzaAlloggio) {
        this.preferenzaAlloggio = preferenzaAlloggio;
    }
}
