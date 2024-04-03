package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0010J(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/ButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class ButtonElevation {
    private final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    private ButtonElevation(float f11, float f12, float f13, float f14, float f15) {
        this.defaultElevation = f11;
        this.pressedElevation = f12;
        this.focusedElevation = f13;
        this.hoveredElevation = f14;
        this.disabledElevation = f15;
    }

    public /* synthetic */ ButtonElevation(float f11, float f12, float f13, float f14, float f15, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r0v11 */
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
            r2 = -1312510462(0xffffffffb1c4ae02, float:-5.724133E-9)
            r7.startReplaceableGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001a
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:803)"
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
            androidx.compose.material3.ButtonElevation$animateElevation$1$1 r8 = new androidx.compose.material3.ButtonElevation$animateElevation$1$1
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
            goto L_0x0090
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
            float r0 = r6.defaultElevation
            goto L_0x0076
        L_0x0090:
            r7.startReplaceableGroup(r2)
            java.lang.Object r0 = r20.rememberedValue()
            java.lang.Object r1 = r4.getEmpty()
            if (r0 != r1) goto L_0x00b4
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
        L_0x00b4:
            r20.endReplaceableGroup()
            r8 = r0
            androidx.compose.animation.core.Animatable r8 = (androidx.compose.animation.core.Animatable) r8
            if (r18 != 0) goto L_0x00d2
            r0 = -719929912(0xffffffffd516bdc8, float:-1.03588655E13)
            r7.startReplaceableGroup(r0)
            androidx.compose.ui.unit.Dp r0 = androidx.compose.ui.unit.Dp.m5476boximpl(r3)
            androidx.compose.material3.ButtonElevation$animateElevation$2 r1 = new androidx.compose.material3.ButtonElevation$animateElevation$2
            r1.<init>(r8, r3, r9)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r7, (int) r10)
            r20.endReplaceableGroup()
            goto L_0x00ee
        L_0x00d2:
            r0 = -719929769(0xffffffffd516be57, float:-1.03590155E13)
            r7.startReplaceableGroup(r0)
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m5476boximpl(r3)
            androidx.compose.material3.ButtonElevation$animateElevation$3 r11 = new androidx.compose.material3.ButtonElevation$animateElevation$3
            r12 = 0
            r0 = r11
            r1 = r8
            r2 = r17
            r4 = r5
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r9, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r11, (androidx.compose.runtime.Composer) r7, (int) r10)
            r20.endReplaceableGroup()
        L_0x00ee:
            androidx.compose.runtime.State r0 = r8.asState()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00fb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00fb:
            r20.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonElevation.animateElevation(boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) obj;
        if (Dp.m5483equalsimpl0(this.defaultElevation, buttonElevation.defaultElevation) && Dp.m5483equalsimpl0(this.pressedElevation, buttonElevation.pressedElevation) && Dp.m5483equalsimpl0(this.focusedElevation, buttonElevation.focusedElevation) && Dp.m5483equalsimpl0(this.hoveredElevation, buttonElevation.hoveredElevation) && Dp.m5483equalsimpl0(this.disabledElevation, buttonElevation.disabledElevation)) {
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
        composer.startReplaceableGroup(-2045116089);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045116089, i11, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:795)");
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
        composer.startReplaceableGroup(-423890235);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-423890235, i11, -1, "androidx.compose.material3.ButtonElevation.tonalElevation (Button.kt:779)");
        }
        State<Dp> animateElevation = animateElevation(z11, interactionSource, composer, (i11 & 896) | (i11 & 14) | (i11 & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }
}
