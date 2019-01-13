package com.safu.safecoin.repositories;

import com.safu.safecoin.models.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Long> {
}