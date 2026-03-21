package project.Vegan_Milk.order.dto;

import project.Vegan_Milk.order.MilkFlavor;
import project.Vegan_Milk.order.MilkSize;
import project.Vegan_Milk.order.MilkType;

public record CreateOrderRequest(MilkType milkType,
                                 MilkFlavor milkFlavor,
                                 MilkSize size,
                                 Integer proteinGrams,
                                 Long pickupMachineId,
                                 String promoCode,
                                 String paymentMethod) {
}
