package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

public final class zal {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, int i11) {
        return this.zaa.get(i11, -1);
    }

    @ResultIgnorabilityUnspecified
    public final int zab(@NonNull Context context, @NonNull Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i11 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zaa2 = zaa(context, minApkVersion);
        if (zaa2 == -1) {
            int i12 = 0;
            while (true) {
                if (i12 >= this.zaa.size()) {
                    i11 = -1;
                    break;
                }
                int keyAt = this.zaa.keyAt(i12);
                if (keyAt > minApkVersion && this.zaa.get(keyAt) == 0) {
                    break;
                }
                i12++;
            }
            if (i11 == -1) {
                zaa2 = this.zab.isGooglePlayServicesAvailable(context, minApkVersion);
            } else {
                zaa2 = i11;
            }
            this.zaa.put(minApkVersion, zaa2);
        }
        return zaa2;
    }

    public final void zac() {
        this.zaa.clear();
    }

    public zal(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}
