package xyz.android.appdesarrollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Activity_registrarse extends AppCompatActivity {
    TextView txt_reg_logearse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        txt_reg_logearse =findViewById(R.id.txt_reg_logearse);

        txt_reg_logearse.setOnClickListener(view ->{
            irLogear();
        });
    }

    public void irLogear(){
        Intent i = new Intent(this, Activity_login.class);
        startActivity(i);
    }
}