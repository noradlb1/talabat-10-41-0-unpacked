package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    @Nullable
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, ResultT> {
        /* access modifiers changed from: private */
        public RemoteCall zaa;
        private boolean zab = true;
        private Feature[] zac;
        private int zad = 0;

        private Builder() {
        }

        public /* synthetic */ Builder(zacw zacw) {
        }

        @NonNull
        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            Preconditions.checkArgument(this.zaa != null, "execute parameter required");
            return new zacv(this, this.zac, this.zab, this.zad);
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        @Deprecated
        public Builder<A, ResultT> execute(@NonNull BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.zaa = new zacu(biConsumer);
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> run(@NonNull RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z11) {
            this.zab = z11;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> setFeatures(@NonNull Feature... featureArr) {
            this.zac = featureArr;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> setMethodKey(int i11) {
            this.zad = i11;
            return this;
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    @KeepForSdk
    public TaskApiCall(@Nullable Feature[] featureArr, boolean z11, int i11) {
        this.zaa = featureArr;
        boolean z12 = false;
        if (featureArr != null && z11) {
            z12 = true;
        }
        this.zab = z12;
        this.zac = i11;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>((zacw) null);
    }

    @KeepForSdk
    public abstract void doExecute(@NonNull A a11, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zac;
    }

    @Nullable
    public final Feature[] zab() {
        return this.zaa;
    }
}
