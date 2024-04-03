package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public abstract class PendingResultFacade<A extends Result, B extends Result> extends PendingResult<B> {
    public final void addStatusListener(@NonNull PendingResult.StatusListener statusListener) {
        throw null;
    }

    @NonNull
    public final B await() {
        throw null;
    }

    @NonNull
    public final B await(long j11, @NonNull TimeUnit timeUnit) {
        throw null;
    }

    public final void cancel() {
        throw null;
    }

    public final boolean isCanceled() {
        throw null;
    }

    public final void setResultCallback(@NonNull ResultCallback<? super B> resultCallback) {
        throw null;
    }

    public final void setResultCallback(@NonNull ResultCallback<? super B> resultCallback, long j11, @NonNull TimeUnit timeUnit) {
        throw null;
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super B, ? extends S> resultTransform) {
        throw null;
    }
}
