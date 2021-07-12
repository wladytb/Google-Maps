package com.wladytb.googlemaps.modelo;

public class modeloMarker {
    String facultad, decano, logo,lat,lng;

    public modeloMarker() {
    }

    public modeloMarker(String facultad, String decano, String logo, String lat, String lng) {
        this.facultad = facultad;
        this.decano = decano;
        this.logo = logo;
        this.lat = lat;
        this.lng = lng;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
