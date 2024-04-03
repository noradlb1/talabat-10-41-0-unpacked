package com.newrelic.agent.android.rum.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import com.newrelic.agent.android.rum.AppApplicationLifeCycle;
import com.newrelic.agent.android.rum.AppTracer;

public class NewRelicAppContentProvider extends ContentProvider {
    AppApplicationLifeCycle appApplicationLifeCycle = new AppApplicationLifeCycle();

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
        AppTracer.getInstance().setContentProviderStartedTime(Long.valueOf(SystemClock.uptimeMillis()));
        Context context = getContext();
        if (context == null) {
            return false;
        }
        this.appApplicationLifeCycle.onColdStartInitiated(context);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
