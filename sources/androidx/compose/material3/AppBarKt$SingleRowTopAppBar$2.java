package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$SingleRowTopAppBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6422g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6423h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6424i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6425j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f6426k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6427l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6428m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6429n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6430o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$SingleRowTopAppBar$2(WindowInsets windowInsets, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i11, TopAppBarScrollBehavior topAppBarScrollBehavior) {
        super(2);
        this.f6422g = windowInsets;
        this.f6423h = topAppBarColors;
        this.f6424i = function2;
        this.f6425j = textStyle;
        this.f6426k = z11;
        this.f6427l = function22;
        this.f6428m = function23;
        this.f6429n = i11;
        this.f6430o = topAppBarScrollBehavior;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        r2 = r2.getState();
     */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r2 = r1 & 11
            r3 = 2
            if (r2 != r3) goto L_0x0015
            boolean r2 = r23.getSkipping()
            if (r2 != 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r23.skipToGroupEnd()
            goto L_0x00ba
        L_0x0015:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0024
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1046)"
            r4 = 376925230(0x16776c2e, float:1.9986637E-25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x0024:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r14 = r23
            java.lang.Object r1 = r14.consume(r1)
            androidx.compose.material3.TopAppBarScrollBehavior r2 = r0.f6430o
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.material3.tokens.TopAppBarSmallTokens r3 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r3 = r3.m2472getContainerHeightD9Ej5fM()
            float r1 = r1.m5447toPx0680j_4(r3)
            if (r2 == 0) goto L_0x0049
            androidx.compose.material3.TopAppBarState r2 = r2.getState()
            if (r2 == 0) goto L_0x0049
            float r2 = r2.getHeightOffset()
            goto L_0x004a
        L_0x0049:
            r2 = 0
        L_0x004a:
            float r3 = r1 + r2
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.layout.WindowInsets r2 = r0.f6422g
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.windowInsetsPadding(r1, r2)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.ClipKt.clipToBounds(r1)
            androidx.compose.material3.TopAppBarColors r1 = r0.f6423h
            long r4 = r1.m2006getNavigationIconContentColor0d7_KjU$material3_release()
            androidx.compose.material3.TopAppBarColors r1 = r0.f6423h
            long r6 = r1.m2007getTitleContentColor0d7_KjU$material3_release()
            androidx.compose.material3.TopAppBarColors r1 = r0.f6423h
            long r8 = r1.m2005getActionIconContentColor0d7_KjU$material3_release()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.f6424i
            androidx.compose.ui.text.TextStyle r11 = r0.f6425j
            r12 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r13 = r1.getCenter()
            boolean r15 = r0.f6426k
            if (r15 == 0) goto L_0x007f
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r1 = r1.getCenter()
            goto L_0x0083
        L_0x007f:
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = r1.getStart()
        L_0x0083:
            r15 = 0
            r16 = 0
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.f6427l
            r17 = r15
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.f6428m
            r18 = r15
            int r15 = r0.f6429n
            int r19 = r15 << 12
            r20 = 458752(0x70000, float:6.42848E-40)
            r19 = r19 & r20
            r20 = 113246208(0x6c00000, float:7.2222373E-35)
            r19 = r19 | r20
            r20 = 3670016(0x380000, float:5.142788E-39)
            int r21 = r15 << 12
            r20 = r21 & r20
            r20 = r19 | r20
            int r15 = r15 >> 6
            r15 = r15 & 896(0x380, float:1.256E-42)
            r15 = r15 | 3126(0xc36, float:4.38E-42)
            r21 = r15
            r14 = r1
            r19 = r23
            r15 = 0
            androidx.compose.material3.AppBarKt.m1501TopAppBarLayoutkXwM9vE(r2, r3, r4, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00ba
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
