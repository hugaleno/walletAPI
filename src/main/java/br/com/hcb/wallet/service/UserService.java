package br.com.hcb.wallet.service;

import br.com.hcb.wallet.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User u);
    Optional<User> findByEmail(String email);
}
