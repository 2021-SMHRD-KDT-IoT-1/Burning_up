package kr.os.burning_up;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FE_disposal extends AppCompatActivity implements View.OnClickListener{
    Button btn_disposal, btn_home;
    TextView tv_num4, tv_fenum4, tv_hopeday, tv_why;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fe_disposal);

        btn_disposal = findViewById(R.id.btn_disposal);
        tv_hopeday = findViewById(R.id.tv_hopeday);
        tv_fenum4 = findViewById(R.id.tv_fenum4);
        tv_why = findViewById(R.id.tv_why);
        tv_num4 = findViewById(R.id.tv_num4);
        btn_home = findViewById(R.id.btn_home);

        Intent intent = getIntent();
        String num = intent.getStringExtra("번호");
        String fenum = intent.getStringExtra("고유번호");
        String day = intent.getStringExtra("희망날짜");
        String why = intent.getStringExtra("사유");
        tv_num4.setText(num);
        tv_fenum4.setText(fenum);
        tv_hopeday.setText(day);
        tv_why.setText(why);

        btn_disposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FE_disposal_req.class);
                startActivity(intent);

            }

        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_M.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}