package br.com.hcb.wallet.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class WalletDTO {

    private Long id;
    @NotNull(message = "O nome não pode ser nulo")
    @Length(min = 3, message = "O nome deve conter no mínimo 3 caracteres")
    private String name;
    @NotNull(message = "O nome não pode ser nulo")
    private BigDecimal value;
}
