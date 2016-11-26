package com.raywenderlich.adaptivescenery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by scheng on 11/25/16.
 */

public class InfoFragment extends Fragment {

    SupportMapFragment mapFragment;

    public InfoFragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpMapIfNeeded();
    }

    private void loadMap(GoogleMap googleMap) {
        if (googleMap != null) {
            // 1
            BitmapDescriptor defaultMarker =
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
            // 2
            LatLng sceneryPosition = new LatLng(44.22438242, 6.944561);
            // 3
            mapFragment.getMap().addMarker(new MarkerOptions()
                    .position(sceneryPosition)
                    .icon(defaultMarker));
        }
    }

    private void setUpMapIfNeeded() {
        if (mapFragment == null) {
            // 1
            mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
            if (mapFragment != null) {
                // 2
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap map) {
                        // 3
                        loadMap(map);
                    }
                });
            }
        }
    }
}
