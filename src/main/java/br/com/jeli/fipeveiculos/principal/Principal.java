package br.com.jeli.fipeveiculos.principal;

import br.com.jeli.fipeveiculos.models.DadosMarcas;
import br.com.jeli.fipeveiculos.service.consumo.ConsumoApi;
import br.com.jeli.fipeveiculos.service.conversor.ConverteDados;

import java.util.Arrays;
import java.util.List;

public class Principal {

    private ConverteDados conversor = new ConverteDados();
    private ConsumoApi consumo = new ConsumoApi();


    public void exibirMenu() {

        String endereco = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

        String json = consumo.obterDados(endereco);

        DadosMarcas[] marcas = conversor.lerDadosArray(json);
        List<DadosMarcas> marcasList = Arrays.stream(marcas).toList();
        marcasList.forEach(System.out::println);



    }
}
