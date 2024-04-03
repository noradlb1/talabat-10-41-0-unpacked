package androidx.compose.material;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabRowKt$ScrollableTabRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f5800g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5801h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5802i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5803j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f5804k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5805l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$ScrollableTabRow$2(float f11, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i12) {
        super(2);
        this.f5800g = f11;
        this.f5801h = function2;
        this.f5802i = function22;
        this.f5803j = i11;
        this.f5804k = function3;
        this.f5805l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: androidx.compose.material.ScrollableTabData} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20 & 11
            r3 = 2
            if (r2 != r3) goto L_0x0015
            boolean r2 = r19.getSkipping()
            if (r2 != 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r19.skipToGroupEnd()
            goto L_0x00b3
        L_0x0015:
            r2 = 0
            r4 = 1
            androidx.compose.foundation.ScrollState r6 = androidx.compose.foundation.ScrollKt.rememberScrollState(r2, r1, r2, r4)
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r5)
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r5)
            java.lang.Object r5 = r19.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r7.getEmpty()
            if (r5 != r8) goto L_0x0042
            kotlin.coroutines.EmptyCoroutineContext r5 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r5 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r5, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r8 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r8.<init>(r5)
            r1.updateRememberedValue(r8)
            r5 = r8
        L_0x0042:
            r19.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r5
            kotlinx.coroutines.CoroutineScope r5 = r5.getCoroutineScope()
            r19.endReplaceableGroup()
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r8)
            boolean r8 = r1.changed((java.lang.Object) r6)
            boolean r9 = r1.changed((java.lang.Object) r5)
            r8 = r8 | r9
            java.lang.Object r9 = r19.rememberedValue()
            if (r8 != 0) goto L_0x0069
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x0071
        L_0x0069:
            androidx.compose.material.ScrollableTabData r9 = new androidx.compose.material.ScrollableTabData
            r9.<init>(r6, r5)
            r1.updateRememberedValue(r9)
        L_0x0071:
            r19.endReplaceableGroup()
            r14 = r9
            androidx.compose.material.ScrollableTabData r14 = (androidx.compose.material.ScrollableTabData) r14
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r7, r4, r8)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenterStart()
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r4, r5, r2, r3, r8)
            r7 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ScrollKt.horizontalScroll$default(r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.ClipKt.clipToBounds(r3)
            androidx.compose.material.TabRowKt$ScrollableTabRow$2$1 r4 = new androidx.compose.material.TabRowKt$ScrollableTabRow$2$1
            float r11 = r0.f5800g
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r0.f5801h
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r13 = r0.f5802i
            int r15 = r0.f5803j
            kotlin.jvm.functions.Function3<java.util.List<androidx.compose.material.TabPosition>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.f5804k
            int r6 = r0.f5805l
            r10 = r4
            r16 = r5
            r17 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r3, r4, r1, r2, r2)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt$ScrollableTabRow$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
