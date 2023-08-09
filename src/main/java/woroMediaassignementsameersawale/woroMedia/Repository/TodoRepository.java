package woroMediaassignementsameersawale.woroMedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import woroMediaassignementsameersawale.woroMedia.Entity.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
