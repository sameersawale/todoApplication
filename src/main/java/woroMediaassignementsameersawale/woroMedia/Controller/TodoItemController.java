package woroMediaassignementsameersawale.woroMedia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woroMediaassignementsameersawale.woroMedia.Dto.TodoItemDto;
import woroMediaassignementsameersawale.woroMedia.Dto.UpdateItemDto;
import woroMediaassignementsameersawale.woroMedia.Entity.TodoItem;
import woroMediaassignementsameersawale.woroMedia.Service.Impl.TodoItemServiceImpl;


@RestController
@RequestMapping("/item")
public class TodoItemController {

    @Autowired
    TodoItemServiceImpl todoItemService;

    @PostMapping("/add")
    public ResponseEntity addItem(@RequestBody TodoItemDto todoItemDto){
        TodoItem item= todoItemService.addTodoItem(todoItemDto);

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity getItemById(@PathVariable("id") int id){
        TodoItem item= todoItemService.getById(id);

        return new ResponseEntity<>(item, HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateItem(@PathVariable("id") int id, @RequestBody UpdateItemDto updateItemDto){
        TodoItem todoItem= todoItemService.updateItem(id, updateItemDto);

        return new ResponseEntity<>(todoItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") int id){
        String result = todoItemService.deleteItem(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
