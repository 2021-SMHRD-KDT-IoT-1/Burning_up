package kr.os.burning_up;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;


public class Mainfrag2 extends Fragment {
    Button btn_add, btn_fecheck, btn_fediposal, btn_check;
    TextView tv_place1, femng_num, femng_place, femng_day;
    String num,place,day;
    RequestQueue queue;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfrag2, container, false);

        btn_add = view.findViewById(R.id.btn_add);
        btn_fecheck = view.findViewById(R.id.btn_fecheck);
        btn_fediposal = view.findViewById(R.id.btn_fediposal);
        btn_check = view.findViewById(R.id.btn_check);
        tv_place1 = view.findViewById(R.id.tv_place1);
        femng_num = view.findViewById(R.id.femng_num);
        femng_place = view.findViewById(R.id.femng_place);
        femng_day = view.findViewById(R.id.femng_day);
        context = container.getContext();

        queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String gyro_url = "http://172.30.1.50:8081/BurningAndroidServer/Gyrosensor2";

                StringRequest request = new StringRequest(Request.Method.POST, gyro_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답결과",response);
                        if(response.equals("0")) {
                            Intent intent = new Intent(view.getContext().getApplicationContext(), FE_check.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(context,"소화약제를 흔들어주세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();
                        params.put("value","0");
                        return params;
                    }
                };

                queue.add(request);

            }
        });



        Bundle args = getArguments();

        if(args != null) {
            num =args.getString("번호");
            place = args.getString("설치장소");
            day = args.getString("점검일자");
            femng_num.setText(num);
            femng_place.setText(place);
            femng_day.setText(day);
        }else{
            femng_num.setText("5");
            femng_place.setText("2층 강의실C");
            femng_day.setText("2021.08.13");
        }

        tv_place1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), Checkfeboard.class);
                startActivity(intent);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), FE_add.class);
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