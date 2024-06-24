package org.example.Payloads;

import com.github.javafaker.Faker;

public class Store {

    Faker faker;

    int id;
    int petId;
    String quantity;
    String shipDate;

    String Status = "placed";
    Boolean complete = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId(int i) {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getShipDate(int i) {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = Boolean.valueOf(complete);
    }

}
