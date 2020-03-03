package whu.kitchen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.kitchen.Entity.HowToDo;

public interface HowToDoRepository extends JpaRepository<HowToDo, Integer> {

}
