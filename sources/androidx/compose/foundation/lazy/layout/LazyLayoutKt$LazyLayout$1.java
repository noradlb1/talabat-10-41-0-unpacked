package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutKt$LazyLayout$1 extends Lambda implements Function3<SaveableStateHolder, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutPrefetchState f3016g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3017h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> f3018i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3019j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<LazyLayoutItemProvider> f3020k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutKt$LazyLayout$1(LazyLayoutPrefetchState lazyLayoutPrefetchState, Modifier modifier, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, int i11, State<? extends LazyLayoutItemProvider> state) {
        super(3);
        this.f3016g = lazyLayoutPrefetchState;
        this.f3017h = modifier;
        this.f3018i = function2;
        this.f3019j = i11;
        this.f3020k = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SaveableStateHolder) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.runtime.saveable.SaveableStateHolder r10, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r11, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = "saveableStateHolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0014
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:49)"
            r2 = 1342877611(0x500aafab, float:9.3070735E9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r12, r0, r1)
        L_0x0014:
            androidx.compose.runtime.State<androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> r12 = r9.f3020k
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r2.getEmpty()
            if (r1 != r3) goto L_0x0035
            androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r1 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$itemContentFactory$1$1 r3 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$itemContentFactory$1$1
            r3.<init>(r12)
            r1.<init>(r10, r3)
            r11.updateRememberedValue(r1)
        L_0x0035:
            r11.endReplaceableGroup()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r1 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory) r1
            r11.startReplaceableGroup(r0)
            java.lang.Object r10 = r11.rememberedValue()
            java.lang.Object r12 = r2.getEmpty()
            if (r10 != r12) goto L_0x0054
            androidx.compose.ui.layout.SubcomposeLayoutState r10 = new androidx.compose.ui.layout.SubcomposeLayoutState
            androidx.compose.foundation.lazy.layout.LazyLayoutItemReusePolicy r12 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemReusePolicy
            r12.<init>(r1)
            r10.<init>((androidx.compose.ui.layout.SubcomposeSlotReusePolicy) r12)
            r11.updateRememberedValue(r10)
        L_0x0054:
            r11.endReplaceableGroup()
            r3 = r10
            androidx.compose.ui.layout.SubcomposeLayoutState r3 = (androidx.compose.ui.layout.SubcomposeLayoutState) r3
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r10 = r9.f3016g
            if (r10 != 0) goto L_0x005f
            goto L_0x006f
        L_0x005f:
            int r12 = r9.f3019j
            int r12 = r12 >> 6
            r12 = r12 & 14
            r12 = r12 | 64
            int r0 = androidx.compose.ui.layout.SubcomposeLayoutState.$stable
            int r0 = r0 << 6
            r12 = r12 | r0
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(r10, r1, r3, r11, r12)
        L_0x006f:
            androidx.compose.ui.Modifier r4 = r9.f3017h
            kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> r10 = r9.f3018i
            r12 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r12)
            boolean r12 = r11.changed((java.lang.Object) r1)
            boolean r0 = r11.changed((java.lang.Object) r10)
            r12 = r12 | r0
            java.lang.Object r0 = r11.rememberedValue()
            if (r12 != 0) goto L_0x008e
            java.lang.Object r12 = r2.getEmpty()
            if (r0 != r12) goto L_0x0096
        L_0x008e:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$2$1 r0 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$2$1
            r0.<init>(r1, r10)
            r11.updateRememberedValue(r0)
        L_0x0096:
            r11.endReplaceableGroup()
            r5 = r0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            int r10 = androidx.compose.ui.layout.SubcomposeLayoutState.$stable
            int r12 = r9.f3019j
            r12 = r12 & 112(0x70, float:1.57E-43)
            r7 = r10 | r12
            r8 = 0
            r6 = r11
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r3, r4, r5, r6, r7, r8)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00b2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1.invoke(androidx.compose.runtime.saveable.SaveableStateHolder, androidx.compose.runtime.Composer, int):void");
    }
}
