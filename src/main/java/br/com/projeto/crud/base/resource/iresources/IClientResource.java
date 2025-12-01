package br.com.projeto.crud.base.resource.iresources;

import br.com.projeto.crud.base.database.dto.ClientDetailsDTO;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponentsBuilder;

@Validated
public interface IClientResource {

    ResponseEntity<ClientDetailsDTO> createClient(@Valid CreateClientDTO dto, UriComponentsBuilder builder);

}
