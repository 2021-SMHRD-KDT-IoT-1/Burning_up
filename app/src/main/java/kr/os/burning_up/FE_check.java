package kr.os.burning_up;

import static java.sql.Types.NULL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class FE_check extends AppCompatActivity {
    Button btn_checkok, btn_nomal, btn_unnomal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fe_check);

        btn_checkok = findViewById(R.id.btn_checkok);
        btn_nomal = findViewById(R.id.btn_normal);
        btn_unnomal =findViewById(R.id.btn_unnomal);






        btn_checkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_M.class);
                startActivity(intent);
                finish();
            }
        });
    }
}