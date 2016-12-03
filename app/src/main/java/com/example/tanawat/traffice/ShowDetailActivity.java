package com.example.tanawat.traffice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Supanat on 19/10/2559.
 */
public class ShowDetailActivity extends AppCompatActivity{
    //Explicit
    private TextView showTitleTextView, showDetailTextView;
    private ImageView showTrafficImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        //Bind Widget
        bindWidget();

        //Show Widget
        showWidget();
    }//OnCreate

    private void bindWidget(){
        showTitleTextView = (TextView) findViewById(R.id.txtTileDetail);
        showDetailTextView = (TextView)findViewById(R.id.txtDetail);
        showTrafficImageView = (ImageView) findViewById(R.id.imvTafficDetail);
    }//bindWidget
    private void showWidget(){
        //Receive from=Intent
        int intClick = getIntent().getIntExtra("click",0);

        //Show Title
        Mydata objMydata = new Mydata();
        String[] strTitle = objMydata.title();
        showTitleTextView.setText(strTitle[intClick]);

        //shoe Traffic Image
        int[]  intDrawable = objMydata.icon();
        showTrafficImageView.setImageResource(intDrawable[intClick]);

        //Show Detail
        String[] strDetail = getResources().getStringArray(R.array.traffic_detail);
        showDetailTextView.setText(strDetail[intClick]);
    }//Show widget


}