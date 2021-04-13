package br.com.zup.transacoes.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class CreditCard {

    @Column(name = "card_id")
    private UUID id;

    private String email;

    @Deprecated
    public CreditCard() {
    }

    public CreditCard(UUID id, String email) {
        this.id = id;
        this.email = email;
    }
}
