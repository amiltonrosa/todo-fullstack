package br.com.amiltonrosa.backend.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amiltonrosa.backend.domain.Todo;
import br.com.amiltonrosa.backend.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instaciaBaseDeDados() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
				LocalDateTime.parse("25/03/2022 10:40", formatter), false);
		Todo t2 = new Todo(null, "Exercícios", "Praticar exercícios fisicos",
				LocalDateTime.parse("20/01/2022 09:00", formatter), false);
		Todo t3 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal",
				LocalDateTime.parse("07/01/2022 15:00", formatter), false);
		Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã",
				LocalDateTime.parse("20/11/2021 09:00", formatter), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}
