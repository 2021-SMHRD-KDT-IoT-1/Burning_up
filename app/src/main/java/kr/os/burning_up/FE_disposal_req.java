package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FE_disposal_req extends AppCompatActivity {
    Spinner spinner2;
    String[] items = {"부식","파손","사용"};
    EditText edt_fenum, edt_wishday;
    Button btn_cancledis, btn_adddis;

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
                Intent intent = new Intent(getApplicationContext(), FE_disposal.class);
                startActivity(intent);
                finish();
            }
        });

        btn_adddis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FE_disposal.class);
                startActivity(intent);
                finish();
            }
        });

    }
}