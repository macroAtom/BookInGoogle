package com.example.android.ud843_bookingoogle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryUtils {
    public static Book fetchBook(String jsonUrl){

        Double averageRating = null;
        String title = "";
        Double retailPrice = null;
        String publishedDate = "";
        String infolink = "";

        try {
            /**
             * 获取根json对象
             */
            JSONObject rootJson = new JSONObject(jsonUrl);

            /**
             * 获取item JSON数组
             */
            JSONArray itemArray = rootJson.optJSONArray("items");

            /**
             * 获取Item json 对象
             */

            JSONObject itemJson = itemArray.getJSONObject(0);

            /**
             * 获取volumeInfo 对象
             */

            JSONObject volumeInfoJson = itemJson.optJSONObject("volumeInfo");

            averageRating = volumeInfoJson.getDouble("averageRating");

            title = volumeInfoJson.getString("title");

            publishedDate = volumeInfoJson.getString("publishedDate");

            infolink = volumeInfoJson.getString("infoLink");


            /**
             * 获取saleInfo 对象
             */

            JSONObject saleInfoJson = itemJson.optJSONObject("saleInfo");

            /**
             * List price json 对象
             */

            JSONObject listPriceJson = saleInfoJson.getJSONObject("listPrice");

            retailPrice = listPriceJson.getDouble("amount");



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new Book(averageRating, title, retailPrice, publishedDate,infolink);
    }
}
