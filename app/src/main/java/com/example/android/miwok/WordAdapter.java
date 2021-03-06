package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, List<Word> words, int backgroundColor) {
        super(context, 0, words);
        mColorResourceId = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object(Word) located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTranslationTextView = listItemView.findViewById(R.id.miwok_word);
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTranslationTextView = listItemView.findViewById(R.id.english_word);
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        View textContainer = listItemView.findViewById(R.id.texts_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView image = listItemView.findViewById(R.id.image_view);
        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }
        else
            image.setVisibility(View.GONE);

        return listItemView;
    }
}
