package com.example.aplicativoportagens.ui.monitorar;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aplicativoportagens.Controle.EquipamentosDAO;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.BuscarEquipamentos;
import com.example.aplicativoportagens.ui.listarEquipamentos.ListaEquipamentos;

public class salas extends Fragment implements View.OnClickListener {

    EquipamentosDAO equipamentosDAO;
    BuscarEquipamentos buscarEquipamentos;
    private boolean stop = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.salas_fragment, container, false);
        Button btnFragment1 = view.findViewById(R.id.salaControle);
        Button btnFragment2 = view.findViewById(R.id.salaServidor);
        btnFragment1.setOnClickListener(this);
        btnFragment2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        equipamentosDAO = new EquipamentosDAO();
        buscarEquipamentos = new BuscarEquipamentos();
        buscarEquipamentos.setListEquipamentos(equipamentosDAO.buscarTodos());
        runtimer();
        if(stop) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ListaEquipamentos listar = new ListaEquipamentos();
            switch (v.getId()) {
                case R.id.salaControle:
                    listar.setTela("Sala de Monitoramento");
                    ft.replace(R.id.nav_host_fragment, listar);
                    break;
                case R.id.salaServidor:
                    listar.setTela("Sala de Servidor");
                    ft.replace(R.id.nav_host_fragment, listar);
                    break;
            }
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    private Boolean runtimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(buscarEquipamentos.getListEquipamentos()!=null){
                    if(!stop) {
                        stop=true;
                        Intent intent = getActivity().getIntent();
                        intent.putExtra("listaEquipamentos", buscarEquipamentos);
                    }
                }else {
                    stop = false;
                }
                handler.postDelayed(this,1000);

            }
        });

        return stop;
    }
}
