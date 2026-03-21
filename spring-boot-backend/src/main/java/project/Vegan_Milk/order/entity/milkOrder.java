package project.Vegan_Milk.order.entity;

import jakarta.persistence.*;
import project.Vegan_Milk.account.model.entity.BaseEntity;
import project.Vegan_Milk.machine.Machine;
import project.Vegan_Milk.order.MilkFlavor;
import project.Vegan_Milk.order.MilkSize;
import project.Vegan_Milk.order.MilkType;
import project.Vegan_Milk.order.OrderStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "milk_orders")
public class milkOrder extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MilkType milkType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MilkFlavor flavor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MilkSize size;

    @Column(nullable = false)
    private Integer proteinGrams;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine pickupMachine;

    private String promoCode;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal drinkPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal proteinPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal promoDiscount;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal serviceFee;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    private String paymentMethod;

    @Column(nullable = false)
    private Integer estimatedPickupMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    public milkOrder() {
    }

    public MilkType getMilkType() {
        return milkType;
    }

    public void setMilkType(MilkType milkType) {
        this.milkType = milkType;
    }

    public MilkFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(MilkFlavor flavor) {
        this.flavor = flavor;
    }

    public MilkSize getSize() {
        return size;
    }

    public void setSize(MilkSize size) {
        this.size = size;
    }

    public Integer getProteinGrams() {
        return proteinGrams;
    }

    public void setProteinGrams(Integer proteinGrams) {
        this.proteinGrams = proteinGrams;
    }

    public Machine getPickupMachine() {
        return pickupMachine;
    }

    public void setPickupMachine(Machine pickupMachine) {
        this.pickupMachine = pickupMachine;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public BigDecimal getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(BigDecimal drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public BigDecimal getProteinPrice() {
        return proteinPrice;
    }

    public void setProteinPrice(BigDecimal proteinPrice) {
        this.proteinPrice = proteinPrice;
    }

    public BigDecimal getPromoDiscount() {
        return promoDiscount;
    }

    public void setPromoDiscount(BigDecimal promoDiscount) {
        this.promoDiscount = promoDiscount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getEstimatedPickupMinutes() {
        return estimatedPickupMinutes;
    }

    public void setEstimatedPickupMinutes(Integer estimatedPickupMinutes) {
        this.estimatedPickupMinutes = estimatedPickupMinutes;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
