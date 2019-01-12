package com.safu.safecoin.repositories;


import com.safu.safecoin.models.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}