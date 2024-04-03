package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabRowKt$ScrollableTabRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8584g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8585h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8586i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8587j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f8588k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8589l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$ScrollableTabRow$2(float f11, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i12) {
        super(2);
        this.f8584g = f11;
        this.f8585h = function2;
        this.f8586i = function22;
        this.f8587j = i11;
        this.f8588k = function3;
        this.f8589l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: androidx.compose.material3.ScrollableTabData} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x0017
            boolean r3 = r19.getSkipping()
            if (r3 != 0) goto L_0x0012
            goto L_0x0017
        L_0x0012:
            r19.skipToGroupEnd()
            goto L_0x00cd
        L_0x0017:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0026
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:241)"
            r6 = 286469328(0x11132cd0, float:1.1610064E-28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
        L_0x0026:
            r2 = 0
            r3 = 1
            androidx.compose.foundation.ScrollState r6 = androidx.compose.foundation.ScrollKt.rememberScrollState(r2, r1, r2, r3)
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r5)
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r5)
            java.lang.Object r5 = r19.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r7.getEmpty()
            if (r5 != r8) goto L_0x0053
            kotlin.coroutines.EmptyCoroutineContext r5 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r5 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r5, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r8 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r8.<init>(r5)
            r1.updateRememberedValue(r8)
            r5 = r8
        L_0x0053:
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
            if (r8 != 0) goto L_0x007a
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x0082
        L_0x007a:
            androidx.compose.material3.ScrollableTabData r9 = new androidx.compose.material3.ScrollableTabData
            r9.<init>(r6, r5)
            r1.updateRememberedValue(r9)
        L_0x0082:
            r19.endReplaceableGroup()
            r14 = r9
            androidx.compose.material3.ScrollableTabData r14 = (androidx.compose.material3.ScrollableTabData) r14
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r7, r3, r8)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenterStart()
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r3, r5, r2, r4, r8)
            r7 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ScrollKt.horizontalScroll$default(r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.ClipKt.clipToBounds(r3)
            androidx.compose.material3.TabRowKt$ScrollableTabRow$2$1 r4 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$2$1
            float r11 = r0.f8584g
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r0.f8585h
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r13 = r0.f8586i
            int r15 = r0.f8587j
            kotlin.jvm.functions.Function3<java.util.List<androidx.compose.material3.TabPosition>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.f8588k
            int r6 = r0.f8589l
            r10 = r4
            r16 = r5
            r17 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r3, r4, r1, r2, r2)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00cd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt$ScrollableTabRow$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
