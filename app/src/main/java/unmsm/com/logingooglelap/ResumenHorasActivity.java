package unmsm.com.logingooglelap;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import unmsm.com.logingooglelap.model.Disponibilidad;

public class ResumenHorasActivity extends AppCompatActivity {

    private String dni;
    private String correo;
    private List<String> Lunes;
    private List<String> Martes;
    private List<String> Miercoles;
    private List<String> Jueves;
    private List<String> Viernes;
    private List<String> Sabado;
    private Disponibilidad disponibilidadHoraria;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference docenteFirebase ;
    //--------------Variables Lunes---------------------------------------------


    TextView hora11;
    TextView hora12;
    TextView hora13;
    TextView hora14;
    TextView hora15;
    TextView hora16;
    TextView hora17;
    TextView hora18;
    TextView hora19;
    TextView hora110;
    TextView hora111;
    TextView hora112;
    TextView hora113;
    TextView hora114;
    //---------------------------------------------------------------------------

    //--------------Variables Martes---------------------------------------------
    TextView hora21;
    TextView hora22;
    TextView hora23;
    TextView hora24;
    TextView hora25;
    TextView hora26;
    TextView hora27;
    TextView hora28;
    TextView hora29;
    TextView hora210;
    TextView hora211;
    TextView hora212;
    TextView hora213;
    TextView hora214;
    //---------------------------------------------------------------------------

    //--------------Variables Miercoles------------------------------------------
    TextView hora31;
    TextView hora32;
    TextView hora33;
    TextView hora34;
    TextView hora35;
    TextView hora36;
    TextView hora37;
    TextView hora38;
    TextView hora39;
    TextView hora310;
    TextView hora311;
    TextView hora312;
    TextView hora313;
    TextView hora314;
    //---------------------------------------------------------------------------

    //--------------Variables Jueves--------------------------------------------
    TextView hora41;
    TextView hora42;
    TextView hora43;
    TextView hora44;
    TextView hora45;
    TextView hora46;
    TextView hora47;
    TextView hora48;
    TextView hora49;
    TextView hora410;
    TextView hora411;
    TextView hora412;
    TextView hora413;
    TextView hora414;
    //---------------------------------------------------------------------------

    //--------------Variables Viernes--------------------------------------------
    TextView hora51;
    TextView hora52;
    TextView hora53;
    TextView hora54;
    TextView hora55;
    TextView hora56;
    TextView hora57;
    TextView hora58;
    TextView hora59;
    TextView hora510;
    TextView hora511;
    TextView hora512;
    TextView hora513;
    TextView hora514;
    //---------------------------------------------------------------------------

    //--------------Variables Sabado-------------------------------------------
    TextView hora61;
    TextView hora62;
    TextView hora63;
    TextView hora64;
    TextView hora65;
    TextView hora66;
    TextView hora67;
    TextView hora68;
    TextView hora69;
    TextView hora610;
    TextView hora611;
    TextView hora612;
    TextView hora613;
    TextView hora614;
    //---------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_horas);
        dni= (String)getIntent().getExtras().get("dni");
        correo= (String)getIntent().getExtras().get("correo");
        Lunes = new ArrayList<String>();
        Martes = new ArrayList<String>();
        Miercoles = new ArrayList<String>();
        Jueves = new ArrayList<String>();
        Viernes = new ArrayList<String>();
        Sabado = new ArrayList<String>();
        disponibilidadHoraria= new Disponibilidad();


        //Lunes
        hora11=(TextView)findViewById(R.id.hora11);
        hora12=(TextView)findViewById(R.id.hora12);
        hora13=(TextView)findViewById(R.id.hora13);
        hora14=(TextView)findViewById(R.id.hora14);
        hora15=(TextView)findViewById(R.id.hora15);
        hora16=(TextView)findViewById(R.id.hora16);
        hora17=(TextView)findViewById(R.id.hora17);
        hora18=(TextView)findViewById(R.id.hora18);
        hora19=(TextView)findViewById(R.id.hora19);
        hora110=(TextView)findViewById(R.id.hora110);
        hora111=(TextView)findViewById(R.id.hora111);
        hora112=(TextView)findViewById(R.id.hora112);
        hora113=(TextView)findViewById(R.id.hora113);
        hora114=(TextView)findViewById(R.id.hora114);

