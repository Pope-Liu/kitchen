package whu.kitchen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.kitchen.Entity.Collections;
import whu.kitchen.Entity.CollectionsPK;

public interface CollectionsRepository extends JpaRepository<Collections, CollectionsPK> {

}
