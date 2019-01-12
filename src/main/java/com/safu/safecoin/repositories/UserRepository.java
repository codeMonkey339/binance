package com.safu.safecoin.repositories;


import com.safu.safecoin.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}