package unmsm.com.logingooglelap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExitoActivity extends AppCompatActivity {
    Button ini;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exito);
        ini = (Button)findViewById(R.id.buttonI);

        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(v.getContext() ,MainActivity .class);
                startActivity(intentReg);
            }
        });
    }
}
