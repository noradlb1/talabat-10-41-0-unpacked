package androidx.compose.foundation.layout;

import a0.b;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B(\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H\u0016J)\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100R+\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/InsetsPaddingModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "consumedInsets", "getConsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setConsumedInsets", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "consumedInsets$delegate", "Landroidx/compose/runtime/MutableState;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "unconsumedInsets", "getUnconsumedInsets", "setUnconsumedInsets", "unconsumedInsets$delegate", "value", "getValue", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InsetsPaddingModifier extends InspectorValueInfo implements LayoutModifier, ModifierLocalConsumer, ModifierLocalProvider<WindowInsets> {
    @NotNull
    private final MutableState consumedInsets$delegate;
    @NotNull
    private final WindowInsets insets;
    @NotNull
    private final MutableState unconsumedInsets$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InsetsPaddingModifier(@NotNull WindowInsets windowInsets, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.insets = windowInsets;
        this.unconsumedInsets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInsets, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.consumedInsets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInsets, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final WindowInsets getConsumedInsets() {
        return (WindowInsets) this.consumedInsets$delegate.getValue();
    }

    private final WindowInsets getUnconsumedInsets() {
        return (WindowInsets) this.unconsumedInsets$delegate.getValue();
    }

    private final void setConsumedInsets(WindowInsets windowInsets) {
        this.consumedInsets$delegate.setValue(windowInsets);
    }

    private final void setUnconsumedInsets(WindowInsets windowInsets) {
        this.unconsumedInsets$delegate.setValue(windowInsets);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsPaddingModifier)) {
            return false;
        }
        return Intrinsics.areEqual((Object) ((InsetsPaddingModifier) obj).insets, (Object) this.insets);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public ProvidableModifierLocal<WindowInsets> getKey() {
        return WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
    }

    public int hashCode() {
        return this.insets.hashCode();
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m454measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        int left = getUnconsumedInsets().getLeft(measureScope, measureScope.getLayoutDirection());
        int top = getUnconsumedInsets().getTop(measureScope);
        int right = getUnconsumedInsets().getRight(measureScope, measureScope.getLayoutDirection()) + left;
        int bottom = getUnconsumedInsets().getBottom(measureScope) + top;
        Placeable r12 = measurable.m4508measureBRTryo0(ConstraintsKt.m5438offsetNN6EwU(j11, -right, -bottom));
        return MeasureScope.CC.p(measureScope, ConstraintsKt.m5436constrainWidthK40F9xA(j11, r12.getWidth() + right), ConstraintsKt.m5435constrainHeightK40F9xA(j11, r12.getHeight() + bottom), (Map) null, new InsetsPaddingModifier$measure$1(r12, left, top), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        WindowInsets windowInsets = (WindowInsets) modifierLocalReadScope.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        setUnconsumedInsets(WindowInsetsKt.exclude(this.insets, windowInsets));
        setConsumedInsets(WindowInsetsKt.union(windowInsets, this.insets));
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a0.a.a(this, modifier);
    }

    @NotNull
    public WindowInsets getValue() {
        return getConsumedInsets();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InsetsPaddingModifier(WindowInsets windowInsets, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, (i11 & 2) != 0 ? InspectableValueKt.isDebugInspectorInfoEnabled() ? new InsetsPaddingModifier$special$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo() : function1);
    }
}
