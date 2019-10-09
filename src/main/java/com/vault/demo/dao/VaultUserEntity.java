package com.vault.demo.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "vault_user")
public class VaultUserEntity {
    @Id
    @Column
    private String name;
    @Column
    private String email;
}
