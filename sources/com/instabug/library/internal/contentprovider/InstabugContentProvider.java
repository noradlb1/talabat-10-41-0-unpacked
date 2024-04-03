package com.instabug.library.internal.contentprovider;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.customtraces.IBGPendingTraceHandler;
import com.instabug.library.internal.stub.a;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

@Keep
public class InstabugContentProvider extends a {
    private void initApplicationProvider(@Nullable Application application) {
        if (application != null) {
            a.b(application);
        }
    }

    private void initSDK(@Nullable Application application) throws PackageManager.NameNotFoundException {
        if (application != null) {
            new Instabug.Builder(application, getInstabugToken(application)).build(Feature.State.DISABLED);
        }
    }

    private void initTrackingDelegate(@Nullable Application application) {
        if (application != null) {
            InstabugInternalTrackingDelegate.init(application);
        }
    }

    private void initialize(Context context) throws PackageManager.NameNotFoundException {
        Application application;
        IBGPendingTraceHandler.setCoreCPStartTime(System.currentTimeMillis());
        if (context != null) {
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                } else {
                    application = null;
                }
            }
            initSDK(application);
            initTrackingDelegate(application);
            initApplicationProvider(application);
            IBGPendingTraceHandler.setCoreCPEndTime(System.currentTimeMillis());
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        try {
            initialize(context);
        } catch (Exception e11) {
            Log.e("IBG-CORE", "Error in content provider: " + e11.getMessage(), e11);
        }
    }

    @NonNull
    public String getInstabugToken(Application application) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String string;
        if (application == null || (bundle = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData) == null || (string = bundle.getString("com.instabug.APP_TOKEN")) == null) {
            return "";
        }
        return string;
    }
}
