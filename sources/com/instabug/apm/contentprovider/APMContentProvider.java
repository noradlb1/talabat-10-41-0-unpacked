package com.instabug.apm.contentprovider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.configuration.c;
import com.instabug.apm.di.a;
import com.instabug.library.diagnostics.customtraces.IBGPendingTraceHandler;

public class APMContentProvider extends ContentProvider {
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        boolean z11;
        super.attachInfo(context, providerInfo);
        if (context != null && (context instanceof Application)) {
            try {
                IBGPendingTraceHandler.setApmCPStartTime(System.currentTimeMillis());
                a.a((Context) (Application) context);
                c c11 = a.c();
                if (!c11.Q()) {
                    if (!c11.P()) {
                        z11 = false;
                        if (z11 || c11.O()) {
                            ((Application) context).registerActivityLifecycleCallbacks(a.a(context, true, true));
                        }
                        IBGPendingTraceHandler.setApmCPEndTime(System.currentTimeMillis());
                    }
                }
                z11 = true;
                ((Application) context).registerActivityLifecycleCallbacks(a.a(context, true, true));
                IBGPendingTraceHandler.setApmCPEndTime(System.currentTimeMillis());
            } catch (Exception e11) {
                Log.e("IBG-APM", "Error in content provider: " + e11.getMessage(), e11);
            }
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
