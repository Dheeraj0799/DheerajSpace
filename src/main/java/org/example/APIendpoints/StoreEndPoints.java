package org.example.APIendpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.Payloads.Store;

import static io.restassured.RestAssured.given;
public class StoreEndPoints {
    public static Response postStore(Store payload) throws NullPointerException,InterruptedException,IllegalArgumentException
    {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.store_post_url);
        return response;
    }
    public static Response getStore(String orderId)
    {
        Response response = given()
                .pathParam("orderId", orderId)
                .when()
                .get(Routes.store_get_url);
        return response;
    }
    public static Response deleteStore(String orderId)
    {
        Response response = given()
                .pathParam("orderId", orderId)
                .when()
                .delete(Routes.store_delete_url);
        return response;

    }
    }
