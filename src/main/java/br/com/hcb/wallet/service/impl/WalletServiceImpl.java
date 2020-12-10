package br.com.hcb.wallet.service.impl;

import br.com.hcb.wallet.entity.Wallet;
import br.com.hcb.wallet.repository.WalletRepository;
import br.com.hcb.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository repository;

    @Override
    public Wallet save(Wallet wallet) {
        return repository.save(wallet);
    }
}
