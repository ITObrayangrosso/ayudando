package com.example.admin.ayudando;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class mapa extends Fragment implements OnMapReadyCallback {
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

    public mapa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_mapa, container, false);
        return mView;
    }

    @Override
    public  void  onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.mapaPerdidos);
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;

        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        //mGoogleMap.setMinZoomPreference(16);
        LatLng snowqualmie = new LatLng(47.5287132, -121.8253906);


        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(getActivity());

        Integer i;
        for(i = 1; i<=7; i++){
            MarkerOptions markerOptions = new MarkerOptions();
            String longitud = "4.62"+(i*20)+"35";
            String latitud = "-74.06"+(i*20)+"44";
            Double.parseDouble(longitud);
            markerOptions.position(new LatLng(Double.parseDouble(longitud),Double.parseDouble(latitud))).icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_ayuda));
            InfoWindowData info = new InfoWindowData();

            mGoogleMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mGoogleMap.addMarker(markerOptions);
        }
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(4.624335,-74.063644)).zoom(16).build();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));
    }
    public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

        private Context context;

        public CustomInfoWindowGoogleMap(Context ctx){
            context = ctx;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            View view = ((getActivity())).getLayoutInflater()
                    .inflate(R.layout.infowindowmarker, null);

            InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

            return view;
        }
    }

}
