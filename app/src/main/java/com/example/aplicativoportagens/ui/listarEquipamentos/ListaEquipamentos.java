package com.example.aplicativoportagens.ui.listarEquipamentos;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplicativoportagens.Controle.EquipamentosDAO;
import com.example.aplicativoportagens.MainActivity;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.logout;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ListaEquipamentos extends Fragment {

    private ListaEquipamentosViewModel mViewModel;
    CustomAdapter customAdapter = new CustomAdapter();
    ListView listView;
    String tela;
    int size = 12;
    ArrayAdapter<String> adapter;
    String[] cameras = {"camera1","camera2","camera3","camera4","camera5","camera6","camera7","camera8","camera9","camera10","camera11","camera12"};
    Boolean[] selecionados = {false,false,false,false,false,false,false,false,false,false,false,false};
    EquipamentosDAO equipamentosDAO = new EquipamentosDAO();
    List<Equipamentos> bairros = null;
    Button enviarCheckList;



    public static ListaEquipamentos newInstance() {
        return new ListaEquipamentos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_equipamentos_fragment, container, false);
        listView = view.findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_multiple_choice,cameras);
        listView.setAdapter(adapter);

        return view;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
//        bairros = equipamentosDAO.buscarPorLocalizacao(tela);
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

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                CheckBox checkBox = view.findViewById(R.id.checkBox);
//                int po = position;
//                listView.setItemChecked(po,true);
////                if(checkBox.isChecked()){
////                Toast.makeText(getContext(),"Selected: "+po,Toast.LENGTH_SHORT).show();
////                    selecionados[po]=true;
////                    Snackbar.make(view,"Selected: "+po,Snackbar.LENGTH_LONG).show();
////                }else {
////                    Toast.makeText(getContext(),"Clicked: "+position,Toast.LENGTH_SHORT).show();
////                Snackbar.make(view,"Clicked: "+po,Snackbar.LENGTH_LONG).show();
////                    checkBox.setChecked(true);
////                }
//            }
//        });

        enviarCheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemSelected = "Selecionados: \n";
                for (int i = 0; i < cameras.length; i++) {
                    if(listView.isItemChecked(i)){
                        itemSelected+= listView.getItemAtPosition(i)+"\n";
                    }

                }
                Snackbar.make(v,itemSelected,Snackbar.LENGTH_LONG).show();

            }
        });
    }

    //    Classe Usada para preencher a lista de cidades na tela principal
    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //  preenche dados de uma cidade como um item da lista
        //
        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.equipamento_item_fragment,null);
            TextView tempAtual = view1.findViewById(R.id.tempAtual);
            TextView nomeCidade = view1.findViewById(R.id.nomeCidade);
//            tempAtual.setText(bairros.get(i).getDescricao());
//            nomeCidade.setText(bairros.get(i).getLocalizacao());
            tempAtual.setText(tela);
            nomeCidade.setText("Testando");
            return view1;


        }
    }

}
