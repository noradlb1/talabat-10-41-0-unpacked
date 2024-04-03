package com.talabat.talabatcommon.views.darkstores.lookingGlass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LookingGlassView$observatory$1 extends FunctionReferenceImpl implements Function1<ABTestResult, Unit> {
    public LookingGlassView$observatory$1(Object obj) {
        super(1, obj, LookingGlassView.class, "getABTestResults", "getABTestResults(Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/ABTestResult;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ABTestResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ABTestResult aBTestResult) {
        ((LookingGlassView) this.receiver).getABTestResults(aBTestResult);
    }
}
