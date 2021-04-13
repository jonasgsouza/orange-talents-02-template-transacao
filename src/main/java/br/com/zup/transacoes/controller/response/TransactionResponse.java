package br.com.zup.transacoes.controller.response;

import br.com.zup.transacoes.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponse {
    private UUID id;

    private BigDecimal value;

    private EstablishmentResponse establishment;

    private LocalDateTime effectiveOn;

    public TransactionResponse(Transaction transaction) {
        id = transaction.getOriginalId();
        value = transaction.getValue();
        establishment = new EstablishmentResponse(transaction.getEstablishment());
        effectiveOn = transaction.getEffectiveOn();
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentResponse getEstablishment() {
        return establishment;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }
}
