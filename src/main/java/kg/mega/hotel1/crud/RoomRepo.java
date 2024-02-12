package kg.mega.hotel1.crud;

import kg.mega.hotel1.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
}
