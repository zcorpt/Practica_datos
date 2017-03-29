package com.practicadatos.omar.tlahuac.practica_datos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView txtnombre, txtdireccion, txttel, txtfecha;
    private Button btneditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txttel = (TextView) findViewById(R.id.txttel);
        txtdireccion = (TextView) findViewById(R.id.txtdireccion);
        txtfecha = (TextView) findViewById(R.id.txtfecha);

        btneditar = (Button) findViewById(R.id.btneditar);
        btneditar.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre = (String) extras.get("nombre");//Obtengo el nombre
            String datoTelefono = (String) extras.get("telefono");//Obtengo el telefono
            String datoDireccion = (String) extras.get("direccion");//Obtengo direccion
            String datoFecha = (String) extras.get("fecha");

            txtnombre.setText("Nombre: " + datoNombre);
            txttel.setText("Telefono :" + datoTelefono);
            txtdireccion.setText("Direccion :" + datoDireccion);
            txtfecha.setText("Fecha Nacimiento :" + datoFecha);
        }
    }

    public void Onclick(View view) {
        Intent i;
        i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
