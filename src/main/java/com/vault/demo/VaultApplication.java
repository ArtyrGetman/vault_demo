package com.vault.demo;

import com.vault.demo.dao.VaultUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.core.env.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
@Log4j2
public class VaultApplication implements CommandLineRunner {

    private final VaultUserRepository vaultUserRepository;
    private final SecurityProperties securityProperties;

    @Value("${app.test-config.password}")
    String password;
    @Value("#{'${app.test-config.roles}'.split(',')}")
    List<String> roles;

    public static void main(String[] args) {
        SpringApplication.run(VaultApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("----------------------------------------");
        log.info("   Configuration properties");
        log.info("        username is {}", securityProperties.getUsername());
        log.info("        password is {}", securityProperties.getPassword());
        log.info("        url is {}", securityProperties.getUrl());
        log.info(securityProperties.getRoles());
        log.info(securityProperties.getUrlPossibleType());
        log.info("----------------------------------------");
        log.info("");
        log.info("----------------------------------------");
        log.info("   Configuration with @Value annotations");
        log.info("         password  {}", password);
        log.info("         roles  {}", roles);
        log.info("----------------------------------------");
        log.info("--------------------------DB BLOCK---------------------------");
        log.info(vaultUserRepository.findAll());
    }
}
