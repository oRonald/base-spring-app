package br.com.projeto.crud.base.database.dto;

import br.com.projeto.crud.base.database.Clients;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ClientDetailsDTO {

    private UUID id;
    private String name;
    private String email;
    private String phone;

    public static ClientDetailsDTO create(Clients clients){
        ClientDetailsDTO dto = new ClientDetailsDTO();
        dto.id = clients.getId();
        dto.name = clients.getName();
        dto.email = clients.getEmail();
        dto.phone = clients.getPhone();

        return dto;
    }
}
