package unmsm.com.logingooglelap;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import unmsm.com.logingooglelap.model.Curso;
import unmsm.com.logingooglelap.model.Docente;
import unmsm.com.logingooglelap.model.Usuarios;

public class ExitoActivity extends AppCompatActivity {
    private Button ini;

    private String correo;
    private String dni;
    private String correoOrigen;
    private String correoDestino;
    private String contraseña;
    private String cadena= "";
    private String mensaje;
    private Session session;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference();
    private DatabaseReference usuariosFirebase = ref.child("usuarios");
    private DatabaseReference docenteFirebase;
    private Docente docenteRecuperado;
    private static final String NOMBRE_CARPETA_APP = "mispdf";
    private static final String GENERADOS ="misArchivos";
    private static final String NOMBRE_ARCHIVO="MiArchivo.pdf";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private String valor8L;
    private String valor8M;
    private String valor8Mi;
    private String valor8J;
    private String valor8V;
    private String valor8S;

    private String valor9L;
    private String valor9M;
    private String valor9Mi;
    private String valor9J;
    private String valor9V;
    private String valor9S;

    private String valor10L;
    private String valor10M;
    private String valor10Mi;
    private String valor10J;
    private String valor10V;
    private String valor10S;

    private String valor11L;
    private String valor11M;
    private String valor11Mi;
    private String valor11J;
    private String valor11V;
    private String valor11S;

    private String valor12L;
    private String valor12M;
    private String valor12Mi;
    private String valor12J;
    private String valor12V;
    private String valor12S;

    private String valor13L;
    private String valor13M;
    private String valor13Mi;
    private String valor13J;
    private String valor13V;
    private String valor13S;

    private String valor14L;
    private String valor14M;
    private String valor14Mi;
    private String valor14J;
    private String valor14V;
    private String valor14S;

    private String valor15L;
    private String valor15M;
    private String valor15Mi;
    private String valor15J;
    private String valor15V;
    private String valor15S;

    private String valor16L;
    private String valor16M;
    private String valor16Mi;
    private String valor16J;
    private String valor16V;
    private String valor16S;

    private String valor17L;
    private String valor17M;
    private String valor17Mi;
    private String valor17J;
    private String valor17V;
    private String valor17S;

    private String valor18L;
    private String valor18M;
    private String valor18Mi;
    private String valor18J;
    private String valor18V;
    private String valor18S;

    private String valor19L;
    private String valor19M;
    private String valor19Mi;
    private String valor19J;
    private String valor19V;
    private String valor19S;

    private String valor20L;
    private String valor20M;
    private String valor20Mi;
    private String valor20J;
    private String valor20V;
    private String valor20S;

    private String valor21L;
    private String valor21M;
    private String valor21Mi;
    private String valor21J;
    private String valor21V;
    private String valor21S;


