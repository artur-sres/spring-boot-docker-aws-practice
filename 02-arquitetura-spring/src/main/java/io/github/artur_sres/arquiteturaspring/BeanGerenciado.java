package io.github.artur_sres.arquiteturaspring;

import io.github.artur_sres.arquiteturaspring.montadora.TodoValidator;
import io.github.artur_sres.arquiteturaspring.todos.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {
    @Autowired
    TodoValidator todoValidator;

    @Autowired //Recomendado
    public BeanGerenciado(TodoValidator todoValidator) {
        this.todoValidator = todoValidator;
    }

    public void utilizar() throws Exception {
        var todo = new TodoEntity();
        todoValidator.validar(todo);
    }

    @Autowired
    public void setTodoValidator(TodoValidator todoValidator){
        this.todoValidator = todoValidator;
    }
}
