package br.com.projeto.crud.base.service;

import br.com.projeto.crud.base.database.Clients;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import br.com.projeto.crud.base.database.repository.ClientsRepository;
import br.com.projeto.crud.base.exception.InvalidPhoneException;
import br.com.projeto.crud.base.service.iservices.IClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientsRepository repository;

    @Override
    @Transactional
    public Clients createClient(CreateClientDTO dto) {
        String phoneRegex = "^(\\(?\\d{2}\\)?\\s?)?(9\\d{4}|\\d{4})-?\\d{4}$";
        if(!dto.getPhone().matches(phoneRegex)){
            throw new InvalidPhoneException("Invalid phone");
        }

        Clients clients = new Clients(dto);
        return repository.save(clients);
    }
}
