package kr.os.burning_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity_M extends AppCompatActivity {

    BottomNavigationView nav1;
    Mainfrag1 frag1;
    Mainfrag2 frag2;
    Mainfrag3 frag3;
    Mainfrag4 frag4;
    Mainfrag5 frag5;
    Mainfrag6 frag6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_m);

        nav1 = findViewById(R.id.nav1);

        frag1 = new Mainfrag1();
        frag2 = new Mainfrag2();
        frag3 = new Mainfrag3();
        frag4 = new Mainfrag4();


        getSupportFragmentManager().beginTransaction().replace(R.id.Frame, frag1).commit();

        nav1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.home_m){
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, frag1).commit();
                }else if(itemId == R.id.fe_m){
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, frag2).commit();
                }else if(itemId == R.id.bd_m){
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, frag3).commit();
                }else if(itemId == R.id.info_m){
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, frag4).commit();
                }else{

                }
                return true;
            }
        });

    }
}