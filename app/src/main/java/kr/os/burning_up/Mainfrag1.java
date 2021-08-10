package kr.os.burning_up;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Mainfrag1 extends Fragment {


    Button btn_mypage_m, btn_fecall;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag1, container, false);




        btn_mypage_m = view.findViewById(R.id.btn_mypage_m);
        btn_fecall = view.findViewById(R.id.btn_fecall);

        btn_fecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), Alarm.class);
                startActivity(intent);
            }
        });

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