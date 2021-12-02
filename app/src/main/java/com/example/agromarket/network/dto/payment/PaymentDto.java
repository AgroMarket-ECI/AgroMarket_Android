package com.example.agromarket.network.dto.payment;

public class PaymentDto {

    private String idOrder;
    private double totalPayment;


    public PaymentDto(String idOrder, double totalPayment) {
        this.idOrder = idOrder;
        this.totalPayment = totalPayment;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
