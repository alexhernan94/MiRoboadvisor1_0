package com.example.miroboadvisor1_0.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miroboadvisor1_0.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarterasFragment extends Fragment {

    public CarterasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carteras, container, false);
    }
}
