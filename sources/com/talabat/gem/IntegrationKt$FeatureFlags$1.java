package com.talabat.gem;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.gem.ports.flags.FeatureFlagPort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/talabat/gem/IntegrationKt$FeatureFlags$1", "Lcom/talabat/gem/ports/flags/FeatureFlagPort;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationKt$FeatureFlags$1 implements FeatureFlagPort {
    @Nullable
    public Object getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        return FeatureFlagPort.DefaultImpls.getFeatureFlag((FeatureFlagPort) this, fWFKey, z11, z12, continuation);
    }

    public void getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        FeatureFlagPort.DefaultImpls.getFeatureFlag((FeatureFlagPort) this, fWFKey, z11, z12, function1);
    }

    public boolean getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11) {
        return FeatureFlagPort.DefaultImpls.getFeatureFlag(this, fWFKey, z11);
    }
}
