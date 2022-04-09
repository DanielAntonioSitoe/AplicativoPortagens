package com.example.aplicativoportagens.ui.meuTurno;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.aplicativoportagens.Controle.NotificacoesDAO;
import com.example.aplicativoportagens.Controle.PortagemDAO;
import com.example.aplicativoportagens.Controle.TurnosDAO;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.Portagem;
import com.example.aplicativoportagens.modelo.Turnos;
import com.example.aplicativoportagens.modelo.Usuario;
import com.example.aplicativoportagens.ui.minhasNotificacoes.VerNotificacaoFragment;

import java.util.ArrayList;
import java.util.List;

public class MeuTurnoFragment extends Fragment {
    private List<Turnos> turnos;
    CustomAdapter customAdapter = new CustomAdapter();
    ListView listView;
    TurnosDAO turnosDAO;
    Intent intent;
    Usuario usuario;
    View root;
    private boolean stop;
    PortagemDAO portagemDAO = new PortagemDAO();
    Portagem portagem;
    List<Portagem> portagens;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_meuturno, container, false);
        return root;
    }
    @Override
    public void onResume() {
        super.onResume();
        intent = getActivity().getIntent();
        turnosDAO = new TurnosDAO();
        turnos = new ArrayList<>();
        stop = false;
        usuario = (Usuario) intent.getSerializableExtra("nome");
        listView = root.findViewById(R.id.listviewTurnos);
        listView.setAdapter(customAdapter);
        turnos = turnosDAO.buscarTodos(usuario.getId());
        portagens = portagemDAO.buscarTodos();
        atualizarTabela();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.nav_host_fragment,new VerNotificacaoFragment());
//                ft.addToBackStack(null);
//                ft.commit();
//            }
//        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return turnos.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.equipamento_item_fragment,null);
            RelativeLayout relativeLayout = view1.findViewById(R.id.listviewdata);
            TextView btnVista = view1.findViewById(R.id.estadoNotificacao);
            btnVista.setVisibility(View.INVISIBLE);
            TextView tema = view1.findViewById(R.id.notificacaoTema);
            TextView descricao = view1.findViewById(R.id.notificacaoDescricao);

            try {
                tema.setText("Dia: "+turnos.get(i).getData_inicio().substring(0, 11) +"    Hora: "+ turnos.get(i).getHora_entrada_saida());
            }catch (Exception e){
                tema.setText(turnos.get(i).getData_inicio() + turnos.get(i).getHora_entrada_saida());
            }
            try {
                for (int j = 0; j < portagens.size(); j++) {
                    portagem =portagens.get(j);
                    if(portagem.getId()==Integer.parseInt(turnos.get(i).getPortagem())){
                        descricao.setText("Portagem:  "+portagem.getNome());
                    }
                }
            }catch (Exception e){
            }
            return view1;
        }
    }

    private void atualizarTabela(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(!stop) {
                    if (turnos.size() != 0) {
                        customAdapter.notifyDataSetChanged();
                        stop =true;
                    }
                }
                handler.postDelayed(this,1000);

            }
        });

    }

}