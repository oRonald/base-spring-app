package br.com.projeto.crud.base.resource;

import br.com.projeto.crud.base.database.dto.ClientDetailsDTO;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import br.com.projeto.crud.base.exception.ClientNewPassword;
import br.com.projeto.crud.base.resource.iresources.IClientResource;
import br.com.projeto.crud.base.service.iservices.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

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

    @Override
    @PatchMapping("/update-password/{id}")
    public ResponseEntity<Void> updatePassword(@RequestBody ClientNewPassword newPassword, @PathVariable("id") String clientId) {
        service.updatePassword(newPassword, clientId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
