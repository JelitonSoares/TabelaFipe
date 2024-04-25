package br.com.jeli.fipeveiculos.models.marca;

import br.com.jeli.fipeveiculos.models.marca.DadosMarca;
import br.com.jeli.fipeveiculos.models.modelo.DadosModelo;

import java.util.List;

public class Marca {
    private Integer codigo;
    private String nome;
    private List<DadosModelo> modelos;

    public Marca(DadosMarca dadosMarca) {
        try{
            this.codigo = Integer.parseInt(dadosMarca.codigo());
        } catch (NumberFormatException ex) {
            this.codigo = 0;
        }
        this.nome = dadosMarca.nome();
        this.modelos = dadosMarca.modelos();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public List<DadosModelo> getModelos() {
        return modelos;
    }

    @Override
    public String toString() {
        return "Cód: " + codigo +
                " Nome: " + nome;
    }
}
