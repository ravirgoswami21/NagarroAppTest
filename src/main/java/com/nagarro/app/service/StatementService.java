package com.nagarro.app.service;

import java.text.ParseException;

import com.nagarro.app.entity.ResponseStatus;
import com.nagarro.app.entity.StatementSearchCriteria;
import com.nagarro.app.exception.AccountIdNotFoundException;
import com.nagarro.app.exception.ValidationException;

public interface StatementService {

	public ResponseStatus getStatement(StatementSearchCriteria statementSearchCriteria) throws 
	ParseException,ValidationException,AccountIdNotFoundException;

	public ResponseStatus getStatementByUser(StatementSearchCriteria statementSearchCriteria) throws 
	ParseException,ValidationException,AccountIdNotFoundException;
}
