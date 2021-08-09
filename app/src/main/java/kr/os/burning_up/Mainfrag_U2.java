package kr.os.burning_up;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Mainfrag_U2 extends Fragment {

    TextView tv_place1_U;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag_u2, container, false);
        tv_place1_U = view.findViewById(R.id.tv_place1_U);

        tv_place1_U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Checkfeboard.class);
                startActivity(intent);
            }
        });

        return view;
    }
}