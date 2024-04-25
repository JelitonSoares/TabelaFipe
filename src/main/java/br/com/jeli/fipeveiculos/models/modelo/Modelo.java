package br.com.jeli.fipeveiculos.models.modelo;

public class Modelo {

    private Integer codigo;
    private String nome;

    public Modelo(DadosModelo dadosModelo) {
        this.codigo = Integer.parseInt(dadosModelo.codigo());
        this.nome = dadosModelo.nome();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cód: " + codigo +
                " Nome: " + nome;
    }
}
