package com.talabat.talabatremoteconfiguration;

import androidx.annotation.VisibleForTesting;
import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.datasource.fwf.FwfRemoteConfigurationDataSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e¢\u0006\u0002\u0010\u000fJ=\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012JK\u0010\b\u001a\u00020\u0013\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0007J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "", "()V", "<set-?>", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "remoteConfigurationDataSource", "getRemoteConfigurationDataSource", "()Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "getRemoteConfiguration", "T", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "classType", "Ljava/lang/Class;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "forceRequest", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "resetRemoteConfigurationDataSource", "setRemoteConfigurationDataSource", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Inject [IRemoteConfigurationDataSource] from [RemoteConfigCoreLibApi] and dont use this global singleton directly")
public final class RemoteConfiguration {
    @NotNull
    public static final RemoteConfiguration INSTANCE = new RemoteConfiguration();
    @NotNull
    private static IRemoteConfigurationDataSource remoteConfigurationDataSource = new FwfRemoteConfigurationDataSource((IFunWithFlags) null, 1, (DefaultConstructorMarker) null);

    private RemoteConfiguration() {
    }

    @Nullable
    public final <T> Object getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Continuation<? super T> continuation) {
        return remoteConfigurationDataSource.getRemoteConfiguration(fWFKey, t11, z11, cls, continuation);
    }

    @NotNull
    public final IRemoteConfigurationDataSource getRemoteConfigurationDataSource() {
        return remoteConfigurationDataSource;
    }

    @VisibleForTesting
    public final void resetRemoteConfigurationDataSource() {
        remoteConfigurationDataSource = new FwfRemoteConfigurationDataSource((IFunWithFlags) null, 1, (DefaultConstructorMarker) null);
    }

    @VisibleForTesting
    public final void setRemoteConfigurationDataSource(@NotNull IRemoteConfigurationDataSource iRemoteConfigurationDataSource) {
        Intrinsics.checkNotNullParameter(iRemoteConfigurationDataSource, "remoteConfigurationDataSource");
        remoteConfigurationDataSource = iRemoteConfigurationDataSource;
    }

    public final <T> void getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(cls, "classType");
        Intrinsics.checkNotNullParameter(function1, "callback");
        remoteConfigurationDataSource.getRemoteConfiguration(fWFKey, t11, z11, cls, function1);
    }

    public final <T> T getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(cls, "classType");
        return remoteConfigurationDataSource.getRemoteConfiguration(fWFKey, t11, cls);
    }
}
