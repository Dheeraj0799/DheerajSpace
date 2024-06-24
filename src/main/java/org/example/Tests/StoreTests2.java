package org.example.Tests;
import com.beust.ah.A;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.example.APIendpoints.StoreEndPoints;
import org.example.APIendpoints.StoreEndPoints2;
import org.example.Payloads.Store;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTests2 {
    Faker fake;
    Store storePayload;
    @Test(priority = 1)
    public void setupStoreData() {
        fake = new Faker();
        storePayload = new Store();
        storePayload.setId(fake.idNumber().hashCode());
        storePayload.setPetId(fake.idNumber().hashCode());
        storePayload.setQuantity(String.valueOf(fake.idNumber().hashCode()));
        storePayload.setShipDate(fake.date().toString());
        System.out.println(storePayload.getQuantity());
    }
    @Test(priority = 2)
    public void testPostStore() throws NullPointerException,IllegalArgumentException,InterruptedException {
        Response response = StoreEndPoints2.postStore(storePayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 3)
    public void testGetStore() {
        Response response = StoreEndPoints2.getStore(this.storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 4)
    public void testDeleteStore() {
        Response response = StoreEndPoints2.deleteStore(this.storePayload.getId());
        response.then().log().all();
//        Assert.assertEquals(response.getStatusCode(),200);
    }
    }
