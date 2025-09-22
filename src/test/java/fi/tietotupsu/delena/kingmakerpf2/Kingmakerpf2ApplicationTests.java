package fi.tietotupsu.delena.kingmakerpf2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fi.tietotupsu.delena.kingmakerpf2.repositories.PfCharacterRepository;

@SpringBootTest
@EnableAutoConfiguration(exclude = {
    org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
    org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration.class
})
class Kingmakerpf2ApplicationTests {
	//TODO: Find a way to mock this properly, without deprecation warnings
    @MockBean
    private PfCharacterRepository pfCharacterRepository;

	@Test
	void contextLoads() {
	}

}
