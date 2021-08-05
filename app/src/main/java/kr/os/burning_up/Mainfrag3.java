package kr.os.burning_up;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Mainfrag3 extends Fragment {
    Button btn_change, btn_delete;
    TextView tv_floar3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag3, container, false);

        btn_change = view.findViewById(R.id.btn_change);
        btn_delete = view.findViewById(R.id.btn_delete);
        tv_floar3 = view.findViewById(R.id.tv_floar3);

        tv_floar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Floar_3.class);
                startActivity(intent);
            }
        });


        return view;
    }
}