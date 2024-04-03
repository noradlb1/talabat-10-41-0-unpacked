package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    public interface StatusListener {
        @KeepForSdk
        void onComplete(@NonNull Status status);
    }

    @KeepForSdk
    public void addStatusListener(@NonNull StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    public abstract R await();

    @ResultIgnorabilityUnspecified
    @NonNull
    public abstract R await(long j11, @NonNull TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback, long j11, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }
}
