package kr.os.burning_up;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Mainfrag1 extends Fragment {
    Spinner spinner;
    String[] items = {"1층","2층","3층"};
    Button btn_mypage_m, btn_fecall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag1, container, false);


        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_spinner_item);
        spinner.setPrompt("층 선택");
        spinner.setAdapter(adapter);
        adapter.addAll(items);

        btn_mypage_m = view.findViewById(R.id.btn_mypage_m);


        btn_mypage_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), Mypage_M.class);
                startActivity(intent);
            }
        });


        return view;
    }
}