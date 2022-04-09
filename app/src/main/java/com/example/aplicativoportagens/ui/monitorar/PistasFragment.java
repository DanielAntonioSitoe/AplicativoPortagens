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

public class PistasFragment extends Fragment implements View.OnClickListener {

    EquipamentosDAO equipamentosDAO;
    BuscarEquipamentos buscarEquipamentos;
    private boolean stop = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pistas_fragment, container, false);
        Button btnFragment1 = view.findViewById(R.id.pista1);
        Button btnFragment2 = view.findViewById(R.id.pista2);
        Button btnFragment3 = view.findViewById(R.id.pista3);
        Button btnFragment4 = view.findViewById(R.id.pista4);
        Button btnFragment5 = view.findViewById(R.id.pista5);
        Button btnFragment6 = view.findViewById(R.id.pista6);
        Button btnFragment7 = view.findViewById(R.id.pista7);
        Button btnFragment8 = view.findViewById(R.id.pista8);
        Button btnFragment9 = view.findViewById(R.id.pista9);
        Button btnFragment10 = view.findViewById(R.id.pista10);
        Button btnFragment11 = view.findViewById(R.id.pista11);
        Button btnFragment12 = view.findViewById(R.id.pista12);
        btnFragment1.setOnClickListener(this);
        btnFragment2.setOnClickListener(this);
        btnFragment3.setOnClickListener(this);
        btnFragment4.setOnClickListener(this);
        btnFragment5.setOnClickListener(this);
        btnFragment6.setOnClickListener(this);
        btnFragment7.setOnClickListener(this);
        btnFragment8.setOnClickListener(this);
        btnFragment9.setOnClickListener(this);
        btnFragment10.setOnClickListener(this);
        btnFragment11.setOnClickListener(this);
        btnFragment12.setOnClickListener(this);

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
        if(stop){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ListaEquipamentos listar = new ListaEquipamentos();
        switch (v.getId()){
            case R.id.pista1:listar.setTela("pista 1");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista2:listar.setTela("pista 2");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista3:listar.setTela("pista 3");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista4:listar.setTela("pista 4");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista5:listar.setTela("pista 5");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista6:listar.setTela("pista 6");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista7:listar.setTela("pista 7");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista8:listar.setTela("pista 8");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista9:listar.setTela("pista 9");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista10:listar.setTela("pista 10");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista11:listar.setTela("pista 11");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista12:listar.setTela("pista 12");ft.replace(R.id.nav_host_fragment,listar);break;
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
