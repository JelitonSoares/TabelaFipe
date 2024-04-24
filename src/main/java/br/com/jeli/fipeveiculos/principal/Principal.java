package br.com.jeli.fipeveiculos.principal;

import br.com.jeli.fipeveiculos.service.consumo.ConsumoApi;
import br.com.jeli.fipeveiculos.service.conversor.ConverteDados;
import br.com.jeli.fipeveiculos.service.conversor.IConverteDados;

public class Principal {

    private IConverteDados conversor = new ConverteDados();
    private ConsumoApi consumo = new ConsumoApi();


    public void exibirMenu() {

    }
}
