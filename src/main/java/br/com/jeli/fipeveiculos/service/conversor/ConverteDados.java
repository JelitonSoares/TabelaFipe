package br.com.jeli.fipeveiculos.service.conversor;

import br.com.jeli.fipeveiculos.models.DadosMarcas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConverteDados implements IConverteDados{

    private ObjectMapper mapper;

    public ConverteDados() {
        this.mapper = new ObjectMapper();
    }


    @Override
    public <T> T lerDados(String json, Class<T> tipo) {
        try{
            return mapper.readValue(json, tipo);
        } catch (IOException exception) {
            throw new RuntimeException();
        }
    }

    public DadosMarcas[] lerDadosArray(String json) {
        try {
            return mapper.readValue(json, DadosMarcas[].class);
        }catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
