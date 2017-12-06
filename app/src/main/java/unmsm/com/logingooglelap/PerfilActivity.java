package unmsm.com.logingooglelap;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import unmsm.com.logingooglelap.model.Curso;
import unmsm.com.logingooglelap.model.Disponibilidad;
import unmsm.com.logingooglelap.model.Docente;
import unmsm.com.logingooglelap.model.Usuario;
import unmsm.com.logingooglelap.model.Usuarios;

public class PerfilActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private TextView twEmail;
    private TextView twName;
    private ImageView iwPhoto;
    private TextView twCategoria;
    private TextView twHoras;
    private TextView twNombres;

    private String displayName;
    private String correo;
    private String urlPhoto;
    private int horas;
    private String dni;

    private GoogleApiClient googleApiClient;
    FloatingActionMenu actionMenu;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usuariosFirebase = ref.child("usuarios");
    DatabaseReference docenteFirebase;
    Usuarios usuariosRecuperados;
    Docente docenteRecuperado;
    AlertDialog.Builder dialogoRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        displayName=getIntent().getExtras().getString("name");
        correo = getIntent().getExtras().getString("correo");
        urlPhoto=getIntent().getExtras().getString("photoUrl");



        twEmail=(TextView)findViewById(R.id.twEmail);
        twName=(TextView)findViewById(R.id.twName);
        twNombres=(TextView)findViewById(R.id.twNombres);
        twCategoria=(TextView)findViewById(R.id.twCategoria);
        twHoras=(TextView)findViewById(R.id.twHoras);
        iwPhoto=(ImageView)findViewById(R.id.photoImage);

        twEmail.setText(correo);
        twName.setText(displayName);

        actionMenu =(FloatingActionMenu)findViewById(R.id.floatingActionMenu);
        actionMenu.setClosedOnTouchOutside(true);


        dialogoRegistro = new AlertDialog.Builder(this);
        dialogoRegistro.setTitle("Registra disponibilidad");
        dialogoRegistro.setMessage(" Usted ya registro su disponibilidad horaria ¿Desea actualizarla?");
        dialogoRegistro.setCancelable(false);
        dialogoRegistro.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                registrarDisponibilidad();
            }
        });
        dialogoRegistro.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });

        try {
            Glide.with(this).load(urlPhoto).into(iwPhoto);
        }catch (Exception e){

        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN ).requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

    }



    @Override
    protected void onStart() {
        super.onStart();

        usuariosFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuariosRecuperados = dataSnapshot.getValue(Usuarios.class);
                try{
                    Log.d("--------------------> ","Los usuarios recuperados son :"+usuariosRecuperados.getListaUsuarios().size());
                    initPerfil();
                }catch(Exception e)
                {
                    Log.d("--------------------> ","No se recupero ningun usuario. Lista Vacia");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }

    private void initPerfil(){
        try {
            List<Usuario> listaUsuarios = usuariosRecuperados.getListaUsuarios();
            Boolean band = false;

            for (Usuario aux:listaUsuarios ) {
                if(correo.equalsIgnoreCase(aux.getCorreo())){
                    band=true;
                    dni=aux.getDni();
                }
            }

            if (band) {
                //Log.d("--------------------> ", "EL USUARIO YA EXISTE");

               // Toast.makeText(getApplicationContext(),"El usuario Existe" +usuariosRecuperados.getListaUsuarios().size() ,Toast.LENGTH_SHORT).show();

                docenteFirebase = ref.child("docentes").child("d_"+dni);
                docenteFirebase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        docenteRecuperado = dataSnapshot.getValue(Docente.class);
                        twNombres.setText(docenteRecuperado.getApellidos()+" "+docenteRecuperado.getNombres());
                        twCategoria.setText(docenteRecuperado.getCategoria()+" - "+docenteRecuperado.getClase());
                        twHoras.setText(docenteRecuperado.getNum_horas()+" horas");
                        horas=docenteRecuperado.getNum_horas();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            } else {
                actionMenu.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"No es Docente de la FISI" ,Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            if(usuariosRecuperados==null){
                Log.d("--------------------> ", "LA LISTA ESTA VACIA");

            }
        }
    }

    public void clickRegistrarDisponibilidad(View view) {

        if(docenteRecuperado.getDisponibilidad()!=null){
            if(docenteRecuperado.getIntentos()<3) {
                dialogoRegistro.show();

            }else{
                Toast.makeText(getApplicationContext(),"Alcanzo el número de intentos máximos" ,Toast.LENGTH_SHORT).show();
            }

        }else{
            registrarDisponibilidad();
        }
    }

    public void registrarDisponibilidad(){

            Intent intent = new Intent(this, RegistrarHorasActivity.class);
            intent.putExtra("horas", horas);
            intent.putExtra("dni", dni);
            intent.putExtra("correo", correo);
            startActivity(intent);

    }
    public void clickVerRegistro(View view) {

        Disponibilidad disponibilidad = docenteRecuperado.getDisponibilidad();
        if(disponibilidad==null || docenteRecuperado.getCursosSeleccionados()==null){
            Toast.makeText(getApplicationContext(),"Aún no a registrado su disponibilidad" ,Toast.LENGTH_SHORT).show();
        }else{

               Intent intent = new Intent(this,VerHorarioActivity.class);
               intent.putExtra("disponibilidad",disponibilidad);
               intent.putExtra("dni",dni);
               startActivity(intent);


        }

    }







    public void logOut(View view){

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if(status.isSuccess()){
                    Toast.makeText(getApplicationContext(),"SE CERRARA SESION",Toast.LENGTH_SHORT).show();
                    goLogInScreen();
                }else{
                    Toast.makeText(getApplicationContext(),"No se pudo cerrar sesión",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void goLogInScreen() {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);   }
}
