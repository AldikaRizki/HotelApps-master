package com.kenjin.hotelapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kenjin.hotelapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSalam extends Fragment {

    public FragmentSalam() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_salam, container, false);
    }

}
