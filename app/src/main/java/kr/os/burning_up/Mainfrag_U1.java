package kr.os.burning_up;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class Mainfrag_U1 extends Fragment {

    Button btn_findfe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag_u1, container, false);
        btn_findfe = view.findViewById(R.id.btn_findfe);

        btn_findfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), User_floar3.class);
                startActivity(intent);
            }
        });

        return view;
    }
}