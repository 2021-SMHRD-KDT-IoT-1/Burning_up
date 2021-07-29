package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class JoinActivity_U extends AppCompatActivity {
    EditText edt_joinid_u,edt_joinpw_u,edt_name_u,edt_birth_u,edt_tel_u;
    RadioButton radio_man,radio_woman;
    RadioGroup gender;
    Button btn_joinok_u,btn_joincancel_u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_u);

        edt_birth_u = findViewById(R.id.edt_birth_u);
        edt_tel_u = findViewById(R.id.edt_tel_u);
        edt_joinid_u = findViewById(R.id.edt_joinid_u);
        edt_joinpw_u = findViewById(R.id.edt_joinpw_u);
        edt_name_u = findViewById(R.id.edt_name_u);
        radio_man = findViewById(R.id.radio_man);
        radio_woman = findViewById(R.id.radio_woman);
        gender = findViewById(R.id.gender);
        btn_joinok_u = findViewById(R.id.btn_joinok_u);
        btn_joincancel_u = findViewById(R.id.btn_joincancel_u);
    }
}