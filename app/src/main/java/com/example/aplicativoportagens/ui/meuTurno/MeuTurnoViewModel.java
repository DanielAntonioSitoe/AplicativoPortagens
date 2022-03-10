package com.example.aplicativoportagens.ui.meuTurno;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeuTurnoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MeuTurnoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Meu Turno fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}