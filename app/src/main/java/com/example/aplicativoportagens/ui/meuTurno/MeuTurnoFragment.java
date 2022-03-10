package com.example.aplicativoportagens.ui.meuTurno;

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

public class MeuTurnoFragment extends Fragment {

    private MeuTurnoViewModel meuTurnoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meuTurnoViewModel =
                ViewModelProviders.of(this).get(MeuTurnoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_meuturno, container, false);
        final TextView textView = root.findViewById(R.id.text_meuTurno);
        meuTurnoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}