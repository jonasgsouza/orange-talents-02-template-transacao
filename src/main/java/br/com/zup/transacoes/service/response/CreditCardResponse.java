package br.com.zup.transacoes.service.response;

import br.com.zup.transacoes.model.CreditCard;

import java.util.UUID;

public class CreditCardResponse {

    private UUID id;

    private String email;

    @Deprecated
    public CreditCardResponse() {}

    public CreditCardResponse(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public CreditCard toModel() {
        return new CreditCard(id, email);
    }
}
