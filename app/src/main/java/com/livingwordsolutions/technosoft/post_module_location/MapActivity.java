package com.livingwordsolutions.technosoft.post_module_location;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;


public class MapActivity extends Activity {

   private LatLng LIVING_WORD = new LatLng(17.6883, 83.21826);
    private GoogleMap googleMap;
    private Marker marker;
    private Geocoder coder;
    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initComponents();
        initSendButton();

    }


    private void initSendButton() {
        button = (ImageButton) findViewById(R.id.map_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("lat", marker.getPosition().latitude+"");
                returnIntent.putExtra("lon", marker.getPosition().longitude+"");
                returnIntent.putExtra("address", marker.getTitle());

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }


    private void initComponents() {
        if(googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap() ;

            if(googleMap == null) {

                Toast.makeText(getApplicationContext(), "Google Map is not loading", Toast.LENGTH_SHORT).show();
            } else {

                coder = new Geocoder(this, Locale.ENGLISH);
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                marker = googleMap.addMarker(new MarkerOptions().position(LIVING_WORD)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                        .draggable(true).snippet("My Marker").title(getAddressText(LIVING_WORD.longitude, LIVING_WORD.latitude)));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LIVING_WORD, 13.0f));

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        marker.setPosition(latLng);
                        marker.setSnippet("Lat: " + latLng.latitude + " - Long:" + latLng.longitude);
                        marker.setTitle(getAddressText(latLng.longitude, latLng.latitude));
                    }

                });

                googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng latLng) {
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13.0f));
                        marker.setPosition(latLng);
                        marker.setTitle(getAddressText(latLng.longitude, latLng.latitude));
                    }
                });

            }
        }
    }


    private String getAddressText(double longitude, double latitude) {
        try {
            List<Address> addressList = coder.getFromLocation(latitude, longitude, 1);
            if (addressList != null) {
                Address address = addressList.get(0);
                String returnString = address.getSubLocality()+","+address.getLocality() +","+address.getCountryName()+","+address.getPostalCode();

                return returnString;
            } else {
                return "address list is empty";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.normal : googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);break;
            case R.id.satellite : googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);break;
            case R.id.hybrid : googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);break;
            case R.id.terrain : googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);break;
        }

        return true;
    }
}
