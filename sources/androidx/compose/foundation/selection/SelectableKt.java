package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aS\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000e\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"selectable", "Landroidx/compose/ui/Modifier;", "selected", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "selectable-O2vRcR0", "selectable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SelectableKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* renamed from: selectable-O2vRcR0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m782selectableO2vRcR0(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r13, boolean r14, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.MutableInteractionSource r15, @org.jetbrains.annotations.Nullable androidx.compose.foundation.Indication r16, boolean r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.semantics.Role r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r19) {
        /*
            r0 = r13
            java.lang.String r1 = "$this$selectable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "interactionSource"
            r9 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "onClick"
            r10 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x002a
            androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x002e
        L_0x002a:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x002e:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r6 = 0
            r11 = 8
            r12 = 0
            r3 = r15
            r4 = r16
            r5 = r17
            r7 = r18
            r8 = r19
            r9 = r11
            r10 = r12
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.foundation.selection.SelectableKt$selectable$4$1 r3 = new androidx.compose.foundation.selection.SelectableKt$selectable$4$1
            r4 = r14
            r3.<init>(r14)
            r4 = 1
            r5 = 0
            r6 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r6, r3, r4, r5)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.platform.InspectableValueKt.inspectableWrapper(r13, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.selection.SelectableKt.m782selectableO2vRcR0(androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function0):androidx.compose.ui.Modifier");
    }

    /* renamed from: selectable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m783selectableO2vRcR0$default(Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z12, Role role, Function0 function0, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        boolean z13 = z12;
        if ((i11 & 16) != 0) {
            role = null;
        }
        return m782selectableO2vRcR0(modifier, z11, mutableInteractionSource, indication, z13, role, function0);
    }

    @NotNull
    /* renamed from: selectable-XHw0xAI  reason: not valid java name */
    public static final Modifier m784selectableXHw0xAI(@NotNull Modifier modifier, boolean z11, boolean z12, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$selectable");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1(z11, z12, role, function0);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new SelectableKt$selectable$2(z11, z12, role, function0));
    }

    /* renamed from: selectable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m785selectableXHw0xAI$default(Modifier modifier, boolean z11, boolean z12, Role role, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        if ((i11 & 4) != 0) {
            role = null;
        }
        return m784selectableXHw0xAI(modifier, z11, z12, role, function0);
    }
}
