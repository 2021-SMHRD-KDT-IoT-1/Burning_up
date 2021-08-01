package kr.os.burning_up;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;


public class Mainfrag1 extends Fragment {
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag1, container, false);
        String[] items = {"1층","2층","3층"};

        spinner = (Spinner) view.findViewById(R.id.spinner);




        return view;
    }
}