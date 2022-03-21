package com.example.aplicativoportagens.ui.listarEquipamentos;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.aplicativoportagens.Controle.EquipamentosDAO;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ListaEquipamentos extends Fragment {

    private ListaEquipamentosViewModel mViewModel;
    ListView listView;
    View view;
    String tela;
    int size = 12;
    ArrayAdapter<Equipamentos> adapter;
    ArrayList<Equipamentos> cameras;
//            = {"camera1","camera2","camera3","camera4","camera5","camera6","camera7","camera8","camera9","camera10","camera11","camera12"};
    Boolean[] selecionados = {false,false,false,false,false,false,false,false,false,false,false,false};
    EquipamentosDAO equipamentosDAO = new EquipamentosDAO();
    List<Equipamentos> ListaDeEquipamentos = null;
    Button enviarCheckList;
    private Context a;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_equipamentos_fragment, container, false);


        this.view = view;
        a=getContext();
        runtimer();
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
                String itemSelected = "Selecionados: \n";
                for (int i = 0; i < cameras.size(); i++) {
                    if(listView.isItemChecked(i)){
                        itemSelected+= listView.getItemAtPosition(i)+"\n";
                    }
                }
                Snackbar.make(v,itemSelected,Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private Boolean runtimer(){
        final Handler handler = new Handler();
        ListaDeEquipamentos = equipamentosDAO.buscarTodos();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(ListaDeEquipamentos !=null){
                    int size = ListaDeEquipamentos.size();
                    cameras = new ArrayList<Equipamentos>(size);
                    for (int i = 0; i < size; i++) {
                        cameras.add(ListaDeEquipamentos.get(i));
                    }
                    listView = view.findViewById(R.id.listview);
                    adapter = new ArrayAdapter<Equipamentos>(a,android.R.layout.simple_list_item_multiple_choice,cameras);
                    listView.setAdapter(adapter);

                }
                handler.postDelayed(this,1000);

            }
        });

        return null;
    }


}
