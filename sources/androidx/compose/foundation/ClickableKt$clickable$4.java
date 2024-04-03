package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$clickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1529g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f1530h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1531i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Indication f1532j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f1533k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Role f1534l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$clickable$4(Function0<Unit> function0, boolean z11, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role) {
        super(3);
        this.f1529g = function0;
        this.f1530h = z11;
        this.f1531i = mutableInteractionSource;
        this.f1532j = indication;
        this.f1533k = str;
        this.f1534l = role;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1} */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            java.lang.String r2 = "$this$composed"
            r3 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 92076020(0x57cf7f4, float:1.1894525E-35)
            r1.startReplaceableGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001f
            r3 = -1
            java.lang.String r4 = "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:135)"
            r5 = r27
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r3, r4)
        L_0x001f:
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.f1529g
            r3 = 0
            androidx.compose.runtime.State r10 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r1, r3)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r2)
            java.lang.Object r4 = r26.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r5.getEmpty()
            r7 = 2
            r8 = 0
            if (r4 != r6) goto L_0x0041
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r8, r8, r7, r8)
            r1.updateRememberedValue(r4)
        L_0x0041:
            r26.endReplaceableGroup()
            r9 = r4
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            r1.startReplaceableGroup(r2)
            java.lang.Object r4 = r26.rememberedValue()
            java.lang.Object r6 = r5.getEmpty()
            if (r4 != r6) goto L_0x005c
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            r1.updateRememberedValue(r4)
        L_0x005c:
            r26.endReplaceableGroup()
            r15 = r4
            java.util.Map r15 = (java.util.Map) r15
            r4 = 1841981561(0x6dca6879, float:7.830284E27)
            r1.startReplaceableGroup(r4)
            boolean r4 = r0.f1530h
            if (r4 == 0) goto L_0x0073
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.f1531i
            r6 = 560(0x230, float:7.85E-43)
            androidx.compose.foundation.ClickableKt.PressedInteractionSourceDisposableEffect(r4, r9, r15, r1, r6)
        L_0x0073:
            r26.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r4 = androidx.compose.foundation.Clickable_androidKt.isComposeRootInScrollableContainer(r1, r3)
            r1.startReplaceableGroup(r2)
            java.lang.Object r6 = r26.rememberedValue()
            java.lang.Object r11 = r5.getEmpty()
            if (r6 != r11) goto L_0x0090
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r8, r7, r8)
            r1.updateRememberedValue(r6)
        L_0x0090:
            r26.endReplaceableGroup()
            r12 = r6
            androidx.compose.runtime.MutableState r12 = (androidx.compose.runtime.MutableState) r12
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r6)
            boolean r6 = r1.changed((java.lang.Object) r12)
            boolean r11 = r1.changed((java.lang.Object) r4)
            r6 = r6 | r11
            java.lang.Object r11 = r26.rememberedValue()
            if (r6 != 0) goto L_0x00b1
            java.lang.Object r6 = r5.getEmpty()
            if (r11 != r6) goto L_0x00b9
        L_0x00b1:
            androidx.compose.foundation.ClickableKt$clickable$4$delayPressInteraction$1$1 r11 = new androidx.compose.foundation.ClickableKt$clickable$4$delayPressInteraction$1$1
            r11.<init>(r12, r4)
            r1.updateRememberedValue(r11)
        L_0x00b9:
            r26.endReplaceableGroup()
            androidx.compose.runtime.State r11 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r11, r1, r3)
            r1.startReplaceableGroup(r2)
            java.lang.Object r4 = r26.rememberedValue()
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x00de
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r4.m2692getZeroF1C5BW0()
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2665boximpl(r4)
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r8, r7, r8)
            r1.updateRememberedValue(r4)
        L_0x00de:
            r26.endReplaceableGroup()
            r17 = r4
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = r0.f1531i
            boolean r4 = r0.f1530h
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            r4 = 6
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r5[r3] = r17
            boolean r6 = r0.f1530h
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r16 = 1
            r5[r16] = r6
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r0.f1531i
            r5[r7] = r6
            r7 = 3
            r5[r7] = r9
            r7 = 4
            r5[r7] = r11
            r7 = 5
            r5[r7] = r10
            boolean r7 = r0.f1530h
            r3 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r1.startReplaceableGroup(r3)
            r3 = 0
            r16 = 0
        L_0x0116:
            if (r3 >= r4) goto L_0x0124
            r4 = r5[r3]
            boolean r4 = r1.changed((java.lang.Object) r4)
            r16 = r16 | r4
            int r3 = r3 + 1
            r4 = 6
            goto L_0x0116
        L_0x0124:
            java.lang.Object r3 = r26.rememberedValue()
            if (r16 != 0) goto L_0x0135
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0133
            goto L_0x0135
        L_0x0133:
            r2 = r8
            goto L_0x014c
        L_0x0135:
            androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1 r3 = new androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1
            r16 = 0
            r4 = r3
            r5 = r17
            r18 = r6
            r6 = r7
            r7 = r18
            r2 = r8
            r8 = r9
            r9 = r11
            r11 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r1.updateRememberedValue(r3)
        L_0x014c:
            r26.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput(r13, r14, r2, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r4)
            java.lang.Object r4 = r26.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r5.getEmpty()
            if (r4 != r6) goto L_0x0171
            androidx.compose.foundation.ClickableKt$clickable$4$1$1 r4 = new androidx.compose.foundation.ClickableKt$clickable$4$1$1
            r4.<init>(r12)
            r1.updateRememberedValue(r4)
        L_0x0171:
            r26.endReplaceableGroup()
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Modifier r11 = r3.then(r4)
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = r0.f1531i
            androidx.compose.foundation.Indication r14 = r0.f1532j
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r3)
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r3)
            java.lang.Object r3 = r26.rememberedValue()
            java.lang.Object r4 = r5.getEmpty()
            if (r3 != r4) goto L_0x01a3
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r3 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r3, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r3)
            r1.updateRememberedValue(r4)
            r3 = r4
        L_0x01a3:
            r26.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r3
            kotlinx.coroutines.CoroutineScope r3 = r3.getCoroutineScope()
            r26.endReplaceableGroup()
            boolean r4 = r0.f1530h
            java.lang.String r5 = r0.f1533k
            androidx.compose.ui.semantics.Role r6 = r0.f1534l
            r21 = 0
            r22 = 0
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r0.f1529g
            r12 = r2
            r2 = r15
            r15 = r3
            r16 = r2
            r18 = r4
            r19 = r5
            r20 = r6
            r23 = r7
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ClickableKt.m201genericClickableWithoutGesturebdNGguI(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01d5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d5:
            r26.endReplaceableGroup()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$clickable$4.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
