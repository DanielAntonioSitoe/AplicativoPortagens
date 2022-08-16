package com.example.aplicativoportagens;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.aplicativoportagens.Controle.UsuarioDAO;
import com.example.aplicativoportagens.modelo.Turnos;

public class Login extends AppCompatActivity {
    Turnos turno;
    Boolean stop = false;
    UsuarioDAO usuarioDAO;
    TextView textError;
    TextView username;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        usuarioDAO = new UsuarioDAO();
        textError = findViewById(R.id.textViewError);
        username = findViewById(R.id.usuario);
        password = findViewById(R.id.senha);


        Button btnFragment3 = findViewById(R.id.login);
        btnFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turno = usuarioDAO.buscarUm(username.getText().toString(),password.getText().toString());
                runtimer();

            }
        });

    }

    private void runtimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(turno.getId()!=0){
                    if(!stop) {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra("nome", turno);
                        username.setText("");
                        password.setText("");
                        textError.setText("");
                        startActivity(intent);
                        stop=true;
                    }
                }else {
                    textError.setText("Falha, Verifique os Dados!");
//                    usuario = usuarioDAO.getBairro();
                    stop = false;
                }
                handler.postDelayed(this,1000);

            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
