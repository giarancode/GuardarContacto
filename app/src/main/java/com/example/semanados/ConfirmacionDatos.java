package com.example.semanados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmacionDatos extends AppCompatActivity {

    private TextView etNombreCompleto,etfechaNacimiento,edTelefono,edEmail,edDescripcion;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_confirmacion);

        etNombreCompleto = (TextView) findViewById(R.id.etNombreCompleto);
        edTelefono = (TextView) findViewById(R.id.edTelefono);
        edEmail = (TextView) findViewById(R.id.edEmail);
        edDescripcion = (TextView) findViewById(R.id.edDescripcion);
        etfechaNacimiento=(TextView) findViewById(R.id.etfechaNacimiento);

        Bundle extra = getIntent().getExtras();
        String nombrE = extra.getString("Nombre");
        String telefonO = extra.getString("telefono");
        String correO = extra.getString("correo");
        String descripcioN = extra.getString("Descripcion");
        String fechA = extra.getString("Calendario");
        etNombreCompleto.setText(nombrE);
        edTelefono.setText(telefonO);
        edEmail.setText(correO);
        edDescripcion.setText("Descripcion :"+ descripcioN);
        etfechaNacimiento.setText("Fecha Nacimiento: "+fechA);
    }
    public void devolverAtras(View view) {
        Intent i = new Intent(this, MainActivity.class);
        Toast.makeText(getBaseContext(),getResources().getString(R.string.toastRegresar),Toast.LENGTH_SHORT).show();
        startActivity(i);
    }

}