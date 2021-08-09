package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Mypage_M extends AppCompatActivity {
    TextView tv_mng,tv_pw,tv_bdname,tv_adr,tv_tel, tv_test;
    Button btn_logout,btn_update;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_m);

        tv_mng = findViewById(R.id.tv_mng);
        tv_pw = findViewById(R.id.tv_pw);
        tv_bdname = findViewById(R.id.tv_bdname);
        tv_adr = findViewById(R.id.tv_adr);
        tv_tel = findViewById(R.id.tv_tel);
        btn_logout = findViewById(R.id.btn_logout);
        btn_update = findViewById(R.id.btn_update);

        queue = Volley.newRequestQueue(getApplicationContext());

        String login_url = "http://192.168.25.11:8081/BurningAndroidServer/UserSelectService";

        StringRequest request = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 관리자 개인정보 받기
                try {
                    JSONArray array = new JSONArray(response);
                    Log.d("========", String.valueOf(array));

                    for(int i =0; i< 1; i++) {
                        JSONObject jsob = array.getJSONObject(i);

                        tv_bdname.setText((jsob.getString("b_name")));
                        tv_mng.setText((jsob.getString("name")));
                        tv_pw.setText((jsob.getString("pw")));
                        tv_adr.setText((jsob.getString("addr")));
                        tv_tel.setText((jsob.getString("tel")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // 로그인 값 받아오기
                SharedPreferences pref = getSharedPreferences("move",MODE_PRIVATE);
                String result = pref.getString("result","default");

                Map<String, String> params = new HashMap<>();
                params.put("login_id",result);

                return params;
            }
        };

        queue.add(request);



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getSharedPreferences("move", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.remove("result");

                Intent intent = new Intent(getApplicationContext(), LoginActivity_U.class);
                startActivity(intent);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Update_M.class);
                startActivity(intent);
            }
        });
    }
}

