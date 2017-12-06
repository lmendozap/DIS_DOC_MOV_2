package unmsm.com.logingooglelap;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import unmsm.com.logingooglelap.model.Curso;
import unmsm.com.logingooglelap.model.Docente;

public class VerCursosRegistradosActivity extends AppCompatActivity {

    private String dni;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference docenteFirebase;
    Docente docenteRecuperado;
    TableLayout tablaCursos ;
    TableRow row;
    TextView textView;
    DisplayMetrics metrics;
    int contador;
    int widthPixels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cursos_registrados);
        dni= (String) getIntent().getExtras().get("dni");
        docenteFirebase = ref.child("docentes").child("d_"+dni);
        docenteFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                docenteRecuperado = dataSnapshot.getValue(Docente.class);
                if(docenteRecuperado.getCursosSeleccionados()!=null){

                   pintarCursos();
                }else{
                    //Mensaje diciendo q no a registrado cursos
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);


            }
        });

    }
    public void pintarCursos(){
        tablaCursos = (TableLayout) findViewById(R.id.tb1);
        row = new TableRow(getBaseContext());
        String[] cadena={"N°","Curso","Escuela"};
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        widthPixels = metrics.widthPixels;

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


        int cont=1;
        for(Curso c : docenteRecuperado.getCursosSeleccionados()){
            String[] cad = {"" + cont, c.getNombre(), c.getEscuela()};
            cont++;
            row = new TableRow(getBaseContext());

            for (int i = 0; i < 3; i++) {
                textView = new TextView(getBaseContext());
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(15, 15, 15, 15);
                textView.setPadding(10, 10, 10, 10);
                textView.setText(cad[i]);
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





    }
}
