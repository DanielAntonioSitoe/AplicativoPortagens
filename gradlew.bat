package com.example.otempo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Cidade> cidades;
    String cidadeAtual;

    class buscarTemperatura extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... caminhos){
            StringBuilder resultado = new StringBuilder();
            try
            {
                URL url = new URL(caminhos[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(inputStream)));

                String linha = "";
                while ((linha = reader.readLine())!=null)
                {
                    resultado.append(linha).append("\n");
                }
                return resultado.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                