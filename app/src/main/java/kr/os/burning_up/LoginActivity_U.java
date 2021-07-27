package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity_U extends AppCompatActivity {
    EditText edt_id_u,edt_pw_u;
    Button btn_login_u, btn_join_u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_u);

        edt_id_u = findViewById(R.id.edt_id_u);
        edt_pw_u = findViewById(R.id.edt_pw_u);
        btn_join_u = findViewById(R.id.btn_join_u);
        btn_login_u = findViewById(R.id.btn_login_u);

        btn_join_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity_U.class);
                startActivity(intent);
            }
        });

        btn_login_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}