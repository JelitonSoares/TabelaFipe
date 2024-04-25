package br.com.jeli.fipeveiculos.models.veiculo;

import java.math.BigDecimal;

public class Veiculo {
    private String nome;
    private Integer anoModelo;
    private String valor;

    public Veiculo(DadosVeiculo dadosVeiculo) {
        this.nome = dadosVeiculo.nome();
        this.anoModelo = dadosVeiculo.anoModelo();
        this.valor = dadosVeiculo.valor();
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " Ano: " + anoModelo +
                " Valor: " + valor;
    }
}
