package kr.os.burning_up;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class JoinActivity_M extends AppCompatActivity {
    EditText edt_joinid_m, edt_joinpw_m, edt_bdname_m, edt_address_m, edt_mngname_m, edt_mngnumber_m;
    Button btn_joinok_m, btn_joincancel_m;
    RequestQueue queue;
    String code = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_m);
        edt_joinid_m = findViewById(R.id.edt_joinid_m);
        edt_joinpw_m = findViewById(R.id.edt_joinpw_m);
        edt_bdname_m = findViewById(R.id.edt_bdname_m);
        edt_address_m = findViewById(R.id.edt_address_m);
        edt_mngname_m = findViewById(R.id.edt_mngname_m);
        edt_mngnumber_m = findViewById(R.id.edt_mngnumber_m);
        btn_joinok_m = findViewById(R.id.btn_joinok_m);
        btn_joincancel_m = findViewById(R.id.btn_joincancel_m);

        queue = Volley.newRequestQueue(getApplicationContext());

        btn_joincancel_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity_U.class);
                startActivity(intent);
            }
        });

        btn_joinok_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = edt_joinid_m.getText().toString();
                String pw = edt_joinpw_m.getText().toString();
                String bdname = edt_bdname_m.getText().toString();
                String name = edt_mngname_m.getText().toString();
                String tel = edt_mngnumber_m.getText().toString();
                String adr = edt_address_m.getText().toString();

                String join_url = "http://192.168.229.25:8081/BurningAndroidServer/MngJoinService";

                StringRequest request = new StringRequest(Request.Method.POST, join_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답결과",response);
                        if(response.equals("1")) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity_U.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(JoinActivity_M.this,"회원가입 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        // 조인 값
                        Map<String, String> params = new HashMap<>();
                        params.put("join_id",id);
                        params.put("join_pw",pw);
                        params.put("join_name",name);
                        params.put("join_tel",tel);
                        params.put("join_adr",adr);
                        params.put("join_bdname",bdname);
                        params.put("join_c",code);
                        return params;
                    }
                };

                queue.add(request);
            }
        });

    }
}