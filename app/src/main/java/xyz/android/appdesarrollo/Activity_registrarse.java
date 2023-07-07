package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Activity_registrarse extends AppCompatActivity {
   /* TextView txt_reg_logearse;
    TextInputEditText txt_correo_registrarse;
    TextInputEditText txt_contrasena_registrarse;
    TextInputEditText txt_contrasena_confirmacion;
    Button btn_registrarse;
    EditText txtplain;
    private String userId;
    private FirebaseAuth mAuth;

    private FirebaseFirestore  db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        txt_reg_logearse = findViewById(R.id.txt_reg_logearse);
        txt_correo_registrarse = findViewById(R.id.txt_correo_registrarse);
        txt_contrasena_registrarse = findViewById(R.id.txt_contrasena_registrarse);
        txt_contrasena_confirmacion = findViewById(R.id.txt_contrasena_confirmacion);
        btn_registrarse = findViewById(R.id.btn_registrarse);

        txtplain = findViewById(R.id.txtplain);
        db = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
        txt_reg_logearse.setOnClickListener(view -> {
            irLogear();
        });

        btn_registrarse.setOnClickListener(view ->{
            createuser();
        });
    }

    public void irLogear() {
        Intent i = new Intent(this, Activity_login.class);
        startActivity(i);
    }


    public void createuser(){
       String correoUser = txtplain.getText().toString();
        String constrasenaUser = txt_contrasena_registrarse.getText().toString();
        String constrasenaConfirmacionUser = txt_contrasena_confirmacion.getText().toString();

        if(TextUtils.isEmpty(correoUser)){
            txtplain.setError("Ingrese un correo");
            txtplain.requestFocus();
        }else if(TextUtils.isEmpty(constrasenaUser)){
            txt_contrasena_registrarse.setError("Ingrese una contraseña");
            txt_contrasena_registrarse.requestFocus();
        }else if (TextUtils.isEmpty(constrasenaConfirmacionUser)) {
            txt_contrasena_confirmacion.setError("Ingrese un correo");
            txt_contrasena_confirmacion.requestFocus();

        }else{
            mAuth.createUserWithEmailAndPassword(correoUser,constrasenaUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        userId = mAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = db.collection("users").document(userId);

                        Map<String,Object> user= new HashMap<>();
                        user.put("Correo", correoUser);
                        user.put("Contraseña", constrasenaUser);
                        user.put("Confirmación contraseña", constrasenaConfirmacionUser);

                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d("TAG", "onSuccess: Datos Registrados"+userId);
                            }
                        });
                        Toast.makeText(Activity_registrarse.this, "usuario registrado", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Activity_registrarse.this, Activity_login.class));

                    }else{
                        Toast.makeText(Activity_registrarse.this, "usuario No registrado"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }*/
}