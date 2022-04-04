package com.example.aplicativoportagens.ui.minhasNotificacoes;

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
import com.example.aplicativoportagens.Controle.NotificacoesDAO;
import com.example.aplicativoportagens.R;
import com.example.aplicativoportagens.modelo.Notificacoes;
import com.example.aplicativoportagens.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class MinhasNotificacoesFragment extends Fragment {
    private List<Notificacoes> notificacoes;
    CustomAdapter customAdapter = new CustomAdapter();
    ListView listView;
    NotificacoesDAO notificacoesDAO;
    Intent intent;
    Usuario usuario;
    View root;
    private boolean stop;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.minhasnotificacoes, container, false);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        intent = getActivity().getIntent();
        notificacoesDAO = new NotificacoesDAO();
        notificacoes = new ArrayList<>();
        stop = false;
        usuario = (Usuario) intent.getSerializableExtra("nome");
        listView = root.findViewById(R.id.listviewNotificacoes);
        listView.setAdapter(customAdapter);
        notificacoes = notificacoesDAO.buscarTodos(usuario.getId());
        atualizarTabela();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Intent intent = getActivity().getIntent();
                intent.putExtra("tema", notificacoes.get(i).getTema());
                intent.putExtra("descricao", notificacoes.get(i).getDescricao());
                intent.putExtra("data", notificacoes.get(i).getData()+"");

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment,new VerNotificacaoFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return notificacoes.size();
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
            if(!notificacoes.get(i).getEstado().equalsIgnoreCase("visto")) {
                btnVista.setVisibility(View.VISIBLE);
            }
            TextView tema = view1.findViewById(R.id.notificacaoTema);
            TextView descricao = view1.findViewById(R.id.notificacaoDescricao);

            try {
                tema.setText(notificacoes.get(i).getTema().substring(0, 40) + "...");
            }catch (Exception e){
                tema.setText(notificacoes.get(i).getTema());
            }
            try {
                descricao.setText(notificacoes.get(i).getDescricao().substring(0, 50) + "...");
            }catch (Exception e){
                descricao.setText(notificacoes.get(i).getDescricao());
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
                    if (notificacoes.size() != 0) {
                        customAdapter.notifyDataSetChanged();
                        stop =true;
                    }
                }
                handler.postDelayed(this,1000);

            }
        });

    }


}