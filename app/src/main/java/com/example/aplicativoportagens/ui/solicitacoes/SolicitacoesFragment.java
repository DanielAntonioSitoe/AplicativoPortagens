package com.example.aplicativoportagens.ui.solicitacoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.aplicativoportagens.Controle.SolicitacoesDAO;
import com.example.aplicativoportagens.MainActivity;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.logout;
import com.example.aplicativoportagens.modelo.Solicitacoes;
import com.example.aplicativoportagens.modelo.Usuario;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class SolicitacoesFragment extends Fragment {

    private SolicitacoesViewModel solicitacoesViewModel;
    Button button;
    EditText editText;
    Solicitacoes solicitacoes;
    Date date;
    MainActivity mainActivity;
    SolicitacoesDAO solicitacoesDAO;
    Usuario idUsuario;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        solicitacoesViewModel =
                ViewModelProviders.of(this).get(SolicitacoesViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_solicitacoes, container, false);
//        final TextView textView = root.findViewById(R.id.text_share);
//        solicitacoesViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        mainActivity = (MainActivity) getActivity();
        idUsuario = mainActivity.getIdUsuario();
        solicitacoesDAO = new SolicitacoesDAO();

        button = root.findViewById(R.id.enviarSolicitacao);
        editText = root.findViewById(R.id.textInputDescricao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editText.getText().toString();
                date = new Date();
                solicitacoes  = new Solicitacoes(0,texto,"pendente", date,idUsuario);
                final Boolean salvo = solicitacoesDAO.salvar(solicitacoes);
                if(salvo) {
                    Snackbar.make(v, "Usuario: "+idUsuario.getNome() + " Texto " + texto+" Estado: "+solicitacoes.getEstado(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
        return root;
    }
}