    private String cursos;
    private String fecha;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exito);
        verifyStoragePermissions(this);
        inicializarValores();

        dni= (String)getIntent().getExtras().get("dni");
        correo= (String)getIntent().getExtras().get("correo");
        ini = (Button)findViewById(R.id.buttonI);


        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(v.getContext() ,MainActivity .class);
                startActivity(intentReg);
            }
        });

        docenteFirebase = ref.child("docentes").child("d_"+dni);
        docenteFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                docenteRecuperado = dataSnapshot.getValue(Docente.class);
                correoDestino =correo;

                mensaje = "Estimado profesor(a). "+docenteRecuperado.getApellidos()+"  a traves de la presente se le hace de conocimiento que el registro de su disponibilidad horaria se ha realizado exitosamente. ";

                correoOrigen = "disponibilida.docente.fisi@gmail.com";
                contraseña = "administrador123";

                Log.d("-----------------","Correo:"+correo);
                enviarCorreo();//
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }


    private void enviarCorreo(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        generarPDF();
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        try{
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return  new PasswordAuthentication(correoOrigen,contraseña);
                }
            });

            if (session != null){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correoOrigen));
                message.setSubject("Registro de Disponibilidad Horaria");
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(correoDestino));


                BodyPart texto = new MimeBodyPart();
                texto.setText(mensaje);

                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(new DataHandler(new FileDataSource(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath().toString()+File.separator+NOMBRE_CARPETA_APP+File.separator+GENERADOS+File.separator+NOMBRE_ARCHIVO)));
                adjunto.setFileName("constancia.pdf");

                MimeMultipart multiParte = new MimeMultipart();

                multiParte.addBodyPart(texto);
                multiParte.addBodyPart(adjunto);
                message.setContent(multiParte);



                Transport.send(message);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void inicializarValores(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();

       fecha = dateFormat.format(date);

        valor8L="-";
        valor8M="-";
        valor8Mi="-";
        valor8J="-";
        valor8V="-";
        valor8S="-";

        valor9L="-";
        valor9M="-";
        valor9Mi="-";
        valor9J="-";
        valor9V="-";
        valor9S="-";

        valor10L="-";
        valor10M="-";
        valor10Mi="-";
        valor10J="-";
        valor10V="-";
        valor10S="-";

        valor11L="-";
        valor11M="-";
        valor11Mi="-";
        valor11J="-";
        valor11V="-";
        valor11S="-";

        valor12L="-";
        valor12M="-";
        valor12Mi="-";
        valor12J="-";
        valor12V="-";
        valor12S="-";

        valor13L="-";
        valor13M="-";
        valor13Mi="-";
        valor13J="-";
        valor13V="-";
        valor13S="-";

        valor14L="-";
        valor14M="-";
        valor14Mi="-";
        valor14J="-";
        valor14V="-";
        valor14S="-";

        valor15L="-";
        valor15M="-";
        valor15Mi="-";
        valor15J="-";
        valor15V="-";
        valor15S="-";

        valor16L="-";
        valor16M="-";
        valor16Mi="-";
        valor16J="-";
        valor16V="-";
        valor16S="-";

        valor17L="-";
        valor17M="-";
        valor17Mi="-";
        valor17J="-";
        valor17V="-";
        valor17S="-";

        valor18L="-";
        valor18M="-";
        valor18Mi="-";
        valor18J="-";
        valor18V="-";
        valor18S="-";

        valor19L="-";
        valor19M="-";
        valor19Mi="-";
        valor19J="-";
        valor19V="-";
        valor19S="-";

        valor20L="-";
        valor20M="-";
        valor20Mi="-";
        valor20J="-";
        valor20V="-";
        valor20S="-";

        valor21L="-";
        valor21M="-";
        valor21Mi="-";
        valor21J="-";
        valor21V="-";
        valor21S="-";

    }

    public void pintarHoras(){


        cursos="";
        int num=1;
        for(Curso c : docenteRecuperado.getCursosSeleccionados()){
            cursos=cursos+
                    "   <tr>" +
                    "        <td><h3> "+num+" </h3></td>" +
                    "        <td><h3>"+c.getNombre()+" </h3></td>" +
                    "        <td><h3>"+c.getEscuela()+"</h3></td>" +
                    "   </tr>" ;
            num++;
        }

        //Lunes
        boolean a11=LunesFragment.button8Si;
        if(a11){

            valor8L="O";
        }

        boolean a12=LunesFragment.button9Si;
        if(a12){

            valor9L="O";
        }

        boolean a13=LunesFragment.button10Si;
        if(a13){
            valor10L="O";
        }

        boolean a14=LunesFragment.button11Si;
        if(a14){
            valor11L="O";
        }

        boolean a15=LunesFragment.button12Si;
        if(a15){
            valor12L="O";
        }

        boolean a16=LunesFragment.button13Si;
        if(a16){
            valor13L="O";
        }

        boolean a17=LunesFragment.button14Si;
        if(a17){
            valor14L="O";
        }

        boolean a18=LunesFragment.button15Si;
        if(a18){
            valor15L="O";
        }

        boolean a19=LunesFragment.button16Si;
        if(a19){
            valor16L="O";
        }

        boolean a110=LunesFragment.button17Si;
        if(a110){
            valor17L="O";
        }
        boolean a111=LunesFragment.button18Si;
        if(a111){
            valor18L="O";
        }

        boolean a112=LunesFragment.button19Si;
        if(a112){
            valor19L="O";
        }

        boolean a113=LunesFragment.button20Si;
        if(a113){
            valor20L="O";
        }

        boolean a114=LunesFragment.button21Si;
        if(a114){
            valor21L="O";
        }

    //Martes
        boolean a21=MartesFragment.button8Si;
        if(a21){
            valor8M="O";
        }

        boolean a22=MartesFragment.button9Si;
        if(a22){
            valor9M="O";
        }

        boolean a23=MartesFragment.button10Si;
        if(a23){
            valor10M="O";
        }

        boolean a24=MartesFragment.button11Si;
        if(a24){
            valor11M="O";
        }

        boolean a25=MartesFragment.button12Si;
        if(a25){
            valor12M="O";
        }

        boolean a26=MartesFragment.button13Si;
        if(a26){
            valor13M="O";
        }

        boolean a27=MartesFragment.button14Si;
        if(a27){
            valor14M="O";
        }

        boolean a28=MartesFragment.button15Si;
        if(a28){
            valor15M="O";
        }

        boolean a29=MartesFragment.button16Si;
        if(a29){
            valor16M="O";
        }

        boolean a210=MartesFragment.button17Si;
        if(a210){
            valor17M="O";
        }
        boolean a211=MartesFragment.button18Si;
        if(a211){
            valor18M="O";
        }

        boolean a212=MartesFragment.button19Si;
        if(a212){
            valor19M="O";
        }

        boolean a213=MartesFragment.button20Si;
        if(a213){
            valor20M="O";
        }

        boolean a214=MartesFragment.button21Si;
        if(a214){
            valor21M="O";
        }


        //Miercoles
        boolean a31=MiercolesFragment.button8Si;
        if(a31){
            valor8Mi="O";
        }

        boolean a32=MiercolesFragment.button9Si;
        if(a32){
            valor9Mi="O";
        }

        boolean a33=MiercolesFragment.button10Si;
        if(a33){
            valor10Mi="O";
        }

        boolean a34=MiercolesFragment.button11Si;
        if(a34){
            valor11Mi="O";
        }

        boolean a35=MiercolesFragment.button12Si;
        if(a35){
            valor12Mi="O";
        }

        boolean a36=MiercolesFragment.button13Si;
        if(a36){
            valor13Mi="O";
        }

        boolean a37=MiercolesFragment.button14Si;
        if(a37){
            valor14Mi="O";
        }

        boolean a38=MiercolesFragment.button15Si;
        if(a38){
            valor15Mi="O";
        }

        boolean a39=MiercolesFragment.button16Si;
        if(a39){
            valor16Mi="O";
        }

        boolean a310=MiercolesFragment.button17Si;
        if(a310){
            valor17Mi="O";
        }
        boolean a311=MiercolesFragment.button18Si;
        if(a311){
            valor18Mi="O";
        }

        boolean a312=MiercolesFragment.button19Si;
        if(a312){
            valor19Mi="O";
        }

        boolean a313=MiercolesFragment.button20Si;
        if(a313){
            valor20Mi="O";
        }

        boolean a314=MiercolesFragment.button21Si;
        if(a314){
            valor21Mi="O";
        }

        //Jueves
        boolean a41=JuevesFragment.button8Si;
        if(a41){
            valor8J="O";
        }

        boolean a42=JuevesFragment.button9Si;
        if(a42){
            valor9J="O";
        }

        boolean a43=JuevesFragment.button10Si;
        if(a43){
            valor10J="O";
        }

        boolean a44=JuevesFragment.button11Si;
        if(a44){
            valor11J="O";
        }

        boolean a45=JuevesFragment.button12Si;
        if(a45){
            valor12J="O";
        }

        boolean a46=JuevesFragment.button13Si;
        if(a46){
            valor13J="O";
        }

        boolean a47=JuevesFragment.button14Si;
        if(a47){
            valor14J="O";
        }

        boolean a48=JuevesFragment.button15Si;
        if(a48){
            valor15J="O";
        }

        boolean a49=JuevesFragment.button16Si;
        if(a49){
            valor16J="O";
        }

        boolean a410=JuevesFragment.button17Si;
        if(a410){
            valor17J="O";
        }
        boolean a411=JuevesFragment.button18Si;
        if(a411){
            valor18J="O";
        }

        boolean a412=JuevesFragment.button19Si;
        if(a412){
            valor19J="O";
        }

        boolean a413=JuevesFragment.button20Si;
        if(a413){
            valor20J="O";
        }

        boolean a414=JuevesFragment.button21Si;
        if(a414){
            valor21J="O";
        }


        //Viernes
        boolean a51=ViernesFragment.button8Si;
        if(a51){
            valor8V="O";
        }

        boolean a52=ViernesFragment.button9Si;
        if(a52){
            valor9V="O";
        }

        boolean a53=ViernesFragment.button10Si;
        if(a53){
            valor10V="O";
        }

        boolean a54=ViernesFragment.button11Si;
        if(a54){
            valor11V="O";
        }

        boolean a55=ViernesFragment.button12Si;
        if(a55){
            valor12V="O";
        }

        boolean a56=ViernesFragment.button13Si;
        if(a56){
            valor13V="O";
        }

        boolean a57=ViernesFragment.button14Si;
        if(a57){
            valor14V="O";
        }

        boolean a58=ViernesFragment.button15Si;
        if(a58){
            valor15V="O";
        }

        boolean a59=ViernesFragment.button16Si;
        if(a59){
            valor16V="O";
        }

        boolean a510=ViernesFragment.button17Si;
        if(a510){
            valor17V="O";
        }
        boolean a511=ViernesFragment.button18Si;
        if(a511){
            valor18V="O";
        }

        boolean a512=ViernesFragment.button19Si;
        if(a512){
            valor19V="19O";
        }

        boolean a513=ViernesFragment.button20Si;
        if(a513){
            valor20V="O";
        }

        boolean a514=ViernesFragment.button21Si;
        if(a514){
            valor21V="O";
        }



        //Sabado
        boolean a61=SabadoFragment.button8Si;
        if(a61){
            valor8S="O";
        }

        boolean a62=SabadoFragment.button9Si;
        if(a62){
            valor9S="O";
        }

        boolean a63=SabadoFragment.button10Si;
        if(a63){
            valor10S="O";
        }

        boolean a64=SabadoFragment.button11Si;
        if(a64){
            valor11S="O";
        }

        boolean a65=SabadoFragment.button12Si;
        if(a65){
            valor12S="O";
        }

        boolean a66=SabadoFragment.button13Si;
        if(a66){
            valor13S="O";
        }

        boolean a67=SabadoFragment.button14Si;
        if(a67){
            valor14S="O";
        }

        boolean a68=SabadoFragment.button15Si;
        if(a68){
            valor15S="O";
        }

        boolean a69=SabadoFragment.button16Si;
        if(a69){
            valor16S="O";
        }

        boolean a610=SabadoFragment.button17Si;
        if(a610){
            valor17S="O";
        }
        boolean a611=SabadoFragment.button18Si;
        if(a611){
            valor18S="O";
        }

        boolean a612=SabadoFragment.button19Si;
        if(a612){
            valor19S="O";
        }

        boolean a613=SabadoFragment.button20Si;
        if(a613){
            valor20S="O";
        }

        boolean a614=SabadoFragment.button21Si;
        if(a614){
            valor21S="O";
        }
    }
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void mostrarPDF(View v){
        generarPDF();
    }


    public void generarPDF(){
        pintarHoras();
        Document document=new Document(PageSize.A4);

        String tarjetaSD= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath().toString();
        Log.d("------------> ",tarjetaSD);
        File pdfDir = new File(tarjetaSD+File.separator+NOMBRE_CARPETA_APP);

        if(!pdfDir.exists()){
            pdfDir.mkdir();
        }

        File pdfSubDir = new File(pdfDir.getAbsolutePath()+File.separator+GENERADOS);
        if(!pdfSubDir.exists()){
            pdfSubDir.mkdir();
        }

        String nombre_completo = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath().toString()+File.separator+NOMBRE_CARPETA_APP+File.separator+GENERADOS+File.separator+NOMBRE_ARCHIVO;


        File outFile = new File(nombre_completo);
        if(outFile.exists()){
            outFile.delete();
        }


        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(nombre_completo));

            document.open();
            document.addAuthor("FISI");
            document.addCreator("FISI");
            document.addSubject("Constanciade de Registro de Disponibilidad Horaria Docente");
            document.addCreationDate();
            document.addTitle("Constancia");

            XMLWorkerHelper worker  = XMLWorkerHelper.getInstance();
           /*String htmlToPDF="<html>" +
                    "               <head></head>" +
                    "                 <body>" +
                    "                       <h1> Facultad de Ingenieria de Sistemas </h1>" +
                    "<h1> Reporte de registro</h1>"+
                    "<h2> Docente   : Virginia Vera Pomalaza</h2>"+
                    "<h2> Categoria : Principal - Tiempo Completo 40 horas</h2>"+
                    "<h2> Fecha de registro : 05/12/17</h2>"+
                    "<h2> N° horas registradas : 40</h2>"+
                    "<h2> Cursos registrados : </h2>"+
                    "                  </body>" +
                    "           </html>";
*/
            String htmlToPDF="<html>" +
                    "               <head><style>" +
                    "table, th, td {" +
                    "    border: 1px solid gray;" +
                    "    border-collapse: collapse;" +
                    "    vertical-align: center;"+
                    "}" +

                    "</style></head>" +
                    "                 <body>" +
                    "                       <h1 style=\"text-align: center\"> Facultad de Ingenieria de Sistemas </h1>" +
                    "<h1 style=\"text-align: center\"> Reporte de registro</h1>"+

                    "<table>" +
                    "   <tr>" +
                    "        <td><h3>Docente </h3></td>" +
                    "       <td><h3>"+docenteRecuperado.getNombres()+" "+docenteRecuperado.getApellidos()+"</h3></td> " +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td><h3>Categoria </h3></td>" +
                    "       <td><h3>"+docenteRecuperado.getCategoria()+" - "+docenteRecuperado.getClase()+" "+docenteRecuperado.getNum_horas()+" - horas</h3></td> " +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td><h3>Fecha de Registro </h3></td>" +
                    "       <td><h3>"+fecha+"</h3></td> " +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td><h3>N° de horas registradas </h3></td>" +
                    "       <td><h3> "+" " +docenteRecuperado.getNum_horas()+" horas"+"</h3></td> " +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td><h3>N° de cursos registrados</h3></td>" +
                    "       <td><h3> "+" " +docenteRecuperado.getCursosSeleccionados().size()+" cursos"+"</h3></td> " +
                    "   </tr>" +
                    "</table>"+
                    "<h3>Resumen detallado de las horas registradas</h3>" +
                    " <table style=\"width:100%;text-align: center; vertical-align: center;\">" +
                    "   <tr>" +
                    "        <td><h3>Hora</h3></td>" +
                    "        <td><h3>Lunes</h3></td>" +
                    "        <td><h3>Martes</h3></td>" +
                    "        <td><h3>Miercoles</h3></td>" +
                    "        <td><h3>Jueves</h3></td>" +
                    "        <td><h3>Viernes</h3></td>" +
                    "        <td><h3>Sabado</h3></td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>08 - 09</td>" +
                    "        <td>"+valor8L+"</td>" +
                    "        <td>"+valor8M+"</td>" +
                    "        <td>"+valor8Mi+"</td>" +
                    "        <td>"+valor8J+"</td>" +
                    "        <td>"+valor8V+"</td>" +
                    "        <td>"+valor8S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>09 - 10</td>" +
                    "        <td>"+valor9L+"</td>" +
                    "        <td>"+valor9M+"</td>" +
                    "        <td>"+valor9Mi+"</td>" +
                    "        <td>"+valor9J+"</td>" +
                    "        <td>"+valor9V+"</td>" +
                    "        <td>"+valor9S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>10 - 11</td>" +
                    "        <td>"+valor10L+"</td>" +
                    "        <td>"+valor10M+"</td>" +
                    "        <td>"+valor10Mi+"</td>" +
                    "        <td>"+valor10J+"</td>" +
                    "        <td>"+valor10V+"</td>" +
                    "        <td>"+valor10S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>11 - 12</td>" +
                    "        <td>"+valor11L+"</td>" +
                    "        <td>"+valor11M+"</td>" +
                    "        <td>"+valor11Mi+"</td>" +
                    "        <td>"+valor11J+"</td>" +
                    "        <td>"+valor11V+"</td>" +
                    "        <td>"+valor11S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>12 - 13</td>" +
                    "        <td>"+valor12L+"</td>" +
                    "        <td>"+valor12M+"</td>" +
                    "        <td>"+valor12Mi+"</td>" +
                    "        <td>"+valor12J+"</td>" +
                    "        <td>"+valor12V+"</td>" +
                    "        <td>"+valor12S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>13 - 14</td>" +
                    "        <td>"+valor13L+"</td>" +
                    "        <td>"+valor13M+"</td>" +
                    "        <td>"+valor13Mi+"</td>" +
                    "        <td>"+valor13J+"</td>" +
                    "        <td>"+valor13V+"</td>" +
                    "        <td>"+valor13S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>14 - 15</td>" +
                    "        <td>"+valor14L+"</td>" +
                    "        <td>"+valor14M+"</td>" +
                    "        <td>"+valor14Mi+"</td>" +
                    "        <td>"+valor14J+"</td>" +
                    "        <td>"+valor14V+"</td>" +
                    "        <td>"+valor14S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>15 - 16</td>" +
                    "        <td>"+valor15L+"</td>" +
                    "        <td>"+valor15M+"</td>" +
                    "        <td>"+valor15Mi+"</td>" +
                    "        <td>"+valor15J+"</td>" +
                    "        <td>"+valor15V+"</td>" +
                    "        <td>"+valor15S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>16 - 17</td>" +
                    "        <td>"+valor16L+"</td>" +
                    "        <td>"+valor16M+"</td>" +
                    "        <td>"+valor16Mi+"</td>" +
                    "        <td>"+valor16J+"</td>" +
                    "        <td>"+valor16V+"</td>" +
                    "        <td>"+valor16S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>17 - 18</td>" +
                    "        <td>"+valor17L+"</td>" +
                    "        <td>"+valor17M+"</td>" +
                    "        <td>"+valor17Mi+"</td>" +
                    "        <td>"+valor17J+"</td>" +
                    "        <td>"+valor17V+"</td>" +
                    "        <td>"+valor17S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>18 - 19</td>" +
                    "        <td>"+valor18L+"</td>" +
                    "        <td>"+valor18M+"</td>" +
                    "        <td>"+valor18Mi+"</td>" +
                    "        <td>"+valor18J+"</td>" +
                    "        <td>"+valor18V+"</td>" +
                    "        <td>"+valor18S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>19 - 20</td>" +
                    "        <td>"+valor19L+"</td>" +
                    "        <td>"+valor19M+"</td>" +
                    "        <td>"+valor19Mi+"</td>" +
                    "        <td>"+valor19J+"</td>" +
                    "        <td>"+valor19V+"</td>" +
                    "        <td>"+valor19S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>20 - 21</td>" +
                    "        <td>"+valor20L+"</td>" +
                    "        <td>"+valor20M+"</td>" +
                    "        <td>"+valor20Mi+"</td>" +
                    "        <td>"+valor20J+"</td>" +
                    "        <td>"+valor20V+"</td>" +
                    "        <td>"+valor20S+"</td>" +
                    "   </tr>" +
                    "   <tr>" +
                    "        <td>21 - 22</td>" +
                    "        <td>"+valor21L+"</td>" +
                    "        <td>"+valor21M+"</td>" +
                    "        <td>"+valor21Mi+"</td>" +
                    "        <td>"+valor21J+"</td>" +
                    "        <td>"+valor21V+"</td>" +
                    "        <td>"+valor21S+"</td>" +
                    "   </tr>" +
                    " </table>"+
                    "<h3>Resumen detallado de las horas registradas</h3>" +
                    " <table style=\"width:100%;text-align: center; vertical-align: center;\">" +
                    "   <tr>" +
                    "        <td><h3>N°</h3></td>" +
                    "        <td><h3>Nombre</h3></td>" +
                    "        <td><h3>Escuela</h3></td>" +
                    "   </tr>" +
                    cursos +
                    " </table>"+
                    "        </body>" +
                    "           </html>";
            String cursos="";
            int num=1;
            for(Curso c : docenteRecuperado.getCursosSeleccionados()){
                cursos=cursos+
                        "   <tr>" +
                        "        <td><h3> "+num+" </h3></td>" +
                        "        <td><h3>"+c.getNombre()+" </h3></td>" +
                        "        <td><h3>"+c.getEscuela()+"</h3></td>" +
                        "   </tr>" ;
                num++;
            }

            worker.parseXHtml(pdfWriter,document, new StringReader(htmlToPDF));

            document.close();

            Toast.makeText(this,"PDF GENERADO",Toast.LENGTH_LONG).show();
            muestraPDF(nombre_completo,this);


        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void muestraPDF(String archivo, Context context){
        Toast.makeText(context,"Leyendo el archivo",Toast.LENGTH_LONG).show();
        File file = new File(archivo);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),"application/pdf");
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);

        try{
            context.startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this,"No tiene una aplicacion para abrir este archivo",Toast.LENGTH_LONG).show();
        }
    }
}
