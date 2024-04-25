package br.com.jeli.fipeveiculos.models;

public class Marca {
    private Integer codigo;
    private String nome;

    public Marca(DadosMarca dadosMarca) {
        try{
            this.codigo = Integer.parseInt(dadosMarca.codigo());
        } catch (NumberFormatException ex) {
            this.codigo = 0;
        }
        this.nome = dadosMarca.nome();
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
