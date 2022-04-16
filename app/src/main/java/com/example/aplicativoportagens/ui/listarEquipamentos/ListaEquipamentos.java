package com.example.aplicativoportagens.ui.listarEquipamentos;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.aplicativoportagens.Controle.EquipamentosDAO;
import com.example.aplicativoportagens.Controle.OcorenciasDAO;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.BuscarEquipamentos;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Usuario;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ListaEquipamentos extends Fragment {
    ListView listView;
    View view;
    String tela;
    int size = 12;
    ArrayAdapter<Equipamentos> adapter;
    ArrayList<Equipamentos> cameras;
    Button enviarCheckList;
    private Context a;
    OcorenciasDAO ocorenciasDAO;
    Equipamentos equipamentos;
    EquipamentosDAO equipamentosDAO;
    Date date;
    Usuario idUsuario;
    private Ocorencias ocorencia;
    private boolean stop = false;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_equipamentos_fragment, container, false);
        this.view = view;
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        try {
        a = getContext();
        ocorenciasDAO = new OcorenciasDAO();
        equipamentos = new Equipamentos();
        Intent intent = getActivity().getIntent();
        listView = view.findViewById(R.id.listview);
        equipamentosDAO = new EquipamentosDAO();
        cameras = (ArrayList<Equipamentos>) equipamentosDAO.buscarTodos(tela,4);
        adapter = new ArrayAdapter<Equipamentos>(a, android.R.layout.simple_list_item_multiple_choice, cameras);
        listView.setAdapter(adapter);
        date = new Date();
        idUsuario = (Usuario) intent.getSerializableExtra("nome");
        atualizarTabela();
        }catch (Exception e){
            Log.e(TAG,e.getMessage());

        }
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        enviarCheckList = view.findViewById(R.id.enviarCheckList);
        enviarCheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String itemSelected = "Selecionados: \n";
                    for (int i = 0; i < cameras.size(); i++) {
                        equipamentos = (Equipamentos) listView.getItemAtPosition(i);
                        if (listView.isItemChecked(i)) {
                            ocorencia = new Ocorencias(0, "checklist"
                                    , "null", "Activo", "null"
                                    , "null", date, idUsuario, equipamentos);
                            ocorenciasDAO.salvar(ocorencia);

                        } else {
                            ocorencia = new Ocorencias(0, "checklist"
                                    , "null", "Inactivo", "null"
                                    , "null", date, idUsuario, equipamentos);
                            ocorenciasDAO.salvar(ocorencia);
                        }
                    }
                    Snackbar.make(v, "ChecList Enviado", Snackbar.LENGTH_LONG).show();
                }catch (Exception e){

                }
            }
        });
    }


    private void atualizarTabela(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(!stop) {
                    if (cameras.size() != 0) {
                        adapter.notifyDataSetChanged();
                        stop = true;
                    }
                }
                handler.postDelayed(this,1000);

            }
        });

    }

}
