package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0011J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/ChipElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class ChipElevation {
    private final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float draggedElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    private ChipElevation(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.defaultElevation = f11;
        this.pressedElevation = f12;
        this.focusedElevation = f13;
        this.hoveredElevation = f14;
        this.draggedElevation = f15;
        this.disabledElevation = f16;
    }

    public /* synthetic */ ChipElevation(float f11, float f12, float f13, float f14, float f15, float f16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15, f16);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> animateElevation(boolean r18, androidx.compose.foundation.interaction.InteractionSource r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r0 = r19
            r7 = r20
            r1 = r21
            r2 = -2071499570(0xffffffff84876cce, float:-3.183827E-36)
            r7.startReplaceableGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001a
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.ChipElevation.animateElevation (Chip.kt:1498)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r3, r4)
        L_0x001a:
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r2)
            java.lang.Object r3 = r20.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            if (r3 != r5) goto L_0x0033
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r7.updateRememberedValue(r3)
        L_0x0033:
            r20.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            int r1 = r1 >> 3
            r1 = r1 & 14
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r5)
            boolean r5 = r7.changed((java.lang.Object) r0)
            boolean r8 = r7.changed((java.lang.Object) r3)
            r5 = r5 | r8
            java.lang.Object r8 = r20.rememberedValue()
            r9 = 0
            if (r5 != 0) goto L_0x0058
            java.lang.Object r5 = r4.getEmpty()
            if (r8 != r5) goto L_0x0060
        L_0x0058:
            androidx.compose.material3.ChipElevation$animateElevation$1$1 r8 = new androidx.compose.material3.ChipElevation$animateElevation$1$1
            r8.<init>(r0, r3, r9)
            r7.updateRememberedValue(r8)
        L_0x0060:
            r20.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r10 = 64
            r1 = r1 | r10
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8, (androidx.compose.runtime.Composer) r7, (int) r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r3)
            r5 = r0
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            if (r18 != 0) goto L_0x0078
            float r0 = r6.disabledElevation
        L_0x0076:
            r3 = r0
            goto L_0x0097
        L_0x0078:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
            if (r0 == 0) goto L_0x007f
            float r0 = r6.pressedElevation
            goto L_0x0076
        L_0x007f:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.HoverInteraction.Enter
            if (r0 == 0) goto L_0x0086
            float r0 = r6.hoveredElevation
            goto L_0x0076
        L_0x0086:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.FocusInteraction.Focus
            if (r0 == 0) goto L_0x008d
            float r0 = r6.focusedElevation
            goto L_0x0076
        L_0x008d:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.DragInteraction.Start
            if (r0 == 0) goto L_0x0094
            float r0 = r6.draggedElevation
            goto L_0x0076
        L_0x0094:
            float r0 = r6.defaultElevation
            goto L_0x0076
        L_0x0097:
            r7.startReplaceableGroup(r2)
            java.lang.Object r0 = r20.rememberedValue()
            java.lang.Object r1 = r4.getEmpty()
            if (r0 != r1) goto L_0x00bb
            androidx.compose.animation.core.Animatable r0 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.unit.Dp r12 = androidx.compose.ui.unit.Dp.m5476boximpl(r3)
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r13 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r1)
            r14 = 0
            r15 = 4
            r16 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16)
            r7.updateRememberedValue(r0)
        L_0x00bb:
            r20.endReplaceableGroup()
            r8 = r0
            androidx.compose.animation.core.Animatable r8 = (androidx.compose.animation.core.Animatable) r8
            if (r18 != 0) goto L_0x00d9
            r0 = -1373769429(0xffffffffae1df12b, float:-3.5911867E-11)
            r7.startReplaceableGroup(r0)
            androidx.compose.ui.unit.Dp r0 = androidx.compose.ui.unit.Dp.m5476boximpl(r3)
            androidx.compose.material3.ChipElevation$animateElevation$2 r1 = new androidx.compose.material3.ChipElevation$animateElevation$2
            r1.<init>(r8, r3, r9)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r7, (int) r10)
            r20.endReplaceableGroup()
            goto L_0x00f5
        L_0x00d9:
            r0 = -1373769286(0xffffffffae1df1ba, float:-3.5912363E-11)
            r7.startReplaceableGroup(r0)
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m5476boximpl(r3)
            androidx.compose.material3.ChipElevation$animateElevation$3 r11 = new androidx.compose.material3.ChipElevation$animateElevation$3
            r12 = 0
            r0 = r11
            r1 = r8
            r2 = r17
            r4 = r5
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r9, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r11, (androidx.compose.runtime.Composer) r7, (int) r10)
            r20.endReplaceableGroup()
        L_0x00f5:
            androidx.compose.runtime.State r0 = r8.asState()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0102
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0102:
            r20.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipElevation.animateElevation(boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipElevation)) {
            return false;
        }
        ChipElevation chipElevation = (ChipElevation) obj;
        if (Dp.m5483equalsimpl0(this.defaultElevation, chipElevation.defaultElevation) && Dp.m5483equalsimpl0(this.pressedElevation, chipElevation.pressedElevation) && Dp.m5483equalsimpl0(this.focusedElevation, chipElevation.focusedElevation) && Dp.m5483equalsimpl0(this.hoveredElevation, chipElevation.hoveredElevation) && Dp.m5483equalsimpl0(this.disabledElevation, chipElevation.disabledElevation)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Dp.m5484hashCodeimpl(this.defaultElevation) * 31) + Dp.m5484hashCodeimpl(this.pressedElevation)) * 31) + Dp.m5484hashCodeimpl(this.focusedElevation)) * 31) + Dp.m5484hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m5484hashCodeimpl(this.disabledElevation);
    }

    @NotNull
    @Composable
    public final State<Dp> shadowElevation$material3_release(boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1881877139);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1881877139, i11, -1, "androidx.compose.material3.ChipElevation.shadowElevation (Chip.kt:1490)");
        }
        State<Dp> animateElevation = animateElevation(z11, interactionSource, composer, (i11 & 896) | (i11 & 14) | (i11 & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }

    @NotNull
    @Composable
    public final State<Dp> tonalElevation$material3_release(boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1108183825);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1108183825, i11, -1, "androidx.compose.material3.ChipElevation.tonalElevation (Chip.kt:1471)");
        }
        State<Dp> animateElevation = animateElevation(z11, interactionSource, composer, (i11 & 896) | (i11 & 14) | (i11 & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }
}
