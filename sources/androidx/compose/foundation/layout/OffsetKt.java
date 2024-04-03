package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a-\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"absoluteOffset", "Landroidx/compose/ui/Modifier;", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "absoluteOffset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "offset-VpY3zN4", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OffsetKt {
    @NotNull
    public static final Modifier absoluteOffset(@NotNull Modifier modifier, @NotNull Function1<? super Density, IntOffset> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "offset");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new OffsetKt$absoluteOffset$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new OffsetPxModifier(function1, false, function12));
    }

    @NotNull
    @Stable
    /* renamed from: absoluteOffset-VpY3zN4  reason: not valid java name */
    public static final Modifier m470absoluteOffsetVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$absoluteOffset");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new OffsetKt$absoluteOffsetVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new OffsetModifier(f11, f12, false, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: absoluteOffset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m471absoluteOffsetVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        return m470absoluteOffsetVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    public static final Modifier offset(@NotNull Modifier modifier, @NotNull Function1<? super Density, IntOffset> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "offset");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new OffsetKt$offset$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new OffsetPxModifier(function1, true, function12));
    }

    @NotNull
    @Stable
    /* renamed from: offset-VpY3zN4  reason: not valid java name */
    public static final Modifier m472offsetVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$offset");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new OffsetKt$offsetVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new OffsetModifier(f11, f12, true, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: offset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m473offsetVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        return m472offsetVpY3zN4(modifier, f11, f12);
    }
}
