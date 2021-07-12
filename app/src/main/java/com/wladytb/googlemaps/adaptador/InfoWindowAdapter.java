package com.wladytb.googlemaps.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;
import com.wladytb.googlemaps.R;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater = null;

    public InfoWindowAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View informacion = inflater.inflate(R.layout.makerpersonalizado, null);
        TextView fc = (TextView) informacion.findViewById(R.id.txtNameFacultad);
        TextView dc = (TextView) informacion.findViewById(R.id.txtNameDecano);
        TextView cr = (TextView) informacion.findViewById(R.id.txtCorreo);
        TextView ub = (TextView) informacion.findViewById(R.id.txtNameUbicacion);
        ImageView img = (ImageView) informacion.findViewById(R.id.imgFacultad);
        fc.setText(marker.getTitle());
        dc.setText(marker.getSnippet().split(";")[0].trim());
        ub.setText(marker.getSnippet().split(";")[1].trim());
        Picasso.get().load(marker.getSnippet().split(";")[2].toString().trim()).into(img);
        cr.setText(marker.getSnippet().split(";")[3].trim());
        return informacion;
    }
}
