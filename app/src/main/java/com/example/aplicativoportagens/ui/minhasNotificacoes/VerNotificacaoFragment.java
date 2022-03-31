package com.example.aplicativoportagens.ui.minhasNotificacoes;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.aplicativoportagens.R;

public class VerNotificacaoFragment extends Fragment{
    TextView tema;
    TextView descricao;
    TextView data;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.notificacao_fragment, container, false);

        tema = root.findViewById(R.id.textViewTitulo);
        descricao = root.findViewById(R.id.textViewDescricao);
        data = root.findViewById(R.id.textViewData);
        Intent intent = getActivity().getIntent();
        tema.setText(intent.getStringExtra("tema"));
        descricao.setText(intent.getStringExtra("descricao"));
        data.setText(intent.getStringExtra("data"));

        return root;
    }


}
