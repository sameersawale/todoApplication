package woroMediaassignementsameersawale.woroMedia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woroMediaassignementsameersawale.woroMedia.Dto.TodoDto;
import woroMediaassignementsameersawale.woroMedia.Entity.Todo;
import woroMediaassignementsameersawale.woroMedia.Entity.TodoItem;
import woroMediaassignementsameersawale.woroMedia.Service.Impl.TodoServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoServiceImpl todoService;

    @PostMapping("/add")
    public ResponseEntity createTodo(@RequestBody TodoDto todoDto){

        Todo todo= todoService.addTodoList(todoDto);

        return new ResponseEntity<>(todo, HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity gtById(@PathVariable Integer id){
        Todo todo= todoService.getById(id);
        return new ResponseEntity<>(todo, HttpStatus.FOUND);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity updateTodo(@PathVariable("id") int id, @RequestBody TodoDto todoDto){
        Todo todo= todoService.updateTodoList(id, todoDto);

        return new ResponseEntity<>(todo, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletedTodo(@PathVariable("id") int id){
        String result= todoService.deleteTodoById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/todoList/{userId}")
    public ResponseEntity todoListByUserId(@PathVariable("userId") int userId) throws Exception {
        List<Todo> todoList= todoService.getTodoListOfUser(userId);
        return new ResponseEntity<>(todoList, HttpStatus.FOUND);
    }

    @GetMapping("/itemList/{id}")
    public ResponseEntity itemListByTodoId(@PathVariable("id") int id){
        List<TodoItem> itemList= todoService.todoItemListById(id);
        return new ResponseEntity<>(itemList, HttpStatus.FOUND);
    }
}
