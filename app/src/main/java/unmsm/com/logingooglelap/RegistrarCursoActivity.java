package unmsm.com.logingooglelap;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import unmsm.com.logingooglelap.model.Curso;
import unmsm.com.logingooglelap.model.Docente;

public class RegistrarCursoActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinnerC;
    String dni;
    String correo;
    TableLayout tablaCursos ;
    TableRow row;
    TextView textView;
    DisplayMetrics metrics;
    int contador;
    int widthPixels;
    FirebaseDatabase database;
    DatabaseReference ref;
    DatabaseReference docenteFirebase;
    Docente docenteRecuperado;
    List<String> cursosSistemas;
    List<String> cursosSoftware;
    List<Curso> cursosSeleccionados;
    Curso cursoSelect;
    int cod_escuela;
    AlertDialog.Builder dialogoConfirmación;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_curso);
        dni= (String)getIntent().getExtras().get("dni");
        correo= (String)getIntent().getExtras().get("correo");

        database = FirebaseDatabase.getInstance();
        ref = database.getReference();
        docenteFirebase = ref.child("docentes").child("d_"+dni);
        docenteFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                docenteRecuperado = dataSnapshot.getValue(Docente.class);
                recuperarListaCursos();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        cursosSeleccionados=new ArrayList<Curso>();
        cursoSelect= new Curso();

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

               if(cursosSeleccionados.size()!=0){

                   dialogoConfirmación.show();

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
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id){
                cursoSelect=new Curso();
                String mensaje="";
                String[] cursos = new String[20];
                switch (pos){
                    case 0:
                         cursos = new String[cursosSistemas.size()];
                         cursos = cursosSistemas.toArray(cursos);
                         cod_escuela=1;
                        break;

                    case 1:

                        cursos = new String[cursosSoftware.size()];
                        cursos = cursosSoftware.toArray(cursos);
                        cod_escuela=2;
                        break;

                    case 2:
                        cursos = new String[]{""};
                        break;

                }
                spinnerC.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.select_dialog_item, cursos));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });

        dialogoConfirmación = new AlertDialog.Builder(this);
        dialogoConfirmación.setTitle("Registrar Cursos");
        dialogoConfirmación.setMessage(" ¿Está seguro de guardar los cambios?");
        dialogoConfirmación.setCancelable(false);
        dialogoConfirmación.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                guardar();
            }
        });
        dialogoConfirmación.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_curso, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent addNuevoCurso = new Intent(getApplicationContext(),RegistrarNuevoCursoActivity.class);
                addNuevoCurso.putExtra("dni",dni);
                startActivity(addNuevoCurso);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void guardar(){
        ref.child("docentes").child("d_"+dni).child("cursosSeleccionados").setValue(cursosSeleccionados);
        ref.child("docentes").child("d_"+dni).child("intentos").setValue(docenteRecuperado.getIntentos()+1);
        Intent intent = new Intent(this,ExitoActivity.class);
        intent.putExtra("dni",dni);
        intent.putExtra("correo", correo);
        startActivity(intent);
    }

    public void agregarCurso(View view){
        boolean band=false;



        try {
            cursoSelect = new Curso();
            String a = spinner.getSelectedItem().toString();
            String b = spinnerC.getSelectedItem().toString();

            for (Curso c : cursosSeleccionados) {
                if (c.getNombre().equalsIgnoreCase(b)) {
                    band = true;
                }
            }

            if (band) {
                Toast toast1 = Toast.makeText(this,
                        "El curso ya ha sido añadido", Toast.LENGTH_SHORT);
            } else {

                cursoSelect.setCodigoEscuela(cod_escuela);
                cursoSelect.setEscuela(a);
                cursoSelect.setNombre(b);
                cursosSeleccionados.add(cursoSelect);

                String[] cadena = {"" + cursosSeleccionados.size(), b, a};
                 row = new TableRow(getBaseContext());

                for (int i = 0; i < 3; i++) {
                    textView = new TextView(getBaseContext());
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    textView.setPadding(15, 15, 15, 15);
                    textView.setPadding(10, 10, 10, 10);
                    textView.setText(cadena[i]);
                    textView.setTextColor(Color.parseColor("#259874"));

                    if (i == 0) {
                        textView.setWidth((widthPixels / 5));
                    } else {
                        textView.setWidth(2 * (widthPixels / 5));
                    }

                    row.addView(textView);
                }
                tablaCursos.addView(row);
            }
        }catch(Exception e){

        }
    }

    public void recuperarListaCursos(){
        cursosSistemas= new ArrayList<String>();
        cursosSoftware= new ArrayList<String>();

        List<Curso> cursosRecuperados = docenteRecuperado.getCursosPreferencia();

       if(cursosRecuperados!=null) {
           for (Curso c : cursosRecuperados) {
               switch (c.getCodigoEscuela()) {
                   case 1:
                       cursosSistemas.add(c.getNombre());
                       break;
                   case 2:
                       cursosSoftware.add(c.getNombre());
                       break;
               }
           }
       }
    }
}
