package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */
    @Nullable
    public ResultTransform zaa = null;
    /* access modifiers changed from: private */
    @Nullable
    public zada zab = null;
    @Nullable
    private volatile ResultCallbacks zac = null;
    @Nullable
    private PendingResult zad = null;
    /* access modifiers changed from: private */
    public final Object zae = new Object();
    @Nullable
    private Status zaf = null;
    /* access modifiers changed from: private */
    public final WeakReference zag;
    /* access modifiers changed from: private */
    public final zacz zah;
    private boolean zai = false;

    public zada(WeakReference weakReference) {
        Looper looper;
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        if (googleApiClient != null) {
            looper = googleApiClient.getLooper();
        } else {
            looper = Looper.getMainLooper();
        }
        this.zah = new zacz(this, looper);
    }

    /* access modifiers changed from: private */
    public final void zaj(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zal(status);
        }
    }

    @GuardedBy("mSyncToken")
    private final void zak() {
        if (this.zaa != null || this.zac != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
            if (!(this.zai || this.zaa == null || googleApiClient == null)) {
                googleApiClient.zao(this);
                this.zai = true;
            }
            Status status = this.zaf;
            if (status != null) {
                zal(status);
                return;
            }
            PendingResult pendingResult = this.zad;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    private final void zal(Status status) {
        synchronized (this.zae) {
            ResultTransform resultTransform = this.zaa;
            if (resultTransform != null) {
                ((zada) Preconditions.checkNotNull(this.zab)).zaj((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
            } else if (zam()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onFailure(status);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean zam() {
        return (this.zac == null || ((GoogleApiClient) this.zag.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public static final void zan(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e11) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e11);
            }
        }
    }

    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z11;
        synchronized (this.zae) {
            boolean z12 = true;
            if (this.zac == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Cannot call andFinally() twice.");
            if (this.zaa != null) {
                z12 = false;
            }
            Preconditions.checkState(z12, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zac = resultCallbacks;
            zak();
        }
    }

    public final void onResult(Result result) {
        synchronized (this.zae) {
            if (!result.getStatus().isSuccess()) {
                zaj(result.getStatus());
                zan(result);
            } else if (this.zaa != null) {
                zaco.zaa().submit(new zacy(this, result));
            } else if (zam()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onSuccess(result);
            }
        }
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z11;
        zada zada;
        synchronized (this.zae) {
            boolean z12 = true;
            if (this.zaa == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Cannot call then() twice.");
            if (this.zac != null) {
                z12 = false;
            }
            Preconditions.checkState(z12, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = resultTransform;
            zada = new zada(this.zag);
            this.zab = zada;
            zak();
        }
        return zada;
    }

    public final void zah() {
        this.zac = null;
    }

    public final void zai(PendingResult pendingResult) {
        synchronized (this.zae) {
            this.zad = pendingResult;
            zak();
        }
    }
}
