package br.com.hcb.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWalletDTO {

    private Long id;
    @NotNull(message = "Informe o Id o usuário")
    private Long user;

    @NotNull(message = "Informe o Id o carteira")
    private Long wallet;

}
