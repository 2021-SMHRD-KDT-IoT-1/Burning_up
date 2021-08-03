package kr.os.burning_up;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Mainfrag2 extends Fragment {
    Button btn_add, btn_fecheck, btn_fediposal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag2, container, false);

        btn_add = view.findViewById(R.id.btn_add);
        btn_fecheck = view.findViewById(R.id.btn_fecheck);
        btn_fediposal = view.findViewById(R.id.btn_fediposal);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), FE_add.class);
                startActivity(intent);
            }
        });
        btn_fecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), FE_check.class);
                startActivity(intent);
            }
        });
        btn_fediposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), FE_disposal.class);
                startActivity(intent);
            }
        });
        return view;
    }
}