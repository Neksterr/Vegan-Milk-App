package project.Vegan_Milk.machine.service;

import org.springframework.stereotype.Service;
import project.Vegan_Milk.machine.Machine;
import project.Vegan_Milk.machine.dto.MachineMapRequest;
import project.Vegan_Milk.machine.dto.MachineMapResponse;
import project.Vegan_Milk.machine.repository.MachineRepository;

import java.util.List;

@Service
public class MachineService {

    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }
    public List<MachineMapResponse> getMachinesForMap(MachineMapRequest request) {
        boolean onlyActive = request.onlyActive() == null || request.onlyActive();

        List<Machine> machines = onlyActive
                ? machineRepository.findByActiveTrue()
                : machineRepository.findAll();

        return machines.stream()
                .filter(machine -> machine.getLatitude() != null && machine.getLongitude() != null)
                .map(machine -> new MachineMapResponse(
                        machine.getId(),
                        machine.getName(),
                        machine.getAddress(),
                        machine.getLatitude(),
                        machine.getLongitude()
                ))
                .toList();
    }

}
