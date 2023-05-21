package patterns.practicies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patterns.practicies.model.Item;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer> {
}
