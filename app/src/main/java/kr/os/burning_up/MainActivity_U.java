package kr.os.burning_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity_U extends AppCompatActivity {

    BottomNavigationView nav2;
    Mainfrag_U1 frag1;
    Mainfrag_U2 frag2;
    Mainfrag4 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_u);

        nav2 = findViewById(R.id.nav2);

        frag1 = new Mainfrag_U1();
        frag2 = new Mainfrag_U2();
        frag3 = new Mainfrag4();

        getSupportFragmentManager().beginTransaction().replace(R.id.Frame2, frag1).commit();

        nav2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.fe_alarm){
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame2, frag1).commit();
                }else if(itemId == R.id.bd_pic){
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame2, frag2).commit();
                }else if(itemId == R.id.info){
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame2, frag3).commit();
                }
                return true;
            }
        });

    }
}