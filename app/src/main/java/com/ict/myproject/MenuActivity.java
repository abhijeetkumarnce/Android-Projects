package com.ict.myproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends Activity implements AdapterView.OnItemClickListener {
    String []ar={"Calculator","JumbleWordGame","TicTacToe","StudentManagementSystem","SongList","QuizApp"};
    ArrayAdapter<String> ad;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lv=findViewById(R.id.list);
        ad=new ArrayAdapter<String>(this,R.layout.listviewdesign,R.id.lvdesign,ar);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        try{
            String s="com.ict.myproject."+ar[i];
            Class c=Class.forName(s);
            Intent intent=new Intent(MenuActivity.this,c);
            startActivity(intent);
        }
        catch (Exception e)
        {

        }
    }
}