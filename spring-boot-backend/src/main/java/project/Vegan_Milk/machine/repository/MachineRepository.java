package project.Vegan_Milk.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Vegan_Milk.machine.Machine;

@Repository
public interface MachineRepository  extends JpaRepository<Machine,Long> {
}
