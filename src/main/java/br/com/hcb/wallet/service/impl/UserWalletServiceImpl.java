package br.com.hcb.wallet.service.impl;

import br.com.hcb.wallet.entity.UserWallet;
import br.com.hcb.wallet.repository.UserWalletRepository;
import br.com.hcb.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    UserWalletRepository repository;

    @Override
    public UserWallet save(UserWallet u) {
        return repository.save(u);
    }

}
