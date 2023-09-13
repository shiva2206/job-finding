package com.example.blackcoffer.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Contacts;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blackcoffer.R;
import com.example.blackcoffer.adp.Recy_adap;
import com.example.blackcoffer.adp.people;
import com.example.blackcoffer.explore;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    String what;
    EditText ser;
    RecyclerView recy ;
    TextView exp;
    Recy_adap adp ;
    List<people> peopleList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public BlankFragment(String strr){
        what=strr;
    }
    public BlankFragment(){}
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recy=view.findViewById(R.id.rec);
        exp=view.findViewById(R.id.exp);
        ser=view.findViewById(R.id.ser);
        peopleList = new ArrayList<>();

        List<people> dumlst = new ArrayList<>();
        people p1 = new people("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.alamy.com%2Fstock-photo%2Fletter-a-3d.html&psig=AOvVaw1LVVvZFAED6fv_7H-nGpLK&ust=1691329407363000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNie55bTxYADFQAAAAAdAAAAABAD","abhi","Hi i am very good boy","Within 100km","Engineer","Travelling | Business");
        people p2 = new people("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.freepik.com%2Ffree-photos-vectors%2Fletter-b&psig=AOvVaw2-NjtqQkHX4BP_tEvJ_ukp&ust=1691329573820000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCIiixOXTxYADFQAAAAAdAAAAABAD","bharat","Star boy","Within 100km","Mech Engineer","Travelling | Dating");
        people p3 = new people("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockphoto.com%2Fillustrations%2Fdrawing-of-the-letter-c-logos%3Fpage%3D2&psig=AOvVaw0m2AAzQd4YqmfqKQHdrdJU&ust=1691329667430000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCJDYuJHUxYADFQAAAAAdAAAAABAD","carol","Hi i am very good boy","Within 100km","Engineer","Travelling | Business");
        people p4 = new people("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.freepik.com%2Ffree-photos-vectors%2Fletter-b&psig=AOvVaw2-NjtqQkHX4BP_tEvJ_ukp&ust=1691329573820000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCIiixOXTxYADFQAAAAAdAAAAABAD","dharani","Star boy","Within 100km","Mech Engineer","Travelling | Dating");

        dumlst.add(p1);
        dumlst.add(p2);
        dumlst.add(p3);
        dumlst.add(p4);
        peopleList = new ArrayList<>(dumlst);
        adp=new Recy_adap(getContext(),peopleList);
        recy.setAdapter(adp);
        recy.setLayoutManager(new LinearLayoutManager(getContext()));

        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), explore.class));
            }
        });



        ser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                peopleList = new ArrayList<>();
                for (people p : dumlst){
                    if (p.name.substring(0,Math.min(s.length(),p.name.length())).equals(s+"")) peopleList.add(p);
//                    Toast.makeText(getContext(), p.name.substring(0,Math.min(s.length(),p.name.length())).equals(s+"")+"", Toast.LENGTH_SHORT).show();

                }
                adp=new Recy_adap(getContext(),peopleList);
                recy.setAdapter(adp);
                recy.setLayoutManager(new LinearLayoutManager(getContext()));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }
}