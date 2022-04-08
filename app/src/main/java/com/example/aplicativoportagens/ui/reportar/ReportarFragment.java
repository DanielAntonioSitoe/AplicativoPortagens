package com.example.aplicativoportagens.ui.reportar;

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

import com.example.aplicativoportagens.Controle.EquipamentosDAO;
import com.example.aplicativoportagens.Controle.OcorenciasDAO;
import com.example.aplicativoportagens.Controle.SolicitacoesDAO;
import com.example.aplicativoportagens.MainActivity;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.BuscarEquipamentos;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Solicitacoes;
import com.example.aplicativoportagens.modelo.Usuario;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;

public class ReportarFragment extends Fragment {

    private ReportarViewModel reportarViewModel;
    private MainActivity mainActivity;
    private Usuario idUsuario;
    OcorenciasDAO ocorenciasDAO;
    Button button;
    EditText descricao;
    EditText observacao;
    EditText resolucao;
    private Date date;
    Ocorencias ocorencias;
    private EquipamentosDAO equipamentosDAO;
    private List<Equipamentos> equipamentosList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reportarViewModel =
                ViewModelProviders.of(this).get(ReportarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reportar, container, false);

        mainActivity = (MainActivity) getActivity();
        idUsuario = mainActivity.getIdUsuario();
        ocorenciasDAO = new OcorenciasDAO();

        button = root.findViewById(R.id.enviarProblema);
        descricao = root.findViewById(R.id.textProblemaDescricao);
        observacao = root.findViewById(R.id.textProblemaObservacao);
        resolucao = root.findViewById(R.id.textProblemaResolucao);
        equipamentosDAO = new EquipamentosDAO();
        equipamentosList = equipamentosDAO.buscarTodos();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descrica = descricao.getText().toString();
                String observaca = observacao.getText().toString();
                String resoluca = resolucao.getText().toString();
                date = new Date();
                Equipamentos equipamentos = equipamentosList.get(0);

                ocorencias  = new Ocorencias(0,"problema",descrica,"Pendente",observaca,resoluca,date,idUsuario,equipamentos);
                final Boolean salvo = ocorenciasDAO.salvar(ocorencias);
                descricao.setText("");
                observacao.setText("");
                resolucao.setText("");
                if(salvo) {
                    Snackbar.make(v, "Problema Enviado ", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }
}