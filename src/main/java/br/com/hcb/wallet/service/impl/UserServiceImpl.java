package br.com.hcb.wallet.service.impl;

import br.com.hcb.wallet.entity.User;
import br.com.hcb.wallet.repository.UserRepository;
import br.com.hcb.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User save(User u) {
        return repository.save(u);
    }

    @Override
    public Optional<User> findByEmail(String email) {
       return repository.findByEmailEquals(email);
    }
}
