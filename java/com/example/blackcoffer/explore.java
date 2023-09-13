package com.example.blackcoffer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class explore extends AppCompatActivity {
    String[] hlst = new String[4];
    ArrayAdapter<String> headp;
    Spinner spi;
    TextView cof,bui,hob,frie,mov,din,dat,matri,distxt ,txtstat;

    EditText count;
    SeekBar seekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        spi= (Spinner) findViewById(R.id.spi);
        txtstat= (TextView) findViewById(R.id.spitxt);
        count= (EditText) findViewById(R.id.edt);
        hlst[0]="Available | Hey Let Us Connect";
        hlst[1]="Away | Stay Discrete And Watch";
        hlst[2]="Busy | Do Not Disturb|Will Catch Up Later";
        hlst[3]="SOS | Emergency! Need Assistance! HELP";
        headp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hlst);
        spi.setAdapter(headp);
        distxt= (TextView) findViewById(R.id.distxt);
        cof= (TextView) findViewById(R.id.cof);
        bui= (TextView) findViewById(R.id.bui);
        hob= (TextView) findViewById(R.id.hobb);
        frie= (TextView) findViewById(R.id.frie);
        mov= (TextView) findViewById(R.id.mov);
        din= (TextView) findViewById(R.id.din);
        dat= (TextView) findViewById(R.id.dat);
        matri= (TextView) findViewById(R.id.matri);
        seekbar= (SeekBar) findViewById(R.id.distsekbr);
        float changeRate = (float) seekbar.getProgress() / 100.0f;
        distxt.setText("Select Hyper Local Distance: "+seekbar.getProgress() + "km");
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Calculate the change rate out of 100
                distxt.setText("Select Hyper Local Distance: "+progress + "km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }
        });

        cof.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
               dfs(cof);
            }
        });
        bui.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dfs(bui);
            }
        });
        hob.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dfs(hob);
            }
        });
        frie.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dfs(frie);
            }
        });
        mov.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dfs(mov);
            }
        });
        din.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dfs(din);
            }
        });
        dat.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dfs(dat);
            }
        });
        matri.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dfs(matri);
            }
        });


        count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int currentLength = charSequence.length();
                int maxLength = 250;

                if (currentLength > maxLength) {
                    String trimmedText = charSequence.subSequence(0, maxLength).toString();
                    txtstat.setText("Add Your Status ("+currentLength+"/250)");
                    count.setSelection(maxLength);
                    count.setText(trimmedText);
//
                }else{
                    txtstat.setText("Add Your Status ("+currentLength+"/250)");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }
    @SuppressLint("ResourceAsColor")
    public void dfs(TextView cof){
        if(cof.getTag().equals("hh")){
            cof.setBackgroundResource(R.drawable.bluefilled);
            cof.setTextColor(R.color.white);
            cof.setTag("bb");
        }else{
            cof.setBackgroundResource(R.drawable.whitefilled);
            cof.setTextColor(R.color.black);
            cof.setTag("hh");
        }
    }

}