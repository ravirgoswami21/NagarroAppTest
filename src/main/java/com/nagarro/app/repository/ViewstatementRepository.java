package com.nagarro.app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.app.entity.Statement;
public interface ViewstatementRepository extends CrudRepository<Statement ,Long>{
List<Statement> findByAccountId(Long accountId);
}
