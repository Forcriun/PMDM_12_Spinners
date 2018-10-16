package com.segudidac.pmdm_12_spinners;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Spinner sTexto, sFondo;
    EditText areaTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Inicialización de componentes de la aplicación
        areaTexto = findViewById(R.id.editAreaTexto);
        llenadoSpinnerTexto();
        llenadoSpinnerFondo();

        //  Se anaden escuchadores a los desplegables
        sTexto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int idColor = 0;
                switch (parent.getSelectedItem().toString()) {
                    case "Blanco":
                        idColor = getResources().getColor(R.color.colorBlanco);
                        break;
                    case "Azul":
                        idColor = getResources().getColor(R.color.colorAzul);
                        break;
                    case "Verde":
                        idColor = getResources().getColor(R.color.colorVerde);
                        break;
                    case "Amarillo":
                        idColor = getResources().getColor(R.color.colorAmarillo);
                        break;
                    case "Rojo":
                        idColor = getResources().getColor(R.color.colorRojo);
                        break;
                    case "Naranja":
                        idColor = getResources().getColor(R.color.colorNaranja);
                        break;
                    case "Marrón":
                        idColor = getResources().getColor(R.color.colorMarron);
                        break;
                    case "Rosa":
                        idColor = getResources().getColor(R.color.colorRosa);
                        break;
                }
                areaTexto.setTextColor(idColor);
                //  areaTexto.append(parent.getSelectedItem().toString());
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sFondo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int idColor = 0;
                switch (parent.getSelectedItem().toString()) {
                    case "Blanco":
                        idColor = getResources().getColor(R.color.colorBlanco);
                        break;
                    case "Azul":
                        idColor = getResources().getColor(R.color.colorAzul);
                        break;
                    case "Verde":
                        idColor = getResources().getColor(R.color.colorVerde);
                        break;
                    case "Amarillo":
                        idColor = getResources().getColor(R.color.colorAmarillo);
                        break;
                    case "Rojo":
                        idColor = getResources().getColor(R.color.colorRojo);
                        break;
                    case "Naranja":
                        idColor = getResources().getColor(R.color.colorNaranja);
                        break;
                    case "Marrón":
                        idColor = getResources().getColor(R.color.colorMarron);
                        break;
                    case "Rosa":
                        idColor = getResources().getColor(R.color.colorRosa);
                        break;
                }
                areaTexto.setBackgroundColor(idColor);
                //  areaTexto.append(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    //  Metodo que se encarga de iniciar y rellenar el desplegable de Texto
    public void llenadoSpinnerTexto() {
        sTexto = (Spinner) findViewById(R.id.spinnerTexto);
//sTexto.setPrompt(String.valueOf(R.string.promptTexto));
        //  Se crea el adaptador encargado de volcar los items en el desplegable
        //  Los items se definen en un array de strings.xml
        ArrayAdapter<CharSequence> adapterTexto = ArrayAdapter.createFromResource(this,
                R.array.coloresTexto, android.R.layout.simple_spinner_item);
        //  Layout por defecto de la lista de opciones que muestra el desplegable
        adapterTexto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTexto.setAdapter(adapterTexto);    //  Asignacion del adaptador al desplegable
    }

    public void llenadoSpinnerFondo() {
        sFondo = (Spinner) findViewById(R.id.spinnerFondo);
        ArrayAdapter<CharSequence> adapterFondo = ArrayAdapter.createFromResource(this,
                R.array.coloresFondo, android.R.layout.simple_spinner_item);
        adapterFondo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sFondo.setAdapter(adapterFondo);
    }
}
