package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutKt$LazyLayout$1$2$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemContentFactory f3021g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> f3022h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutKt$LazyLayout$1$2$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        super(2);
        this.f3021g = lazyLayoutItemContentFactory;
        this.f3022h = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m737invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m737invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
        return this.f3022h.invoke(new LazyLayoutMeasureScopeImpl(this.f3021g, subcomposeMeasureScope), Constraints.m5410boximpl(j11));
    }
}
