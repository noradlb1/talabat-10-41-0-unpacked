package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$createMeasurePolicy$1", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeSubcompositionsState$createMeasurePolicy$1 extends LayoutNode.NoIntrinsicsMeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeSubcompositionsState f9851a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2<SubcomposeMeasureScope, Constraints, MeasureResult> f9852b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeSubcompositionsState$createMeasurePolicy$1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, String str) {
        super(str);
        this.f9851a = layoutNodeSubcompositionsState;
        this.f9852b = function2;
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m4495measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.f9851a.scope.setLayoutDirection(measureScope.getLayoutDirection());
        this.f9851a.scope.setDensity(measureScope.getDensity());
        this.f9851a.scope.setFontScale(measureScope.getFontScale());
        this.f9851a.currentIndex = 0;
        return new LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1(this.f9852b.invoke(this.f9851a.scope, Constraints.m5410boximpl(j11)), this.f9851a, this.f9851a.currentIndex);
    }
}
