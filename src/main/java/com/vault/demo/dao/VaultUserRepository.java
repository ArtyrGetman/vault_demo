package com.vault.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaultUserRepository extends JpaRepository<VaultUserEntity, String> {
}
