package unmsm.com.logingooglelap;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
import unmsm.com.logingooglelap.model.Malla;
import unmsm.com.logingooglelap.model.Plan;

public class RegistrarNuevoCursoActivity extends AppCompatActivity {

    private String dni;
    FirebaseDatabase database;
    DatabaseReference ref;
    DatabaseReference mallaFirebase;
    DatabaseReference docenteFirebase;
    Docente docenteRecuperado;
    List<Curso> cursosRecuperados;
    Malla mallaRecuperada;
    Spinner spinnerEscuela;
    Spinner spinnerPlan;
    Spinner spinnerCurso;
    String[] planesSistemas = {""};
    String[] planesSotware = {""};
    List<String> cursos2009;
    List<String> cursos2009S;
    List<String> cursos2014;

    int codEscuela=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_nuevo_curso);
        dni=getIntent().getExtras().getString("dni");
        database = FirebaseDatabase.getInstance();
        ref = database.getReference();

        mallaFirebase = ref.child("mallas");
        mallaFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mallaRecuperada = dataSnapshot.getValue(Malla.class);
                inicializarPlanes();
                inicializarSpinners();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        docenteFirebase = ref.child("docentes").child("d_"+dni);
        docenteFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                docenteRecuperado = dataSnapshot.getValue(Docente.class);
                cursosRecuperados = docenteRecuperado.getCursosPreferencia();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             agregarNuevoCurso();
            }
        });

        spinnerEscuela = (Spinner) findViewById(R.id.spinnerEscuela);
        spinnerPlan = (Spinner) findViewById(R.id.spinnerPlan);
        spinnerCurso = (Spinner) findViewById(R.id.spinnerCurso);

        String[] esc = {"Sistemas "," Software"};
        String[] plan = {""};
        String[] cursos = {""};
        spinnerEscuela.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, esc));
        spinnerPlan.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, plan));
        spinnerCurso.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, cursos));




    }
    public void inicializarSpinners2(){
        spinnerPlan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id){
                String [] cursos= {""};

                switch (codEscuela){
                    case 1://Sistemas
                        switch (pos){
                            case 0: //Plan 2009
                                if(cursos2009!=null) {
                                    cursos = new String[cursos2009.size()];
                                    cursos = cursos2009.toArray(cursos);
                                }
                                break;

                            case 1: //Plan 2014
                                if(cursos2014!=null) {
                                    cursos = new String[cursos2014.size()];
                                    cursos = cursos2014.toArray(cursos);
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (pos){
                            case 0: //Plan 2009
                                if(cursos2009S!=null) {
                                    cursos = new String[cursos2009S.size()];
                                    cursos = cursos2009S.toArray(cursos);
                                }
                                break;
                        }
                        break;
                }

                spinnerCurso.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_item, cursos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
    public void inicializarSpinners(){

        String[] esc = {"Sistemas "," Software"};
        String[] plan = {""};
        String[] cursos = {""};
        spinnerEscuela.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, esc));
        spinnerPlan.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, plan));
        spinnerCurso.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, cursos));

        spinnerEscuela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String [] plan= {""};
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id){

                switch (pos){
                    case 0: //Sistemas
                        plan = new String[planesSistemas.length];
                        plan=planesSistemas;
                        codEscuela=1;
                        inicializarSpinners2();
                        break;

                    case 1: //Software

                        plan = new String[planesSotware.length];
                        plan=planesSotware;
                        codEscuela=2;
                        inicializarSpinners2();
                        break;
                }

                spinnerPlan.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.select_dialog_item, plan));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });




    }
    public void inicializarPlanes(){

        int numplanesSistemas=0;
        int numplanesSoftware=0;

        for(Plan p : mallaRecuperada.getPlanes()){
            if(p.getCodEscuela()==1){
                numplanesSistemas++;
            }else{
                numplanesSoftware++;
            }
        }
        planesSistemas = new String[numplanesSistemas];
        planesSotware = new String[numplanesSoftware];

        int contadorSistemas=0;
        int contadorSoftware=0;
        for(Plan p : mallaRecuperada.getPlanes()){
            if(p.getCodEscuela()==1){
               planesSistemas[contadorSistemas]="Plan "+p.getAnio();
               contadorSistemas++;
            }else{
                planesSotware[contadorSoftware]="Plan "+p.getAnio();
                contadorSoftware++;
            }
        }

        cursos2009= new ArrayList<String>();
        cursos2009S= new ArrayList<String>();
        cursos2014= new ArrayList<String>();
        for(Plan p : mallaRecuperada.getPlanes()){
            if(p.getCodEscuela()==1){
                if(p.getAnio()==2009){
                    for(Curso C : p.getCursos()){
                        cursos2009.add(C.getNombre());
                    }
                }else{
                    if(p.getAnio()==2014){
                        for(Curso C : p.getCursos()){
                            cursos2014.add(C.getNombre());
                        }
                    }
                }

            }else{
                if(p.getAnio()==2009){
                    for(Curso C : p.getCursos()){
                        cursos2009S.add(C.getNombre());
                    }
                }
            }
        }


    }

    public void agregarNuevoCurso(){

        String escuelaCurso="";
        String nombreCurso;

        switch (codEscuela){
            case 1:
                escuelaCurso="Sistemas";
                break;
            case  2:
                escuelaCurso="Software";
                break;
        }
        nombreCurso=spinnerCurso.getSelectedItem().toString();
        boolean band = false;
        if(cursosRecuperados!=null){
            for (Curso c: cursosRecuperados){
                if(c.getCodigoEscuela()==codEscuela && c.getNombre().equalsIgnoreCase(nombreCurso)){
                   band=true;
                }
            }
        }else{
            cursosRecuperados = new ArrayList<Curso>();
        }

        if(band){
            Toast toast1 = Toast.makeText(this,
                    "El curso ya ha sido añadido", Toast.LENGTH_SHORT);
            toast1.show();
        }else{
            Curso nuevo = new Curso();
            nuevo.setNombre(nombreCurso);
            nuevo.setCodigoEscuela(codEscuela);
            nuevo.setEscuela(escuelaCurso);
            cursosRecuperados.add(nuevo);
            ref.child("docentes").child("d_"+dni).child("cursosPreferencia").setValue(cursosRecuperados);
            Toast toast1 = Toast.makeText(this,
                    "Curso agregado Satisfactoriamente", Toast.LENGTH_SHORT);
            toast1.show();

        }






    }
}
