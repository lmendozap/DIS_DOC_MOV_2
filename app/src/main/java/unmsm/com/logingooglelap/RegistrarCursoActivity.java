package unmsm.com.logingooglelap;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarCursoActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinnerC;
    String dni;
    TableLayout tablaCursos ;
    TableRow row;
    TextView textView;
    DisplayMetrics metrics;
    int contador;
    int widthPixels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dni= (String)getIntent().getExtras().get("dni");
        setContentView(R.layout.activity_registrar_curso);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        tablaCursos = (TableLayout) findViewById(R.id.tb1);
        row = new TableRow(getBaseContext());
        String[] cadena={"N°","Curso","Escuela"};
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        widthPixels = metrics.widthPixels;
        contador=0;


        //Colocamos el encabezado a la tabla de cursos
        for(int i=0;i<3;i++){
            textView = new TextView(getBaseContext());
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setPadding(15, 15, 15, 15);
            textView.setPadding(10,10,10,10);
            textView.setBackgroundResource(R.color.fondoEncabezado);
            textView.setText(cadena[i]);
            textView.setTextColor(Color.WHITE);
            if(i==0){
                textView.setWidth((widthPixels/5));
            }else{
                textView.setWidth(2*(widthPixels/5));
            }
            row.addView(textView);
        }
        tablaCursos.addView(row);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ref.child("docentes").child("d_"+dni).child("disponibilidad").setValue(disponibilidadHoraria);
               if(true){
                   //Si selecciono mimimamente un curso, guardar en la base de datos y pasar a la activity de
                   //finalizacion
                   Intent intent = new Intent(view.getContext(),ExitoActivity.class);

                   startActivity(intent);

               }else{
                   Toast toast1 = Toast.makeText(getApplicationContext(),
                           "Debe seleccionar al menos un curso", Toast.LENGTH_SHORT);

                   toast1.show();
               }
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        String[] letra = {" Sistemas "," Software","Otras"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, letra));


        spinnerC = (Spinner) findViewById(R.id.spinnerC);
        String[] cursos = {""};
        spinnerC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, cursos));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                String mensaje="";
                String[] cursos = new String[0];
                switch (pos){
                    case 0:
                        mensaje="E.P Sistemas";
                         cursos = new String[]{"Modelamiento de Negocios", "Análisis de Sistemas de Información", "Diseño de sistemas de Información"};
                        break;

                    case 1:
                        mensaje="E.P Software";
                        cursos = new String[]{"Calidad de software" ,"Prueba de software"};

                        break;

                    case 2:
                        mensaje="Otras E.P";
                        cursos = new String[]{""};
                        break;

                }
                spinnerC.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.select_dialog_item, cursos));
                Toast.makeText(adapterView.getContext(),
                        mensaje, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });


    }

    public void agregarCurso(View view){

        contador++;
        String a=spinner.getSelectedItem().toString();
        String b=spinnerC.getSelectedItem().toString();
        String[] cadena={""+contador,b,a};
        row = new TableRow(getBaseContext());

        for(int i=0;i<3;i++){
            textView = new TextView(getBaseContext());
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setPadding(15, 15, 15, 15);
            textView.setPadding(10,10,10,10);
            textView.setBackgroundResource(R.color.plomo);
            textView.setText(cadena[i]);
           // textView.setTextColor(R.color.blanco);
            if(i==0){
                textView.setWidth((widthPixels/5));
            }else{
                textView.setWidth(2*(widthPixels/5));
            }

            row.addView(textView);
        }
        tablaCursos.addView(row);
    }
}
