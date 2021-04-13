package br.com.zup.transacoes.service.response;

import br.com.zup.transacoes.model.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponse {
    private UUID id;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private EstablishmentResponse establishment;

    @JsonProperty("cartao")
    private CreditCardResponse card;

    @JsonProperty("efetivadaEm")
    private LocalDateTime effectiveOn;

    @Deprecated
    public TransactionResponse() {
    }

    public TransactionResponse(UUID id, BigDecimal value, EstablishmentResponse establishment, CreditCardResponse card, LocalDateTime effectiveOn) {
        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectiveOn = effectiveOn;
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

    public CreditCardResponse getCard() {
        return card;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "id=" + id +
                ", value=" + value +
                ", establishment=" + establishment +
                ", card=" + card +
                ", effectiveOn=" + effectiveOn +
                '}';
    }

    public Transaction toModel() {
        return new Transaction(id, value, establishment.toModel(), card.toModel(), effectiveOn);
    }
}
