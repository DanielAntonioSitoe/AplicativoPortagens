package com.example.aplicativoportagens.ui.listarEquipamentos;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.aplicativoportagens.Controle.OcorenciasDAO;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.BuscarEquipamentos;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Usuario;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Date;

public class ListaEquipamentos extends Fragment {

    private ListaEquipamentosViewModel mViewModel;
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
    Date date;
    Usuario idUsuario;
    private Ocorencias ocorencia;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_equipamentos_fragment, container, false);
        this.view = view;
        try {
            a = getContext();
            ocorenciasDAO = new OcorenciasDAO();
            equipamentos = new Equipamentos();
            Intent intent = getActivity().getIntent();
            BuscarEquipamentos buscarEquipamentos = (BuscarEquipamentos) intent.getSerializableExtra("listaEquipamentos");
            cameras = (ArrayList<Equipamentos>) buscarEquipamentos.getListEquipamentos();
            listView = view.findViewById(R.id.listview);
            adapter = new ArrayAdapter<Equipamentos>(a, android.R.layout.simple_list_item_multiple_choice, cameras);
            listView.setAdapter(adapter);
            date = new Date();
            idUsuario = (Usuario) intent.getSerializableExtra("nome");
        }catch (Exception e){

        }
        return view;
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
        mViewModel = ViewModelProviders.of(this).get(ListaEquipamentosViewModel.class);
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

}
