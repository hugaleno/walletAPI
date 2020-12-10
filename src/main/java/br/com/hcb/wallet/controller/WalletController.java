package br.com.hcb.wallet.controller;


import br.com.hcb.wallet.dto.WalletDTO;
import br.com.hcb.wallet.entity.Wallet;
import br.com.hcb.wallet.response.Response;
import br.com.hcb.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping
    public ResponseEntity<Response<WalletDTO>> create(@Valid @RequestBody WalletDTO dto, BindingResult result){

        Response<WalletDTO> response = new Response<WalletDTO>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(objectError -> response.getErrors().add(objectError.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Wallet wallet = walletService.save(convertDtoToEntity(dto));

        response.setData(convertEntityToDto(wallet));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private Wallet convertDtoToEntity(WalletDTO dto){
        Wallet wallet = new Wallet();
        wallet.setId(dto.getId());
        wallet.setName(dto.getName());
        wallet.setValue(dto.getValue());

        return wallet;
    }

    private WalletDTO convertEntityToDto(Wallet wallet){
        WalletDTO dto = new WalletDTO();
        dto.setId(wallet.getId());
        dto.setName(wallet.getName());
        dto.setValue(wallet.getValue());
        return dto;
    }
}
