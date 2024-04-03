package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H\u0007\u001a \u0010\u0004\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\u001a\"\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"focusGroupInspectorInfo", "Landroidx/compose/ui/platform/InspectableModifier;", "focusGroup", "Landroidx/compose/ui/Modifier;", "focusable", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusableInNonTouchMode", "onPinnableParentAvailable", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/PinnableParent;", "", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FocusableKt {
    @NotNull
    private static final InspectableModifier focusGroupInspectorInfo;

    static {
        Function1 function1;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new FocusableKt$special$$inlined$debugInspectorInfo$1();
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        focusGroupInspectorInfo = new InspectableModifier(function1);
    }

    @NotNull
    @ExperimentalFoundationApi
    public static final Modifier focusGroup(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties(modifier.then(focusGroupInspectorInfo), FocusableKt$focusGroup$1.INSTANCE));
    }

    @NotNull
    public static final Modifier focusable(@NotNull Modifier modifier, boolean z11, @Nullable MutableInteractionSource mutableInteractionSource) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new FocusableKt$focusable$$inlined$debugInspectorInfo$1(z11, mutableInteractionSource);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new FocusableKt$focusable$2(mutableInteractionSource, z11));
    }

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z11, mutableInteractionSource);
    }

    @NotNull
    public static final Modifier focusableInNonTouchMode(@NotNull Modifier modifier, boolean z11, @Nullable MutableInteractionSource mutableInteractionSource) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new FocusableKt$focusableInNonTouchMode$$inlined$debugInspectorInfo$1(z11, mutableInteractionSource);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new FocusableKt$focusableInNonTouchMode$2(z11, mutableInteractionSource));
    }

    /* access modifiers changed from: private */
    @ExperimentalFoundationApi
    @Stable
    public static final Modifier onPinnableParentAvailable(Modifier modifier, Function1<? super PinnableParent, Unit> function1) {
        Function1 function12;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new FocusableKt$onPinnableParentAvailable$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return InspectableValueKt.inspectableWrapper(modifier, function12, Modifier.Companion.then(new PinnableParentConsumer(function1)));
    }
}
