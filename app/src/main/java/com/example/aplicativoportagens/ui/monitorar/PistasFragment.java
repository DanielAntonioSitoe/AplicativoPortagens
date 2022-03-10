package com.example.aplicativoportagens.ui.monitorar;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.ui.listarEquipamentos.ListaEquipamentos;

public class PistasFragment extends Fragment implements View.OnClickListener {

    private PistasViewModel mViewModel;

    public static PistasFragment newInstance() {
        return new PistasFragment();
    }

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
        mViewModel = ViewModelProviders.of(this).get(PistasViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ListaEquipamentos listar = new ListaEquipamentos();
        switch (v.getId()){
            case R.id.pista1:listar.setTela("pista1");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista2:listar.setTela("pista2");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista3:listar.setTela("pista3");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista4:listar.setTela("pista4");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista5:listar.setTela("pista5");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista6:listar.setTela("pista6");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista7:listar.setTela("pista7");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista8:listar.setTela("pista8");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista9:listar.setTela("pista9");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista10:listar.setTela("pista10");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista11:listar.setTela("pista11");ft.replace(R.id.nav_host_fragment,listar);break;
            case R.id.pista12:listar.setTela("pista12");ft.replace(R.id.nav_host_fragment,listar);break;
        }
        ft.addToBackStack(null);
        ft.commit();
    }
}
