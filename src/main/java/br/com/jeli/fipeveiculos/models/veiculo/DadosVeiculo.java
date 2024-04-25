package br.com.jeli.fipeveiculos.models.veiculo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("Modelo") String nome,
                           @JsonAlias("AnoModelo") Integer anoModelo,
                           @JsonAlias("Valor") String valor
                           ) {
}
