package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                String login_url = "http://localhost:8081/BurningAndroidServer/JoinService";

                StringRequest request = new StringRequest(DownloadManager.Request.Method.post, login_url, new Response.Listener<String>(){

                });
            }
        });
    }
}