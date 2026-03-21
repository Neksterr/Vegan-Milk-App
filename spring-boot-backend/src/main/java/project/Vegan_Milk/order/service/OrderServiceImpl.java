package project.Vegan_Milk.order.service;

import org.springframework.stereotype.Service;
import project.Vegan_Milk.machine.repository.MachineRepository;
import project.Vegan_Milk.order.MilkFlavor;
import project.Vegan_Milk.order.MilkSize;
import project.Vegan_Milk.order.MilkType;
import project.Vegan_Milk.order.dto.CreateOrderRequest;
import project.Vegan_Milk.order.dto.OptionResponse;
import project.Vegan_Milk.order.dto.OrderOptionResponse;
import project.Vegan_Milk.order.dto.OrderResponse;
import project.Vegan_Milk.order.entity.milkOrder;
import project.Vegan_Milk.order.repository.OrderRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final MachineRepository machineRepository;

    public OrderServiceImpl(OrderRepository orderRepository, MachineRepository machineRepository) {
        this.orderRepository = orderRepository;
        this.machineRepository = machineRepository;
    }


    @Override
    public OrderOptionResponse getOptions() {
        return new OrderOptionResponse(
                mapMilkTypes(),
                mapFlavors(),
                mapSizes()
        );    }

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {
        return null;
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {
        return null;
    }

    private OrderResponse mapToResponse(milkOrder order) {
        return new OrderResponse(
                order.getId(),
                order.getMilkType().getLabel(),
                order.getFlavor().getLabel(),
                order.getSize().getLabel(),
                order.getProteinGrams(),
                order.getPickupMachine().getName(),
                order.getTotalPrice(),
                order.getEstimatedPickupMinutes(),
                order.getStatus()
        );
    }

    private List<OptionResponse> mapMilkTypes() {
        return Arrays.stream(MilkType.values())
                .map(value -> new OptionResponse(value.name(), value.getLabel()))
                .toList();
    }

    private List<OptionResponse> mapFlavors() {
        return Arrays.stream(MilkFlavor.values())
                .map(value -> new OptionResponse(value.name(), value.getLabel()))
                .toList();
    }

    private List<OptionResponse> mapSizes() {
        return Arrays.stream(MilkSize.values())
                .map(value -> new OptionResponse(value.name(), value.getLabel()))
                .toList();
    }
}
