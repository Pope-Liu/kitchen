package whu.kitchen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.kitchen.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
