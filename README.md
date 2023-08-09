# todoApplication

This is todo application using spring security and swagger ui

for test this application using swagger
first goto "http://localhost:9090/swagger-ui/index.html#/"
and find "/auth/login" and put username and password.
After that you can access all the APIs

Following re the apis
1) for add user -"/auth/add" 2) for find out current usser who logged in-"/auth/get"

3)to add todo list with respective user-"/todo/create
4)to update todolist-"/toto/edit/{id}
5)to get todo with id-"/toto/{id}
6)to find out todo list with respective user-"/todo/todoList/{userId}
7)to find out all items of respective todo-"/todo/itemList/{id}
8) to delete todo-"/todo/delete/{id}

9)to add item-"/item/add'
10)to update item-"/item/update/{id}
11)to get item by id-"/item/get/{id}
12)to delete item by id-"/item/delete/{id}
