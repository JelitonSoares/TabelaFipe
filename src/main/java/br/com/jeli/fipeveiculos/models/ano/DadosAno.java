package br.com.jeli.fipeveiculos.models.ano;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAno(@JsonAlias("anos") List<Ano> anos) {
}
