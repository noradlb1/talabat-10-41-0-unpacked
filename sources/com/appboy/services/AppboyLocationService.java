package com.appboy.services;

import android.content.Context;
import com.braze.Braze;
import com.braze.support.BrazeLogger;

@Deprecated
public class AppboyLocationService {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) AppboyLocationService.class);

    @Deprecated
    public static void requestInitialization(Context context) {
        BrazeLogger.d(TAG, "Location permissions were granted. Requesting geofence and location initialization.");
        Braze.getInstance(context).requestLocationInitialization();
    }
}
