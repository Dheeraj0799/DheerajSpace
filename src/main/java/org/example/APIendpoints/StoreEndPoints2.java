package org.example.APIendpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.Payloads.Store;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.example.APIendpoints.Routes.*;

public class StoreEndPoints2 {
    static ResourceBundle getUrl()
    {
      ResourceBundle  routes =ResourceBundle.getBundle("routes");
      return routes;
    }
    public static Response postStore(Store payload) throws NullPointerException,IllegalArgumentException
    {
        getUrl().getString("post_url");
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
        return response;
    }
    public static Response getStore(int orderId)
    {
        getUrl().getString("store_get_url");
        Response response = given()
                .queryParam("orderId", orderId)  //when .Path paramentere is unable to read the data change to .queryparametre
                .when()
                .get(store_get_url);
        return response;
    }
    public static Response deleteStore(int orderId)
    {
        getUrl().getString("store_delete_url");
        Response response = given()
                .queryParam("orderId", orderId)
                .when()
                .delete(store_delete_url);
        return response;

    }
    }
