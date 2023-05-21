package patterns.practicies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patterns.practicies.model.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {
}
