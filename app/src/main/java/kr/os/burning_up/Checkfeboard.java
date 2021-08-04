package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Checkfeboard extends AppCompatActivity {
    Button btn_fecheckok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfeboard);

        btn_fecheckok = findViewById(R.id.btn_fecheckok);

        btn_fecheckok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_M.class);
                startActivity(intent);
                finish();
            }
        });
    }
}