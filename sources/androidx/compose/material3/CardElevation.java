package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0011J*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/CardElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardElevation {
    /* access modifiers changed from: private */
    public final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float draggedElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    private CardElevation(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.defaultElevation = f11;
        this.pressedElevation = f12;
        this.focusedElevation = f13;
        this.hoveredElevation = f14;
        this.draggedElevation = f15;
        this.disabledElevation = f16;
    }

    public /* synthetic */ CardElevation(float f11, float f12, float f13, float f14, float f15, float f16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15, f16);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> animateElevation(boolean r17, androidx.compose.foundation.interaction.InteractionSource r18, androidx.compose.runtime.Composer r19, int r20) {
        /*
            r16 = this;
            r7 = r16
            r0 = r18
            r8 = r19
            r1 = r20
            r2 = -1421890746(0xffffffffab3fab46, float:-6.809452E-13)
            r8.startReplaceableGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001a
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.CardElevation.animateElevation (Card.kt:612)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r3, r4)
        L_0x001a:
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            java.lang.Object r3 = r19.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            if (r3 != r5) goto L_0x0033
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r8.updateRememberedValue(r3)
        L_0x0033:
            r19.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            int r1 = r1 >> 3
            r1 = r1 & 14
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r8.startReplaceableGroup(r5)
            boolean r5 = r8.changed((java.lang.Object) r0)
            boolean r6 = r8.changed((java.lang.Object) r3)
            r5 = r5 | r6
            java.lang.Object r6 = r19.rememberedValue()
            if (r5 != 0) goto L_0x0057
            java.lang.Object r5 = r4.getEmpty()
            if (r6 != r5) goto L_0x0060
        L_0x0057:
            androidx.compose.material3.CardElevation$animateElevation$1$1 r6 = new androidx.compose.material3.CardElevation$animateElevation$1$1
            r5 = 0
            r6.<init>(r0, r3, r5)
            r8.updateRememberedValue(r6)
        L_0x0060:
            r19.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r9 = 64
            r1 = r1 | r9
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r6, (androidx.compose.runtime.Composer) r8, (int) r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r3)
            r5 = r0
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            if (r17 != 0) goto L_0x0078
            float r0 = r7.disabledElevation
        L_0x0076:
            r6 = r0
            goto L_0x0097
        L_0x0078:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
            if (r0 == 0) goto L_0x007f
            float r0 = r7.pressedElevation
            goto L_0x0076
        L_0x007f:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.HoverInteraction.Enter
            if (r0 == 0) goto L_0x0086
            float r0 = r7.hoveredElevation
            goto L_0x0076
        L_0x0086:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.FocusInteraction.Focus
            if (r0 == 0) goto L_0x008d
            float r0 = r7.focusedElevation
            goto L_0x0076
        L_0x008d:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.DragInteraction.Start
            if (r0 == 0) goto L_0x0094
            float r0 = r7.draggedElevation
            goto L_0x0076
        L_0x0094:
            float r0 = r7.defaultElevation
            goto L_0x0076
        L_0x0097:
            r8.startReplaceableGroup(r2)
            java.lang.Object r0 = r19.rememberedValue()
            java.lang.Object r1 = r4.getEmpty()
            if (r0 != r1) goto L_0x00ba
            androidx.compose.animation.core.Animatable r0 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r6)
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r12 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r1)
            r13 = 0
            r14 = 4
            r15 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)
            r8.updateRememberedValue(r0)
        L_0x00ba:
            r19.endReplaceableGroup()
            r10 = r0
            androidx.compose.animation.core.Animatable r10 = (androidx.compose.animation.core.Animatable) r10
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r6)
            androidx.compose.material3.CardElevation$animateElevation$2 r12 = new androidx.compose.material3.CardElevation$animateElevation$2
            r13 = 0
            r0 = r12
            r1 = r17
            r2 = r10
            r3 = r16
            r4 = r6
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r12, (androidx.compose.runtime.Composer) r8, (int) r9)
            androidx.compose.runtime.State r0 = r10.asState()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00e2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00e2:
            r19.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardElevation.animateElevation(boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CardElevation)) {
            return false;
        }
        CardElevation cardElevation = (CardElevation) obj;
        if (Dp.m5483equalsimpl0(this.defaultElevation, cardElevation.defaultElevation) && Dp.m5483equalsimpl0(this.pressedElevation, cardElevation.pressedElevation) && Dp.m5483equalsimpl0(this.focusedElevation, cardElevation.focusedElevation) && Dp.m5483equalsimpl0(this.hoveredElevation, cardElevation.hoveredElevation) && Dp.m5483equalsimpl0(this.disabledElevation, cardElevation.disabledElevation)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Dp.m5484hashCodeimpl(this.defaultElevation) * 31) + Dp.m5484hashCodeimpl(this.pressedElevation)) * 31) + Dp.m5484hashCodeimpl(this.focusedElevation)) * 31) + Dp.m5484hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m5484hashCodeimpl(this.disabledElevation);
    }

    @NotNull
    @Composable
    public final State<Dp> shadowElevation$material3_release(boolean z11, @Nullable InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1763481333);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763481333, i11, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:601)");
        }
        composer.startReplaceableGroup(-1409180589);
        if (interactionSource == null) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m5476boximpl(this.defaultElevation), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return mutableState;
        }
        composer.endReplaceableGroup();
        State<Dp> animateElevation = animateElevation(z11, interactionSource, composer, (i11 & 896) | (i11 & 14) | (i11 & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }

    @NotNull
    @Composable
    public final State<Dp> tonalElevation$material3_release(boolean z11, @Nullable InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1757792649);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1757792649, i11, -1, "androidx.compose.material3.CardElevation.tonalElevation (Card.kt:579)");
        }
        composer.startReplaceableGroup(603878391);
        if (interactionSource == null) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m5476boximpl(this.defaultElevation), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return mutableState;
        }
        composer.endReplaceableGroup();
        State<Dp> animateElevation = animateElevation(z11, interactionSource, composer, (i11 & 896) | (i11 & 14) | (i11 & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }
}
