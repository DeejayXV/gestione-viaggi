package com.prenotazioni.gestione_prenotazioni.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class PrenotazioneDTO {

    @NotNull(message = "Il campo viaggioId è obbligatorio.")
    private Long viaggioId;

    @NotNull(message = "Il campo dipendenteId è obbligatorio.")
    private Long dipendenteId;

    @NotNull(message = "La data di richiesta è obbligatoria.")
    private LocalDate dataRichiesta;

    public Long getViaggioId() {
        return viaggioId;
    }

//    public void setViaggioId(Long viaggioId) {
//        this.viaggioId = viaggioId;
//    }

    public Long getDipendenteId() {
        return dipendenteId;
    }

//    public void setDipendenteId(Long dipendenteId) {
//        this.dipendenteId = dipendenteId;
//    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

//    public void setDataRichiesta(LocalDate dataRichiesta) {
//        this.dataRichiesta = dataRichiesta;
//    }
}
