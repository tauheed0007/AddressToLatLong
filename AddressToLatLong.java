package com.gps.maps.navigation.street.live.view.apptronix;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.GeoPoint;
import com.gps.maps.navigation.street.live.view.apptronix.Activities.VoiceSearchActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AddressToLatLong extends AppCompatActivity {

    EditText etLatLong;
    Button btnLatLong;
    TextView tvLatLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_to_lat_long);

        etLatLong = findViewById(R.id.etAdress);
        btnLatLong = findViewById(R.id.btnLatLong);
        tvLatLong = findViewById(R.id.tvLatLong);


        btnLatLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strAddress =  VoiceSearchActivity.global_source;

                AddressToLatLongComplete(strAddress);
            }
        });


    }


    public GeoPoint AddressToLatLongComplete(String strAddress) {

            Geocoder coder = new Geocoder(this);
            List<Address> address;
            GeoPoint p1 = null;

            try {
                address = coder.getFromLocationName(etLatLong.getText().toString(), 5);
                if (address != null) {
                    Address location = address.get(0);
                   double dlatitude = location.getLatitude();
                    double dlongitude =  location.getLongitude();

                    tvLatLong.setText(String.valueOf(dlatitude) + String.valueOf(dlongitude));
                }



            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;

        }

}