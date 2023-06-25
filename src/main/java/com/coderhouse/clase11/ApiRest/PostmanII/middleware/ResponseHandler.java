package com.coderhouse.clase11.ApiRest.PostmanII.middleware;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    // Método para generar una respuesta con el mensaje, estado y objeto de respuesta proporcionados
    public static ResponseEntity<Object> generateResponse(
            String message,
            HttpStatus status,
            Object responseObj
    ) {
        // Crear un mapa para almacenar los datos de la respuesta
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        // Crear una nueva ResponseEntity con el mapa y el estado proporcionados
        return new ResponseEntity<Object>(map, status);
    }

}
