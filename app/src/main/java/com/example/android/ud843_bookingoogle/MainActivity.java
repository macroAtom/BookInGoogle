package com.example.android.ud843_bookingoogle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {


//    private final String SAMPLE_JSON_DATA = "{\n" +
//            "  \"kind\": \"books#volumes\",\n" +
//            "  \"totalItems\": 1273,\n" +
//            "  \"items\": [\n" +
//            "    {\n" +
//            "      \"kind\": \"books#volume\",\n" +
//            "      \"id\": \"uwJQDwAAQBAJ\",\n" +
//            "      \"etag\": \"unoTcwdnRxc\",\n" +
//            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/uwJQDwAAQBAJ\",\n" +
//            "      \"volumeInfo\": {\n" +
//            "        \"title\": \"The Richest Man in Babylon\",\n" +
//            "        \"subtitle\": \"The most inspiring book on wealth ever written\",\n" +
//            "        \"authors\": [\n" +
//            "          \"George S. Clason\",\n" +
//            "          \"General Press\"\n" +
//            "        ],\n" +
//            "        \"publisher\": \"GENERAL PRESS\",\n" +
//            "        \"publishedDate\": \"2018-03-08\",\n" +
//            "        \"description\": \"The Richest Man in Babylon is considered as the greatest of all inspirational works on the subject of thrift, financial planning, and personal wealth. Revealed inside are the secrets to acquiring money, keeping money, and making money earn more money. Providing financial wisdom through parables, 'The Richest Man in Babylon' was originally a set of pamphlets, written by the author and distributed by banks and insurance companies. These pamphlets were later bundled together, giving birth to a book. In this new rendering by Charles Conrad, the classic tale is retold in clear, simple language for today's readers. These fascinating and informative stories set you on a sure path to prosperity and its accompanying joys.\",\n" +
//            "        \"industryIdentifiers\": [\n" +
//            "          {\n" +
//            "            \"type\": \"ISBN_13\",\n" +
//            "            \"identifier\": \"9789387669383\"\n" +
//            "          },\n" +
//            "          {\n" +
//            "            \"type\": \"ISBN_10\",\n" +
//            "            \"identifier\": \"9387669386\"\n" +
//            "          }\n" +
//            "        ],\n" +
//            "        \"readingModes\": {\n" +
//            "          \"text\": true,\n" +
//            "          \"image\": true\n" +
//            "        },\n" +
//            "        \"pageCount\": 192,\n" +
//            "        \"printType\": \"BOOK\",\n" +
//            "        \"categories\": [\n" +
//            "          \"Business & Economics\"\n" +
//            "        ],\n" +
//            "        \"averageRating\": 4.5,\n" +
//            "        \"ratingsCount\": 3,\n" +
//            "        \"maturityRating\": \"NOT_MATURE\",\n" +
//            "        \"allowAnonLogging\": true,\n" +
//            "        \"contentVersion\": \"1.11.12.0.preview.3\",\n" +
//            "        \"panelizationSummary\": {\n" +
//            "          \"containsEpubBubbles\": false,\n" +
//            "          \"containsImageBubbles\": false\n" +
//            "        },\n" +
//            "        \"imageLinks\": {\n" +
//            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=uwJQDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
//            "          \"thumbnail\": \"http://books.google.com/books/content?id=uwJQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
//            "        },\n" +
//            "        \"language\": \"en\",\n" +
//            "        \"previewLink\": \"http://books.google.nl/books?id=uwJQDwAAQBAJ&printsec=frontcover&dq=The+most+inspiring+book+on+wealth+ever+written&hl=&cd=1&source=gbs_api\",\n" +
//            "        \"infoLink\": \"https://play.google.com/store/books/details?id=uwJQDwAAQBAJ&source=gbs_api\",\n" +
//            "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=uwJQDwAAQBAJ\"\n" +
//            "      },\n" +
//            "      \"saleInfo\": {\n" +
//            "        \"country\": \"NL\",\n" +
//            "        \"saleability\": \"FOR_SALE\",\n" +
//            "        \"isEbook\": true,\n" +
//            "        \"listPrice\": {\n" +
//            "          \"amount\": 2.89,\n" +
//            "          \"currencyCode\": \"EUR\"\n" +
//            "        },\n" +
//            "        \"retailPrice\": {\n" +
//            "          \"amount\": 2.89,\n" +
//            "          \"currencyCode\": \"EUR\"\n" +
//            "        },\n" +
//            "        \"buyLink\": \"https://play.google.com/store/books/details?id=uwJQDwAAQBAJ&rdid=book-uwJQDwAAQBAJ&rdot=1&source=gbs_api\",\n" +
//            "        \"offers\": [\n" +
//            "          {\n" +
//            "            \"finskyOfferType\": 1,\n" +
//            "            \"listPrice\": {\n" +
//            "              \"amountInMicros\": 2890000,\n" +
//            "              \"currencyCode\": \"EUR\"\n" +
//            "            },\n" +
//            "            \"retailPrice\": {\n" +
//            "              \"amountInMicros\": 2890000,\n" +
//            "              \"currencyCode\": \"EUR\"\n" +
//            "            }\n" +
//            "          }\n" +
//            "        ]\n" +
//            "      },\n" +
//            "      \"accessInfo\": {\n" +
//            "        \"country\": \"NL\",\n" +
//            "        \"viewability\": \"PARTIAL\",\n" +
//            "        \"embeddable\": true,\n" +
//            "        \"publicDomain\": false,\n" +
//            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
//            "        \"epub\": {\n" +
//            "          \"isAvailable\": true,\n" +
//            "          \"acsTokenLink\": \"http://books.google.nl/books/download/The_Richest_Man_in_Babylon-sample-epub.acsm?id=uwJQDwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
//            "        },\n" +
//            "        \"pdf\": {\n" +
//            "          \"isAvailable\": true,\n" +
//            "          \"acsTokenLink\": \"http://books.google.nl/books/download/The_Richest_Man_in_Babylon-sample-pdf.acsm?id=uwJQDwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
//            "        },\n" +
//            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=uwJQDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
//            "        \"accessViewStatus\": \"SAMPLE\",\n" +
//            "        \"quoteSharingAllowed\": false\n" +
//            "      },\n" +
//            "      \"searchInfo\": {\n" +
//            "        \"textSnippet\": \"These pamphlets were later bundled together, giving birth to a book. In this new rendering by Charles Conrad, the classic tale is retold in clear, simple language for today&#39;s readers.\"\n" +
//            "      }\n" +
//            "    }\n" +
//            "  ]\n" +
//            "}";


    private final String URL_JSON = "https://www.googleapis.com/books/v1/volumes?q=python&maxResults=5";

    final String LOG_TAG = MainActivity.class.getSimpleName();

    BookAdapter mBookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);



        List<Book> bookArrayList = new ArrayList<Book>();

        ListView listView = findViewById(R.id.id_list);

        mBookAdapter = new BookAdapter(this,bookArrayList);

        listView.setAdapter(mBookAdapter);



