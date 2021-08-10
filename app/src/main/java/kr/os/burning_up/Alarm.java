package kr.os.burning_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Alarm extends AppCompatActivity {
    Spinner spinner;
    String[] items = {"1층","2층","3층"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);
        spinner.setPrompt("층 선택");
        spinner.setAdapter(adapter);
        adapter.addAll(items);
    }
}