package br.com.jeli.fipeveiculos.models.marca;

import br.com.jeli.fipeveiculos.models.modelo.DadosModelo;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarca(@JsonAlias("codigo") String codigo,
                         @JsonAlias("nome") String nome,
                         @JsonAlias("modelos") List<DadosModelo> modelos) {
}
