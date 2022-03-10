package com.example.aplicativoportagens.ui.solicitacoes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.aplicativoportagens.R;

public class SolicitacoesFragment extends Fragment {

    private SolicitacoesViewModel solicitacoesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        solicitacoesViewModel =
                ViewModelProviders.of(this).get(SolicitacoesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_solicitacoes, container, false);
//        final TextView textView = root.findViewById(R.id.text_share);
//        solicitacoesViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}