package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mypage_M extends AppCompatActivity {
    TextView tv_mng,tv_pw,tv_bdname,tv_adr,tv_tel;
    Button btn_logout,btn_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_m);
        tv_mng = findViewById(R.id.tv_mng);
        tv_pw = findViewById(R.id.tv_pw);
        tv_bdname = findViewById(R.id.tv_bdname);
        tv_adr = findViewById(R.id.tv_adr);
        tv_tel = findViewById(R.id.tv_tel);
        btn_logout = findViewById(R.id.btn_logout);
        btn_update = findViewById(R.id.btn_update);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity_U.class);
                startActivity(intent);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}