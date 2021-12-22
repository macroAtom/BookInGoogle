package com.example.android.ud843_bookingoogle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(@NonNull Context context, @NonNull List<Book> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View contentListView = convertView;

        if(contentListView == null){
            contentListView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }


        Book book = getItem(position);

        /**
         * rating 视图
         */
        TextView averageRatingText = contentListView.findViewById(R.id.average_rating_text_view);
        averageRatingText.setText(book.getAverageRating().toString());

        TextView titleTextView = contentListView.findViewById(R.id.tile_text_view);
        titleTextView.setText(book.getTitle());

        TextView retailPriceTextView = contentListView.findViewById(R.id.retail_price_text_view);
        retailPriceTextView.setText(book.getRetailPrice().toString());

        TextView publishedDateTextView = contentListView.findViewById(R.id.published_date_text_view);
        publishedDateTextView.setText(book.getPublishedDate());

        return contentListView;
    }
}
