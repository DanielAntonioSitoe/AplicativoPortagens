package com.example.aplicativoportagens.ui.listarEquipamentos;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplicativoportagens.R;

public class EquipamentoItem extends Fragment {

    private EquipamentoItemViewModel mViewModel;

    public static EquipamentoItem newInstance() {
        return new EquipamentoItem();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.equipamento_item_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EquipamentoItemViewModel.class);
        // TODO: Use the ViewModel
    }

}
