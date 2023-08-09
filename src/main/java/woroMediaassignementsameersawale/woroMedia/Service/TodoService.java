package woroMediaassignementsameersawale.woroMedia.Service;

import woroMediaassignementsameersawale.woroMedia.Dto.TodoDto;
import woroMediaassignementsameersawale.woroMedia.Entity.Todo;
import woroMediaassignementsameersawale.woroMedia.Entity.TodoItem;

import java.util.List;

public interface TodoService {

    public Todo addTodoList(TodoDto todoDto);

    public Todo updateTodoList(int id, TodoDto todoDto);

    public Todo getById(int id);

    public List<TodoItem> todoItemListById(int id);

    public String deleteTodoById(int id);

    public List<Todo> getTodoListOfUser(int userId) throws Exception;
}
