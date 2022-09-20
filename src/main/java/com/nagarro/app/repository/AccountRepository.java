package com.nagarro.app.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.app.entity.Accounts;
public interface AccountRepository extends CrudRepository<Accounts ,Long>{
Optional<Accounts> findById(Long accountId);
}
