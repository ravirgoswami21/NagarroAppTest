package com.nagarro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.app.entity.ResponseStatus;
import com.nagarro.app.entity.StatementSearchCriteria;
import com.nagarro.app.exception.AccountIdNotFoundException;
import com.nagarro.app.exception.ValidationException;
import com.nagarro.app.service.StatementService;

@RestController
@RequestMapping("api/rest/accountstatement")
public class AccountStatementController {
	
	@Autowired
	private StatementService statementService;

	@PostMapping(value = "/statementByAccId" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStatus> statementByAccId(@RequestBody StatementSearchCriteria statementSearchCriteria) 
	{
		ResponseStatus accountStatementDetail = new ResponseStatus();
		try {
			 accountStatementDetail = statementService.getStatement(statementSearchCriteria);
		if (accountStatementDetail.getAccountStatementDetailList() != null) {
			return new ResponseEntity<>(accountStatementDetail,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(accountStatementDetail,HttpStatus.NOT_FOUND);
		}
		}
		catch(ValidationException e)
		{
			ResponseStatus r = new ResponseStatus();
			r.setAccountStatementDetailList(null);
			r.setResponseMessage("validation exception : "+e.getLocalizedMessage());
			r.setStatus("Error");
			return new ResponseEntity<>(r,HttpStatus.NOT_ACCEPTABLE);
		}
		catch(AccountIdNotFoundException e)
		{
			ResponseStatus r = new ResponseStatus();
			r.setAccountStatementDetailList(null);
			r.setResponseMessage(e.getLocalizedMessage());
			r.setStatus("Error");
			return new ResponseEntity<>(r,HttpStatus.NOT_ACCEPTABLE);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(accountStatementDetail,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping(value = "/statementByUser" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStatus>  statementByUser(@RequestBody StatementSearchCriteria statementSearchCriteria) 
	{	ResponseStatus accountStatementDetail = new ResponseStatus();
		try {
			 accountStatementDetail = statementService.getStatementByUser(statementSearchCriteria);
			if (accountStatementDetail != null) {
				return new ResponseEntity<>(accountStatementDetail,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(accountStatementDetail,HttpStatus.NOT_FOUND);
			}
			}
			catch(Exception e)
			{
				return new ResponseEntity<>(accountStatementDetail,HttpStatus.NOT_ACCEPTABLE);
			}
	}
}
