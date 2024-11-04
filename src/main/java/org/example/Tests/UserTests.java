package org.example.Tests;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.example.APIendpoints.UserEndPoints;
import org.example.Payloads.User;
import org.testng.Assert;
import org.testng.annotations.Test;
public class UserTests {
    Faker fake;
    User userPayload;
    @Test(priority = 1)
    public  void setupData() {
        fake = new Faker();
        userPayload = new User();
        userPayload.setId(fake.idNumber().hashCode());
        userPayload.setUsername(fake.name().username());
        userPayload.setFirstname(fake.name().firstName());
        userPayload.setLastname(fake.name().lastName());
        userPayload.setEmail(fake.internet().safeEmailAddress());
        userPayload.setPassword(fake.internet().password(5,10));
        userPayload.setPhone(fake.phoneNumber().cellPhone());
    }
    @Test(priority = 2)
    public void testPostUser() throws NullPointerException {
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 3)
    public void testGetUser() {
            Response response =UserEndPoints.readUser(this.userPayload.getUsername());
            response.then().log().all();
            Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 4)
    public void testUpdateUser() throws InterruptedException {
        userPayload.setFirstname(fake.name().firstName());
        userPayload.setLastname(fake.name().lastName());
        userPayload.setEmail(fake.internet().safeEmailAddress());
        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);
        //check wether data is updated or not.
        Thread.sleep(2000);
        Response response1 =UserEndPoints.readUser(this.userPayload.getUsername());
        Assert.assertEquals(response1.getStatusCode(),200);
    }
    @Test(priority = 5)
    public void testDeleteUser() {
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    }
