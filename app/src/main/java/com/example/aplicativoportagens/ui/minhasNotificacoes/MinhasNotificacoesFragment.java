package com.example.aplicativoportagens.ui.minhasNotificacoes;

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

public class MinhasNotificacoesFragment extends Fragment {

    private MinhasNotificacoesViewModel minhasNotificacoesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        minhasNotificacoesViewModel =
                ViewModelProviders.of(this).get(MinhasNotificacoesViewModel.class);
        View root = inflater.inflate(R.layout.minhasnotificacoes, container, false);
        final TextView textView = root.findViewById(R.id.text_minhasNotificacoes);
        minhasNotificacoesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}