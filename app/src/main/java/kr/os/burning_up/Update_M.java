package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Update_M extends AppCompatActivity {
    EditText edt_mngname, edt_mngpw,edt_mngtel;
    Button btn_updateok;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_m);

        edt_mngname = findViewById(R.id.edt_mngname);
        edt_mngpw = findViewById(R.id.edt_mngpw);
        edt_mngtel = findViewById(R.id.edt_mngtel);
        btn_updateok = findViewById(R.id.btn_updateok);

        queue = Volley.newRequestQueue(getApplicationContext());

        btn_updateok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edt_mngname.getText().toString();
                String pw = edt_mngpw.getText().toString();
                String tel = edt_mngtel.getText().toString();

                String join_url = "http://172.30.1.50:8081/BurningAndroidServer/UserUpdateService";

                StringRequest request = new StringRequest(Request.Method.POST, join_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답결과",response);
                        if(response.equals("1")) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity_M.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Update_M.this,"정보수정 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        SharedPreferences pref = getSharedPreferences("move",MODE_PRIVATE);
                        String result = pref.getString("result","default");

                        Map<String, String> params = new HashMap<>();
                        params.put("id",result);
                        params.put("pw",pw);
                        params.put("name",name);
                        params.put("tel",tel);

                        return params;
                    }
                };

                queue.add(request);

            }
        });
    }
}