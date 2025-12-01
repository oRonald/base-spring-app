package br.com.projeto.crud.base.service.iservices;

import br.com.projeto.crud.base.database.Clients;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import br.com.projeto.crud.base.exception.ClientNewPassword;

import java.util.UUID;

public interface IClientService {

    Clients createClient(CreateClientDTO dto);
    void updatePassword(ClientNewPassword newPassword, String clientId);
}
