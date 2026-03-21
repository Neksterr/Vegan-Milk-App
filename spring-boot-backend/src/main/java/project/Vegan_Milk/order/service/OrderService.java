package project.Vegan_Milk.order.service;

import project.Vegan_Milk.order.dto.CreateOrderRequest;
import project.Vegan_Milk.order.dto.OrderOptionResponse;
import project.Vegan_Milk.order.dto.OrderResponse;

public interface OrderService {
    OrderOptionResponse getOptions();
    OrderResponse createOrder(CreateOrderRequest request);
    OrderResponse getOrderById(Long orderId);
}
