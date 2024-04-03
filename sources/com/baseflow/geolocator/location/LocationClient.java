package com.baseflow.geolocator.location;

import android.app.Activity;
import android.content.Context;
import com.baseflow.geolocator.errors.ErrorCallback;

public interface LocationClient {
    boolean checkLocationService(Context context);

    void getLastKnownPosition(PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback);

    void isLocationServiceEnabled(LocationServiceListener locationServiceListener);

    boolean onActivityResult(int i11, int i12);

    void startPositionUpdates(Activity activity, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback);

    void stopPositionUpdates();
}
