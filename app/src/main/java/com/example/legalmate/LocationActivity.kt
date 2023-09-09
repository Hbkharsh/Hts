package com.example.legalmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.legalmate.databinding.ActivityLocationBinding
import com.example.legalmate.databinding.ActivityNameBinding
import com.google.android.gms.common.api.Status
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

private lateinit var binding:ActivityLocationBinding
class LocationActivity : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var autocompleteFragment:  AutocompleteSupportFragment
    private var mGoogleMap:GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Places.initialize(applicationContext,getString(R.string.google_map_api))
        autocompleteFragment=supportFragmentManager
            .findFragmentById(R.id.autocomplete_Fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID,
            Place.Field.ADDRESS,
            Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object:PlaceSelectionListener{
            override fun onError(p0: Status) {
                Toast.makeText(this@LocationActivity,"Some Error in Search",Toast.LENGTH_SHORT).show()
            }

            override fun onPlaceSelected(place: Place) {
                val add = place.address
            val id = place.id
                val latLng = place.latLng!!
                val marker = addMarker(latLng)
                marker.title = "$add"
                marker.snippet = "$id"
                zoomOnMap(latLng)
            }

        })

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.button3.setOnClickListener {
            val i = Intent(this,AssuranceMeter::class.java).also{
                startActivity(it)
            }
        }
    }

    private fun zoomOnMap (latLng: LatLng){
        val newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng,15f)
        mGoogleMap?.animateCamera(newLatLngZoom)
    }

    override fun onMapReady(googleMap: GoogleMap) {
      mGoogleMap= googleMap
//        addMarker(LatLng(13.234,12.543))


        mGoogleMap?.setOnMapClickListener {
            mGoogleMap?.clear()
            addMarker(it)
        }

        mGoogleMap?.setOnMarkerClickListener {marker->

            marker.remove()
            false
        }

    }


    private fun addMarker(position:LatLng): Marker {
      val marker =  mGoogleMap?.addMarker(MarkerOptions()
            .position(position)
            .title("Draggable Marker")
            .draggable(true))

        return marker!!
    }

}