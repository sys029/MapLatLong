package com.example.maplocation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment

        bt.setOnClickListener(View.OnClickListener {

            if (latitude.text.isEmpty() || longitude.text.isEmpty()){
                Toast.makeText(this,"Enter Latitude and Longitude", Toast.LENGTH_SHORT).show()
            }
            else
                mapFragment.getMapAsync(this)


        })

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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val locationLatLong = LatLng(latitude.text.toString().toDouble(),longitude.text.toString().toDouble())
        mMap.addMarker(MarkerOptions().position(locationLatLong).title("Location"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locationLatLong,15f))
        mMap.uiSettings.isZoomControlsEnabled = true

    }
}
