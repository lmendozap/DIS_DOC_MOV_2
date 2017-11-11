package unmsm.com.logingooglelap;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class RegistrarHorasActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    LunesFragment lunesFragment = new LunesFragment();
    MartesFragment martesFragment = new MartesFragment();
    MiercolesFragment miercolesFragment = new MiercolesFragment();
    JuevesFragment juevesFragment = new JuevesFragment();
    ViernesFragment viernesFragment = new ViernesFragment();
    SabadoFragment sabadoFragment = new SabadoFragment();

    private ViewPager mViewPager;
    static int horasTotales;
    private String dni;
    static int horasSeleccionadas;

    static Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_horas);
        horasTotales=(Integer)getIntent().getExtras().getInt("horas");
        dni=(String)getIntent().getExtras().get("dni");
        horasSeleccionadas=0;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Registro de Horas  :  "+horasSeleccionadas+"/"+horasTotales);
       
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());      
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(6);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(horasSeleccionadas==horasTotales){
                     Intent intent = new Intent(view.getContext(),ResumenHorasActivity.class);
                     intent.putExtra("dni",dni);
                     startActivityForResult(intent, 0);
                }else{
                    Toast toast1 = Toast.makeText(getApplicationContext(),
                            "Complete todas sus horas para continuar", Toast.LENGTH_SHORT);

                    toast1.show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_restart) {
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);
            mViewPager.setOffscreenPageLimit(6);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);
            horasSeleccionadas=0;
            toolbar.setTitle("Registro de Horas  :  "+horasSeleccionadas+"/"+horasTotales);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return lunesFragment;
                case 1:
                    return martesFragment;
                case 2:
                    return miercolesFragment;
                case 3:
                    return juevesFragment;
                case 4:
                    return viernesFragment;
                case 5:
                    return sabadoFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Lu";
                case 1:
                    return "Ma";
                case 2:
                    return "Mi";
                case 3:
                    return "Ju";
                case 4:
                    return "Vi";
                case 5:
                    return "Sa";
            }
            return null;
        }


    }

    public static void disminuirHoraSelecionada(){
        horasSeleccionadas=horasSeleccionadas-1;
        toolbar.setTitle("Registro de Horas  :  "+horasSeleccionadas+"/"+horasTotales);
    }

    public static void aumentarHoraSelecionada(){
        horasSeleccionadas=horasSeleccionadas+1;
        toolbar.setTitle("Registro de Horas  :  "+horasSeleccionadas+"/"+horasTotales);
    }
    
    public static void contarHoras(){
        if(LunesFragment.button8Si){ horasSeleccionadas++;  }
        if(LunesFragment.button9Si){ horasSeleccionadas++;  }
        if(LunesFragment.button10Si){ horasSeleccionadas++;  }
        if(LunesFragment.button11Si){ horasSeleccionadas++;  }
        if(LunesFragment.button12Si){ horasSeleccionadas++;  }
        if(LunesFragment.button13Si){ horasSeleccionadas++;  }
        if(LunesFragment.button14Si){ horasSeleccionadas++;  }
        if(LunesFragment.button15Si){ horasSeleccionadas++;  }
        if(LunesFragment.button16Si){ horasSeleccionadas++;  }
        if(LunesFragment.button17Si){ horasSeleccionadas++;  }
        if(LunesFragment.button18Si){ horasSeleccionadas++;  }
        if(LunesFragment.button19Si){ horasSeleccionadas++;  }
        if(LunesFragment.button20Si){ horasSeleccionadas++;  }
        if(LunesFragment.button21Si){ horasSeleccionadas++;  }


        if(MartesFragment.button8Si){ horasSeleccionadas++;  }
        if(MartesFragment.button9Si){ horasSeleccionadas++;  }
        if(MartesFragment.button10Si){ horasSeleccionadas++;  }
        if(MartesFragment.button11Si){ horasSeleccionadas++;  }
        if(MartesFragment.button12Si){ horasSeleccionadas++;  }
        if(MartesFragment.button13Si){ horasSeleccionadas++;  }
        if(MartesFragment.button14Si){ horasSeleccionadas++;  }
        if(MartesFragment.button15Si){ horasSeleccionadas++;  }
        if(MartesFragment.button16Si){ horasSeleccionadas++;  }
        if(MartesFragment.button17Si){ horasSeleccionadas++;  }
        if(MartesFragment.button18Si){ horasSeleccionadas++;  }
        if(MartesFragment.button19Si){ horasSeleccionadas++;  }
        if(MartesFragment.button20Si){ horasSeleccionadas++;  }
        if(MartesFragment.button21Si){ horasSeleccionadas++;  }

        if(MiercolesFragment.button8Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button9Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button10Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button11Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button12Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button13Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button14Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button15Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button16Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button17Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button18Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button19Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button20Si){ horasSeleccionadas++;  }
        if(MiercolesFragment.button21Si){ horasSeleccionadas++;  }

        if(JuevesFragment.button8Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button9Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button10Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button11Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button12Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button13Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button14Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button15Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button16Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button17Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button18Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button19Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button20Si){ horasSeleccionadas++;  }
        if(JuevesFragment.button21Si){ horasSeleccionadas++;  }

        if(ViernesFragment.button8Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button9Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button10Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button11Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button12Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button13Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button14Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button15Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button16Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button17Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button18Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button19Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button20Si){ horasSeleccionadas++;  }
        if(ViernesFragment.button21Si){ horasSeleccionadas++;  }

        if(SabadoFragment.button8Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button9Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button10Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button11Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button12Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button13Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button14Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button15Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button16Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button17Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button18Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button19Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button20Si){ horasSeleccionadas++;  }
        if(SabadoFragment.button21Si){ horasSeleccionadas++;  }





    }
}
