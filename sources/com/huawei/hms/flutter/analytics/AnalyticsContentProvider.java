package com.huawei.hms.flutter.analytics;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.huawei.hms.analytics.HiAnalytics;
import com.visa.checkout.Profile;
import java.util.Arrays;

public class AnalyticsContentProvider extends ContentProvider {
    private static final String TAG = "AnalyticsContentProvider";
    private final String[] routePolicyList = {Profile.Country.CN, "DE", Profile.Country.SG, "RU"};

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Log.i(TAG, "AnalyticsContentProvider -> onCreate");
        try {
            ApplicationInfo applicationInfo = getContext().getApplicationContext().getPackageManager().getApplicationInfo(getContext().getApplicationContext().getPackageName(), 128);
            if (!applicationInfo.metaData.getBoolean("hms_is_analytics_enabled", true)) {
                return true;
            }
            String string = applicationInfo.metaData.getString("hms_is_analytics_enabled");
            if (Arrays.asList(this.routePolicyList).contains(string)) {
                HiAnalytics.getInstance(getContext(), string);
                return true;
            }
            HiAnalytics.getInstance(getContext().getApplicationContext()).setAnalyticsEnabled(true);
            return true;
        } catch (Exception e11) {
            String str = TAG;
            Log.e(str, "HiAnalytics -> Invalid routePolicy! Initialization failed. Message: " + e11.getMessage());
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public void shutdown() {
        Log.i(TAG, "HMSContentProvider -> shutdown");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
