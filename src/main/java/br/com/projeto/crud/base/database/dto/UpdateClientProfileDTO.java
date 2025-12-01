package br.com.projeto.crud.base.database.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateClientProfileDTO {

    private String name;

    @Email
    private String email;

    private String phone;

    public void validatePhone(){
        if(this.phone != null && !this.phone.isBlank() && this.phone.length() < 11){
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }
}
