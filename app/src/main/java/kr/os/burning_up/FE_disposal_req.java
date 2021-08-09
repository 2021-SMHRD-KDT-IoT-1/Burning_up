package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FE_disposal_req extends AppCompatActivity implements View.OnClickListener{
    Spinner spinner2;
    String[] items = {"부식","파손","사용"};
    EditText edt_fenum, edt_wishday;
    Button btn_cancledis, btn_adddis;
    TextView tv_num4, tv_fenum4, tv_hopeday, tv_why;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fe_disposal_req);

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);
        spinner2.setPrompt("폐기 사유");
        spinner2.setAdapter(adapter);
        adapter.addAll(items);

        edt_fenum = findViewById(R.id.edt_fenum);
        edt_wishday = findViewById(R.id.edt_wishday);
        btn_adddis = findViewById(R.id.btn_adddis);
        btn_cancledis = findViewById(R.id.btn_cancledis);





        btn_cancledis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_adddis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FE_disposal.class);
                intent.putExtra("번호","4");
                intent.putExtra("고유번호",edt_fenum.getText().toString());
                intent.putExtra("희망날짜",edt_wishday.getText().toString());
                intent.putExtra("사유","사용");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}