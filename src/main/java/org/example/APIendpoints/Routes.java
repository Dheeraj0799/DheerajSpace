package org.example.APIendpoints;

public class Routes {

    public static  String base_url = "https://petstore.swagger.io/";

        //user module

    public static String post_url = base_url+"v2/user";
    public static String get_url = base_url+"v2/user/{username}";
    public static String update_url = base_url+"v2/user/{username}";
    public static String delete_url = base_url+"v2/user/{username}";


    //store module

    public static String store_post_url = base_url+"#/store/placeOrder";

    public static String store_get_url = base_url+"#/store/order/{orderID}";

    public static String store_delete_url = base_url+"#/store/order/{orderID}";


}
