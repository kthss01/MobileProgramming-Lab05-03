package kay.kookmin.ac.kr.lab05_03;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements GoogleMap.OnMyLocationChangeListener {
    static final LatLng SEOUL = new LatLng(37.56,126.97);
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL,15));
        map.animateCamera(CameraUpdateFactory.zoomTo(10),2000,null);

        map.setMyLocationEnabled(true);
        map.setOnMyLocationChangeListener(this);

    }

    @Override
    public void onMyLocationChange(Location location) {
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        Log.e("onMyLocationChange", lat + "," + lng);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng),15));
    }
}
