package project.Vegan_Milk.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Vegan_Milk.order.entity.milkOrder;

@Repository
public interface OrderRepository extends JpaRepository<milkOrder,Long> {
}
