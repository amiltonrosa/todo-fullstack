package br.com.amiltonrosa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amiltonrosa.backend.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
}
