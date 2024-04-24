package br.com.jeli.fipeveiculos.service.conversor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{

    private ObjectMapper mapper;

    public ConverteDados() {
        this.mapper = new ObjectMapper();
    }


    @Override
    public <T> T lerDados(String json, Class<T> tipo) {
        try{
            return mapper.readValue(json, tipo);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException();
        }
    }
}
