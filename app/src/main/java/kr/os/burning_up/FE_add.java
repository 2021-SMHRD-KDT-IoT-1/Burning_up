package kr.os.burning_up;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class FE_add extends AppCompatActivity {
    TextView tv_fenum, tv_fepro, tv_fedate;
    EditText edt_feplace;
    Button btn_cancleadd,btn_addfe, btn_feadd;
    Mainfrag2 frag;

    IntentIntegrator qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fe_add);

        frag = new Mainfrag2();
        tv_fedate = findViewById(R.id.tv_fedate);
        tv_fenum = findViewById(R.id.tv_fenum);
        tv_fepro = findViewById(R.id.tv_fepro);
        edt_feplace = findViewById(R.id.edt_feplace);
        btn_addfe = findViewById(R.id.btn_addfe);
        btn_cancleadd = findViewById(R.id.btn_cancleadd);
        btn_feadd = findViewById(R.id.btn_feadd);

        qr = new IntentIntegrator(this);

        btn_feadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qr.setPrompt("Scanning...");
                qr.setOrientationLocked(false);
                qr.initiateScan();
                Log.v("result scanning", "result scanning");

            }
        });

        ////scan option 아래로 버튼 온클릭
        //                qrScan.setPrompt("Scanning...");
        //                qrScan.setOrientationLocked(false);
        //                qrScan.initiateScan();
        //                Log.v("result scanning", "result scanning");
        ////                Intent intent = new Intent(getApplicationContext(), Cos_DetailActivity.class);
        ////                startActivity(intent);

        btn_addfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle(3);
                bundle.putString("번호","5");
                bundle.putString("설치장소",edt_feplace.getText().toString());
                bundle.putString("점검일자",tv_fepro.getText().toString());
                frag.setArguments(bundle);


                finish();
            }
        });

        btn_cancleadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(FE_add.this, "취소", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(FE_add.this, "스캔완료", Toast.LENGTH_SHORT).show();
                try {
                    JSONObject obj = new JSONObject(result.getContents());

                    tv_fedate.setText(obj.getString("유통기한"));
                    tv_fenum.setText(obj.getString("고유번호"));
                    tv_fepro.setText(obj.getString("제조일자"));

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}