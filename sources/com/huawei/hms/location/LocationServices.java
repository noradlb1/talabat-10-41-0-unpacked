package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import java.util.Locale;

public class LocationServices {
    public static FusedLocationProviderClient getFusedLocationProviderClient(Activity activity) {
        return new FusedLocationProviderClient(activity);
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(Context context) {
        return new FusedLocationProviderClient(context);
    }

    public static GeocoderService getGeocoderService(Activity activity, Locale locale) {
        return new GeocoderService(activity, locale);
    }

    public static GeocoderService getGeocoderService(Context context, Locale locale) {
        return new GeocoderService(context, locale);
    }

    public static GeofenceService getGeofenceService(Activity activity) {
        return new GeofenceService(activity);
    }

    public static GeofenceService getGeofenceService(Context context) {
        return new GeofenceService(context);
    }

    public static LocationEnhanceService getLocationEnhanceService(Activity activity) {
        return new LocationEnhanceService(activity);
    }

    public static LocationEnhanceService getLocationEnhanceService(Context context) {
        return new LocationEnhanceService(context);
    }

    public static SettingsClient getSettingsClient(Activity activity) {
        return new SettingsClient(activity);
    }

    public static SettingsClient getSettingsClient(Context context) {
        return new SettingsClient(context);
    }
}
