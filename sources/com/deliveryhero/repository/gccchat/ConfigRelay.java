package com.deliveryhero.repository.gccchat;

import com.deliveryhero.contract.model.ConfigMessage;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/repository/gccchat/ConfigRelay;", "", "()V", "relay", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deliveryhero/contract/model/ConfigMessage;", "clearCache", "", "configStream", "Lkotlinx/coroutines/flow/Flow;", "setConfig", "config", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfigRelay {
    @NotNull
    private final MutableSharedFlow<ConfigMessage> relay = SharedFlowKt.MutableSharedFlow$default(1, 0, (BufferOverflow) null, 6, (Object) null);

    public final void clearCache() {
        this.relay.resetReplayCache();
    }

    @NotNull
    public final Flow<ConfigMessage> configStream() {
        return this.relay;
    }

    public final void setConfig(@NotNull ConfigMessage configMessage) {
        Intrinsics.checkNotNullParameter(configMessage, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.relay.tryEmit(configMessage);
    }
}
