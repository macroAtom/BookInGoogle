package com.example.android.ud843_bookingoogle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private final String SAMPLE_JSON_DATA = "{\n" +
            "  \"kind\": \"books#volumes\",\n" +
            "  \"totalItems\": 1273,\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"uwJQDwAAQBAJ\",\n" +
            "      \"etag\": \"unoTcwdnRxc\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/uwJQDwAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"The Richest Man in Babylon\",\n" +
            "        \"subtitle\": \"The most inspiring book on wealth ever written\",\n" +
            "        \"authors\": [\n" +
            "          \"George S. Clason\",\n" +
            "          \"General Press\"\n" +
            "        ],\n" +
            "        \"publisher\": \"GENERAL PRESS\",\n" +
            "        \"publishedDate\": \"2018-03-08\",\n" +
            "        \"description\": \"The Richest Man in Babylon is considered as the greatest of all inspirational works on the subject of thrift, financial planning, and personal wealth. Revealed inside are the secrets to acquiring money, keeping money, and making money earn more money. Providing financial wisdom through parables, 'The Richest Man in Babylon' was originally a set of pamphlets, written by the author and distributed by banks and insurance companies. These pamphlets were later bundled together, giving birth to a book. In this new rendering by Charles Conrad, the classic tale is retold in clear, simple language for today's readers. These fascinating and informative stories set you on a sure path to prosperity and its accompanying joys.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9789387669383\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"9387669386\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 192,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Business & Economics\"\n" +
            "        ],\n" +
            "        \"averageRating\": 4.5,\n" +
            "        \"ratingsCount\": 3,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"1.11.12.0.preview.3\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=uwJQDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=uwJQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.nl/books?id=uwJQDwAAQBAJ&printsec=frontcover&dq=The+most+inspiring+book+on+wealth+ever+written&hl=&cd=1&source=gbs_api\",\n" +
            "        \"infoLink\": \"https://play.google.com/store/books/details?id=uwJQDwAAQBAJ&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=uwJQDwAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"NL\",\n" +
            "        \"saleability\": \"FOR_SALE\",\n" +
            "        \"isEbook\": true,\n" +
            "        \"listPrice\": {\n" +
            "          \"amount\": 2.89,\n" +
            "          \"currencyCode\": \"EUR\"\n" +
            "        },\n" +
            "        \"retailPrice\": {\n" +
            "          \"amount\": 2.89,\n" +
            "          \"currencyCode\": \"EUR\"\n" +
            "        },\n" +
            "        \"buyLink\": \"https://play.google.com/store/books/details?id=uwJQDwAAQBAJ&rdid=book-uwJQDwAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "        \"offers\": [\n" +
            "          {\n" +
            "            \"finskyOfferType\": 1,\n" +
            "            \"listPrice\": {\n" +
            "              \"amountInMicros\": 2890000,\n" +
            "              \"currencyCode\": \"EUR\"\n" +
            "            },\n" +
            "            \"retailPrice\": {\n" +
            "              \"amountInMicros\": 2890000,\n" +
            "              \"currencyCode\": \"EUR\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"NL\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.nl/books/download/The_Richest_Man_in_Babylon-sample-epub.acsm?id=uwJQDwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.nl/books/download/The_Richest_Man_in_Babylon-sample-pdf.acsm?id=uwJQDwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=uwJQDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"These pamphlets were later bundled together, giving birth to a book. In this new rendering by Charles Conrad, the classic tale is retold in clear, simple language for today&#39;s readers.\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        ArrayList<Book> bookArrayList = new ArrayList<>();

        Book book = QueryUtils.fetchBook(SAMPLE_JSON_DATA);

        bookArrayList.add(book);

        ListView listView = findViewById(R.id.id_list);

        BookAdapter bookAdapter = new BookAdapter(this,bookArrayList);

        listView.setAdapter(bookAdapter);

    }
}