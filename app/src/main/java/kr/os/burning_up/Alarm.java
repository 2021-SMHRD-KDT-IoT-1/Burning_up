package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Alarm extends AppCompatActivity {
    private static final int LEFT_TAG = 567;

    Spinner spinner;
    String[] items = {"1층","2층","3층"};
    Button btn_goalarm, btn_back;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        btn_back = findViewById(R.id.btn_back);
        btn_goalarm = findViewById(R.id.btn_goalarm);

        queue = Volley.newRequestQueue(this);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);
        spinner.setPrompt("층 선택");
        spinner.setAdapter(adapter);
        adapter.addAll(items);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_goalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_goalarm.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_goalarm.setEnabled(true);
                    }
                },1000);
            }
        });

    }
    private void sendRequest(int TAG) {
        StringRequest stringRequest;
        switch (TAG) {
            case LEFT_TAG:
                stringRequest = new StringRequest(Request.Method.GET, "http://172.30.1.28:5000/led/on",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                queue.add(stringRequest);
                break;
            default:
                break;
        }
    }


}