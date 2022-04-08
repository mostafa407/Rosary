package com.example.rosary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    MediaPlayer mysong;
    TextView counterTxt;
    private Button count,zero;
    private int counter;
    private View.OnClickListener clickListener=new View.OnClickListener ( ) {
        @Override
        public void onClick(View v) {
            switch (v.getId ()){

                case R.id.count:
                    countCounter ();
                    break;
                case R.id.zero:
                    initCounter ();
                    break;
            }

        }
    };
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        /* ads*/


        mysong=MediaPlayer.create ( MainActivity.this,R.raw.myaudio2 );
        mysong.start ();
        counterTxt=findViewById ( R.id.view);
        count=findViewById ( R.id.count );
        zero=findViewById ( R.id.zero );
        count.setOnClickListener ( clickListener );
        zero.setOnClickListener ( clickListener );
        initCounter();
    }

    private void initCounter() {
        counter=0;
        counterTxt.setText ( counter +"" );
    }
    private void countCounter(){
        counter++;
        counterTxt.setText ( counter  +"");
    }


    @Override
    protected void onPause() {
        super.onPause ( );
        mysong.release ();
    }
}