        //Martes
        hora21=(TextView)findViewById(R.id.hora21);
        hora22=(TextView)findViewById(R.id.hora22);
        hora23=(TextView)findViewById(R.id.hora23);
        hora24=(TextView)findViewById(R.id.hora24);
        hora25=(TextView)findViewById(R.id.hora25);
        hora26=(TextView)findViewById(R.id.hora26);
        hora27=(TextView)findViewById(R.id.hora27);
        hora28=(TextView)findViewById(R.id.hora28);
        hora29=(TextView)findViewById(R.id.hora29);
        hora210=(TextView)findViewById(R.id.hora210);
        hora211=(TextView)findViewById(R.id.hora211);
        hora212=(TextView)findViewById(R.id.hora212);
        hora213=(TextView)findViewById(R.id.hora213);
        hora214=(TextView)findViewById(R.id.hora214);

        //Miercoles
        hora31=(TextView)findViewById(R.id.hora31);
        hora32=(TextView)findViewById(R.id.hora32);
        hora33=(TextView)findViewById(R.id.hora33);
        hora34=(TextView)findViewById(R.id.hora34);
        hora35=(TextView)findViewById(R.id.hora35);
        hora36=(TextView)findViewById(R.id.hora36);
        hora37=(TextView)findViewById(R.id.hora37);
        hora38=(TextView)findViewById(R.id.hora38);
        hora39=(TextView)findViewById(R.id.hora39);
        hora310=(TextView)findViewById(R.id.hora310);
        hora311=(TextView)findViewById(R.id.hora311);
        hora312=(TextView)findViewById(R.id.hora312);
        hora313=(TextView)findViewById(R.id.hora313);
        hora314=(TextView)findViewById(R.id.hora314);

        //Jueves
        hora41=(TextView)findViewById(R.id.hora41);
        hora42=(TextView)findViewById(R.id.hora42);
        hora43=(TextView)findViewById(R.id.hora43);
        hora44=(TextView)findViewById(R.id.hora44);
        hora45=(TextView)findViewById(R.id.hora45);
        hora46=(TextView)findViewById(R.id.hora46);
        hora47=(TextView)findViewById(R.id.hora47);
        hora48=(TextView)findViewById(R.id.hora48);
        hora49=(TextView)findViewById(R.id.hora49);
        hora410=(TextView)findViewById(R.id.hora410);
        hora411=(TextView)findViewById(R.id.hora411);
        hora412=(TextView)findViewById(R.id.hora412);
        hora413=(TextView)findViewById(R.id.hora413);
        hora414=(TextView)findViewById(R.id.hora414);

        //Viernes
        hora51=(TextView)findViewById(R.id.hora51);
        hora52=(TextView)findViewById(R.id.hora52);
        hora53=(TextView)findViewById(R.id.hora53);
        hora54=(TextView)findViewById(R.id.hora54);
        hora55=(TextView)findViewById(R.id.hora55);
        hora56=(TextView)findViewById(R.id.hora56);
        hora57=(TextView)findViewById(R.id.hora57);
        hora58=(TextView)findViewById(R.id.hora58);
        hora59=(TextView)findViewById(R.id.hora59);
        hora510=(TextView)findViewById(R.id.hora510);
        hora511=(TextView)findViewById(R.id.hora511);
        hora512=(TextView)findViewById(R.id.hora512);
        hora513=(TextView)findViewById(R.id.hora513);
        hora514=(TextView)findViewById(R.id.hora514);

        //Sabado
        hora61=(TextView)findViewById(R.id.hora61);
        hora62=(TextView)findViewById(R.id.hora62);
        hora63=(TextView)findViewById(R.id.hora63);
        hora64=(TextView)findViewById(R.id.hora64);
        hora65=(TextView)findViewById(R.id.hora65);
        hora66=(TextView)findViewById(R.id.hora66);
        hora67=(TextView)findViewById(R.id.hora67);
        hora68=(TextView)findViewById(R.id.hora68);
        hora69=(TextView)findViewById(R.id.hora69);
        hora610=(TextView)findViewById(R.id.hora610);
        hora611=(TextView)findViewById(R.id.hora611);
        hora612=(TextView)findViewById(R.id.hora612);
        hora613=(TextView)findViewById(R.id.hora613);
        hora614=(TextView)findViewById(R.id.hora614);
        
