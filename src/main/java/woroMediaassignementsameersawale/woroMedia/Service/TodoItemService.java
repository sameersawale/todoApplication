package woroMediaassignementsameersawale.woroMedia.Service;

import woroMediaassignementsameersawale.woroMedia.Dto.TodoItemDto;
import woroMediaassignementsameersawale.woroMedia.Dto.UpdateItemDto;
import woroMediaassignementsameersawale.woroMedia.Entity.TodoItem;

public interface TodoItemService {

    public TodoItem addTodoItem(TodoItemDto todoItemDto);

    public TodoItem updateItem(int id, UpdateItemDto updateItemDto);

    public TodoItem getById(int id);

    public String deleteItem(int id);
}
