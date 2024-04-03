package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BoxWithConstraintsKt$BoxWithConstraints$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MeasurePolicy f2465g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f2466h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2467i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxWithConstraintsKt$BoxWithConstraints$1$1(MeasurePolicy measurePolicy, Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f2465g = measurePolicy;
        this.f2466h = function3;
        this.f2467i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m433invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m433invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        return this.f2465g.m4509measure3p2s80s(subcomposeMeasureScope, subcomposeMeasureScope.subcompose(Unit.INSTANCE, ComposableLambdaKt.composableLambdaInstance(-1945019079, true, new BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(this.f2466h, new BoxWithConstraintsScopeImpl(subcomposeMeasureScope, j11, (DefaultConstructorMarker) null), this.f2467i))), j11);
    }
}
