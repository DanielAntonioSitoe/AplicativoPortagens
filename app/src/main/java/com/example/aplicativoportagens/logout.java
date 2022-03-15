package com.example.aplicativoportagens;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aplicativoportagens.Controle.UsuarioDAO;
import com.example.aplicativoportagens.modelo.Usuario;

public class logout extends AppCompatActivity {
    Usuario usuario;
    UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnFragment3 = findViewById(R.id.login);
        btnFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                usuario = new Usuario(3,"Daniel",847464965,"Daniel","1234");
                TextView username = findViewById(R.id.usuario);
                TextView password = findViewById(R.id.senha);
                usuarioDAO = new UsuarioDAO();
                usuario = usuarioDAO.buscarUm(username.getText().toString(),password.getText().toString());
                Intent intent = new Intent(logout.this, MainActivity.class);
                intent.putExtra("id",usuario.getId());
                startActivity(intent);
            }
        });

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
