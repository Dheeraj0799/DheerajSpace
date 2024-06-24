//package org.example.Tests;
//import com.github.javafaker.Faker;
//import io.restassured.response.Response;
//import org.example.APIendpoints.StoreEndPoints;
//import org.example.APIendpoints.UserEndPoints;
//import org.example.Payloads.Store;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import java.text.SimpleDateFormat;
//public class StoreTests {
//
//    Faker fake;
//    Store storePayload;
//    @Test(priority = 1)
//    public void setupStoreData()
//    {
//
//        fake = new Faker();
//        storePayload = new Store();
//        storePayload.setId(fake.idNumber().hashCode());
//        storePayload.setPetId(fake.idNumber().hashCode());
//        storePayload.setQuantity(String.valueOf(fake.idNumber().hashCode()));
//        storePayload.setShipDate(fake.date().toString());
//        System.out.println(storePayload.getQuantity());
//    }
//    @Test(priority = 2)
//    public void testPostStore() throws NullPointerException,IllegalArgumentException,InterruptedException
//    {
//        Response response = StoreEndPoints.postStore(storePayload);
//        response.then().log().all();
//        Assert.assertEquals(response.getStatusCode(),200);
//    }
//}
