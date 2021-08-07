package kr.os.burning_up;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class JoinActivity_U extends AppCompatActivity {
    EditText edt_joinid_u,edt_joinpw_u,edt_name_u,edt_birth_u,edt_tel_u;
    RadioButton radio_man,radio_woman;
    RadioGroup gender;
    Button btn_joinok_u,btn_joincancel_u;
    RequestQueue queue;
    String gen;
    String code = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_u);

        edt_birth_u = findViewById(R.id.edt_birth_u);
        edt_tel_u = findViewById(R.id.edt_tel_u);
        edt_joinid_u = findViewById(R.id.edt_joinid_u);
        edt_joinpw_u = findViewById(R.id.edt_joinpw_u);
        edt_name_u = findViewById(R.id.edt_name_u);
        btn_joinok_u = findViewById(R.id.btn_joinok_u);
        btn_joincancel_u = findViewById(R.id.btn_joincancel_u);
        radio_man = findViewById(R.id.radio_man);
        radio_woman = findViewById(R.id.radio_woman);
        gender = findViewById(R.id.gender);

        queue = Volley.newRequestQueue(getApplicationContext());


        // 라디오 그룹 설정
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(i == R.id.radio_man){
                    gen = "남";
                }else if(i == R.id.radio_woman){
                    gen = "여";
                }
            }
        });
        //취소버튼
        btn_joincancel_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity_U.class);
                startActivity(intent);
            }
        });
        // 회원가입 버튼
        btn_joinok_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = edt_joinid_u.getText().toString();
                String pw = edt_joinpw_u.getText().toString();
                String name = edt_name_u.getText().toString();
                String tel = edt_tel_u.getText().toString();
                String birth = edt_birth_u.getText().toString();

                String join_url = "http://172.30.1.50:8081/BurningAndroidServer/UserJoinService";

                StringRequest request = new StringRequest(Request.Method.POST, join_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답결과",response);
                        if(response.equals("1")) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity_U.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(JoinActivity_U.this,"회원가입 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        // 로그인 값 받아오기
                        Map<String, String> params = new HashMap<>();
                        params.put("join_id",id);
                        params.put("join_pw",pw);
                        params.put("join_name",name);
                        params.put("join_tel",tel);
                        params.put("join_birth",birth);
                        params.put("join_gen",gen);
                        params.put("join_c",code);
                        return params;
                    }
                };

                queue.add(request);
            }
        });

    }


}