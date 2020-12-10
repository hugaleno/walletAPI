package br.com.hcb.wallet.repository;

import br.com.hcb.wallet.WalletApplication;
import br.com.hcb.wallet.entity.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@SpringBootTest(classes = {
        WalletApplication.class
})
@AutoConfigureTestDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    private static final String EMAIL = "email@teste.com";

    @Autowired
    UserRepository repository;

    @Test
    @Order(1)
    public void testSave(){
        User user = new User();
        user.setName("Teste");
        user.setPassword("123456");
        user.setEmail(EMAIL);
        User response = repository.save(user);
        assertNotNull(response);
    }

    @Test
    @Order(2)
    public void testFindById(){
        Optional<User> response = repository.findById(1L);
        assertNotNull(response.get());
        assertEquals(response.get().getId().intValue(), 1);
    }

    @Test
    @Order(2)
    public void testFindByEmail(){
        Optional<User> response = repository.findByEmailEquals(EMAIL);
        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }

    @Test
    @Order(2)
    public void testUpdate(){

        Optional<User> user = repository.findById(1L);
        user.get().setName("testeUpdateUser");
        User response = repository.save(user.get());
        assertNotNull(response);
        assertEquals(response.getName(), "testeUpdateUser");
    }

    @Test
    public void testDelete(){

        repository.deleteById(1L);
        Optional<User> user = repository.findById(1L);
        assertTrue(user.isEmpty());
    }
}
