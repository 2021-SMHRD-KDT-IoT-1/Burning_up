package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity_M extends AppCompatActivity {
    EditText edt_pw_m,edt_id_m;
    Button btn_login_m, btn_join_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_m);

        edt_id_m = findViewById(R.id.edt_id_m);
        edt_pw_m = findViewById(R.id.edt_pw_m);
        btn_login_m = findViewById(R.id.btn_login_m);
        btn_join_m = findViewById(R.id.btn_join_m);

        btn_join_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity_M.class);
                startActivity(intent);
            }
        });

        btn_login_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}