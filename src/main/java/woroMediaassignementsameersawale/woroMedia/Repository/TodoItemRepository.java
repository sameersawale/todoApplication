package woroMediaassignementsameersawale.woroMedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import woroMediaassignementsameersawale.woroMedia.Entity.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {
}
