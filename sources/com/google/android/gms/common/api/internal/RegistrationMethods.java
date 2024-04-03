package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L> {
    @NonNull
    @KeepForSdk
    public final RegisterListenerMethod<A, L> register;
    @NonNull
    public final UnregisterListenerMethod zaa;
    @NonNull
    public final Runnable zab;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L> {
        /* access modifiers changed from: private */
        public RemoteCall zaa;
        /* access modifiers changed from: private */
        public RemoteCall zab;
        private Runnable zac = zacj.zaa;
        private ListenerHolder zad;
        private Feature[] zae;
        private boolean zaf = true;
        private int zag;

        private Builder() {
        }

        public /* synthetic */ Builder(zacm zacm) {
        }

        @NonNull
        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            boolean z11;
            boolean z12;
            boolean z13 = true;
            if (this.zaa != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Must set register function");
            if (this.zab != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkArgument(z12, "Must set unregister function");
            if (this.zad == null) {
                z13 = false;
            }
            Preconditions.checkArgument(z13, "Must set holder");
            return new RegistrationMethods<>(new zack(this, this.zad, this.zae, this.zaf, this.zag), new zacl(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.zad.getListenerKey(), "Key must not be null")), this.zac, (zacn) null);
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, L> onConnectionSuspended(@NonNull Runnable runnable) {
            this.zac = runnable;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, L> register(@NonNull RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(boolean z11) {
            this.zaf = z11;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, L> setFeatures(@NonNull Feature... featureArr) {
            this.zae = featureArr;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, L> setMethodKey(int i11) {
            this.zag = i11;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, L> unregister(@NonNull RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.zab = remoteCall;
            return this;
        }

        @CanIgnoreReturnValue
        @NonNull
        @KeepForSdk
        public Builder<A, L> withHolder(@NonNull ListenerHolder<L> listenerHolder) {
            this.zad = listenerHolder;
            return this;
        }
    }

    public /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacn zacn) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>((zacm) null);
    }
}
