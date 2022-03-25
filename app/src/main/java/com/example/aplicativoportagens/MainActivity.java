package com.example.aplicativoportagens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aplicativoportagens.Controle.CheckInDAO;
import com.example.aplicativoportagens.modelo.CheckIn;
import com.example.aplicativoportagens.modelo.Portagem;
import com.example.aplicativoportagens.modelo.Usuario;
import com.example.aplicativoportagens.ui.OpenDialog;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    FusedLocationProviderClient client;
    private AppBarConfiguration mAppBarConfiguration;
    private double latitude;
    private double longitude;
    private String textPortagem;
    private boolean adicionar = true;
    private TextView tempAtual;
    private TextView tempAtual2;
    Usuario idUsuario;
    Portagem portagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.monitorar_equipamentos, R.id.nav_meuTurno,
                R.id.nav_minhasNotificacoes, R.id.nav_solicitacoes, R.id.nav_reportar,R.id.nav_sair,R.id.nav_listarEquipamentos)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Intent intent = getIntent();
        idUsuario = (Usuario) intent.getSerializableExtra("nome");
        atualizarNome();
        client = LocationServices.getFusedLocationProviderClient(this);
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public  void  atualizarNome(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        View heaerView = navigationView.getHeaderView(0);
        TextView userName = heaerView.findViewById(R.id.userName);
        TextView userPortagem = heaerView.findViewById(R.id.userPortagem);
        userPortagem.setText(textPortagem);
        userName.setText(idUsuario.getNome());
        saveCheckIn();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();


        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            getLocation();
        }else{
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            getLocation();
        }else{
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},44);
        }
    }


    private void getLocation(){
        client.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                tempAtual = findViewById(R.id.portagem);
                tempAtual2 = findViewById(R.id.coordenadas);
                if(location!=null){
                    try {
                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                        List <Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(),location.getLongitude(),1
                        );
                        latitude = addresses.get(0).getLatitude();
                        longitude = addresses.get(0).getLongitude();
                        if(((-25.78586<=latitude)&&(latitude<=-25.77329))&&((32.66390<=longitude)&&(longitude<=32.66568))){
                            textPortagem="Portagem Zintava";
                        } else if(((-25.86440<=latitude)&&(latitude<=-25.88166))&&((32.64821<=longitude)&&(longitude<=32.67725))){
                            textPortagem="Portagem Costa do Sol";
                        }else if(((-25.79514<=latitude)&&(latitude<=-25.80411))&&((32.56816<=longitude)&&(longitude<=32.58441))){
                            textPortagem="Portagem Kumbeza";
                        }else if(((-25.81472<=latitude)&&(latitude<=-25.82630))&&((32.45449<=longitude)&&(longitude<=32.47372))){
                            textPortagem="Portagem Matola Gare";
                        }else{
                            textPortagem="Portagem nao Identificada";
//                            openDialog();
                        }
                        tempAtual2.setText(latitude+" "+longitude);
                        runtimer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
//                    openDialog();
                    getLocation();
                    try {
                        tempAtual2.setText("Localizacao nao detectada.");
                    }catch (Exception e){

                    }
                }
            }
        });
    }

    public void saveCheckIn(){
        CheckInDAO checkInDAO = new CheckInDAO();
        Date date = new Date();
        portagem = new Portagem(1,"Zintava",0,0);
        CheckIn checkIn = checkInDAO.salvar(new CheckIn(0,date,date,idUsuario,portagem));
    }

    public void openDialog(){
        OpenDialog openDialog = new OpenDialog();
        openDialog.show(getSupportFragmentManager(),"Portagem nao Identificada");
    }

    private void runtimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(adicionar){
                    tempAtual.setText(textPortagem);
                    adicionar = false;
                }
                handler.postDelayed(this,1000);

            }
        });

    }
}
