package com.wladytb.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wladytb.googlemaps.adaptador.InfoWindowAdapter;
import com.wladytb.googlemaps.modelo.modeloMarker;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mapa;
    RadioButton RadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        RadioButton = (RadioButton) findViewById(R.id.rdNormal);
        RadioButton.setChecked(true);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        LatLng ltLng = new LatLng(-1.0127291289943696, -79.4694318818125);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(ltLng, 17);
        mapa.animateCamera(cameraUpdate);
        for (modeloMarker mm : cargarMarker()) {
            mapa.addMarker(new MarkerOptions().
                    position(new LatLng(Double.parseDouble(mm.getLat()), Double.parseDouble(mm.getLng()))).
                    title(mm.getFacultad()).
                    snippet("Decano: " + mm.getDecano() + "; Ubicación: " + "Lat: " + mm.getLat() + " , Lng: " + mm.getLng() + " ; " + mm.getLogo() + "; Correo: " + mm.getCorreo()));
            mapa.setInfoWindowAdapter(new InfoWindowAdapter(getLayoutInflater()));
        }
        mapa.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(getApplicationContext(), latLng.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void mapaNormal(View view) {
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.getUiSettings().setZoomControlsEnabled(true);
    }

    public void mapaHybrido(View view) {
        mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mapa.getUiSettings().setZoomControlsEnabled(true);
    }

    public void mapaTerrain(View view) {
        mapa.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mapa.getUiSettings().setZoomControlsEnabled(true);
    }

    public void mapaSatelital(View view) {
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
    }

    public List<modeloMarker> cargarMarker() {
        List<modeloMarker> listaMarker = new ArrayList<>();
        modeloMarker fci = new modeloMarker(
                "Facultad de Ciencias de la Ingeniería ",
                "Ing. Washington Alberto Chiriboga Casanova, M.Sc.",
                "facultadci@uteq.edu.ec",
                "https://www.uteq.edu.ec/images/about/logo_fci.jpg",
                "-1.0125821345064658", "-79.47061004072364"
        );
        modeloMarker fce = new modeloMarker(
                "Facultad de Ciencias Empresariales",
                "Ing. Mariela Susana Andrade Arias, PhD.",
                "facultadce@uteq.edu.ec",
                "https://www.uteq.edu.ec/images/about/logo_fce.jpg",
                "-1.0121446581770701", "-79.47035097530821");

        modeloMarker fca = new modeloMarker(
                "Facultad de Ciencias Agropecuarias",
                "Ing. Leonardo Gonzalo Matute, M.Sc.",
                "decanato_agropecuarias@uteq.edu.ec",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScDRZJ3wT-_O09VEvtMYqordRtqCS0z72Jyw&usqp=CAU",
                "-1.0813624489354845", "-79.50302236394958");
        modeloMarker fcip = new modeloMarker(
                "Facultad de Ciencias de la Industria y Producción",
                "Ing. Sonnia Esther Barzola Miranda, M.Sc.",
                "fcip@uteq.edu.ec",
                "https://3.bp.blogspot.com/-fYlOzJNk0DA/WoSbHJXGzcI/AAAAAAAAA7E/SGC6Hp2qlcEDCbks59AykK3-8EYeSDeEQCLcBGAs/s320/Imagen1.jpg",
                "-1.0126327850989705", "-79.47107283317435");
        listaMarker.add(fci);
        listaMarker.add(fce);
        listaMarker.add(fca);
        listaMarker.add(fcip);
        return listaMarker;
    }
}