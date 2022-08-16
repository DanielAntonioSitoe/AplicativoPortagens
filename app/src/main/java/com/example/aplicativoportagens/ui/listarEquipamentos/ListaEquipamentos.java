package com.example.aplicativoportagens.ui.listarEquipamentos;
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
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Turnos;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Date;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ListaEquipamentos extends Fragment {
    ListView listView;
    View view;
    String tela;
    int size = 12;
    ArrayAdapter<Equipamentos> equipamentosArrayAdapter;
    ArrayList<Equipamentos> equipamentos1;
    Button enviarCheckList;
    private Context a;
    OcorenciasDAO ocorenciasDAO;
    Equipamentos equipamentos;
    EquipamentosDAO equipamentosDAO;
    Date date;
    Turnos turnos;
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
        stop = false;
        try {
        a = getContext();
        ocorenciasDAO = new OcorenciasDAO();
        equipamentos = new Equipamentos();
        Intent intent = getActivity().getIntent();
        listView = view.findViewById(R.id.listview);
        equipamentosDAO = new EquipamentosDAO();
        turnos = (Turnos) intent.getSerializableExtra("nome");
        equipamentos1 = (ArrayList<Equipamentos>) equipamentosDAO.buscarTodos(tela, turnos.getPortagem().getId());
        equipamentosArrayAdapter = new ArrayAdapter<Equipamentos>(a, android.R.layout.simple_list_item_multiple_choice, equipamentos1);
        listView.setAdapter(equipamentosArrayAdapter);
        date = new Date();
        atualizarTabela();
        }catch (Exception e){
            Log.e(TAG,e.getMessage());

        }
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
                    for (int i = 0; i < equipamentos1.size(); i++) {
                        equipamentos = (Equipamentos) listView.getItemAtPosition(i);
                        if (listView.isItemChecked(i)) {
                            ocorencia = new Ocorencias(0, "checklist"
                                    , "null", "Activo", "null"
                                    , "null", date, turnos.getUsuario(), equipamentos);
                            ocorenciasDAO.salvar(ocorencia);

                        } else {
                            ocorencia = new Ocorencias(0, "checklist"
                                    , "null", "Inactivo", "null"
                                    , "null", date, turnos.getUsuario(), equipamentos);
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
                    if (equipamentos1.size() != 0) {
                        equipamentosArrayAdapter.notifyDataSetChanged();
                        stop = true;
                    }
                }
                handler.postDelayed(this,1000);

            }
        });

    }

}
