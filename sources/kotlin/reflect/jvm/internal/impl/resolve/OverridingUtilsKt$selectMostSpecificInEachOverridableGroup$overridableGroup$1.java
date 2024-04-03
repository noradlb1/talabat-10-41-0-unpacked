package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1 extends Lambda implements Function1<H, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SmartSet<H> f24801g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(SmartSet<H> smartSet) {
        super(1);
        this.f24801g = smartSet;
    }

    public final void invoke(H h11) {
        SmartSet<H> smartSet = this.f24801g;
        Intrinsics.checkNotNullExpressionValue(h11, "it");
        smartSet.add(h11);
    }
}
