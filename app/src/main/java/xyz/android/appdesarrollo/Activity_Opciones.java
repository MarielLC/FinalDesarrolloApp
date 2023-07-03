package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

public class Activity_Opciones extends AppCompatActivity {
    Button btn_op1;
    Button btn_op2;
    Button btn_op3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        //toolbar retroceder
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //boton 1 cambio de ventana - areas y perimetros
        btn_op1 =findViewById(R.id.btn_op1);
        btn_op1.setOnClickListener(view ->{
            CambiarVentana(Activity_AreayPerimetro.class);
        });

//boton 1 cambio de ventana - areas y perimetros
        btn_op2 =findViewById(R.id.btn_op2);
        btn_op2.setOnClickListener(view ->{
            CambiarVentana(activity_volumen.class);
        });

        //boton 3 cambio ventana- razones trigonometricas
        btn_op3 =findViewById(R.id.btn_op3);
        btn_op3.setOnClickListener(view ->{
            CambiarVentana(activity_razones_trig.class);
        });
    }
    //Clase Padre
    //toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    //Cambiar de ventana
    public void CambiarVentana( Class ventanaDestino){
        Intent i = new Intent(this,  ventanaDestino);
        startActivity(i);
    }

}