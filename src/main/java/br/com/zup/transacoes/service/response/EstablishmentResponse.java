package br.com.zup.transacoes.service.response;

import br.com.zup.transacoes.model.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentResponse {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("endereco")
    private String address;

    @Deprecated
    public EstablishmentResponse() {
    }

    public EstablishmentResponse(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
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

    @Override
    public String toString() {
        return "EstablishmentResponse{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Establishment toModel() {
        return new Establishment(name, city, address);
    }
}
