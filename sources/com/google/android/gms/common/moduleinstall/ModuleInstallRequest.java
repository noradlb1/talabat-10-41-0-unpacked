package com.google.android.gms.common.moduleinstall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class ModuleInstallRequest {
    private final List zaa;
    @Nullable
    private final InstallStatusListener zab;
    @Nullable
    private final Executor zac;

    public static class Builder {
        private final List zaa = new ArrayList();
        @Nullable
        private InstallStatusListener zab;
        @Nullable
        private Executor zac;

        @NonNull
        @CanIgnoreReturnValue
        public Builder addApi(@NonNull OptionalModuleApi optionalModuleApi) {
            this.zaa.add(optionalModuleApi);
            return this;
        }

        @NonNull
        public ModuleInstallRequest build() {
            return new ModuleInstallRequest(this.zaa, this.zab, this.zac, true, (zac) null);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setListener(@NonNull InstallStatusListener installStatusListener) {
            return setListener(installStatusListener, (Executor) null);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setListener(@NonNull InstallStatusListener installStatusListener, @Nullable Executor executor) {
            this.zab = installStatusListener;
            this.zac = executor;
            return this;
        }
    }

    public /* synthetic */ ModuleInstallRequest(List list, InstallStatusListener installStatusListener, Executor executor, boolean z11, zac zac2) {
        Preconditions.checkNotNull(list, "APIs must not be null.");
        Preconditions.checkArgument(!list.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            Preconditions.checkNotNull(installStatusListener, "Listener must not be null when listener executor is set.");
        }
        this.zaa = list;
        this.zab = installStatusListener;
        this.zac = executor;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @NonNull
    public List<OptionalModuleApi> getApis() {
        return this.zaa;
    }

    @Nullable
    public InstallStatusListener getListener() {
        return this.zab;
    }

    @Nullable
    public Executor getListenerExecutor() {
        return this.zac;
    }
}
