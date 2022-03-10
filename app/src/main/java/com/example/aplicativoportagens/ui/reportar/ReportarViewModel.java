package com.example.aplicativoportagens.ui.reportar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReportarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReportarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Reportar Problemas  fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}