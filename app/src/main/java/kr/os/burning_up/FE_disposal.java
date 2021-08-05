package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FE_disposal extends AppCompatActivity {
    Button btn_disposal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fe_disposal);

        btn_disposal = findViewById(R.id.btn_disposal);

        btn_disposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FE_disposal_req.class);
                startActivity(intent);
            }
        });
    }
}