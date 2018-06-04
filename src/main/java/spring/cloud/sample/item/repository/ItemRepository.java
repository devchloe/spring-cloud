package spring.cloud.sample.item.repository;

import org.springframework.data.repository.CrudRepository;
import spring.cloud.sample.item.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
