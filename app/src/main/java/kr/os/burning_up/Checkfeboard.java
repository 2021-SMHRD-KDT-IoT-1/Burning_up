package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Checkfeboard extends AppCompatActivity {
    Button btn_fecheckok;
    TextView tv_board1,tv_board2,tv_board3,tv_board4,tv_board5,tv_board6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfeboard);
        tv_board1 = findViewById(R.id.tv_board1);
        tv_board2 = findViewById(R.id.tv_board2);
        tv_board3 = findViewById(R.id.tv_board3);
        tv_board4 = findViewById(R.id.tv_board4);
        tv_board5 = findViewById(R.id.tv_board5);
        tv_board6 = findViewById(R.id.tv_board6);
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