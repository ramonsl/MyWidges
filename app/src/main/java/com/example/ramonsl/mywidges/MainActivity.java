package com.example.ramonsl.mywidges;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtToast = findViewById(R.id.txtToast);
        final EditText edtToast = findViewById(R.id.edtToast);
        final Button btnEnviar = findViewById(R.id.btnEnviar);
        final SeekBar seek= findViewById(R.id.seek);



        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            Integer valor=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valor = progress;
                edtToast.setText(valor.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                edtToast.setText(valor.toString());

                Toast.makeText(MainActivity.this,valor.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                edtToast.setText(valor.toString());
            }
        });




        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder= new AlertDialog.Builder(v.getContext());
                builder.setTitle("ATENÇÃO");
                builder.setMessage("Isso é um alerta para vo!");




                builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(edtToast.getText().length()!=0){
                            txtToast.setText(edtToast.getText().toString());
                            Toast.makeText(getApplicationContext(),edtToast.getText().toString(),Toast.LENGTH_LONG).show();

                        }
                    }
                });


                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_LONG).show();

                    }
                });

                builder.create();
                builder.show();


            }
        });











    }
}
