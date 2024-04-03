package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class zaal implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference zaa;
    private final Api zab;
    /* access modifiers changed from: private */
    public final boolean zac;

    public zaal(zaaw zaaw, Api api, boolean z11) {
        this.zaa = new WeakReference(zaaw);
        this.zab = api;
        this.zac = z11;
    }

    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        boolean z11;
        Lock zap;
        zaaw zaaw = (zaaw) this.zaa.get();
        if (zaaw != null) {
            if (Looper.myLooper() == zaaw.zaa.zag.getLooper()) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaaw.zab.lock();
            try {
                if (!zaaw.zaG(0)) {
                    zap = zaaw.zab;
                } else {
                    if (!connectionResult.isSuccess()) {
                        zaaw.zaE(connectionResult, this.zab, this.zac);
                    }
                    if (zaaw.zaH()) {
                        zaaw.zaF();
                    }
                    zap = zaaw.zab;
                }
                zap.unlock();
            } catch (Throwable th2) {
                zaaw.zab.unlock();
                throw th2;
            }
        }
    }
}
