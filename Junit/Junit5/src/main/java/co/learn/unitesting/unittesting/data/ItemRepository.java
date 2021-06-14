package co.learn.unitesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import co.learn.unitesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
