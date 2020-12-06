package br.com.hcb.wallet.repository;

import br.com.hcb.wallet.WalletApplication;
import br.com.hcb.wallet.WalletApplicationTests;
import br.com.hcb.wallet.entity.User;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        WalletApplication.class
})
//@MockBean(value = UserRepository.class)
//@DataJpaTest
@AutoConfigureTestDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    @Order(1)
    public void testSave(){
        User user = new User();
        user.setName("Teste");
        user.setPassword("123456");
        user.setEmail("teste@teste.com");
        User response = repository.save(user);
        assertNotNull(response);
        System.out.println(response);
        assertEquals(response.getId().intValue(), 1);
    }

    @Test
    @Order(2)
    public void testFindById(){
        Optional<User> response = repository.findById(1l);
        assertNotNull(response.get());
        System.out.println(response);
        assertEquals(response.get().getId().intValue(), 1);
    }

    @Test
    @Order(2)
    public void testUpdate(){

        Optional<User> user = repository.findById(1l);
        System.out.println(user);
        user.get().setName("testeUpdateUser");
        User response = repository.save(user.get());
        assertNotNull(response);
        System.out.println(response);
        assertEquals(response.getName(), "testeUpdateUser");
    }

    @Test
    public void testDelete(){

        repository.deleteById(1l);
        Optional<User> user = repository.findById(1l);
        assertTrue(user.isEmpty());
    }
}
