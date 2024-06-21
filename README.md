# Практика "Создание клиент-серверного приложения"
## _**Задание №1 -  Создание контроллера**_ 

<br>
В папке src/main/java/ru/neoflex/practice создаю папку controller. В ней (/controller) создаём файл CalcController.java <br>
Над классом указываем аннотацию @RestController<br>
Создаём 2 public метода с аннотациями @GetMapping("/plus/{a}/{b}") и @GetMapping("/minus/{a}/{b}"), которые принимают 2 аргумента, типа Integer, а возвращают их сумму/разность соответственно. Перед каждым аргументом метода необходимо поставить @PathVariable("<a или b соответственно для каждого аргумента>")
<br>
  
```
package ru.neoflex.practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping("/plus/{a}/{b}")
    public Integer Sum (@PathVariable("a") Integer a, @PathVariable("b") Integer b){
        return a+b;
    }
    @GetMapping("/minus/{a}/{b}")
    public Integer Min(@PathVariable("a") Integer a, @PathVariable("b") Integer b){
        return a-b;
    }
}
```
<br>
Запускаем сервис, по зеленой кнопке сверху справа в окне Intellij IDEA <br>
Тестируем своё приложение по адресу http://localhost:8080/<адрес_и_параметры_для_2х_созданных_АПИ> <br>
Сложение<br>
  ![work+](https://github.com/KseniyaVinevskaya/CalculatorJava/blob/main/images/image1.png)<br>
Вычитание<br>
  ![work-](https://github.com/KseniyaVinevskaya/CalculatorJava/blob/main/images/image2.png)<br>

  ## _**Задание №2 - Подключение Swagger 3.0.0**_
  
  <br>
Добавляем в pom.xml необходимую зависимость<br>

```
<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>3.0.0</version>
		</dependency>
```
Тестируем своё приложение по адресу http://localhost:8080/swagger-ui/index.html
Результат ссылки <br>
![Right](https://github.com/KseniyaVinevskaya/CalculatorJava/blob/main/images/image3.png)<br>
Сложение в swagger<br>
![Swork+](https://github.com/KseniyaVinevskaya/CalculatorJava/blob/main/images/image4.png)<br>
Вычитание в swagger<br>
![Swork-](https://github.com/KseniyaVinevskaya/CalculatorJava/blob/main/images/image5.png)<br>


## _**Задание №3 - Создание тестов на проект**_

<br>
Измененный код pom.xml<br>

```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>javax.persistence</groupId>
			<artifactId>javax.persistence-api</artifactId>
			<version>2.2</version>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- Swagger Dependency-->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.0.2</version>
		</dependency>
		<!-- TestNG Dependency-->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>RELEASE</version>
			<scope>test</scope>
		</dependency>
		<!-- Mockito Core Dependency -->
		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

<br>
Код тестов
<br>

```
package ru.neoflex.practice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PracticeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void sum() throws Exception {
		this.mockMvc.perform(get("/calc/plus/3/2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("5"));
	}

	@Test
	public void min() throws Exception {
		this.mockMvc.perform(get("/calc/minus/5/3"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("2"));
	}
}
```

Результаты тестов<br>
![Test](https://github.com/KseniyaVinevskaya/CalculatorJava/blob/main/images/image6.png)<br>


## _**Задание №4 - Подключение in-memory БД**_
<br>
Добавляем в pom.xml необходимые зависимости <br>

```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
```

<br>
Добавляем в файл application.properties строки 
<br>

```
spring.application.name=practice

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=vinevskaya
spring.datasource.password=123456321
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
```

<br>
Создаём файлы базы данных (DatabaseRes) и репозитория (RepositoryRes)
