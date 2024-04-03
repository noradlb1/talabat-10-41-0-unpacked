package com.huawei.hms.analytics.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.d;
import com.huawei.hms.analytics.dp;
import com.huawei.hms.analytics.dr;
import com.huawei.hms.analytics.dv;
import com.huawei.hms.analytics.ea;

public class AnalyticsInitializeProvider extends ContentProvider {
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
        try {
            Context context = getContext();
            if (!ea.lmn().lmn(context)) {
                return false;
            }
            if (!(dv.klm(context, "global_v2", "is_analytics_initialized", 0) != 1 ? false : dv.klm(context, "global_v2", "is_analytics_enabled", true))) {
                HiLog.w("HaProvider", "init check failed");
                return false;
            }
            d.lmn().lmn(context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : dp.lmn());
            return false;
        } catch (Throwable th2) {
            Log.w("InitializeProvider", "onCreate error: " + th2.getMessage());
            dr.lmn(getContext(), th2);
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
