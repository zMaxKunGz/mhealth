package mhealt.kku.funlhek.dao;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Map;

/**
 * Created by zMaxKunGz on 1/12/2017 AD.
 */
@IgnoreExtraProperties
public class OrthoDontist {
    Map<String, DoctorInfo> dataList;

    public Map<String, DoctorInfo> getDataList() {
        return dataList;
    }

    public void setDataList(Map<String, DoctorInfo> dataList) {
        this.dataList = dataList;
    }
}
