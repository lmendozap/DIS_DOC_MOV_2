package unmsm.com.logingooglelap;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import unmsm.com.logingooglelap.model.Disponibilidad;

public class VerHorarioActivity extends AppCompatActivity {

    private Disponibilidad disponibilidad;
    private String dni;
    private Boolean botonL8;
    private Boolean botonL9;
    private Boolean botonL10;
    private Boolean botonL11;
    private Boolean botonL12;
    private Boolean botonL13;
    private Boolean botonL14;
    private Boolean botonL15;
    private Boolean botonL16;
    private Boolean botonL17;
    private Boolean botonL18;
    private Boolean botonL19;
    private Boolean botonL20;
    private Boolean botonL21;

    private Boolean botonMa8;
    private Boolean botonMa9;
    private Boolean botonMa10;
    private Boolean botonMa11;
    private Boolean botonMa12;
    private Boolean botonMa13;
    private Boolean botonMa14;
    private Boolean botonMa15;
    private Boolean botonMa16;
    private Boolean botonMa17;
    private Boolean botonMa18;
    private Boolean botonMa19;
    private Boolean botonMa20;
    private Boolean botonMa21;

    private Boolean botonMi8;
    private Boolean botonMi9;
    private Boolean botonMi10;
    private Boolean botonMi11;
    private Boolean botonMi12;
    private Boolean botonMi13;
    private Boolean botonMi14;
    private Boolean botonMi15;
    private Boolean botonMi16;
    private Boolean botonMi17;
    private Boolean botonMi18;
    private Boolean botonMi19;
    private Boolean botonMi20;
    private Boolean botonMi21;

    private Boolean botonJ8;
    private Boolean botonJ9;
    private Boolean botonJ10;
    private Boolean botonJ11;
    private Boolean botonJ12;
    private Boolean botonJ13;
    private Boolean botonJ14;
    private Boolean botonJ15;
    private Boolean botonJ16;
    private Boolean botonJ17;
    private Boolean botonJ18;
    private Boolean botonJ19;
    private Boolean botonJ20;
    private Boolean botonJ21;

    private Boolean botonV8;
    private Boolean botonV9;
    private Boolean botonV10;
    private Boolean botonV11;
    private Boolean botonV12;
    private Boolean botonV13;
    private Boolean botonV14;
    private Boolean botonV15;
    private Boolean botonV16;
    private Boolean botonV17;
    private Boolean botonV18;
    private Boolean botonV19;
    private Boolean botonV20;
    private Boolean botonV21;

    private Boolean botonS8;
    private Boolean botonS9;
    private Boolean botonS10;
    private Boolean botonS11;
    private Boolean botonS12;
    private Boolean botonS13;
    private Boolean botonS14;
    private Boolean botonS15;
    private Boolean botonS16;
    private Boolean botonS17;
    private Boolean botonS18;
    private Boolean botonS19;
    private Boolean botonS20;
    private Boolean botonS21;


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
        setContentView(R.layout.activity_ver_horario);
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


