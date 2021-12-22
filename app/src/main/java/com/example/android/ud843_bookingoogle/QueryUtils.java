package com.example.android.ud843_bookingoogle;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    public static List<Book> fetchBook(String jsonUrl) {

        final String LOG_TAG = QueryUtils.class.getSimpleName();

        List<Book> bookList = new ArrayList<>();

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


            for(int i=0;i<itemArray.length();i++){

                JSONObject itemJson = itemArray.getJSONObject(i);

                /**
                 * 获取volumeInfo 对象
                 */

                JSONObject volumeInfoJson = itemJson.optJSONObject("volumeInfo");

                Log.i(LOG_TAG, "fetchBook: "+volumeInfoJson.optString("averageRating"));


                if(volumeInfoJson.optString("averageRating").equals("")){
                    averageRating = 0.0;
                }else {
                    averageRating = volumeInfoJson.getDouble("averageRating");
                }



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


                if(volumeInfoJson.optString("listPrice").equals("")){
                    retailPrice =  0.0;
                }else {
                    JSONObject listPriceJson = saleInfoJson.optJSONObject("listPrice");
                    retailPrice = listPriceJson.getDouble("amount");
                }

                Book book = new Book(averageRating, title, retailPrice, publishedDate, infolink);

                bookList.add(book);

                Log.i(LOG_TAG, "fetchBook: "+bookList);

            }




        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    /**
     * 获取URL对象
     */
    private static URL createUrl(String jsonUrl) {

        URL url = null;
        try {
            url = new URL(jsonUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 通过webapi 请求网络数据
     */

    private static String makeHttpRequest(URL url) {
        String bookJson = "";
        if (url == null) {
            return bookJson;
        }

        try {

            /**
             * 设置http连接对象
             */
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            /**
             * 设置读超时时间
             */
            urlConnection.setReadTimeout(10000);

            /**
             * 设置连接超时时间
             */
            urlConnection.setConnectTimeout(15000);

            /**
             * 连接服务器
             */
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200){
                /**
                 * 获取字节流对象
                 */
                InputStream inputStream = urlConnection.getInputStream();

                bookJson = readFromServer(inputStream);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookJson;
    }

    /**
     * 从远程服务器读取数据并返回String
     * @param inputStream
     * @return Json 类型的字符串
     * @throws IOException
     */
    private static String readFromServer(InputStream inputStream) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("utf-8"));

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = bufferedReader.readLine();

        StringBuilder output = new StringBuilder();

        while (line !=null){
            output = output.append(line);
            line = bufferedReader.readLine();
        }

        return output.toString();
    }


    /**
     *
     */

    public static List<Book> extractBookJson(String jsonUrl){
        List<Book> book = null;

        URL url = createUrl(jsonUrl);

        String bookJson = makeHttpRequest(url);

        book = fetchBook(bookJson);

        return book;

    }
}
