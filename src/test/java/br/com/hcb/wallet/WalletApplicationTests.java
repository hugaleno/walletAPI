package br.com.hcb.wallet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//@RunWith(SpringRunner.class)
@ActiveProfiles("test")
//@SpringBootTest
//@Configuration
//@EnableJpaRepositories(basePackages = {
//        "br.com.hcb.wallet.repository"
//})
//@EnableTransactionManagement
public class WalletApplicationTests {

}
