package com.livingwordsolutions.technosoft.post_module_location;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class map_locate extends Fragment {

    Context context;
    public Button getLocationButton;
    TextView lat, lon;
    EditText address;

    public map_locate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.map_locate, container, false);

        map_comp();
        return result;
    }

    private void map_comp() {
        getLocationButton = (Button) getActivity().findViewById(R.id.locationButton);
        lat = (TextView)getActivity().findViewById(R.id.latText);
        lon = (TextView) getActivity().findViewById(R.id.longText);
        address = (EditText) getActivity().findViewById(R.id.address);
        getLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && data != null) {
            if(resultCode == getActivity().RESULT_OK) {
                String lat = data.getStringExtra("lat");
                String lon = data.getStringExtra("lon");
                String address = data.getStringExtra("address");
                this.lat.setText(lat);
                this.lon.setText(lon);
                this.address.setText(address);


            }
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Not Loaded.. Please try again..!", Toast.LENGTH_SHORT).show();
        }
    }



}
