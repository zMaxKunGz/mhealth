package mhealt.kku.funlhek.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mhealt.kku.funlhek.R;
import mhealt.kku.funlhek.dao.DoctorInfo;
import mhealt.kku.funlhek.dao.PlaceInfoMarker;


public class MapsActivity extends AppCompatActivity implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        SeekBar.OnSeekBarChangeListener,
        OnMapReadyCallback,
        GoogleMap.OnInfoWindowLongClickListener,
        GoogleMap.OnInfoWindowCloseListener
{
    private DatabaseReference myRef;
    private List<PlaceInfoMarker> markers;
    private GoogleMap mMap;
    private boolean mPermissionDenied = false;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private ArrayList<String> titleArray;
    private AutoCompleteTextView textView;
    private List<DoctorInfo> doctorInfo;

    private static final LatLng DEFAULT_LATLNG = new LatLng(16.472573, 102.825716);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        feedData();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(this);
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.style_json));
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Inflate the layouts for the info window, title and snippet.
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_contents, null);


                TextView title = ((TextView) infoWindow.findViewById(R.id.title));
                title.setText(marker.getTitle());


                TextView snippet = ((TextView) infoWindow.findViewById(R.id.snippet));
                snippet.setText(marker.getSnippet());


                return infoWindow;
            }
        });
        // Add marker
        for(int i = 0 ; i < markers.size(); i++)
        {
            mMap.clear();
            markers.get(i).setKeepMarker(mMap.addMarker(markers.get(i).getMarker()));
//            markers.get(i).getKeepMarker()
        }
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        if (getApplicationContext().getPackageManager().checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, getApplicationContext().getPackageName())
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LATLNG, 12.0f));
        } else {
            // add error message
        }
    }
    private void feedData() {
        myRef = FirebaseDatabase.getInstance().getReference();
//        myRef.child("orthodontists").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                GenericTypeIndicator<List<DoctorInfo>> t = new GenericTypeIndicator<List<DoctorInfo>>() {};
//
//                doctorInfo = dataSnapshot.getValue(t);
//                Log.d("Check",doctorInfo.get(0).getName() + "อิอิ");
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        //Toast.makeText(getApplicationContext(), doctorInfo.get(0).getName(), Toast.LENGTH_SHORT).show();
        myRef.child("clinics").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<DoctorInfo>> t = new GenericTypeIndicator<List<DoctorInfo>>() {};

                doctorInfo = dataSnapshot.getValue(t);
                Log.d("Check", doctorInfo.get(0).getName());
                // finish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TagDatabase", databaseError.getMessage());
            }
        });
        markers = new ArrayList<PlaceInfoMarker>();
        PlaceInfoMarker place1 = new PlaceInfoMarker(16.4317683, 102.8399799);
        place1.setName("บ้านฟันสวย");
        place1.setSnippet("อิอิ");
        markers.add(0, place1);
    }
    @Override
    public boolean onMyLocationButtonClick() {
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent;
        for(int i = 0 ; i < markers.size(); i++)
        {
            if(markers.get(i).getName().contains(marker.getTitle())) {
                intent = new Intent(MapsActivity.this, InfoActivity.class);
//                intent.putExtra(markers.get(i).getClinicInfo());
            }
        }
    }

    @Override
    public void onInfoWindowClose(Marker marker) {

    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;

    }



    public void createTitleArray() {
        titleArray = new ArrayList<String>();
        for(int i = 0 ; i < markers.size() ; i++)
        {
            titleArray.add(i, markers.get(i).getName());
        }
    }
}
