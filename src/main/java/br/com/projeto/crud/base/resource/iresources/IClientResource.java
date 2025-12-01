package br.com.projeto.crud.base.resource.iresources;

import br.com.projeto.crud.base.database.dto.ClientDetailsDTO;
import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import br.com.projeto.crud.base.database.dto.UpdateClientProfileDTO;
import br.com.projeto.crud.base.exception.ClientNewPassword;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponentsBuilder;

@Validated
public interface IClientResource {

    ResponseEntity<ClientDetailsDTO> createClient(@Valid CreateClientDTO dto, UriComponentsBuilder builder);
    ResponseEntity<Void> updatePassword(@Valid ClientNewPassword newPassword, @NotNull @NotBlank String clientId);
    ResponseEntity<ClientDetailsDTO> updateClientProfile(@Valid UpdateClientProfileDTO updateProfile, @NotNull @NotBlank String clientId);
}
