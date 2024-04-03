package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    @VisibleForTesting
    static int zba = 1;
    private static final zbb zbb = new zbb((zba) null);

    public GoogleSignInClient(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final synchronized int zba() {
        int i11;
        i11 = zba;
        if (i11 == 1) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0) {
                i11 = 4;
                zba = 4;
            } else if (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, (String) null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                i11 = 2;
                zba = 2;
            } else {
                i11 = 3;
                zba = 3;
            }
        }
        return i11;
    }

    @NonNull
    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int zba2 = zba();
        int i11 = zba2 - 1;
        if (zba2 == 0) {
            throw null;
        } else if (i11 == 2) {
            return zbm.zba(applicationContext, (GoogleSignInOptions) getApiOptions());
        } else {
            if (i11 != 3) {
                return zbm.zbb(applicationContext, (GoogleSignInOptions) getApiOptions());
            }
            return zbm.zbc(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
    }

    @NonNull
    public Task<Void> revokeAccess() {
        boolean z11;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (zba() == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        return PendingResultUtil.toVoidTask(zbm.zbf(asGoogleApiClient, applicationContext, z11));
    }

    @NonNull
    public Task<Void> signOut() {
        boolean z11;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (zba() == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        return PendingResultUtil.toVoidTask(zbm.zbg(asGoogleApiClient, applicationContext, z11));
    }

    @NonNull
    public Task<GoogleSignInAccount> silentSignIn() {
        boolean z11;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) getApiOptions();
        if (zba() == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        return PendingResultUtil.toTask(zbm.zbe(asGoogleApiClient, applicationContext, googleSignInOptions, z11), zbb);
    }

    public GoogleSignInClient(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
