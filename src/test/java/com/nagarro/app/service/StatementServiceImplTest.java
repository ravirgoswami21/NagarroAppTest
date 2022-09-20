package com.nagarro.app.service;


import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nagarro.app.repository.AccountRepository;
import com.nagarro.app.repository.ViewstatementRepository;
import com.nagarro.app.utils.Utils;

public class StatementServiceImplTest {

	@InjectMocks
	StatementServiceImpl statementServiceImpl = new StatementServiceImpl();
	
	@Mock
	private ViewstatementRepository  viewstatementRepository ;
	
	@Mock
	private AccountRepository accountRepository ;
	
	@Mock
	Utils utils;
	
	 @BeforeAll
	    public void setUp() {
	    	MockitoAnnotations.initMocks(this);
	    	viewstatementRepository = Mockito.mock(ViewstatementRepository.class);
	    }	 
}
