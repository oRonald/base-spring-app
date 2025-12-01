package br.com.projeto.crud.base.service.iservices;

import br.com.projeto.crud.base.database.Clients;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import br.com.projeto.crud.base.database.dto.UpdateClientProfileDTO;
import br.com.projeto.crud.base.database.dto.ClientNewPasswordDTO;

public interface IClientService {

    Clients createClient(CreateClientDTO dto);
    void updatePassword(ClientNewPasswordDTO newPassword, String clientId);
    Clients updateClient(UpdateClientProfileDTO dto, String clientId);
}
