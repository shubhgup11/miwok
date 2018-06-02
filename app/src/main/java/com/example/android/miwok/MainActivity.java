package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView nxt = findViewById(R.id.num);
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,number.class);
                startActivity(i);
            }
        });
//        TextView nxt1 = (TextView) findViewById(R.id.fam);
//        nxt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(MainActivity.this,family.class);
//                startActivity(i);
//            }
 //       });
        TextView nxt1=findViewById(R.id.fam);
        nxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(view.getContext(),family.class);
                startActivity(ii);
            }
        });
        TextView nxt2 = (TextView) findViewById(R.id.col);
        nxt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,colors.class);
                startActivity(i);
            }
        });
        TextView nxt3 = (TextView) findViewById(R.id.phra);
        nxt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,phrase.class);
                startActivity(i);
            }
        });
    }
}
