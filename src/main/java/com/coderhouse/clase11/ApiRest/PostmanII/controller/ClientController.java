package com.coderhouse.clase11.ApiRest.PostmanII.controller;

import com.coderhouse.clase11.ApiRest.PostmanII.middleware.ResponseHandler;
import com.coderhouse.clase11.ApiRest.PostmanII.model.Client;
import com.coderhouse.clase11.ApiRest.PostmanII.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    // Método auxiliar para verificar si una cadena es numérica
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9\\.]+");
    }

    // Endpoint para crear un cliente
    @PostMapping
    public ResponseEntity<Object> postClient(@RequestBody Client client) {
        try {
            System.out.println(client);
            if (client.getName() == null || client.getName().isEmpty()) {
                return ResponseHandler.generateResponse(
                        "El nombre no puede estar vacío",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (isNumeric(client.getName())) {
                return ResponseHandler.generateResponse(
                        "El nombre debe ser un String",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (client.getLastname() == null || client.getLastname().isEmpty()) {
                return ResponseHandler.generateResponse(
                        "El apellido no puede estar vacío",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (isNumeric(client.getLastname())) {
                return ResponseHandler.generateResponse(
                        "El apellido debe ser un String",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (client.getDocnumber() == null) {
                return ResponseHandler.generateResponse(
                        "El documento no puede estar vacío",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (!isNumeric(client.getDocnumber())) {
                return ResponseHandler.generateResponse(
                        "El documento debe ser un número",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }

            // Guardar el cliente en la base de datos
            Client clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Datos obtenidos exitosamente",
                    HttpStatus.OK,
                    clientSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Endpoint para obtener un cliente por su ID
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient(@PathVariable() int id) {
        try {
            System.out.println(id);
            // Buscar el cliente en la base de datos
            Client clientFound = clientService.getClient(id);
            return ResponseHandler.generateResponse(
                    "Cliente obtenido exitosamente",
                    HttpStatus.OK,
                    clientFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> putClient(@PathVariable("id") int id, @RequestBody Client updatedClient) {
        try {
            // Verificar si el cliente existe antes de realizar cualquier operación
            if (!clientService.clientExist(id)) {
                return ResponseHandler.generateResponse(
                        "No se encontró el cliente con el ID proporcionado",
                        HttpStatus.NOT_FOUND,
                        null
                );
            }

            // Obtener el cliente existente
            Client existingClient = clientService.getClient(id);

            // Actualizar los campos relevantes del cliente existente
            existingClient.setName(updatedClient.getName());
            existingClient.setLastname(updatedClient.getLastname());
            existingClient.setDocnumber(String.valueOf(Integer.valueOf(updatedClient.getDocnumber())));

            // Actualizar el cliente existente en el servicio
            Client updatedExistingClient = clientService.updateClient(existingClient);

            return ResponseHandler.generateResponse(
                    "Cliente actualizado exitosamente",
                    HttpStatus.OK,
                    updatedExistingClient
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable("id") int id) {
        try {
            // Verificar si el cliente existe antes de realizar cualquier operación
            if (!clientService.clientExist(id)) {
                return ResponseHandler.generateResponse(
                        "No se encontró el cliente con el ID proporcionado",
                        HttpStatus.NOT_FOUND,
                        null
                );
            }

            // Eliminar el cliente mediante el servicio
            clientService.deleteClient(id);

            return ResponseHandler.generateResponse(
                    "Cliente eliminado exitosamente",
                    HttpStatus.OK,
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }


}
