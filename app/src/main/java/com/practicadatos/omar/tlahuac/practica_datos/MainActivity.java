package com.practicadatos.omar.tlahuac.practica_datos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnfecha, btnenviar;
    EditText etfecha, etnombre, etdireccion, ettel;
    private int dia, mes, anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//fecha
        etfecha = (EditText)findViewById(R.id.etfecha);
        btnfecha = (Button)findViewById(R.id.btnfecha);
        btnfecha.setOnClickListener(this);
//datos
        etnombre = (EditText) findViewById(R.id.etnombre);
        etdireccion  = (EditText) findViewById(R.id.etdireccion);
        ettel = (EditText) findViewById(R.id.ettel);
//btn enviar
        btnenviar = (Button)findViewById(R.id.btnenviar);
        btnenviar.setOnClickListener(this);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if(extras != null){
            String datoNombre = (String) extras.get("nombre");
            String datoTelefono = (String) extras.get("telefono");
            String datoDireccion = (String) extras.get("direccion");
            String datoFecha = (String) extras.get("fecha");

            etnombre.setText(datoNombre);
            ettel.setText(datoTelefono);
            etdireccion.setText(datoDireccion);
            etfecha.setText(datoFecha);
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if(v == btnfecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    etfecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,dia,mes,anio);
            picker.show();
        } else if(v == btnenviar){
            Intent i;

            i = new Intent(this, Main2Activity.class);
            String auxEdiNombre = etnombre.getText().toString();
            String auxEdiTelefono = ettel.getText().toString();
            String auxEdiDireccion = etdireccion.getText().toString();
            String auxEdiFecha = etfecha.getText().toString();

            i.putExtra("nombre", auxEdiNombre);//Guardamos una cadena
            i.putExtra("telefono", auxEdiTelefono);//Guardamos un entero
            i.putExtra("direccion", auxEdiDireccion);
            i.putExtra("fecha",auxEdiFecha);
            startActivity(i);
        }

    }
}
