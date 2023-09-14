package com.example.admin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Page.this, SMS.class));

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url= "https://docs.google.com/spreadsheets/d/e/2PACX-1vQ8enrL4awKXofj_OwAkyBH4D9A819VpROocK_hxjYkQHfHXsVQq6V0CwCpMwGpX5KzIOdXN6zO3bwN/pubhtml";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url= "https://docs.google.com/spreadsheets/d/e/2PACX-1vTZZbr2sY5R6VC2wJB1HPICy8eF5eBVAKJwp_m03MU_SMNGVTptbcgM7kgmoAlkrkYt7wJgK17dKjXY/pubhtml";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url= "https://docs.google.com/spreadsheets/d/e/2PACX-1vS05T5lXTWpmyCiqjuoRJWdwJmH637wWI7gWMbAuDRzu7AGY5sm9MT8IGcupTTMdNHg1Afe3ifS4xP3/pubhtml";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
