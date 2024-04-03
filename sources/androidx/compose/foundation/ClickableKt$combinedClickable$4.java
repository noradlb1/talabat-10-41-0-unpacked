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
public final class ClickableKt$combinedClickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1560g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1561h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1562i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1563j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1564k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Indication f1565l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f1566m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Role f1567n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f1568o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$combinedClickable$4(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, boolean z11, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role, String str2) {
        super(3);
        this.f1560g = function0;
        this.f1561h = function02;
        this.f1562i = function03;
        this.f1563j = z11;
        this.f1564k = mutableInteractionSource;
        this.f1565l = indication;
        this.f1566m = str;
        this.f1567n = role;
        this.f1568o = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1} */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33) {
        /*
            r30 = this;
            r0 = r30
            r1 = r32
            java.lang.String r2 = "$this$composed"
            r3 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 1841718000(0x6dc662f0, float:7.674705E27)
            r1.startReplaceableGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001f
            r3 = -1
            java.lang.String r4 = "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:306)"
            r5 = r33
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r3, r4)
        L_0x001f:
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.f1560g
            r3 = 0
            androidx.compose.runtime.State r14 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r1, r3)
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.f1561h
            androidx.compose.runtime.State r10 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r1, r3)
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.f1562i
            androidx.compose.runtime.State r9 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r1, r3)
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.f1561h
            if (r2 == 0) goto L_0x0038
            r8 = 1
            goto L_0x0039
        L_0x0038:
            r8 = r3
        L_0x0039:
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.f1562i
            if (r2 == 0) goto L_0x003f
            r6 = 1
            goto L_0x0040
        L_0x003f:
            r6 = r3
        L_0x0040:
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r2)
            java.lang.Object r5 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r7.getEmpty()
            r12 = 2
            r13 = 0
            if (r5 != r11) goto L_0x005b
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r13, r12, r13)
            r1.updateRememberedValue(r5)
        L_0x005b:
            r32.endReplaceableGroup()
            r15 = r5
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            r1.startReplaceableGroup(r2)
            java.lang.Object r5 = r32.rememberedValue()
            java.lang.Object r11 = r7.getEmpty()
            if (r5 != r11) goto L_0x0076
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            r1.updateRememberedValue(r5)
        L_0x0076:
            r32.endReplaceableGroup()
            r11 = r5
            java.util.Map r11 = (java.util.Map) r11
            r5 = 1321107720(0x4ebe8108, float:1.59806362E9)
            r1.startReplaceableGroup(r5)
            boolean r5 = r0.f1563j
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            if (r5 == 0) goto L_0x00bf
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = r0.f1564k
            r1.startReplaceableGroup(r4)
            boolean r16 = r1.changed((java.lang.Object) r15)
            boolean r17 = r1.changed((java.lang.Object) r12)
            r16 = r16 | r17
            java.lang.Object r4 = r32.rememberedValue()
            if (r16 != 0) goto L_0x00a8
            java.lang.Object r13 = r7.getEmpty()
            if (r4 != r13) goto L_0x00b0
        L_0x00a8:
            androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1 r4 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1
            r4.<init>(r15, r12)
            r1.updateRememberedValue(r4)
        L_0x00b0:
            r32.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r5, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r4, (androidx.compose.runtime.Composer) r1, (int) r3)
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.f1564k
            r5 = 560(0x230, float:7.85E-43)
            androidx.compose.foundation.ClickableKt.PressedInteractionSourceDisposableEffect(r4, r15, r11, r1, r5)
        L_0x00bf:
            r32.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r4 = androidx.compose.foundation.Clickable_androidKt.isComposeRootInScrollableContainer(r1, r3)
            r1.startReplaceableGroup(r2)
            java.lang.Object r5 = r32.rememberedValue()
            java.lang.Object r12 = r7.getEmpty()
            if (r5 != r12) goto L_0x00de
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r12 = 2
            r13 = 0
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r13, r12, r13)
            r1.updateRememberedValue(r5)
        L_0x00de:
            r32.endReplaceableGroup()
            r13 = r5
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r5)
            boolean r5 = r1.changed((java.lang.Object) r13)
            boolean r12 = r1.changed((java.lang.Object) r4)
            r5 = r5 | r12
            java.lang.Object r12 = r32.rememberedValue()
            if (r5 != 0) goto L_0x00ff
            java.lang.Object r5 = r7.getEmpty()
            if (r12 != r5) goto L_0x0107
        L_0x00ff:
            androidx.compose.foundation.ClickableKt$combinedClickable$4$delayPressInteraction$1$1 r12 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$delayPressInteraction$1$1
            r12.<init>(r13, r4)
            r1.updateRememberedValue(r12)
        L_0x0107:
            r32.endReplaceableGroup()
            androidx.compose.runtime.State r17 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r1, r3)
            r1.startReplaceableGroup(r2)
            java.lang.Object r4 = r32.rememberedValue()
            java.lang.Object r5 = r7.getEmpty()
            if (r4 != r5) goto L_0x012e
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r4.m2692getZeroF1C5BW0()
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2665boximpl(r4)
            r5 = 2
            r7 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r7, r5, r7)
            r1.updateRememberedValue(r4)
        L_0x012e:
            r32.endReplaceableGroup()
            r22 = r4
            androidx.compose.runtime.MutableState r22 = (androidx.compose.runtime.MutableState) r22
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            r4 = 4
            java.lang.Object[] r7 = new java.lang.Object[r4]
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r0.f1564k
            r7[r3] = r5
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)
            r16 = 1
            r7[r16] = r5
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
            r18 = 2
            r7[r18] = r5
            boolean r5 = r0.f1563j
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r18 = 3
            r7[r18] = r5
            r5 = 10
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r3] = r22
            java.lang.Boolean r19 = java.lang.Boolean.valueOf(r6)
            r2[r16] = r19
            boolean r3 = r0.f1563j
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r19 = 2
            r2[r19] = r3
            r2[r18] = r9
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r8)
            r2[r4] = r3
            r3 = 5
            r2[r3] = r10
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.f1564k
            r4 = 6
            r2[r4] = r3
            r4 = 7
            r2[r4] = r15
            r4 = 8
            r2[r4] = r17
            r4 = 9
            r2[r4] = r14
            boolean r4 = r0.f1563j
            r5 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r1.startReplaceableGroup(r5)
            r18 = r4
            r4 = 10
            r5 = 0
            r16 = 0
        L_0x0198:
            if (r5 >= r4) goto L_0x01a7
            r4 = r2[r5]
            boolean r4 = r1.changed((java.lang.Object) r4)
            r16 = r16 | r4
            int r5 = r5 + 1
            r4 = 10
            goto L_0x0198
        L_0x01a7:
            java.lang.Object r2 = r32.rememberedValue()
            if (r16 != 0) goto L_0x01bd
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x01b6
            goto L_0x01bd
        L_0x01b6:
            r0 = r7
            r21 = r11
            r3 = r12
            r29 = r13
            goto L_0x01d9
        L_0x01bd:
            androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1 r2 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1
            r16 = 0
            r4 = r2
            r5 = r22
            r0 = r7
            r7 = r18
            r21 = r11
            r11 = r3
            r3 = r12
            r12 = r15
            r15 = r13
            r13 = r17
            r29 = r15
            r15 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1.updateRememberedValue(r2)
        L_0x01d9:
            r32.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r3, (java.lang.Object[]) r0, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r2)
            java.lang.Object r2 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r3.getEmpty()
            if (r2 != r4) goto L_0x0200
            androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1 r2 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1
            r5 = r29
            r2.<init>(r5)
            r1.updateRememberedValue(r2)
        L_0x0200:
            r32.endReplaceableGroup()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r16 = r0.then(r2)
            r0 = r30
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r0.f1564k
            androidx.compose.foundation.Indication r4 = r0.f1565l
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r5)
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r5)
            java.lang.Object r5 = r32.rememberedValue()
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0233
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r3 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r3, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r5.<init>(r3)
            r1.updateRememberedValue(r5)
        L_0x0233:
            r32.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r5
            kotlinx.coroutines.CoroutineScope r20 = r5.getCoroutineScope()
            r32.endReplaceableGroup()
            boolean r3 = r0.f1563j
            java.lang.String r5 = r0.f1566m
            androidx.compose.ui.semantics.Role r6 = r0.f1567n
            java.lang.String r7 = r0.f1568o
            kotlin.jvm.functions.Function0<kotlin.Unit> r8 = r0.f1561h
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r0.f1560g
            r18 = r2
            r19 = r4
            r23 = r3
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ClickableKt.m201genericClickableWithoutGesturebdNGguI(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0268
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0268:
            r32.endReplaceableGroup()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$combinedClickable$4.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
