package project.Vegan_Milk.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Vegan_Milk.machine.Machine;

import java.util.List;

@Repository
public interface MachineRepository  extends JpaRepository<Machine,Long> {
    List<Machine> findByActiveTrue();

}
