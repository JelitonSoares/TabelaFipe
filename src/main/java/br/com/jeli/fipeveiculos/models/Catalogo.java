package br.com.jeli.fipeveiculos.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Catalogo(@JsonAlias("dados") List<DadosMarca> dados) {
}
