package dev.groupone.repotests;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import dev.groupone.beans.User;
import dev.groupone.repositories.UserRepo;

@RunWith(SpringRunner.class)
class UserRepoTests {
	@Autowired
	private static UserRepo urep;
	
	@Test
	void test() {
		User a = new User("generic@gmail.com", "generic", "genericpass");
		System.out.println(a.toString());
		urep.save(a);

	}

}
