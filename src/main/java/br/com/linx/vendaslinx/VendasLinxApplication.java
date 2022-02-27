package br.com.linx.vendaslinx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VendasLinxApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendasLinxApplication.class, args);
    }

}
