package com.example.aplicativoportagens.ui.solicitacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SolicitacoesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SolicitacoesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Solicitacoes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}