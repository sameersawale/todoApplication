package woroMediaassignementsameersawale.woroMedia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import woroMediaassignementsameersawale.woroMedia.Dto.TodoItemDto;
import woroMediaassignementsameersawale.woroMedia.Dto.UpdateItemDto;
import woroMediaassignementsameersawale.woroMedia.Entity.TodoItem;
import woroMediaassignementsameersawale.woroMedia.Entity.Todo;
import woroMediaassignementsameersawale.woroMedia.Repository.TodoItemRepository;
import woroMediaassignementsameersawale.woroMedia.Service.TodoItemService;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Autowired
    TodoServiceImpl todoService;

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public TodoItem addTodoItem(TodoItemDto todoItemDto) {
        Todo todoList=todoService.getById(todoItemDto.getTodoId());

        TodoItem todoItem=new TodoItem();

        todoItem.setTitle(todoItemDto.getTitle());
        todoItem.setDescription(todoItemDto.getDescription());
        todoItem.setDueDate(todoItemDto.getDueDate());
        todoItem.setDueDate(todoItemDto.getDueDate());
        todoItem.setTodoList(todoList);

        return todoItemRepository.save(todoItem);
    }

    @Override
    public TodoItem updateItem(int id, UpdateItemDto updateItemDto) {
        TodoItem todoItem=getById(id);

        todoItem.setTitle(updateItemDto.getTitle());
        todoItem.setDescription(updateItemDto.getDescription());
        todoItem.setCompleted(updateItemDto.isCompleted());
        todoItem.setDueDate(updateItemDto.getDueDate());

        todoItemRepository.save(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem getById(int id) {
        return todoItemRepository.findById(id).get();
    }

    @Override
    public String deleteItem(int id) {
         todoItemRepository.deleteById(id);

         return "item deleted successfully...";
    }


}
