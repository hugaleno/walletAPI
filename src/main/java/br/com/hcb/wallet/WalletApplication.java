package br.com.hcb.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@SpringBootConfiguration
@EnableJpaRepositories
@EntityScan("br.com.hcb.wallet.entity")
public class WalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class);
    }
}
