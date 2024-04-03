package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationRailKt$placeLabelAndIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f7616g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f7617h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f7618i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Placeable f7619j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7620k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7621l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7622m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Placeable f7623n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7624o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7625p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Placeable f7626q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f7627r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f7628s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f7629t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f7630u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$placeLabelAndIcon$1(Placeable placeable, boolean z11, float f11, Placeable placeable2, int i11, int i12, int i13, Placeable placeable3, int i14, int i15, Placeable placeable4, int i16, int i17, int i18, MeasureScope measureScope) {
        super(1);
        this.f7616g = placeable;
        this.f7617h = z11;
        this.f7618i = f11;
        this.f7619j = placeable2;
        this.f7620k = i11;
        this.f7621l = i12;
        this.f7622m = i13;
        this.f7623n = placeable3;
        this.f7624o = i14;
        this.f7625p = i15;
        this.f7626q = placeable4;
        this.f7627r = i16;
        this.f7628s = i17;
        this.f7629t = i18;
        this.f7630u = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if ((r8.f7618i == 0.0f) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.Placeable.PlacementScope r9) {
        /*
            r8 = this;
            java.lang.String r0 = "$this$layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            androidx.compose.ui.layout.Placeable r2 = r8.f7616g
            if (r2 == 0) goto L_0x002a
            int r0 = r8.f7629t
            int r1 = r8.f7625p
            androidx.compose.ui.layout.MeasureScope r3 = r8.f7630u
            int r4 = r8.f7622m
            int r5 = r2.getWidth()
            int r0 = r0 - r5
            int r0 = r0 / 2
            float r5 = androidx.compose.material3.NavigationRailKt.IndicatorVerticalPaddingWithLabel
            int r3 = r3.m5441roundToPx0680j_4(r5)
            int r1 = r1 - r3
            int r4 = r4 + r1
            r5 = 0
            r6 = 4
            r7 = 0
            r1 = r9
            r3 = r0
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x002a:
            boolean r0 = r8.f7617h
            if (r0 != 0) goto L_0x003a
            float r0 = r8.f7618i
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0037
            r0 = 1
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            if (r0 != 0) goto L_0x004b
        L_0x003a:
            androidx.compose.ui.layout.Placeable r2 = r8.f7619j
            int r3 = r8.f7620k
            int r0 = r8.f7621l
            int r1 = r8.f7622m
            int r4 = r0 + r1
            r5 = 0
            r6 = 4
            r7 = 0
            r1 = r9
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x004b:
            androidx.compose.ui.layout.Placeable r2 = r8.f7623n
            int r3 = r8.f7624o
            int r0 = r8.f7625p
            int r1 = r8.f7622m
            int r4 = r0 + r1
            r5 = 0
            r6 = 4
            r7 = 0
            r1 = r9
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.layout.Placeable r2 = r8.f7626q
            int r3 = r8.f7627r
            int r0 = r8.f7628s
            int r1 = r8.f7622m
            int r4 = r0 + r1
            r1 = r9
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1.invoke(androidx.compose.ui.layout.Placeable$PlacementScope):void");
    }
}
