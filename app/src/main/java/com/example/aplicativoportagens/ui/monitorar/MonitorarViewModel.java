package com.example.aplicativoportagens.ui.monitorar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aplicativoportagens.R;

public class MonitorarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MonitorarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Monitorar Equipamentos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
//    public void salas(@NonNull LayoutInflater inflater,
//                      ViewGroup container, Bundle savedInstanceState){
//        View root = inflater.inflate(R.layout.salas_fragment, container, false);
//    }
}