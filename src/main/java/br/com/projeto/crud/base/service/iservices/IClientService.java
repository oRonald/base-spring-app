package br.com.projeto.crud.base.service.iservices;

import br.com.projeto.crud.base.database.Clients;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;

public interface IClientService {

    Clients createClient(CreateClientDTO dto);
}
