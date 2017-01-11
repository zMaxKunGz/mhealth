package mhealt.kku.funlhek.dao;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vashi on 11-Jan-17.
 */

@IgnoreExtraProperties
public class Clinic {
    public String address;
    public String name;
    public String tell;

    public Clinic() {

    }

    public Clinic(String address, String name,String tell) {
        this.address = address;
        this.name = name;
        this.tell = tell;
    }
}
