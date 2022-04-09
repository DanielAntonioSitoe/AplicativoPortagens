package com.example.aplicativoportagens.ui.monitorar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.example.aplicativoportagens.Controle.EquipamentosDAO;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.BuscarEquipamentos;
import com.example.aplicativoportagens.ui.listarEquipamentos.ListaEquipamentos;

public class MonitorarFragment extends Fragment {

    EquipamentosDAO equipamentosDAO;
    BuscarEquipamentos buscarEquipamentos;
    private boolean stop = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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
                equipamentosDAO = new EquipamentosDAO();
                buscarEquipamentos = new BuscarEquipamentos();
                buscarEquipamentos.setListEquipamentos(equipamentosDAO.buscarTodos());
                runtimer();
                if(stop) {
                    ListaEquipamentos listar = new ListaEquipamentos();
                    listar.setTela("Outras");
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.nav_host_fragment, listar);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });




        return view;
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