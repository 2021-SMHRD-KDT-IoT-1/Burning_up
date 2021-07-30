package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_M extends AppCompatActivity {
    Button btn_FEtag, btn_FEmng, btn_BDmng, btn_FEdisposal, btn_alarm_m, btn_FF_m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_m);
        btn_FEtag = findViewById(R.id.btn_FEtag);
        btn_FEmng = findViewById(R.id.btn_FEmng);
        btn_BDmng = findViewById(R.id.btn_BDmng);
        btn_FEdisposal = findViewById(R.id.btn_FEdisposal);
        btn_alarm_m = findViewById(R.id.btn_alarm_m);
        btn_FF_m = findViewById(R.id.btn_FF_m);

        btn_FEtag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FE_tag_M.class);
                startActivity(intent);
            }
        });
        btn_FEmng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FE_mng_M.class);
                startActivity(intent);
            }
        });
        btn_BDmng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BD_mng_M.class);
                startActivity(intent);
            }
        });
        btn_FEdisposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FE_disposal_M.class);
                startActivity(intent);
            }
        });
        btn_alarm_m .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fire_alarm_M.class);
                startActivity(intent);
            }
        });
        // 소방정보 작성관리
        btn_FF_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FF_infowrite_M.class);

                startActivity(intent);
            }
        });
    }
}