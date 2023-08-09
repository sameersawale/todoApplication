package woroMediaassignementsameersawale.woroMedia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import woroMediaassignementsameersawale.woroMedia.Dto.TodoDto;
import woroMediaassignementsameersawale.woroMedia.Entity.Todo;
import woroMediaassignementsameersawale.woroMedia.Entity.TodoItem;
import woroMediaassignementsameersawale.woroMedia.Entity.User;
import woroMediaassignementsameersawale.woroMedia.Exception.TodoNotFoundException;
import woroMediaassignementsameersawale.woroMedia.Repository.TodoRepository;
import woroMediaassignementsameersawale.woroMedia.Service.TodoService;

import java.util.Collections;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {


    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserServiceImpl userService;


    @Override
    public Todo addTodoList(TodoDto todoDto) {
        User user=userService.getAuthenticateUser();

        Todo todoList=new Todo();

        todoList.setUser(user);
        todoList.setName(todoDto.getName());

        return todoRepository.save(todoList);
    }

    @Override
    public Todo updateTodoList(int id, TodoDto todoDto) {
        Todo todoList = getById(id);
        todoList.setName(todoDto.getName());

        return todoList;
    }

    @Override
    public Todo getById(int id) {
        User user=userService.getAuthenticateUser();
        Todo todo= todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        if(user.getUsername().equals(todo.getUser().getUsername())){
            return todo;
        }
        else {
            throw new TodoNotFoundException();
        }
    }

    @Override
    public List<TodoItem> todoItemListById(int id) {
        Todo todo=getById(id);
        List<TodoItem> itemList=todo.getTodoItemList();
        return itemList;
    }

    @Override
    public String deleteTodoById(int id) {
        Todo todo=getById(id);
        todo.getTodoItemList().clear();

        todoRepository.save(todo);

        todoRepository.delete(todo);

        return "todo deleted successfully...";

    }

    @Override
    public List<Todo> getTodoListOfUser(int userId) throws Exception {
        User auth=userService.getAuthenticateUser();

        User user=userService.findUserById(userId);

        if(auth.getUsername().equals(user.getUsername())){
            List<Todo> todoList=user.getTodoList();
            return todoList;
        }
        else {
            throw new Exception("please check user id");
        }
    }


}
