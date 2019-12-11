package com.example.Maps2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.maps.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap




        val latitude = -7.747033
        val longitude =  110.355398
        val latitudeJombor = -7.750193
        val longtitudeJombor = 110.369472
        val latKontrakan = -7.753442
        val longKontrakan = 110.345821
        val zoomLevel =15f
        val overlaySize = 100f

        val homeLatLng = LatLng(latitude,longitude)
        mMap.addMarker(MarkerOptions().position(homeLatLng).title("Universitas Teknologi Yogjakarta").snippet("-7.747033/110.355398"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng,zoomLevel))

        val Jombor = LatLng(latitudeJombor,longtitudeJombor)
        mMap.addMarker(MarkerOptions().position(Jombor).title("Jombor").snippet("-7.750193/110.369472").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val kos = LatLng(latKontrakan,longKontrakan)
        mMap.addMarker(MarkerOptions().position(kos).title("Kontrakan").snippet("-7.753462/110.345780").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))


        val googleOverlay= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.uty)).position(homeLatLng,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay3= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.jombor)).position(kos,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)

        val googleOverlay2= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.kontrakan)).position(Jombor,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)
    }}



