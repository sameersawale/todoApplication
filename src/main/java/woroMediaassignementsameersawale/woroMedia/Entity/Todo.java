package woroMediaassignementsameersawale.woroMedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo")
@Data
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "todoList", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    List<TodoItem> todoItemList=new ArrayList<>();
}
