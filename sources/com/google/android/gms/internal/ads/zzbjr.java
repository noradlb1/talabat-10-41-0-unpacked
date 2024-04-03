package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzbjr extends ContentProvider {
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        String str;
        String str2;
        Bundle bundle = null;
        try {
            bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NullPointerException e11) {
            zzciz.zzh("Failed to load metadata: Null pointer exception.", e11);
        } catch (PackageManager.NameNotFoundException e12) {
            zzciz.zzh("Failed to load metadata: Package name not found.", e12);
        }
        zzbxa zza = zzbxa.zza();
        if (bundle == null) {
            zzciz.zzg("Metadata was null.");
        } else {
            try {
                String str3 = (String) bundle.get("com.google.android.gms.ads.APPLICATION_ID");
                try {
                    Boolean bool = (Boolean) bundle.get("com.google.android.gms.ads.AD_MANAGER_APP");
                    try {
                        Boolean bool2 = (Boolean) bundle.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
                        try {
                            String str4 = (String) bundle.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
                            if (str3 == null || str3.matches("^/\\d+~.+$")) {
                                if (bool == null || !bool.booleanValue()) {
                                    if (!TextUtils.isEmpty(str4)) {
                                        String valueOf = String.valueOf(str4);
                                        if (valueOf.length() != 0) {
                                            str = "The Google Mobile Ads SDK is integrated by ".concat(valueOf);
                                        } else {
                                            str = new String("The Google Mobile Ads SDK is integrated by ");
                                        }
                                        zzciz.zze(str);
                                    } else {
                                        throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                                    }
                                }
                            } else if (str3.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                                if (str3.length() != 0) {
                                    str2 = "Publisher provided Google AdMob App ID in manifest: ".concat(str3);
                                } else {
                                    str2 = new String("Publisher provided Google AdMob App ID in manifest: ");
                                }
                                zzciz.zze(str2);
                                if (bool2 == null || !bool2.booleanValue()) {
                                    zza.zzb(context, str3);
                                }
                            } else {
                                throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                            }
                        } catch (ClassCastException e13) {
                            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", e13);
                        }
                    } catch (ClassCastException e14) {
                        throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", e14);
                    }
                } catch (ClassCastException e15) {
                    throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", e15);
                }
            } catch (ClassCastException e16) {
                throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", e16);
            }
        }
        super.attachInfo(context, providerInfo);
    }

    public final int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Nullable
    public final String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public final Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        return false;
    }

    @Nullable
    public final Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
