package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class zak extends zap {
    private final SparseArray zad = new SparseArray();

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zak = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zak != null) {
            return zak;
        }
        return new zak(fragment);
    }

    @Nullable
    private final zaj zai(int i11) {
        if (this.zad.size() <= i11) {
            return null;
        }
        SparseArray sparseArray = this.zad;
        return (zaj) sparseArray.get(sparseArray.keyAt(i11));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i11 = 0; i11 < this.zad.size(); i11++) {
            zaj zai = zai(i11);
            if (zai != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zai.zaa);
                printWriter.println(CertificateUtil.DELIMITER);
                zai.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z11 = this.zaa;
        String valueOf = String.valueOf(this.zad);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStart ");
        sb2.append(z11);
        sb2.append(" ");
        sb2.append(valueOf);
        if (this.zab.get() == null) {
            for (int i11 = 0; i11 < this.zad.size(); i11++) {
                zaj zai = zai(i11);
                if (zai != null) {
                    zai.zab.connect();
                }
            }
        }
    }

    public final void onStop() {
        super.onStop();
        for (int i11 = 0; i11 < this.zad.size(); i11++) {
            zaj zai = zai(i11);
            if (zai != null) {
                zai.zab.disconnect();
            }
        }
    }

    public final void zab(ConnectionResult connectionResult, int i11) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i11 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zaj = (zaj) this.zad.get(i11);
        if (zaj != null) {
            zae(i11);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaj.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public final void zac() {
        for (int i11 = 0; i11 < this.zad.size(); i11++) {
            zaj zai = zai(i11);
            if (zai != null) {
                zai.zab.connect();
            }
        }
    }

    public final void zad(int i11, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean z11;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        String str = "Already managing a GoogleApiClient with id " + i11;
        if (this.zad.indexOfKey(i11) < 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zam zam = (zam) this.zab.get();
        boolean z12 = this.zaa;
        String valueOf = String.valueOf(zam);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("starting AutoManage for client ");
        sb2.append(i11);
        sb2.append(" ");
        sb2.append(z12);
        sb2.append(" ");
        sb2.append(valueOf);
        zaj zaj = new zaj(this, i11, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zaj);
        this.zad.put(i11, zaj);
        if (this.zaa && zam == null) {
            "connecting ".concat(googleApiClient.toString());
            googleApiClient.connect();
        }
    }

    public final void zae(int i11) {
        zaj zaj = (zaj) this.zad.get(i11);
        this.zad.remove(i11);
        if (zaj != null) {
            zaj.zab.unregisterConnectionFailedListener(zaj);
            zaj.zab.disconnect();
        }
    }
}
