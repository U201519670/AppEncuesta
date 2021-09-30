package com.example.myproject1

import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.GoogleMap
import android.os.Bundle
import com.google.android.gms.maps.SupportMapFragment
import com.example.myproject1.R
import com.example.myproject1.databinding.ActivityMapaLocalesBinding
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.CameraUpdateFactory

class Mapa_Locales : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    private var binding: ActivityMapaLocalesBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapaLocalesBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
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
        val miraflores = LatLng(-12.121781, -77.030422)
        val lamolina = LatLng(-12.077559, -76.964625)
        val surco = LatLng(-12.127818, -76.986377)
        mMap!!.addMarker(MarkerOptions().position(miraflores).title("Local Miraflores"))
        mMap!!.addMarker(MarkerOptions().position(lamolina).title("Local La Molina"))
        mMap!!.addMarker(MarkerOptions().position(surco).title("Local Surco"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(miraflores, 12F))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(lamolina, 12F))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(surco, 12F))
    }
}