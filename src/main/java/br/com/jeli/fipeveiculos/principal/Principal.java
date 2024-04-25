package br.com.jeli.fipeveiculos.principal;

import br.com.jeli.fipeveiculos.models.ano.Ano;
import br.com.jeli.fipeveiculos.models.ano.DadosAno;
import br.com.jeli.fipeveiculos.models.exception.DomainException;
import br.com.jeli.fipeveiculos.models.marca.Catalogo;
import br.com.jeli.fipeveiculos.models.marca.DadosMarca;
import br.com.jeli.fipeveiculos.models.marca.Marca;
import br.com.jeli.fipeveiculos.models.modelo.DadosModelo;
import br.com.jeli.fipeveiculos.models.modelo.Modelo;
import br.com.jeli.fipeveiculos.models.veiculo.DadosVeiculo;
import br.com.jeli.fipeveiculos.models.veiculo.Veiculo;
import br.com.jeli.fipeveiculos.service.consumo.Request;
import br.com.jeli.fipeveiculos.service.conversor.ConverteDados;
import com.fasterxml.jackson.core.JsonToken;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private static ConverteDados conversor = new ConverteDados();
    private static Request consumo = new Request();
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");


    public static void exibirMenu() {
        try{
            String opcao = selecionaVeiculo().trim();
            String endereco = "https://parallelum.com.br/fipe/api/v1/"+ opcao + "/marcas";
            List<Marca> marcas = getMarcas(endereco);
            marcas.forEach(System.out::println);

            String codigoMarca = selecionaMarca(marcas);

             endereco = endereco + "/" + codigoMarca + "/modelos/";
            List<Modelo> modelos = getModelo(endereco);
            modelos.forEach(System.out::println);

            List<Modelo> modelosFiltrados = filtraModelos(modelos);
            modelosFiltrados.forEach(System.out::println);

            String codigoModelo = slecionaCodigoModelo();

            endereco = endereco + codigoModelo + "/anos/";

            List<Ano> anos = getAno(endereco);

            List<DadosVeiculo> dadosVeiculos = getVeiculos(endereco, anos);
            List<Veiculo> veiculos = dadosVeiculos.stream()
                    .map(v -> new Veiculo(v))
                    .collect(Collectors.toList());

            veiculos.forEach(System.out::println);



        }catch (DomainException ex) {
            System.out.println(ex.getMessage());

        }

    }










    private static String selecionaVeiculo() {
        System.out.println("""
                <********************->OPÇÕES<-********************>
                <*****************->SELECIONE UMA<-****************>
                CARROS
                MOTOS
                CAMINHOES""");
        String opcao = scanner.next();

        if(opcao.equalsIgnoreCase("carros") || opcao.equalsIgnoreCase("motos") ||
                opcao.equalsIgnoreCase("caminhoes")) {
            System.out.println("PRESSIONE ENTER PARA CONFIRMAR: ");
            scanner.next();
            return opcao.toLowerCase();
        }
        throw new DomainException("Veículo Inválido!!");
    }








    private static List<Marca> getMarcas(String endereco) {
        String json = consumo.obterDados(endereco);

        String jsonModificado = "{ \"dados\": " +  json + "}";

        List<DadosMarca> dadosMarcas = conversor.lerDados(jsonModificado, Catalogo.class).dados();

        return dadosMarcas.stream()
                .map(m -> new Marca(m))
                .sorted(Comparator.comparing(Marca::getCodigo))
                .collect(Collectors.toList());

    }









    private static String selecionaMarca(List<Marca> marcas) {
        System.out.println("Digite o código da marca: ");
        String codigoMarca = scanner.next();
        Optional<Marca> marcaDesejada = marcas.stream()
                .filter(e -> e.getCodigo().equals(Integer.parseInt(codigoMarca)))
                .findFirst();
        if(marcaDesejada.isPresent()){
            System.out.println(marcaDesejada.get().getNome());
            System.out.println("Aperte enter para confirmar");
            scanner.next();

            return codigoMarca;
        }
        throw new DomainException("Código Inserido não está correto");

    }

    private static List<Modelo> getModelo(String endereco) {
        String json = consumo.obterDados(endereco);
        List<DadosModelo> modelos = conversor.lerDados(json, DadosMarca.class).modelos();
        return modelos.stream()
                .map(m -> new Modelo(m))
                .collect(Collectors.toList());
    }

    private static List<Modelo> filtraModelos(List<Modelo> modelos) {
        System.out.println("Digite um trecho do nome do modelo que deseja: ");
        String trechoNome = scanner.next();
        System.out.println("Pressione enter para continuar: ");
        scanner.next();

        return modelos.stream()
                .filter(m -> m.getNome().toLowerCase().contains(trechoNome.toLowerCase()))
                .collect(Collectors.toList());
    }

    private static String slecionaCodigoModelo() {
        System.out.println("Digite o código do modelo que deseja consultar: ");
        String codigoModelo = scanner.next();
        System.out.println("Pressione enter para confirmar: ");
        scanner.next();
        return codigoModelo;
    }

    private static List<Ano> getAno(String endereco) {
        String jsonTeste = consumo.obterDados(endereco);
        String jsonAlterado = "{ \"anos\": " + jsonTeste + "}";
        List<Ano> anos = conversor.lerDados(jsonAlterado, DadosAno.class).anos();
        return anos;
    }


    private static List<DadosVeiculo> getVeiculos(String endereco, List<Ano> anos) {
        List<DadosVeiculo> veiculos = new ArrayList<>();
        for(int i = 0; i < anos.size(); i++) {
            String enderecoComAno = endereco + anos.get(i).ano();
            String json = consumo.obterDados(enderecoComAno);
            DadosVeiculo veiculo = conversor.lerDados(json, DadosVeiculo.class);
            veiculos.add(veiculo);
        }
        return veiculos;
    }





}
