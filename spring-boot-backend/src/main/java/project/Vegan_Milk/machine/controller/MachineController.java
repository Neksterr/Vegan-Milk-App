package project.Vegan_Milk.machine.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Vegan_Milk.machine.dto.MachineMapListResponse;
import project.Vegan_Milk.machine.dto.MachineMapRequest;
import project.Vegan_Milk.machine.dto.MachineMapResponse;
import project.Vegan_Milk.machine.service.MachineService;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
public class MachineController {
    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping("/map")
    public MachineMapListResponse getMachinesForMap(@RequestBody MachineMapRequest request) {
        return new MachineMapListResponse(machineService.getMachinesForMap(request));
    }
}
