package project.Vegan_Milk.order.dto;

import java.util.List;

public record OrderOptionResponse(List<OptionResponse> milkTypes,
                                  List<OptionResponse> flavors,
                                  List<OptionResponse> sizes) {
}
