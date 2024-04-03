package androidx.compose.material;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/material/DefaultButtonElevation;", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "disabledElevation", "hoveredElevation", "focusedElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Stable
final class DefaultButtonElevation implements ButtonElevation {
    private final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    private DefaultButtonElevation(float f11, float f12, float f13, float f14, float f15) {
        this.defaultElevation = f11;
        this.pressedElevation = f12;
        this.disabledElevation = f13;
        this.hoveredElevation = f14;
        this.focusedElevation = f15;
    }

    public /* synthetic */ DefaultButtonElevation(float f11, float f12, float f13, float f14, float f15, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> elevation(boolean r16, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.InteractionSource r17, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r18, int r19) {
        /*
            r15 = this;
            r6 = r15
            r0 = r17
            r7 = r18
            java.lang.String r1 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = -1588756907(0xffffffffa14d7e55, float:-6.96239E-19)
            r7.startReplaceableGroup(r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r1)
            java.lang.Object r2 = r18.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r3.getEmpty()
            if (r2 != r4) goto L_0x0029
            androidx.compose.runtime.snapshots.SnapshotStateList r2 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r7.updateRememberedValue(r2)
        L_0x0029:
            r18.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r2 = (androidx.compose.runtime.snapshots.SnapshotStateList) r2
            androidx.compose.material.DefaultButtonElevation$elevation$1 r4 = new androidx.compose.material.DefaultButtonElevation$elevation$1
            r5 = 0
            r4.<init>(r0, r2, r5)
            int r8 = r19 >> 3
            r8 = r8 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r4, (androidx.compose.runtime.Composer) r7, (int) r8)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r2)
            r4 = r0
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            if (r16 != 0) goto L_0x0048
            float r0 = r6.disabledElevation
        L_0x0046:
            r8 = r0
            goto L_0x0060
        L_0x0048:
            boolean r0 = r4 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
            if (r0 == 0) goto L_0x004f
            float r0 = r6.pressedElevation
            goto L_0x0046
        L_0x004f:
            boolean r0 = r4 instanceof androidx.compose.foundation.interaction.HoverInteraction.Enter
            if (r0 == 0) goto L_0x0056
            float r0 = r6.hoveredElevation
            goto L_0x0046
        L_0x0056:
            boolean r0 = r4 instanceof androidx.compose.foundation.interaction.FocusInteraction.Focus
            if (r0 == 0) goto L_0x005d
            float r0 = r6.focusedElevation
            goto L_0x0046
        L_0x005d:
            float r0 = r6.defaultElevation
            goto L_0x0046
        L_0x0060:
            r7.startReplaceableGroup(r1)
            java.lang.Object r0 = r18.rememberedValue()
            java.lang.Object r1 = r3.getEmpty()
            if (r0 != r1) goto L_0x0083
            androidx.compose.animation.core.Animatable r0 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.unit.Dp r10 = androidx.compose.ui.unit.Dp.m5476boximpl(r8)
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r11 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r1)
            r12 = 0
            r13 = 4
            r14 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            r7.updateRememberedValue(r0)
        L_0x0083:
            r18.endReplaceableGroup()
            r9 = r0
            androidx.compose.animation.core.Animatable r9 = (androidx.compose.animation.core.Animatable) r9
            r10 = 0
            if (r16 != 0) goto L_0x00a2
            r0 = -1598807481(0xffffffffa0b42247, float:-3.051587E-19)
            r7.startReplaceableGroup(r0)
            androidx.compose.ui.unit.Dp r0 = androidx.compose.ui.unit.Dp.m5476boximpl(r8)
            androidx.compose.material.DefaultButtonElevation$elevation$2 r1 = new androidx.compose.material.DefaultButtonElevation$elevation$2
            r1.<init>(r9, r8, r5)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r7, (int) r10)
            r18.endReplaceableGroup()
            goto L_0x00bc
        L_0x00a2:
            r0 = -1598807310(0xffffffffa0b422f2, float:-3.051631E-19)
            r7.startReplaceableGroup(r0)
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r8)
            androidx.compose.material.DefaultButtonElevation$elevation$3 r12 = new androidx.compose.material.DefaultButtonElevation$elevation$3
            r5 = 0
            r0 = r12
            r1 = r9
            r2 = r15
            r3 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r12, (androidx.compose.runtime.Composer) r7, (int) r10)
            r18.endReplaceableGroup()
        L_0x00bc:
            androidx.compose.runtime.State r0 = r9.asState()
            r18.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DefaultButtonElevation.elevation(boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }
}
