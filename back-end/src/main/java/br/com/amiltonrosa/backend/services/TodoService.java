package br.com.amiltonrosa.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amiltonrosa.backend.domain.Todo;
import br.com.amiltonrosa.backend.repositories.TodoRepository;
import br.com.amiltonrosa.backend.services.exception.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public Todo findById(Integer id) {
		Optional<Todo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Todo.class.getName()));
	}

	public List<Todo> findByOpen() {
		List<Todo> list = repository.findByOpen();
		return list;
	}

	public List<Todo> findByClose() {
		List<Todo> list = repository.findByClose();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;
	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		
		return repository.save(newObj);
	}
}
