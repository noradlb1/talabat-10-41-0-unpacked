package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaax implements zabf {
    @NotOnlyInitialized
    private final zabi zaa;

    public zaax(zabi zabi) {
        this.zaa = zabi;
    }

    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zaa.zag.zaa.add(apiMethodImpl);
        return apiMethodImpl;
    }

    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void zad() {
        for (Api.Client disconnect : this.zaa.zaa.values()) {
            disconnect.disconnect();
        }
        this.zaa.zag.zad = Collections.emptySet();
    }

    public final void zae() {
        this.zaa.zaj();
    }

    public final void zag(@Nullable Bundle bundle) {
    }

    public final void zah(ConnectionResult connectionResult, Api api, boolean z11) {
    }

    public final void zai(int i11) {
    }

    public final boolean zaj() {
        return true;
    }
}
