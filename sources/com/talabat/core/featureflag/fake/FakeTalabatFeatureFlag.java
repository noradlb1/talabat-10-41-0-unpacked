package com.talabat.core.featureflag.fake;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J)\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ4\u0010\t\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/featureflag/fake/FakeTalabatFeatureFlag;", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "()V", "returnValue", "", "getReturnValue", "()Z", "setReturnValue", "(Z)V", "getFeatureFlag", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "com_talabat_core_feature-flag_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class FakeTalabatFeatureFlag implements ITalabatFeatureFlag {
    private boolean returnValue;

    @Nullable
    public Object getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.returnValue);
    }

    public final boolean getReturnValue() {
        return this.returnValue;
    }

    public final void setReturnValue(boolean z11) {
        this.returnValue = z11;
    }

    public void getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        function1.invoke(Boolean.valueOf(this.returnValue));
    }

    public boolean getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        return this.returnValue;
    }
}
