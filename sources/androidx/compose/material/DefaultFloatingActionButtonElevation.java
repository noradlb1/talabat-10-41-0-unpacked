package androidx.compose.material;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\rR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/DefaultFloatingActionButtonElevation;", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Stable
final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {
    private final float defaultElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    private DefaultFloatingActionButtonElevation(float f11, float f12, float f13, float f14) {
        this.defaultElevation = f11;
        this.pressedElevation = f12;
        this.hoveredElevation = f13;
        this.focusedElevation = f14;
    }

    public /* synthetic */ DefaultFloatingActionButtonElevation(float f11, float f12, float f13, float f14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> elevation(@org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.InteractionSource r10, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r11, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -478475335(0xffffffffe37b0bb9, float:-4.6309775E21)
            r11.startReplaceableGroup(r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r2.getEmpty()
            if (r1 != r3) goto L_0x0024
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r11.updateRememberedValue(r1)
        L_0x0024:
            r11.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = (androidx.compose.runtime.snapshots.SnapshotStateList) r1
            androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1 r3 = new androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1
            r4 = 0
            r3.<init>(r10, r1, r4)
            r12 = r12 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r10, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r3, (androidx.compose.runtime.Composer) r11, (int) r12)
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r1)
            r7 = r10
            androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
            boolean r10 = r7 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
            if (r10 == 0) goto L_0x0043
            float r10 = r9.pressedElevation
        L_0x0041:
            r6 = r10
            goto L_0x0054
        L_0x0043:
            boolean r10 = r7 instanceof androidx.compose.foundation.interaction.HoverInteraction.Enter
            if (r10 == 0) goto L_0x004a
            float r10 = r9.hoveredElevation
            goto L_0x0041
        L_0x004a:
            boolean r10 = r7 instanceof androidx.compose.foundation.interaction.FocusInteraction.Focus
            if (r10 == 0) goto L_0x0051
            float r10 = r9.focusedElevation
            goto L_0x0041
        L_0x0051:
            float r10 = r9.defaultElevation
            goto L_0x0041
        L_0x0054:
            r11.startReplaceableGroup(r0)
            java.lang.Object r10 = r11.rememberedValue()
            java.lang.Object r12 = r2.getEmpty()
            if (r10 != r12) goto L_0x0077
            androidx.compose.animation.core.Animatable r10 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5476boximpl(r6)
            androidx.compose.ui.unit.Dp$Companion r12 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r2 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r12)
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            r11.updateRememberedValue(r10)
        L_0x0077:
            r11.endReplaceableGroup()
            androidx.compose.animation.core.Animatable r10 = (androidx.compose.animation.core.Animatable) r10
            androidx.compose.ui.unit.Dp r12 = androidx.compose.ui.unit.Dp.m5476boximpl(r6)
            androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2 r0 = new androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2
            r8 = 0
            r3 = r0
            r4 = r10
            r5 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            r1 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r11, (int) r1)
            androidx.compose.runtime.State r10 = r10.asState()
            r11.endReplaceableGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DefaultFloatingActionButtonElevation.elevation(androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }
}
