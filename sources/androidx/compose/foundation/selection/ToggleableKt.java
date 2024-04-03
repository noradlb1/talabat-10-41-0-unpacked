package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000e\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000f\u001aS\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001aA\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-O2vRcR0", "toggleable-XHw0xAI", "triStateToggleable", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "triStateToggleable-O2vRcR0", "triStateToggleable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ToggleableKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r0v4, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* renamed from: toggleable-O2vRcR0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m786toggleableO2vRcR0(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r8, boolean r9, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.MutableInteractionSource r10, @org.jetbrains.annotations.Nullable androidx.compose.foundation.Indication r11, boolean r12, @org.jetbrains.annotations.Nullable androidx.compose.ui.semantics.Role r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r14) {
        /*
            java.lang.String r0 = "$this$toggleable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r0 == 0) goto L_0x0022
            androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$$inlined$debugInspectorInfo$1 r0 = new androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$$inlined$debugInspectorInfo$1
            r1 = r0
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0026
        L_0x0022:
            kotlin.jvm.functions.Function1 r0 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x0026:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.state.ToggleableState r2 = androidx.compose.ui.state.ToggleableStateKt.ToggleableState(r9)
            androidx.compose.foundation.selection.ToggleableKt$toggleable$4$1 r7 = new androidx.compose.foundation.selection.ToggleableKt$toggleable$4$1
            r7.<init>(r14, r9)
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            androidx.compose.ui.Modifier r9 = m790triStateToggleableO2vRcR0(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.platform.InspectableValueKt.inspectableWrapper(r8, r0, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.selection.ToggleableKt.m786toggleableO2vRcR0(androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function1):androidx.compose.ui.Modifier");
    }

    /* renamed from: toggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m787toggleableO2vRcR0$default(Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z12, Role role, Function1 function1, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        boolean z13 = z12;
        if ((i11 & 16) != 0) {
            role = null;
        }
        return m786toggleableO2vRcR0(modifier, z11, mutableInteractionSource, indication, z13, role, function1);
    }

    @NotNull
    /* renamed from: toggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m788toggleableXHw0xAI(@NotNull Modifier modifier, boolean z11, boolean z12, @Nullable Role role, @NotNull Function1<? super Boolean, Unit> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "$this$toggleable");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(z11, z12, role, function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function12, new ToggleableKt$toggleable$2(z11, z12, role, function1));
    }

    /* renamed from: toggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m789toggleableXHw0xAI$default(Modifier modifier, boolean z11, boolean z12, Role role, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        if ((i11 & 4) != 0) {
            role = null;
        }
        return m788toggleableXHw0xAI(modifier, z11, z12, role, function1);
    }

    @NotNull
    /* renamed from: triStateToggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m790triStateToggleableO2vRcR0(@NotNull Modifier modifier, @NotNull ToggleableState toggleableState, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z11, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Function1<InspectorInfo, Unit> function1;
        Modifier modifier2 = modifier;
        ToggleableState toggleableState2 = toggleableState;
        Intrinsics.checkNotNullParameter(modifier2, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(toggleableState2, "state");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1(toggleableState, z11, role, mutableInteractionSource, indication, function0);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return InspectableValueKt.inspectableWrapper(modifier2, function1, SemanticsModifierKt.semantics$default(ClickableKt.m194clickableO2vRcR0$default(Modifier.Companion, mutableInteractionSource, indication, z11, (String) null, role, function0, 8, (Object) null), false, new ToggleableKt$triStateToggleable$4$1(toggleableState2), 1, (Object) null));
    }

    /* renamed from: triStateToggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m791triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, Role role, Function0 function0, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            role = null;
        }
        return m790triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z12, role, function0);
    }

    @NotNull
    /* renamed from: triStateToggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m792triStateToggleableXHw0xAI(@NotNull Modifier modifier, @NotNull ToggleableState toggleableState, boolean z11, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(toggleableState, z11, role, function0);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new ToggleableKt$triStateToggleable$2(toggleableState, z11, role, function0));
    }

    /* renamed from: triStateToggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m793triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z11, Role role, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            role = null;
        }
        return m792triStateToggleableXHw0xAI(modifier, toggleableState, z11, role, function0);
    }
}
