package io.github.artur_sres.arquiteturaspring.montadora;

import io.github.artur_sres.arquiteturaspring.todos.TodoEntity;
import io.github.artur_sres.arquiteturaspring.todos.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {
    TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void validar(TodoEntity todo) throws Exception{
        if(existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO com essa descrição");
        }
    }

    private boolean existeTodoComDescricao(String descricao){
        return todoRepository.existsByDescricao(descricao);
    }
}
