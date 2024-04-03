package o3;

import android.content.Context;
import android.location.LocationManager;
import com.baseflow.geolocator.location.LocationClient;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;

public final /* synthetic */ class c {
    public static boolean a(LocationClient locationClient, Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
        boolean isProviderEnabled2 = locationManager.isProviderEnabled(SDKCoreEvent.Network.TYPE_NETWORK);
        if (isProviderEnabled || isProviderEnabled2) {
            return true;
        }
        return false;
    }
}
