package com.prenotazioni.gestione_prenotazioni.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinazione;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    @ManyToMany
    @JoinTable(
            name = "viaggio_dipendenti",
            joinColumns = @JoinColumn(name = "viaggio_id"),
            inverseJoinColumns = @JoinColumn(name = "dipendente_id")
    )
    private Set<Dipendente> dipendenti = new HashSet<>();

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDestinazione() {
//        return destinazione;
//    }
//
//    public void setDestinazione(String destinazione) {
//        this.destinazione = destinazione;
//    }
//
//    public LocalDate getData() {
//        return data;
//    }
//
//    public void setData(LocalDate data) {
//        this.data = data;
//    }
//
//    public StatoViaggio getStato() {
//        return stato;
//    }
//
//    public void setStato(StatoViaggio stato) {
//        this.stato = stato;
//    }

    public Set<Dipendente> getDipendenti() {
        return dipendenti;
    }

//    public void setDipendenti(Set<Dipendente> dipendenti) {
//        this.dipendenti = dipendenti;
//    }
}
