package mhealt.kku.funlhek.dao;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by zMaxKunGz on 1/12/2017 AD.
 */
@IgnoreExtraProperties
public class DoctorInfo {
    String clinic_id;
    String license;
    String name;

    public String getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(String clinic_id) {
        this.clinic_id = clinic_id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
