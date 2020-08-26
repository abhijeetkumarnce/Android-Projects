package com.ict.myproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class JumbleWordGame extends ListActivity implements AdapterView.OnItemClickListener {
    String []ar = {"CityGame", "FruitGame", "StateGame", "AnimalGame"};

    ArrayAdapter<String> ad;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumble_word_game);
        lv=findViewById(android.R.id.list);
        ad = new ArrayAdapter<String>(this,R.layout.listviewdesign,R.id.lvdesign, ar);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        try{
            String s = "com.ict.myproject."+ar[i];
            Class c = Class.forName(s);
            Intent intent = new Intent(JumbleWordGame.this, c);
            startActivity(intent);
        }
        catch(Exception e){

        }

    }
}