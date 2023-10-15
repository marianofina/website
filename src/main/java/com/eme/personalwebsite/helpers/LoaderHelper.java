package com.eme.personalwebsite.helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;

import java.io.IOException;

import java.io.FileReader;

public class LoaderHelper {

    private final String nombre_archivo;

    public LoaderHelper(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    private JSONObject read() throws ParseException, IOException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\MARIA\\IdeaProjects\\PersonalWebsite-master\\src\\main\\resources\\data\\" + nombre_archivo);
        return (JSONObject) jsonParser.parse(reader);
    }

    public JSONObject getData() {
        JSONObject data_object;
        try {
             data_object = this.read();
        } catch(ParseException e) {
            data_object = null;
            System.out.println("Error de parseo");
        } catch(IOException e) {
            data_object = null;
            System.out.println("Error de ruta (dirección de archivo 'data')");
        }
        return data_object;
    }

}
