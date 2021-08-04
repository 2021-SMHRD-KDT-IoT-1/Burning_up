package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FE_add extends AppCompatActivity {
    TextView tv_fenum, tv_fepro, tv_fedate;
    EditText edt_feplace;
    Button btn_cancleadd,btn_addfe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fe_add);

        tv_fedate = findViewById(R.id.tv_fedate);
        tv_fenum = findViewById(R.id.tv_fenum);
        tv_fepro = findViewById(R.id.tv_fepro);
        edt_feplace = findViewById(R.id.edt_feplace);
        btn_addfe = findViewById(R.id.btn_addfe);
        btn_cancleadd = findViewById(R.id.btn_cancleadd);

        btn_addfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_M.class);
                startActivity(intent);
                finish();
            }
        });

        btn_cancleadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_M.class);
                startActivity(intent);
                finish();
            }
        });

    }
}