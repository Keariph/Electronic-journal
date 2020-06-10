package ru.aryhlinskaya.Diplom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;
import ru.aryhlinskaya.Diplom.config.BeanConfig;
import ru.aryhlinskaya.Diplom.config.DBConfig;

@SpringBootTest
class DiplomApplicationTests {

	@Test
	void contextLoads() {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		DBConfig config = (DBConfig) context.getBean("connect");
		Student student = new Student(1,"", "", "" , "", 1, "", "");
		student.create();
		Assert.notNull(student.dbConfig);
	}

}
