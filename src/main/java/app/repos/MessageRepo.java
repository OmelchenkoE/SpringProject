package app.repos;

import app.domain.Message;
import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Integer> {
}
