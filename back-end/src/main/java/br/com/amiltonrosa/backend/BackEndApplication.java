package br.com.amiltonrosa.backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.amiltonrosa.backend.domain.Todo;
import br.com.amiltonrosa.backend.repositories.TodoRepository;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
				LocalDateTime.parse("25/03/2022 10:40", formatter), false);
		Todo t2 = new Todo(null, "Exercicios", "Praticar exercícios",
				LocalDateTime.parse("20/01/2022 09:00", formatter), false);

		todoRepository.saveAll(Arrays.asList(t1, t2));
	}

}
