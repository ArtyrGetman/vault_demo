package com.vault.demo;

import com.vault.demo.dao.VaultUserEntity;
import com.vault.demo.dao.VaultUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
@Log4j2
public class RestCrudController {

    @Autowired
    private VaultUserRepository vaultUserRepository;

    @GetMapping
    private List<VaultUserEntity> getVaultUserList(){
        log.info("get vault user list");
        return vaultUserRepository.findAll();
    }
}