//        BookAsyncTask bookAsyncTask = new BookAsyncTask();
//        bookAsyncTask.execute(URL_JSON);


        getSupportLoaderManager().initLoader(0,null, this).forceLoad();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = bookArrayList.get(position);

                Book book1 = mBookAdapter.getItem(position);

                Log.i(LOG_TAG, "onItemClick: ");
                // 获取书的详情介绍
                String url = book.getInfolink();

                /**
                 * 通过intent 向web 浏览器传递信息 并打开事件发生的详情页面
                 */
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });

    }

    @NonNull
    @Override
    public Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        return new BookLoader(this,URL_JSON);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Book>> loader, List<Book> data) {
        Log.i(LOG_TAG, "onPostExecute: "+data);


//        清空之前的数据
        mBookAdapter.clear();

        if(data != null && !data.isEmpty()){
            mBookAdapter.addAll(data);
        }


    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Book>> loader) {
        mBookAdapter.clear();
    }


//    /**
//     * 内部类 bookAsyncTask
//     */
//
//    private class BookAsyncTask extends AsyncTask<String, Void, List<Book>>{
//
//        @Override
//        protected List<Book> doInBackground(String... url) {
//
//            List<Book> book = QueryUtils.extractBookJson(url[0]);
//            return book;
//        }
//
//        @Override
//        protected void onPostExecute(List<Book> bookList) {
//            Log.i(LOG_TAG, "onPostExecute: "+bookList);
//            mBookAdapter.addAll(bookList);
//        }
//
//    }

}