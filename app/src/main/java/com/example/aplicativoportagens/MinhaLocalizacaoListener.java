package com.example.aplicativoportagens;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MinhaLocalizacaoListener implements LocationListener {
    public  double latitude;
    public  double longitude;

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            this.latitude = location.getLatitude();
            this.longitude = location.getLongitude();
            if (latitude != 0.0 && longitude != 0.0) {
                System.out.println("WE GOT THE LOCATION");
                System.out.println(latitude);
                System.out.println(longitude);
            }

    }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
