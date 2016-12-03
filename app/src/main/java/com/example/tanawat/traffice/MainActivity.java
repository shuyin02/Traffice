package com.example.tanawat.traffice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creat ListView
        createListView();
    }//Main Metod
    private  void  createListView(){
        Mydata objMydata = new Mydata();
        int[] intIcon = objMydata.icon();
        String[] strTitle = objMydata.title();

        MyAdapter objMyAdpter = new MyAdapter(MainActivity.this,intIcon,strTitle);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objMyAdpter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                myIntentToDetail(i);
            }
        });
    } //createListView
    private void myIntentToDetail(int intClick){
        Intent intent = new Intent(MainActivity.this, ShowDetailActivity.class);
        intent.putExtra("click", intClick);
        startActivity(intent);
    }

    public void clickAboutMe (View view){
        Intent objIntent = new Intent(Intent.ACTION_VIEW);
        objIntent.setData(Uri.parse("http://www.expertlab.ssru.ac.th/satien"));
        startActivity(objIntent);
    }//clickAboutMe
}
