package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button btn_mng, btn_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn_mng = findViewById(R.id.btn_mng);
        btn_user = findViewById(R.id.btn_user);

        // 유저용 로그인 페이지 이동
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity_U.class);
                startActivity(intent);

            }
        });
        // 관리자용 로그인 페이지 이동
        btn_mng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity_M.class);
                startActivity(intent);
            }
        });

    }
}