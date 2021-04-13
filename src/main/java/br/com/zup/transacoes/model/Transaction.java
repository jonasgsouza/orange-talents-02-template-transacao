package br.com.zup.transacoes.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID originalId;

    private BigDecimal value;

    @Embedded
    private Establishment establishment;

    @Embedded
    private CreditCard creditCard;

    private LocalDateTime effectiveOn;

    @Deprecated
    public Transaction() {
    }

    public Transaction(UUID originalId, BigDecimal value, Establishment establishment, CreditCard creditCard, LocalDateTime effectiveOn) {
        this.originalId = originalId;
        this.value = value;
        this.establishment = establishment;
        this.creditCard = creditCard;
        this.effectiveOn = effectiveOn;
    }

    public Long getId() {
        return id;
    }

    public UUID getOriginalId() {
        return originalId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public CreditCard getCard() {
        return creditCard;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }
}
