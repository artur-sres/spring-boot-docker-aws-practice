package io.github.artur_sres.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        return todoService.salvar(todo);
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
