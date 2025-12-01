package br.com.projeto.crud.base.resource;

import br.com.projeto.crud.base.database.dto.ClientDetailsDTO;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import br.com.projeto.crud.base.resource.iresources.IClientResource;
import br.com.projeto.crud.base.service.iservices.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientsResource implements IClientResource {

    private final IClientService service;

    @Override
    @PostMapping
    public ResponseEntity<ClientDetailsDTO> createClient(@RequestBody CreateClientDTO dto, UriComponentsBuilder builder) {
        var client = service.createClient(dto);
        var uri = builder.path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(ClientDetailsDTO.create(client));
    }
}
