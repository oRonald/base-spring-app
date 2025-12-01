package br.com.projeto.crud.base.database.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateClientDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Length(max = 15)
    private String password;

    @NotNull
    @NotBlank
    @Length(min = 11, max = 12)
    private String phone;
}
