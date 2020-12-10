package br.com.hcb.wallet.repository;

import br.com.hcb.wallet.entity.UserWallet;
import br.com.hcb.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {
}
