package com.nagarro.app.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.app.entity.Statement;
import com.nagarro.app.service.StatementServiceImpl;

/*@RunWith(SpringRunner.class)
@DataJpaTest*/
@TestInstance(Lifecycle.PER_CLASS)
class StatementRepositoryTest {

	@Autowired
	StatementServiceImpl statementServiceImpl;

	@Mock
	ViewstatementRepository viewstatementRepository;

	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		viewstatementRepository = Mockito.mock(ViewstatementRepository.class);
	}

	@Test
	void shouldSearchById() {

		Statement statement = new Statement(4L, 3L, "03.02.2020", "330.455004587924");

		List<Statement> s = viewstatementRepository.findByAccountId(3L);
		// Assert.assertNotNull(s);
	}
}