        disponibilidad= (Disponibilidad)getIntent().getExtras().getSerializable("disponibilidad");
        dni= (String) getIntent().getExtras().get("dni");
        limpiarBotones();
        decodificarHoras();
        pintarHoras();
        if(disponibilidad==null){
            Toast.makeText(getApplicationContext(),"No se pudo obtener la disponibilidad" ,Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(getApplicationContext(),"Presenta Disponibilidad" ,Toast.LENGTH_SHORT).show();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent intent = new Intent(view.getContext(),VerCursosRegistradosActivity.class);
                    intent.putExtra("dni",dni);
                    startActivityForResult(intent, 0);


            }
        });

    }
    
    private void limpiarBotones(){
        
        botonL8=false;
        botonL9=false;
        botonL10=false;
        botonL11=false;
        botonL12=false;
        botonL13=false;
        botonL14=false;
        botonL15=false;
        botonL16=false;
        botonL17=false;
        botonL18=false;
        botonL19=false;
        botonL20=false;
        botonL21=false;

        botonMa8=false;
        botonMa9=false;
        botonMa10=false;
        botonMa11=false;
        botonMa12=false;
        botonMa13=false;
        botonMa14=false;
        botonMa15=false;
        botonMa16=false;
        botonMa17=false;
        botonMa18=false;
        botonMa19=false;
        botonMa20=false;
        botonMa21=false;

        botonMi8=false;
        botonMi9=false;
        botonMi10=false;
        botonMi11=false;
        botonMi12=false;
        botonMi13=false;
        botonMi14=false;
        botonMi15=false;
        botonMi16=false;
        botonMi17=false;
        botonMi18=false;
        botonMi19=false;
        botonMi20=false;
        botonMi21=false;

        botonJ8=false;
        botonJ9=false;
        botonJ10=false;
        botonJ11=false;
        botonJ12=false;
        botonJ13=false;
        botonJ14=false;
        botonJ15=false;
        botonJ16=false;
        botonJ17=false;
        botonJ18=false;
        botonJ19=false;
        botonJ20=false;
        botonJ21=false;

        botonV8=false;
        botonV9=false;
        botonV10=false;
        botonV11=false;
        botonV12=false;
        botonV13=false;
        botonV14=false;
        botonV15=false;
        botonV16=false;
        botonV17=false;
        botonV18=false;
        botonV19=false;
        botonV20=false;
        botonV21=false;

        botonS8=false;
        botonS9=false;
        botonS10=false;
        botonS11=false;
        botonS12=false;
        botonS13=false;
        botonS14=false;
        botonS15=false;
        botonS16=false;
        botonS17=false;
        botonS18=false;
        botonS19=false;
        botonS20=false;
        botonS21=false;


    }

    private void decodificarHoras(){

        List<String> lunes = disponibilidad.getLunes();
        List<String> martes = disponibilidad.getMartes();
        List<String> miercoles = disponibilidad.getMiercoles();
        List<String> jueves = disponibilidad.getJueves();
        List<String> viernes = disponibilidad.getViernes();
        List<String> sabado = disponibilidad.getSabado();

        if(lunes!=null) {
            for (String hora : lunes) {
                switch (hora) {
                    case "8":
                            botonL8=true;
                        break;
                    case "9":
                            botonL9=true;
                        break;
                    case "10":
                        botonL10=true;
                        break;
                    case "11":
                        botonL11=true;
                        break;
                    case "12":
                        botonL12=true;
                        break;
                    case "13":
                        botonL13=true;
                        break;
                    case "14":
                        botonL14=true;
                        break;
                    case "15":
                        botonL15=true;
                        break;
                    case "16":
                        botonL16=true;
                        break;
                    case "17":
                        botonL17=true;
                        break;
                    case "18":
                        botonL18=true;
                        break;
                    case "19":
                        botonL19=true;
                        break;
                    case "20":
                        botonL20=true;
                        break;
                    case "21":
                        botonL21=true;
                        break;
                }

            }
        }

        if(martes!=null) {
            for (String hora : martes) {
                switch (hora) {
                    case "8":
                        botonMa8=true;
                        break;
                    case "9":
                        botonMa9=true;
                        break;
                    case "10":
                        botonMa10=true;
                        break;
                    case "11":
                        botonMa11=true;
                        break;
                    case "12":
                        botonMa12=true;
                        break;
                    case "13":
                        botonMa13=true;
                        break;
                    case "14":
                        botonMa14=true;
                        break;
                    case "15":
                        botonMa15=true;
                        break;
                    case "16":
                        botonMa16=true;
                        break;
                    case "17":
                        botonMa17=true;
                        break;
                    case "18":
                        botonMa18=true;
                        break;
                    case "19":
                        botonMa19=true;
                        break;
                    case "20":
                        botonMa20=true;
                        break;
                    case "21":
                        botonMa21=true;
                        break;
                }

            }
        }

        if(miercoles!=null) {
            for (String hora : miercoles) {
                switch (hora) {
                    case "8":
                        botonMi8=true;
                        break;
                    case "9":
                        botonMi9=true;
                        break;
                    case "10":
                        botonMi10=true;
                        break;
                    case "11":
                        botonMi11=true;
                        break;
                    case "12":
                        botonMi12=true;
                        break;
                    case "13":
                        botonMi13=true;
                        break;
                    case "14":
                        botonMi14=true;
                        break;
                    case "15":
                        botonMi15=true;
                        break;
                    case "16":
                        botonMi16=true;
                        break;
                    case "17":
                        botonMi17=true;
                        break;
                    case "18":
                        botonMi18=true;
                        break;
                    case "19":
                        botonMi19=true;
                        break;
                    case "20":
                        botonMi20=true;
                        break;
                    case "21":
                        botonMi21=true;
                        break;
                }

            }
        }

        if(jueves!=null) {
            for (String hora : jueves) {
                switch (hora) {
                    case "8":
                        botonJ8=true;
                        break;
                    case "9":
                        botonJ9=true;
                        break;
                    case "10":
                        botonJ10=true;
                        break;
                    case "11":
                        botonJ11=true;
                        break;
                    case "12":
                        botonJ12=true;
                        break;
                    case "13":
                        botonJ13=true;
                        break;
                    case "14":
                        botonJ14=true;
                        break;
                    case "15":
                        botonJ15=true;
                        break;
                    case "16":
                        botonJ16=true;
                        break;
                    case "17":
                        botonJ17=true;
                        break;
                    case "18":
                        botonJ18=true;
                        break;
                    case "19":
                        botonJ19=true;
                        break;
                    case "20":
                        botonJ20=true;
                        break;
                    case "21":
                        botonJ21=true;
                        break;
                }

            }
        }

        if(viernes!=null) {
            for (String hora : viernes) {
                switch (hora) {
                    case "8":
                        botonV8=true;
                        break;
                    case "9":
                        botonV9=true;
                        break;
                    case "10":
                        botonV10=true;
                        break;
                    case "11":
                        botonV11=true;
                        break;
                    case "12":
                        botonV12=true;
                        break;
                    case "13":
                        botonV13=true;
                        break;
                    case "14":
                        botonV14=true;
                        break;
                    case "15":
                        botonV15=true;
                        break;
                    case "16":
                        botonV16=true;
                        break;
                    case "17":
                        botonV17=true;
                        break;
                    case "18":
                        botonV18=true;
                        break;
                    case "19":
                        botonV19=true;
                        break;
                    case "20":
                        botonV20=true;
                        break;
                    case "21":
                        botonV21=true;
                        break;
                }

            }
        }

        if(sabado!=null) {
            for (String hora : sabado) {
                switch (hora) {
                    case "8":
                        botonS8=true;
                        break;
                    case "9":
                        botonS9=true;
                        break;
                    case "10":
                        botonS10=true;
                        break;
                    case "11":
                        botonS11=true;
                        break;
                    case "12":
                        botonS12=true;
                        break;
                    case "13":
                        botonS13=true;
                        break;
                    case "14":
                        botonS14=true;
                        break;
                    case "15":
                        botonS15=true;
                        break;
                    case "16":
                        botonS16=true;
                        break;
                    case "17":
                        botonS17=true;
                        break;
                    case "18":
                        botonS18=true;
                        break;
                    case "19":
                        botonS19=true;
                        break;
                    case "20":
                        botonS20=true;
                        break;
                    case "21":
                        botonS21=true;
                        break;
                }

            }
        }
        
        
        
        
    }

    private void pintarHoras(){

        if(botonL8){ hora11.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL9){ hora12.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL10){ hora13.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL11){ hora14.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL12){ hora15.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL13){ hora16.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL14){ hora17.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL15){ hora18.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL16){ hora19.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL17){ hora110.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL18){ hora111.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL19){ hora112.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL20){ hora113.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonL21){ hora114.setBackgroundResource(R.color.fondoceldasSeleccionada);}

        if(botonMa8){ hora21.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa9){ hora22.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa10){ hora23.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa11){ hora24.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa12){ hora25.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa13){ hora26.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa14){ hora27.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa15){ hora28.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa16){ hora29.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa17){ hora210.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa18){ hora211.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa19){ hora212.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa20){ hora213.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMa21){ hora214.setBackgroundResource(R.color.fondoceldasSeleccionada);}

        if(botonMi8){ hora31.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi9){ hora32.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi10){ hora33.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi11){ hora34.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi12){ hora35.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi13){ hora36.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi14){ hora37.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi15){ hora38.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi16){ hora39.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi17){ hora310.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi18){ hora311.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi19){ hora312.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi20){ hora313.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonMi21){ hora314.setBackgroundResource(R.color.fondoceldasSeleccionada);}

        if(botonJ8){ hora41.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ9){ hora42.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ10){ hora43.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ11){ hora44.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ12){ hora45.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ13){ hora46.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ14){ hora47.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ15){ hora48.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ16){ hora49.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ17){ hora410.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ18){ hora411.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ19){ hora412.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ20){ hora413.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonJ21){ hora414.setBackgroundResource(R.color.fondoceldasSeleccionada);}

        if(botonV8){ hora51.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV9){ hora52.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV10){ hora53.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV11){ hora54.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV12){ hora55.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV13){ hora56.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV14){ hora57.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV15){ hora58.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV16){ hora59.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV17){ hora510.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV18){ hora511.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV19){ hora512.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV20){ hora513.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonV21){ hora514.setBackgroundResource(R.color.fondoceldasSeleccionada);}

        if(botonS8){ hora61.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS9){ hora62.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS10){ hora63.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS11){ hora64.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS12){ hora65.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS13){ hora66.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS14){ hora67.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS15){ hora68.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS16){ hora69.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS17){ hora610.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS18){ hora611.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS19){ hora612.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS20){ hora613.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        if(botonS21){ hora614.setBackgroundResource(R.color.fondoceldasSeleccionada);}
        



    }

}
