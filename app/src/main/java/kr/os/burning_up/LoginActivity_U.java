package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class LoginActivity_U extends AppCompatActivity {
    EditText edt_id_u,edt_pw_u;
    Button btn_login_u, btn_join_u,btn_join_m;
    RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_u);

        edt_id_u = findViewById(R.id.edt_id_u);
        edt_pw_u = findViewById(R.id.edt_pw_u);
        btn_join_u = findViewById(R.id.btn_join_u);
        btn_login_u = findViewById(R.id.btn_login_u);
        btn_join_m = findViewById(R.id.btn_join_m);

        queue = Volley.newRequestQueue(getApplicationContext());

        // 사용자 회원가입 페이지로 이동
        btn_join_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity_U.class);
                startActivity(intent);
            }
        });
        // 관리자 회원가입 페이지로 이동
        btn_join_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity_M.class);
                startActivity(intent);
            }
        });

        // 사용자 로그인 - 이클립스 연동으로 DB연결 필요
        btn_login_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_url = "http://192.168.102.25:8081/BurningAndroidServer/LoginService";

                StringRequest request = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("1")){
                            Intent intent = new Intent(getApplicationContext(), MainActivity_M.class);
                            startActivity(intent);
                        }else if(response.equals("2")){
                            Intent intent = new Intent(getApplicationContext(), MainActivity_U.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LoginActivity_U.this, "아이디와 비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show();
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
                        params.put("login_id",edt_id_u.getText().toString());
                        params.put("login_pw",edt_pw_u.getText().toString());
                        return params;
                    }
                };

                queue.add(request);
            }
        });
    }
}