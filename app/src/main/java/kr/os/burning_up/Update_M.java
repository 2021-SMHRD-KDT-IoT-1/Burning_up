package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update_M extends AppCompatActivity {
    EditText edt_mngname, edt_mngpw,edt_mngtel;
    Button btn_updateok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_m);

        edt_mngname = findViewById(R.id.edt_mngname);
        edt_mngpw = findViewById(R.id.edt_mngpw);
        edt_mngtel = findViewById(R.id.edt_mngtel);
        btn_updateok = findViewById(R.id.btn_updateok);

        btn_updateok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}