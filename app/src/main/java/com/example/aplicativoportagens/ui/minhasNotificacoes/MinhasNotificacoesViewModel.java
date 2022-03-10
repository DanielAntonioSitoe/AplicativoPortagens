package com.example.aplicativoportagens.ui.minhasNotificacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MinhasNotificacoesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MinhasNotificacoesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Minhas Notificacoes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}