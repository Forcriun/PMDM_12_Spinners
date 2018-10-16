package com.segudidac.pmdm_12_spinners;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner sTexto, sFondo;
    private EditText areaTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Inicialización de componentes de la aplicación
        areaTexto = findViewById(R.id.editAreaTexto);
        llenadoSpinnerTexto();
        llenadoSpinnerFondo();

        //  Se anade el escuchador a los spinner
        sTexto.setOnItemSelectedListener(this);
        sFondo.setOnItemSelectedListener(this);
    }

    //  Metodo que se encarga de iniciar y rellenar el desplegable de Texto
    public void llenadoSpinnerTexto() {
        sTexto = (Spinner) findViewById(R.id.spinnerTexto);
//sTexto.setPrompt(String.valueOf(R.string.promptTexto));
        //  Se crea el adaptador encargado de volcar los items en el desplegable
        //  Los items se definen en un array de strings.xml
        ArrayAdapter<CharSequence> adapterTexto = ArrayAdapter.createFromResource(this,
                R.array.nombresColores, android.R.layout.simple_spinner_item);
        //  Layout por defecto de la lista de opciones que muestra el desplegable
        adapterTexto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTexto.setAdapter(adapterTexto);    //  Asignacion del adaptador al desplegable
    }

    public void llenadoSpinnerFondo() {
        sFondo = (Spinner) findViewById(R.id.spinnerFondo);
        ArrayAdapter<CharSequence> adapterFondo = ArrayAdapter.createFromResource(this,
                R.array.nombresColores, android.R.layout.simple_spinner_item);
        adapterFondo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sFondo.setAdapter(adapterFondo);
    }

    //  Metodo que devuelve un array con los IDs de un conjunto de colores predefinido
    public int[] obtenerColores() {
        int[] arrayColores = getApplicationContext().getResources().getIntArray(R.array.colores);
        return arrayColores;
    }

    //  Implementacion del escuchador
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //  En funcion del spinner sobre el que recae la seleccion...
        switch (parent.getId()) {
            case R.id.spinnerTexto:
                areaTexto.setTextColor(obtenerColores()[position]);
                //  areaTexto.append(parent.getSelectedItem().toString());
                break;
            case R.id.spinnerFondo:
                areaTexto.setBackgroundColor(obtenerColores()[position]);
                //  areaTexto.append(parent.getSelectedItem().toString());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
