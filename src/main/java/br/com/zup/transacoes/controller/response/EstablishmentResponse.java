package br.com.zup.transacoes.controller.response;

import br.com.zup.transacoes.model.Establishment;

public class EstablishmentResponse {

    private String name;

    private String city;

    private String address;

    public EstablishmentResponse(Establishment establishment) {
        name = establishment.getName();
        city = establishment.getCity();
        address = establishment.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
