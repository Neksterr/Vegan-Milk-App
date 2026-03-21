package project.Vegan_Milk.order.dto;

import project.Vegan_Milk.order.OrderStatus;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            String milkType,
                            String flavor,
                            String size,
                            Integer proteinGrams,
                            String pickupMachineName,
                            BigDecimal totalPrice,
                            Integer estimatedPickupMinutes,
                            OrderStatus status) {
}
