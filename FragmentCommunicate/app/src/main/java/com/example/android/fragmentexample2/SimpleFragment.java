package com.example.android.fragmentexample2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends android.support.v4.app.Fragment {

    private static final int YES = 0;
    private static final int NO = 1;


    public SimpleFragment() {
        // Required empty public constructor
    }

    public static SimpleFragment newInstance(){
        return new SimpleFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        final RatingBar ratingBar = rootView.findViewById(R.id.rating_bar_song);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView = rootView.findViewById(R.id.fragment_header);

                switch(index){
                    case YES: //user chose yes.
                        textView.setText(R.string.yes_message);
                        break;
                    case NO: //user chose no.
                        textView.setText(R.string.no_message);
                        break;
                    default: //no choice made.
                        //do nothing.
                        break;
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(rootView.getContext(), "My Rating:"+v, Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
