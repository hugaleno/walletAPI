package br.com.hcb.wallet.service;

import br.com.hcb.wallet.entity.User;
import br.com.hcb.wallet.entity.UserWallet;

import java.util.Optional;

public interface UserWalletService {

    UserWallet save(UserWallet userWallet);
}
