package io.github.artur_sres.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        try {
            return todoService.salvar(todo);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarStatus(@PathVariable("id") Integer id,
                                @RequestBody TodoEntity todo) {
        todo.setId(id);
        todoService.atualizarStatus(todo);
    }

    @GetMapping
    public TodoEntity buscarPorId(@PathVariable("id)") Integer id){
        return todoService.buscarPorId(id);
    }
}
