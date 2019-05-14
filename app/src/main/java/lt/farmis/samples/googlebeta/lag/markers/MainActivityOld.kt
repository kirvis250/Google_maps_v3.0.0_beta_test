package lt.farmis.samples.googlebeta.lag.markers

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions
import kotlin.random.Random

class MainActivityOld : AppCompatActivity() {

    lateinit var mapView: MapView

    var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_old)
       mapView = findViewById(R.id.mapView)
       mapView.onCreate(savedInstanceState)

       mapView.getMapAsync {
            onMapInitialized(it)
        }

        findViewById<Button>(R.id.viewOld)?.setOnClickListener {
           finish()
        }

    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }


    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }



    fun onMapInitialized(map: GoogleMap) {
        googleMap = map

        for (i in 0..100) {
            val rand1 = Random.nextDouble(0.001, 0.02)
            val rand2 = Random.nextDouble(0.001, 0.02)
            val marker = MarkerOptions()
            marker.position(LatLng( (54.9208509757241 + rand1), (23.931122794747353 + rand2)) )
            marker.draggable(true)
            googleMap?.addMarker(marker)
        }

        for (i in 0..100) {
            val rand1 = Random.nextDouble(0.001, 0.02)
            val rand2 = Random.nextDouble(0.001, 0.02)
            val polyOptions = getRandomizedPolygonOptions(rand1, rand2)
            googleMap?.addPolygon(polyOptions)
        }

    }



    fun getRandomizedPolygonOptions(rand1: Double, rand2: Double) : PolygonOptions {

        val coordinatesList = mutableListOf<LatLng>()

        coordinatesList.add(LatLng(54.9208509757241 + rand2, 23.931122794747353 + rand1))
        coordinatesList.add(LatLng(54.9204912299213 + rand2, 23.930992037057877 + rand1))
        coordinatesList.add(LatLng(54.92034632872146 + rand2, 23.930909894406796 + rand1))
        coordinatesList.add(LatLng(54.920542870116435 + rand2, 23.929188586771488 + rand1))
        coordinatesList.add(LatLng(54.920633625671876 + rand2, 23.929970115423206 + rand1))
        coordinatesList.add(LatLng(54.92099645316168 + rand2, 23.929857462644573 + rand1))
        coordinatesList.add(LatLng(54.920780452697535 + rand2, 23.929780684411522 + rand1))
        coordinatesList.add(LatLng(54.920637864779856 + rand2, 23.92940115183592 + rand1))
        coordinatesList.add(LatLng(54.9208149434828 + rand2, 23.929570131003857 + rand1))
        coordinatesList.add(LatLng(54.92104828539315 + rand2, 23.929577507078648 + rand1))
        coordinatesList.add(LatLng(54.92066599703067 + rand2, 23.929243236780167 + rand1))
        coordinatesList.add(LatLng(54.92084114875241 + rand2, 23.92926603555679 + rand1))
        coordinatesList.add(LatLng(54.92122979401941 + rand2, 23.929239213466648 + rand1))
        coordinatesList.add(LatLng(54.9208509757241 + rand2, 23.931122794747353 + rand1))
        coordinatesList.add(LatLng(54.9208509757241 + rand2, 23.931122794747353 + rand1))
        coordinatesList.add(LatLng(54.9208509757241 + rand2, 23.931122794747353 + rand1))

        val polygonOptions = PolygonOptions()
        polygonOptions.addAll(coordinatesList)
        polygonOptions.fillColor(Color.BLACK)
        polygonOptions.strokeColor(Color.BLUE)

        return polygonOptions
    }



}


