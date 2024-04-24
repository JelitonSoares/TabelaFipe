package br.com.jeli.fipeveiculos.service.conversor;

public interface IConverteDados {

    public <T> T lerDados(String json, Class<T> tipo);
}
