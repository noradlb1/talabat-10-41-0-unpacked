package com.talabat.talabatremoteconfiguration.datasource.fake;

import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.datasource.fwf.FwfRemoteConfigurationParser;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u0011H\u0016¢\u0006\u0002\u0010\u0012J=\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015JM\u0010\u000b\u001a\u00020\u0016\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00160\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/datasource/fake/FakeRemoteConfigurationDataSource;", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "fwf", "Lcom/talabat/core/fwf/domain/IFunWithFlags;", "(Lcom/talabat/core/fwf/domain/IFunWithFlags;)V", "parser", "Lcom/talabat/talabatremoteconfiguration/datasource/fwf/FwfRemoteConfigurationParser;", "getParser", "()Lcom/talabat/talabatremoteconfiguration/datasource/fwf/FwfRemoteConfigurationParser;", "parser$delegate", "Lkotlin/Lazy;", "getRemoteConfiguration", "T", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "classType", "Ljava/lang/Class;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "forceRequest", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeRemoteConfigurationDataSource implements IRemoteConfigurationDataSource {
    @NotNull
    private final IFunWithFlags fwf;
    @NotNull
    private final Lazy parser$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, FakeRemoteConfigurationDataSource$parser$2.INSTANCE);

    @Inject
    public FakeRemoteConfigurationDataSource(@NotNull IFunWithFlags iFunWithFlags) {
        Intrinsics.checkNotNullParameter(iFunWithFlags, "fwf");
        this.fwf = iFunWithFlags;
    }

    /* access modifiers changed from: private */
    public final FwfRemoteConfigurationParser getParser() {
        return (FwfRemoteConfigurationParser) this.parser$delegate.getValue();
    }

    @Nullable
    public <T> Object getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        IFunWithFlags iFunWithFlags = this.fwf;
        if (t11 != null) {
            iFunWithFlags.getVariation(fWFKey, t11, z11, new FakeRemoteConfigurationDataSource$getRemoteConfiguration$2$1(safeContinuation, this, t11, cls));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public <T> void getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(cls, "classType");
        Intrinsics.checkNotNullParameter(function1, "callback");
        IFunWithFlags iFunWithFlags = this.fwf;
        if (t11 != null) {
            iFunWithFlags.getVariation(fWFKey, t11, z11, new FakeRemoteConfigurationDataSource$getRemoteConfiguration$3(function1, this, t11, cls));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public <T> T getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(cls, "classType");
        IFunWithFlags iFunWithFlags = this.fwf;
        if (t11 != null) {
            return getParser().getTheVariationValue(iFunWithFlags.getVariation(fWFKey, t11), t11, cls);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }
}