        pintarHoras();
        disponibilidadHoraria.setLunes(Lunes);
        disponibilidadHoraria.setMartes(Martes);
        disponibilidadHoraria.setMiercoles(Miercoles);
        disponibilidadHoraria.setJueves(Jueves);
        disponibilidadHoraria.setViernes(Viernes);
        disponibilidadHoraria.setSabado(Sabado);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.child("docentes").child("d_"+dni).child("disponibilidad").setValue(disponibilidadHoraria);
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Registro de horas exitoso", Toast.LENGTH_SHORT);

                toast1.show();

                Intent intent = new Intent(view.getContext(),RegistrarCursoActivity.class);
                intent.putExtra("dni",dni);
                intent.putExtra("correo",correo);
                startActivity(intent);


            }
        });

    }
    
    private void limpiarCeldas(){
        hora11.setBackgroundResource(R.color.fondoceldas);
        hora12.setBackgroundResource(R.color.fondoceldas);
        hora13.setBackgroundResource(R.color.fondoceldas);
        hora14.setBackgroundResource(R.color.fondoceldas);
        hora15.setBackgroundResource(R.color.fondoceldas);
        hora16.setBackgroundResource(R.color.fondoceldas);
        hora17.setBackgroundResource(R.color.fondoceldas);
        hora18.setBackgroundResource(R.color.fondoceldas);
        hora19.setBackgroundResource(R.color.fondoceldas);
        hora110.setBackgroundResource(R.color.fondoceldas);
        hora111.setBackgroundResource(R.color.fondoceldas);
        hora112.setBackgroundResource(R.color.fondoceldas);
        hora113.setBackgroundResource(R.color.fondoceldas);
        hora114.setBackgroundResource(R.color.fondoceldas);

        hora21.setBackgroundResource(R.color.fondoceldas);
        hora22.setBackgroundResource(R.color.fondoceldas);
        hora23.setBackgroundResource(R.color.fondoceldas);
        hora24.setBackgroundResource(R.color.fondoceldas);
        hora25.setBackgroundResource(R.color.fondoceldas);
        hora26.setBackgroundResource(R.color.fondoceldas);
        hora27.setBackgroundResource(R.color.fondoceldas);
        hora28.setBackgroundResource(R.color.fondoceldas);
        hora29.setBackgroundResource(R.color.fondoceldas);
        hora210.setBackgroundResource(R.color.fondoceldas);
        hora211.setBackgroundResource(R.color.fondoceldas);
        hora212.setBackgroundResource(R.color.fondoceldas);
        hora213.setBackgroundResource(R.color.fondoceldas);
        hora214.setBackgroundResource(R.color.fondoceldas);

        hora31.setBackgroundResource(R.color.fondoceldas);
        hora32.setBackgroundResource(R.color.fondoceldas);
        hora33.setBackgroundResource(R.color.fondoceldas);
        hora34.setBackgroundResource(R.color.fondoceldas);
        hora35.setBackgroundResource(R.color.fondoceldas);
        hora36.setBackgroundResource(R.color.fondoceldas);
        hora37.setBackgroundResource(R.color.fondoceldas);
        hora38.setBackgroundResource(R.color.fondoceldas);
        hora39.setBackgroundResource(R.color.fondoceldas);
        hora310.setBackgroundResource(R.color.fondoceldas);
        hora311.setBackgroundResource(R.color.fondoceldas);
        hora312.setBackgroundResource(R.color.fondoceldas);
        hora313.setBackgroundResource(R.color.fondoceldas);
        hora314.setBackgroundResource(R.color.fondoceldas);

        hora41.setBackgroundResource(R.color.fondoceldas);
        hora42.setBackgroundResource(R.color.fondoceldas);
        hora43.setBackgroundResource(R.color.fondoceldas);
        hora44.setBackgroundResource(R.color.fondoceldas);
        hora45.setBackgroundResource(R.color.fondoceldas);
        hora46.setBackgroundResource(R.color.fondoceldas);
        hora47.setBackgroundResource(R.color.fondoceldas);
        hora48.setBackgroundResource(R.color.fondoceldas);
        hora49.setBackgroundResource(R.color.fondoceldas);
        hora410.setBackgroundResource(R.color.fondoceldas);
        hora411.setBackgroundResource(R.color.fondoceldas);
        hora412.setBackgroundResource(R.color.fondoceldas);
        hora413.setBackgroundResource(R.color.fondoceldas);
        hora414.setBackgroundResource(R.color.fondoceldas);

        hora51.setBackgroundResource(R.color.fondoceldas);
        hora52.setBackgroundResource(R.color.fondoceldas);
        hora53.setBackgroundResource(R.color.fondoceldas);
        hora54.setBackgroundResource(R.color.fondoceldas);
        hora55.setBackgroundResource(R.color.fondoceldas);
        hora56.setBackgroundResource(R.color.fondoceldas);
        hora57.setBackgroundResource(R.color.fondoceldas);
        hora58.setBackgroundResource(R.color.fondoceldas);
        hora59.setBackgroundResource(R.color.fondoceldas);
        hora510.setBackgroundResource(R.color.fondoceldas);
        hora511.setBackgroundResource(R.color.fondoceldas);
        hora512.setBackgroundResource(R.color.fondoceldas);
        hora513.setBackgroundResource(R.color.fondoceldas);
        hora514.setBackgroundResource(R.color.fondoceldas);

        hora61.setBackgroundResource(R.color.fondoceldas);
        hora62.setBackgroundResource(R.color.fondoceldas);
        hora63.setBackgroundResource(R.color.fondoceldas);
        hora64.setBackgroundResource(R.color.fondoceldas);
        hora65.setBackgroundResource(R.color.fondoceldas);
        hora66.setBackgroundResource(R.color.fondoceldas);
        hora67.setBackgroundResource(R.color.fondoceldas);
        hora68.setBackgroundResource(R.color.fondoceldas);
        hora69.setBackgroundResource(R.color.fondoceldas);
        hora610.setBackgroundResource(R.color.fondoceldas);
        hora611.setBackgroundResource(R.color.fondoceldas);
        hora612.setBackgroundResource(R.color.fondoceldas);
        hora613.setBackgroundResource(R.color.fondoceldas);
        hora614.setBackgroundResource(R.color.fondoceldas);
        
    }
    
    private void pintarHoras(){
        limpiarCeldas();
        if(LunesFragment.button8Si){ hora11.setBackgroundResource(R.color.fondoceldasSeleccionada); Lunes.add("8");}
        if(LunesFragment.button9Si){ hora12.setBackgroundResource(R.color.fondoceldasSeleccionada); Lunes.add("9");}
        if(LunesFragment.button10Si){ hora13.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("10");}
        if(LunesFragment.button11Si){ hora14.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("11");}
        if(LunesFragment.button12Si){ hora15.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("12");}
        if(LunesFragment.button13Si){ hora16.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("13");}
        if(LunesFragment.button14Si){ hora17.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("14");}
        if(LunesFragment.button15Si){ hora18.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("15");}
        if(LunesFragment.button16Si){ hora19.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("16");}
        if(LunesFragment.button17Si){ hora110.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("17");}
        if(LunesFragment.button18Si){ hora111.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("18");}
        if(LunesFragment.button19Si){ hora112.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("19");}
        if(LunesFragment.button20Si){ hora113.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("20");}
        if(LunesFragment.button21Si){ hora114.setBackgroundResource(R.color.fondoceldasSeleccionada);Lunes.add("21");}


        if(MartesFragment.button8Si){ hora21.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("8");}
        if(MartesFragment.button9Si){ hora22.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("9");}
        if(MartesFragment.button10Si){ hora23.setBackgroundResource(R.color.fondoceldasSeleccionada);  Martes.add("10");}
        if(MartesFragment.button11Si){ hora24.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("11");}
        if(MartesFragment.button12Si){ hora25.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("12");}
        if(MartesFragment.button13Si){ hora26.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("13");}
        if(MartesFragment.button14Si){ hora27.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("14");}
        if(MartesFragment.button15Si){ hora28.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("15");}
        if(MartesFragment.button16Si){ hora29.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("16");}
        if(MartesFragment.button17Si){ hora210.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("17");}
        if(MartesFragment.button18Si){ hora211.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("18");}
        if(MartesFragment.button19Si){ hora212.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("19");}
        if(MartesFragment.button20Si){ hora213.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("20");}
        if(MartesFragment.button21Si){ hora214.setBackgroundResource(R.color.fondoceldasSeleccionada); Martes.add("21");}

        if(MiercolesFragment.button8Si){ hora31.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("8");}
        if(MiercolesFragment.button9Si){ hora32.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("9");}
        if(MiercolesFragment.button10Si){ hora33.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("10");}
        if(MiercolesFragment.button11Si){ hora34.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("11");}
        if(MiercolesFragment.button12Si){ hora35.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("12");}
        if(MiercolesFragment.button13Si){ hora36.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("13");}
        if(MiercolesFragment.button14Si){ hora37.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("14");}
        if(MiercolesFragment.button15Si){ hora38.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("15");}
        if(MiercolesFragment.button16Si){ hora39.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("16");}
        if(MiercolesFragment.button17Si){ hora310.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("17");}
        if(MiercolesFragment.button18Si){ hora311.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("18");}
        if(MiercolesFragment.button19Si){ hora312.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("19");}
        if(MiercolesFragment.button20Si){ hora313.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("20");}
        if(MiercolesFragment.button21Si){ hora314.setBackgroundResource(R.color.fondoceldasSeleccionada); Miercoles.add("21");}

        if(JuevesFragment.button8Si){ hora41.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("8");}
        if(JuevesFragment.button9Si){ hora42.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("9");}
        if(JuevesFragment.button10Si){ hora43.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("10");}
        if(JuevesFragment.button11Si){ hora44.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("11");}
        if(JuevesFragment.button12Si){ hora45.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("12");}
        if(JuevesFragment.button13Si){ hora46.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("13");}
        if(JuevesFragment.button14Si){ hora47.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("14");}
        if(JuevesFragment.button15Si){ hora48.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("15");}
        if(JuevesFragment.button16Si){ hora49.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("16");}
        if(JuevesFragment.button17Si){ hora410.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("17");}
        if(JuevesFragment.button18Si){ hora411.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("18");}
        if(JuevesFragment.button19Si){ hora412.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("19");}
        if(JuevesFragment.button20Si){ hora413.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("20");}
        if(JuevesFragment.button21Si){ hora414.setBackgroundResource(R.color.fondoceldasSeleccionada); Jueves.add("21");}

        if(ViernesFragment.button8Si){ hora51.setBackgroundResource(R.color.fondoceldasSeleccionada);  Viernes.add("8");}
        if(ViernesFragment.button9Si){ hora52.setBackgroundResource(R.color.fondoceldasSeleccionada);  Viernes.add("9");}
        if(ViernesFragment.button10Si){ hora53.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("10");}
        if(ViernesFragment.button11Si){ hora54.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("11");}
        if(ViernesFragment.button12Si){ hora55.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("12");}
        if(ViernesFragment.button13Si){ hora56.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("13");}
        if(ViernesFragment.button14Si){ hora57.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("14");}
        if(ViernesFragment.button15Si){ hora58.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("15");}
        if(ViernesFragment.button16Si){ hora59.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("16");}
        if(ViernesFragment.button17Si){ hora510.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("17");}
        if(ViernesFragment.button18Si){ hora511.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("18");}
        if(ViernesFragment.button19Si){ hora512.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("19");}
        if(ViernesFragment.button20Si){ hora513.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("20");}
        if(ViernesFragment.button21Si){ hora514.setBackgroundResource(R.color.fondoceldasSeleccionada); Viernes.add("21");}

        if(SabadoFragment.button8Si){ hora61.setBackgroundResource(R.color.fondoceldasSeleccionada);  Sabado.add("8");}
        if(SabadoFragment.button9Si){ hora62.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("9");}
        if(SabadoFragment.button10Si){ hora63.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("10");}
        if(SabadoFragment.button11Si){ hora64.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("11");}
        if(SabadoFragment.button12Si){ hora65.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("12");}
        if(SabadoFragment.button13Si){ hora66.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("13");}
        if(SabadoFragment.button14Si){ hora67.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("14");}
        if(SabadoFragment.button15Si){ hora68.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("15");}
        if(SabadoFragment.button16Si){ hora69.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("16");}
        if(SabadoFragment.button17Si){ hora610.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("17");}
        if(SabadoFragment.button18Si){ hora611.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("18");}
        if(SabadoFragment.button19Si){ hora612.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("19");}
        if(SabadoFragment.button20Si){ hora613.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("20");}
        if(SabadoFragment.button21Si){ hora614.setBackgroundResource(R.color.fondoceldasSeleccionada); Sabado.add("21");}
    }
}
