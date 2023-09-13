package com.example.blackcoffer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.blackcoffer.adp.fragadp;
import com.example.blackcoffer.fragments.BlankFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tb;
    private ViewPager vp;
    private fragadp adp;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(MainActivity.this,explore.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tb=findViewById(R.id.tbbb);
        vp=findViewById(R.id.vvpag);

        tb.setupWithViewPager(vp);

        List<String> titlst = new ArrayList<>();
        List<Fragment> fraglst = new ArrayList<>();

        fraglst.add(new BlankFragment("Personal"));
        fraglst.add(new BlankFragment("Business"));
        fraglst.add(new BlankFragment("Merchant"));


        titlst.add("Personal");
        titlst.add("Business");
        titlst.add("Merchant");

        adp=new fragadp(getSupportFragmentManager(),fraglst,titlst);
        vp.setAdapter(adp);
        tb.setupWithViewPager(vp);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.men, menu);
        return true;

    }
}