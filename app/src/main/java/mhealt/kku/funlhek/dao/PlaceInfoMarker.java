package mhealt.kku.funlhek.dao;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by zMaxKunGz on 1/11/2017 AD.
 */

public class PlaceInfoMarker {
    MarkerOptions marker;
    Marker keepMarker;
    String name;
    Double lat,lng;
    Clinic clinicInfo;
    LatLng latlng;
    String snippet;
    String clinicID;
    public static int count = 0;

    public PlaceInfoMarker(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
        latlng = new LatLng(lat, lng);
        marker = new MarkerOptions().position(latlng);
        count++;

       // marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.logo_arrow));
    }

    public MarkerOptions getMarker() {
        return marker;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
        marker.snippet(snippet);
    }

    public String getName() {
        return name;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    public void setName(String name) {
        this.name = name;
        marker.title(this.name);
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Marker getKeepMarker() {
        return keepMarker;
    }

    public void setKeepMarker(Marker keepMarker) {
        this.keepMarker = keepMarker;
    }
    public Clinic getClinicInfo() {
        return clinicInfo;
    }

    public void setClinicInfo(Clinic clinicInfo) {
        this.clinicInfo = clinicInfo;
    }
    public String getClinicID() {
        return clinicID;
    }

    public void setClinicID(String clinicID) {
        this.clinicID = clinicID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
