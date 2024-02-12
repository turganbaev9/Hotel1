package kg.mega.hotel1.crud;

import kg.mega.hotel1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository< Order,Long> {
}
