package kr.os.burning_up;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Mainfrag2 extends Fragment {
    BottomNavigationView nav;
    Fe_disposal disposal;
    Fe_mng mng;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag2, container, false);
        nav = view.findViewById(R.id.Frame1);
        disposal = new Fe_disposal();
        mng = new Fe_mng();




        return view;
    }
}