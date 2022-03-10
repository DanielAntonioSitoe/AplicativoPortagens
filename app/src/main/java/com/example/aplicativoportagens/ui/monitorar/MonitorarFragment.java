package com.example.aplicativoportagens.ui.monitorar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.aplicativoportagens.MainActivity;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.ui.listarEquipamentos.ListaEquipamentos;

public class MonitorarFragment extends Fragment {

    private MonitorarViewModel monitorarViewModel;

    private SalasViewModel salasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        monitorarViewModel =
                ViewModelProviders.of(this).get(MonitorarViewModel.class);
        View view = inflater.inflate(R.layout.fragment_monitorar, container, false);
        Button btnFragment = view.findViewById(R.id.salas);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment,new salas());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        Button btnFragment2 = view.findViewById(R.id.cabines);
        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment,new CabinesFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        Button btnFragment3 = view.findViewById(R.id.pistas);
        btnFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment,new PistasFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        Button btnFragment4 = view.findViewById(R.id.outros);
        btnFragment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaEquipamentos listar = new ListaEquipamentos();
                listar.setTela("Outros");
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment,listar);
                ft.addToBackStack(null);
                ft.commit();
            }
        });




        return view;
    }

}