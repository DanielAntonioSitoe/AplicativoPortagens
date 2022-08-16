package com.example.aplicativoportagens.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.example.aplicativoportagens.Login;

public class OpenDialog extends AppCompatDialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Informação")
                .setMessage("Portagem não Encontrada! \nConecte quando estiver numa portagem.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), Login.class);
                        startActivity(intent);
                    }
                });
        return builder.create();
    }
}
