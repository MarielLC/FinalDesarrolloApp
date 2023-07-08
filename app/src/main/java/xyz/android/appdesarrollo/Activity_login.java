package xyz.android.appdesarrollo;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_login extends AppCompatActivity {
    TextView txt_nombre_log, txt_correo_log, txt_contraseña_log;
    Button btn_logearse;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView irARegistrarse;

    //verificar si el usuario ya accedio
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent  i=new Intent(getApplicationContext(), Activity_Opciones.class);
            startActivity(i);
            finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        //txt_nombre_log =findViewById(R.id.txt_nombres);
        txt_correo_log=findViewById(R.id.txt_correo);
        txt_contraseña_log=findViewById(R.id.txt_contrasena);
        btn_logearse=findViewById(R.id.btn_logearse);
        progressBar=findViewById(R.id.progressBar);
        irARegistrarse=findViewById(R.id.btn_crear_cuenta);

        irARegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistrar();
            }
        });

        btn_logearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email= String.valueOf(txt_correo_log.getText());
                password=String.valueOf(txt_contraseña_log.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Activity_login.this, "Ingrese email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Activity_login.this, "Ingrese contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Acceso permitido", Toast.LENGTH_SHORT).show();
                                    Intent  i=new Intent(getApplicationContext(), Activity_Opciones.class);
                                    startActivity(i);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Activity_login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });



    }

    public void irRegistrar(){
        Intent i = new Intent(this, Activity_registrarse.class);
        startActivity(i);
        finish();
    }
}