package br.com.hcb.wallet.controller;


import br.com.hcb.wallet.dto.UserWalletDTO;
import br.com.hcb.wallet.dto.WalletDTO;
import br.com.hcb.wallet.entity.User;
import br.com.hcb.wallet.entity.UserWallet;
import br.com.hcb.wallet.entity.Wallet;
import br.com.hcb.wallet.response.Response;
import br.com.hcb.wallet.service.UserWalletService;
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
@RequestMapping(path = "user-wallet")
public class UserWalletController {

    @Autowired
    private UserWalletService walletService;

    @PostMapping
    public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO dto, BindingResult result){

        Response<UserWalletDTO> response = new Response<>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(objectError -> response.getErrors().add(objectError.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        UserWallet userWallet = walletService.save(convertDtoToEntity(dto));

        response.setData(convertEntityToDto(userWallet));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private UserWallet convertDtoToEntity(UserWalletDTO dto){
        UserWallet userWallet = new UserWallet();
        userWallet.setId(dto.getId());
        userWallet.setUser(User.builder().id(dto.getUser()).build());
        userWallet.setWallet(Wallet.builder().id(dto.getWallet()).build());

        return userWallet;
    }

    private UserWalletDTO convertEntityToDto(UserWallet userWallet){
        UserWalletDTO dto = new UserWalletDTO();
        dto.setId(userWallet.getId());
        dto.setUser(userWallet.getUser().getId());
        dto.setWallet(userWallet.getWallet().getId());
        return dto;
    }
}
