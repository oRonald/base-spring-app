package br.com.projeto.crud.base.service;

import br.com.projeto.crud.base.database.Clients;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import br.com.projeto.crud.base.database.repository.ClientsRepository;
import br.com.projeto.crud.base.exception.ClientNewPassword;
import br.com.projeto.crud.base.exception.InvalidPhoneException;
import br.com.projeto.crud.base.service.iservices.IClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientsRepository repository;

    @Override
    @Transactional
    public Clients createClient(CreateClientDTO dto) {
        String phoneRegex = "^(\\(?\\d{2}\\)?\\s?)?(9\\d{4}|\\d{4})-?\\d{4}$";
        if(!dto.getPhone().matches(phoneRegex)){
            throw new InvalidPhoneException("Invalid Phone Number");
        }

        Clients clients = new Clients(dto);
        return repository.save(clients);
    }

    @Override
    public void updatePassword(ClientNewPassword newPassword, String clientId) {
        Clients client = repository.findById(UUID.fromString(clientId)).orElseThrow(() -> new IllegalStateException("User not found"));
        client.setPassword(newPassword.getNewPassword());

        repository.save(client);
    }
}
