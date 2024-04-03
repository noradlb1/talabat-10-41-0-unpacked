package com.talabat.gem.adapters.flags;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.gem.GemIntegrationDsl;
import com.talabat.gem.ports.flags.FeatureFlagPort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@GemIntegrationDsl
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ4\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/gem/adapters/flags/GemFeatureFlags;", "Lcom/talabat/gem/ports/flags/FeatureFlagPort;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getFeatureFlag", "", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemFeatureFlags implements FeatureFlagPort {
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public GemFeatureFlags(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @Nullable
    public Object getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        return this.talabatFeatureFlag.getFeatureFlag(fWFKey, z11, z12, continuation);
    }

    public void getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.talabatFeatureFlag.getFeatureFlag(fWFKey, z11, z12, function1);
    }

    public boolean getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        return this.talabatFeatureFlag.getFeatureFlag(fWFKey, z11);
    }
}
