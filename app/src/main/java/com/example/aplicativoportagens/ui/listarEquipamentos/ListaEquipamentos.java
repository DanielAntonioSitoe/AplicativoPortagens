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
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.BuscarEquipamentos;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

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


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_equipamentos_fragment, container, false);
        this.view = view;
        a=getContext();
        Intent intent = getActivity().getIntent();
        BuscarEquipamentos buscarEquipamentos = (BuscarEquipamentos) intent.getSerializableExtra("listaEquipamentos");
        cameras = (ArrayList<Equipamentos>) buscarEquipamentos.getListEquipamentos();
        listView = view.findViewById(R.id.listview);
        adapter = new ArrayAdapter<Equipamentos>(a,android.R.layout.simple_list_item_multiple_choice,cameras);
        listView.setAdapter(adapter);
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

}
