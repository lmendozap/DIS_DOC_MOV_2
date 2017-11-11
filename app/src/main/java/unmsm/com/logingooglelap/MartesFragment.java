 package unmsm.com.logingooglelap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import unmsm.com.logingooglelap.Util.Util;

 /**
 * Created by Luis on 10/11/2017.
 */


public class MartesFragment extends Fragment {

    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;

    static Boolean button8Si;
    static Boolean button9Si;
    static Boolean button10Si;
    static Boolean button11Si;
    static Boolean button12Si;
    static Boolean button13Si;
    static Boolean button14Si;
    static Boolean button15Si;
    static Boolean button16Si;
    static Boolean button17Si;
    static Boolean button18Si;
    static Boolean button19Si;
    static Boolean button20Si;
    static Boolean button21Si;

    private int maxHoras;
    private int contHoras;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_martes, container, false);



        resetBotones();
        inicializarEventoBotones(view);
        maxHoras=RegistrarHorasActivity.horasTotales;
        contHoras=0;
        return view;
    }






    //Coloca en false el valor de los boleans que almacenan el estado del boton.
    private void resetBotones(){
        button8Si=false;
        button9Si=false;
        button10Si=false;
        button11Si=false;
        button12Si=false;
        button13Si=false;
        button14Si=false;
        button15Si=false;
        button16Si=false;
        button17Si=false;
        button18Si=false;
        button19Si=false;
        button20Si=false;
        button21Si=false;
    }

    //Asigna el controlador a cada uno de los botones
    private void inicializarEventoBotones(View view){
        button8= (Button)view.findViewById(R.id.buttonMa_8);
        button8.setOnClickListener(pintarHora);
        button9= (Button)view.findViewById(R.id.buttonMa_9);
        button9.setOnClickListener(pintarHora);
        button10= (Button)view.findViewById(R.id.buttonMa_10);
        button10.setOnClickListener(pintarHora);
        button11= (Button)view.findViewById(R.id.buttonMa_11);
        button11.setOnClickListener(pintarHora);
        button12= (Button)view.findViewById(R.id.buttonMa_12);
        button12.setOnClickListener(pintarHora);
        button13= (Button)view.findViewById(R.id.buttonMa_13);
        button13.setOnClickListener(pintarHora);
        button14= (Button)view.findViewById(R.id.buttonMa_14);
        button14.setOnClickListener(pintarHora);
        button15= (Button)view.findViewById(R.id.buttonMa_15);
        button15.setOnClickListener(pintarHora);
        button16= (Button)view.findViewById(R.id.buttonMa_16);
        button16.setOnClickListener(pintarHora);
        button17= (Button)view.findViewById(R.id.buttonMa_17);
        button17.setOnClickListener(pintarHora);
        button18= (Button)view.findViewById(R.id.buttonMa_18);
        button18.setOnClickListener(pintarHora);
        button19= (Button)view.findViewById(R.id.buttonMa_19);
        button19.setOnClickListener(pintarHora);
        button20= (Button)view.findViewById(R.id.buttonMa_20);
        button20.setOnClickListener(pintarHora);
        button21= (Button)view.findViewById(R.id.buttonMa_21);
        button21.setOnClickListener(pintarHora);

        int radio=10;
        Util.bordecolorboton(button8, Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button9,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button10,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button11,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button12,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button13,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button14,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button15,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button16,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button17,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button18,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button19,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button20,Color.parseColor(getString(R.string.colorBoton)),radio);
        Util.bordecolorboton(button21,Color.parseColor(getString(R.string.colorBoton)),radio);



    }

    public View.OnClickListener pintarHora = new View.OnClickListener() {
        public void onClick(View v) {
            int radio=10;
            Button boton =(Button)v;
            contHoras=RegistrarHorasActivity.horasSeleccionadas;
            switch (v.getId()) {
                case R.id.buttonMa_8:

                    if (button8Si) {
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                         RegistrarHorasActivity.disminuirHoraSelecionada();
                        button8Si = !button8Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                           RegistrarHorasActivity.aumentarHoraSelecionada();
                            button8Si = !button8Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;

                case R.id.buttonMa_9:
                    if (button9Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button9Si = !button9Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                           RegistrarHorasActivity.aumentarHoraSelecionada();
                            button9Si = !button9Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_10:
                    if (button10Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button10Si = !button10Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                           RegistrarHorasActivity.aumentarHoraSelecionada();
                            button10Si = !button10Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_11:
                    if (button11Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button11Si = !button11Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            RegistrarHorasActivity.aumentarHoraSelecionada();
                            button11Si = !button11Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_12:
                    if (button12Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button12Si = !button12Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            RegistrarHorasActivity.aumentarHoraSelecionada();
                            button12Si = !button12Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_13:
                    if (button13Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button13Si = !button13Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            RegistrarHorasActivity.aumentarHoraSelecionada();
                            button13Si = !button13Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_14:
                    if (button14Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button14Si = !button14Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            RegistrarHorasActivity.aumentarHoraSelecionada();
                            button14Si = !button14Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_15:
                    if (button15Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button15Si = !button15Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                             RegistrarHorasActivity.aumentarHoraSelecionada();
                            button15Si = !button15Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_16:
                    if (button16Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button16Si = !button16Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            contHoras++;
                            button16Si = !button16Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_17:
                    if (button17Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button17Si = !button17Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            contHoras++;
                            button17Si = !button17Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_18:
                    if (button18Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button18Si = !button18Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            contHoras++;
                            button18Si = !button18Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_19:
                    if (button19Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button19Si = !button19Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            contHoras++;
                            button19Si = !button19Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;
                case R.id.buttonMa_20:
                    if (button20Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button20Si = !button20Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            contHoras++;
                            button20Si = !button20Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;

                case R.id.buttonMa_21:
                    if (button21Si) {
                        contHoras=contHoras-1;
                        Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBoton)), radio);
                        button21Si = !button21Si;
                    } else {
                        if(contHoras<maxHoras) {
                            Util.bordecolorboton(boton, Color.parseColor(getString(R.string.colorBotonPresionado)), radio);
                            contHoras++;
                            button21Si = !button21Si;
                        }else {
                            Snackbar.make(v, "Número de horas completadas", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }

                    break;

            }
        }
    };



}