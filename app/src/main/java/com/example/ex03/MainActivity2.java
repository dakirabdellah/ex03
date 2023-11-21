package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button ok,back;
    EditText nbr1,nbr2;
    TextView op;
    double d;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Ex03 - Resultat");
        ok=findViewById(R.id.btnOK);
        back=findViewById(R.id.btnBack);
        nbr1=findViewById(R.id.nbr1);
        nbr2=findViewById(R.id.nbr2);
        op=findViewById(R.id.operation);
        op.setText(getIntent().getStringExtra("op"));
        String s=op.getText().toString();



        ok.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                if (s.equals("+")){
                    try {
                        d=Double.parseDouble(nbr1.getText().toString()) + Double.parseDouble(nbr2.getText().toString());
                    }catch (Exception e){
                        Toast.makeText(MainActivity2.this, "Nombre no valide", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (s.equals("-")){
                    try {
                        d=Double.parseDouble(nbr1.getText().toString()) - Double.parseDouble(nbr2.getText().toString());
                    }catch (Exception e){
                        Toast.makeText(MainActivity2.this, "Nombre no valide", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    try {
                        d=Double.parseDouble(String.valueOf(nbr1.getText()))*Double.parseDouble(String.valueOf(nbr2.getText()));
                    }catch (Exception e){
                        Toast.makeText(MainActivity2.this, "Nombre no valide", Toast.LENGTH_SHORT).show();
                    }

                }
                if (d!=0){
                    Toast.makeText(MainActivity2.this, String.format("%.2f",d), Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}