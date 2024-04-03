package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0001H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "T", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwipeableKt$swipeable$3 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Map<Float, T> f8406g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8407h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Orientation f8408i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8409j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8410k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f8411l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ResistanceConfig f8412m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<T, T, ThresholdConfig> f8413n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f8414o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$swipeable$3(Map<Float, ? extends T> map, SwipeableState<T> swipeableState, Orientation orientation, boolean z11, MutableInteractionSource mutableInteractionSource, boolean z12, ResistanceConfig resistanceConfig, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, float f11) {
        super(3);
        this.f8406g = map;
        this.f8407h = swipeableState;
        this.f8408i = orientation;
        this.f8409j = z11;
        this.f8410k = mutableInteractionSource;
        this.f8411l = z12;
        this.f8412m = resistanceConfig;
        this.f8413n = function2;
        this.f8414o = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: kotlin.jvm.functions.Function3} */
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
            r2 = 1169892884(0x45bb2614, float:5988.76)
            r1.startReplaceableGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001f
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.swipeable.<anonymous> (Swipeable.kt:581)"
            r5 = r27
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r3, r4)
        L_0x001f:
            java.util.Map<java.lang.Float, T> r2 = r0.f8406g
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x00da
            java.util.Map<java.lang.Float, T> r2 = r0.f8406g
            java.util.Collection r2 = r2.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.distinct(r2)
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            java.util.Map<java.lang.Float, T> r4 = r0.f8406g
            int r4 = r4.size()
            if (r2 != r4) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r3 = 0
        L_0x0045:
            if (r3 == 0) goto L_0x00ce
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r1.consume(r2)
            r7 = r2
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.material3.SwipeableState<T> r2 = r0.f8407h
            java.util.Map<java.lang.Float, T> r3 = r0.f8406g
            r2.ensureInit$material3_release(r3)
            java.util.Map<java.lang.Float, T> r2 = r0.f8406g
            androidx.compose.material3.SwipeableState<T> r11 = r0.f8407h
            androidx.compose.material3.SwipeableKt$swipeable$3$3 r12 = new androidx.compose.material3.SwipeableKt$swipeable$3$3
            androidx.compose.material3.ResistanceConfig r6 = r0.f8412m
            kotlin.jvm.functions.Function2<T, T, androidx.compose.material3.ThresholdConfig> r8 = r0.f8413n
            float r9 = r0.f8414o
            r10 = 0
            r3 = r12
            r4 = r11
            r5 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r3 = 520(0x208, float:7.29E-43)
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r2, r11, r12, r1, r3)
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.material3.SwipeableState<T> r2 = r0.f8407h
            boolean r18 = r2.isAnimationRunning()
            androidx.compose.material3.SwipeableState<T> r2 = r0.f8407h
            androidx.compose.foundation.gestures.DraggableState r14 = r2.getDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r15 = r0.f8408i
            boolean r2 = r0.f8409j
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.f8410k
            r19 = 0
            androidx.compose.material3.SwipeableState<T> r4 = r0.f8407h
            r5 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r5)
            boolean r5 = r1.changed((java.lang.Object) r4)
            java.lang.Object r6 = r26.rememberedValue()
            if (r5 != 0) goto L_0x00a1
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x00aa
        L_0x00a1:
            androidx.compose.material3.SwipeableKt$swipeable$3$4$1 r6 = new androidx.compose.material3.SwipeableKt$swipeable$3$4$1
            r5 = 0
            r6.<init>(r4, r5)
            r1.updateRememberedValue(r6)
        L_0x00aa:
            r26.endReplaceableGroup()
            r20 = r6
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            boolean r4 = r0.f8411l
            r22 = 32
            r23 = 0
            r16 = r2
            r17 = r3
            r21 = r4
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ca:
            r26.endReplaceableGroup()
            return r2
        L_0x00ce:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "You cannot have two anchors mapped to the same state."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00da:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "You must have at least one anchor."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableKt$swipeable$3.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
