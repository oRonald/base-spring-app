package br.com.projeto.crud.base.database.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ClientNewPasswordDTO {

    @NotNull
    @NotBlank
    @Length(max = 15)
    private String newPassword;
}
