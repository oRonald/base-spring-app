package br.com.projeto.crud.base.database;

import br.com.projeto.crud.base.database.dto.CreateClientDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_clients")

@Getter
@Setter
@NoArgsConstructor
public class Clients implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String password;

    @Column(nullable = false, unique = true)
    private String phone;

    public Clients(CreateClientDTO dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.phone = dto.getPhone();
    }
}
