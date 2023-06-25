package com.coderhouse.clase11.ApiRest.PostmanII.service;

import com.coderhouse.clase11.ApiRest.PostmanII.model.Client;
import com.coderhouse.clase11.ApiRest.PostmanII.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client postClient(Client client) throws Exception {
        return clientRepository.save(client);
    }

    public Client getClient(int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById(id);
        if(cliente.isEmpty()){
            throw new Exception("Cliente con id: " + id + ", no existe");
        } else {
            return cliente.get();
        }
    }

    public boolean clientExist (int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById(id);
        return cliente.isPresent();
    }

    public void deleteClient(int id) throws Exception {
        if (!clientExist(id)) {
            throw new Exception("No se encontró el cliente con el ID proporcionado");
        }

        clientRepository.deleteById(id);
    }
    public Client updateClient(Client updatedClient) throws Exception {
        int id = updatedClient.getId();
        Optional<Client> existingClientOptional = clientRepository.findById(id);
        if (existingClientOptional.isEmpty()) {
            throw new Exception("No se encontró el cliente con el ID proporcionado");
        }

        Client existingClient = existingClientOptional.get();
        existingClient.setName(updatedClient.getName());
        existingClient.setLastname(updatedClient.getLastname());
        existingClient.setDocnumber(String.valueOf(Integer.valueOf(updatedClient.getDocnumber())));

        return clientRepository.save(existingClient);
    }
}

