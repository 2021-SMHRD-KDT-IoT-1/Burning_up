package kr.os.burning_up;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;


public class Mainfrag_U1 extends Fragment {

    Spinner spinner3, spinner4;
    Button btn_findfe;
    String[] item1 = {"1층","2층","3층"};
    String[] item2 = {"스마트인재개발원","스마트인재캠퍼스"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag_u1, container, false);
        btn_findfe = view.findViewById(R.id.btn_findfe);
        spinner3 = (Spinner)view.findViewById(R.id.spinner3);
        spinner4 = (Spinner)view.findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item);
        spinner3.setPrompt("층 선택");
        spinner3.setAdapter(adapter1);
        adapter1.addAll(item1);
        spinner3.setPrompt("건물 선택");
        spinner4.setAdapter(adapter2);
        adapter2.addAll(item2);

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