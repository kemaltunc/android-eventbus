package com.example.kemal.eventbus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Subscribe;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {


    private TextView textView;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        textView = view.findViewById(R.id.textView);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getBus().unregister(this);
    }

    @Subscribe
    public void receiver(String s) {
        textView.setText(s);
    }
}
