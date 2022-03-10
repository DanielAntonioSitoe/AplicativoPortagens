package com.example.aplicativoportagens.ui.reportar;

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

public class ReportarFragment extends Fragment {

    private ReportarViewModel reportarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reportarViewModel =
                ViewModelProviders.of(this).get(ReportarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reportar, container, false);
//        final TextView textView = root.findViewById(R.id.text_reportar);
//        reportarViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}