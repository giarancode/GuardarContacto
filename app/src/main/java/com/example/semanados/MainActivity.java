package com.example.semanados;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombreCompleto,etTelefono,etEmail,etDescripcion;
    private CalendarView miCalendario;
    private TextView fechaNacimiento;
    String fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombreCompleto = (EditText) findViewById(R.id.etNombreCompleto);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        miCalendario = (CalendarView) findViewById(R.id.miCalendario);
        fechaNacimiento = (TextView) findViewById(R.id.fechaNacimiento);
        miCalendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String fecha=dayOfMonth+"/"+month+"/"+year;
                fechaNacimiento.setText(fecha);
                Toast.makeText(getBaseContext(),getResources().getString(R.string.toastCalendario),Toast.LENGTH_SHORT).show();
            }

        });
        cargarPreferencias();
    }

    public void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        String nombre = etNombreCompleto.getText().toString();
        String tel = etTelefono.getText().toString();
        String correo = etEmail.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String fecha = fechaNacimiento.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre",nombre);
        editor.putString("telefono",tel);
        editor.putString("correo",correo);
        editor.putString("Descripcion",descripcion);
        editor.putString("Calendario",fecha);
        editor.commit();
    }
    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("Credenciales", MODE_PRIVATE);
        String nombre = preferences.getString("Nombre","No existe Nombre");
        String tel = preferences.getString("telefono","No existe Telefono");
        String correo = preferences.getString("correo","No existe correo");
        String descripcion = preferences.getString("Descripcion","No existe Descripcion");
        String fecha = preferences.getString("Calendario", "No existe Calendario");
        etNombreCompleto.setText(nombre);
        etTelefono.setText(tel);
        etEmail.setText(correo);
        etDescripcion.setText(descripcion);
        fechaNacimiento.setText(fecha);

         }
    public void Onclick(View view){
        guardarPreferencias();
        String nombre = etNombreCompleto.getText().toString();
        String tel = etTelefono.getText().toString();
        String correo = etEmail.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String fecha = fechaNacimiento.getText().toString();
        Intent intent = new Intent(MainActivity.this, ConfirmacionDatos.class);
        intent.putExtra("Nombre",nombre);
        intent.putExtra("telefono",tel);
        intent.putExtra("correo",correo);
        intent.putExtra("Descripcion",descripcion);
        intent.putExtra("Calendario",fecha);
        startActivity(intent);
    }
}