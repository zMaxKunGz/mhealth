package mhealt.kku.funlhek.dao;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by vashi on 11-Jan-17.
 */

@IgnoreExtraProperties
public class Clinic {
    String id;
    String address;
    String lat;
    String lng;
    String name;
    String tell;
    String type;

    public Clinic(String address, String lat, String lng, String name, String tell, String type) {
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.tell = tell;
        this.type = type;
    }
    public Clinic() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
