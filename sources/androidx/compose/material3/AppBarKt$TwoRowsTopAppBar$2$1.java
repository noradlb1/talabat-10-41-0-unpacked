package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$TwoRowsTopAppBar$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6500g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f6501h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f6502i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TwoRowsTopAppBar$2$1(TopAppBarScrollBehavior topAppBarScrollBehavior, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
        super(0);
        this.f6500g = topAppBarScrollBehavior;
        this.f6501h = floatRef;
        this.f6502i = floatRef2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r4 = this;
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r4.f6500g
            r1 = 0
            if (r0 == 0) goto L_0x0014
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            if (r0 == 0) goto L_0x0014
            float r0 = r0.getHeightOffsetLimit()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            kotlin.jvm.internal.Ref$FloatRef r2 = r4.f6501h
            float r2 = r2.element
            kotlin.jvm.internal.Ref$FloatRef r3 = r4.f6502i
            float r3 = r3.element
            float r2 = r2 - r3
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r0, (float) r2)
            if (r0 != 0) goto L_0x003b
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r4.f6500g
            if (r0 == 0) goto L_0x002c
            androidx.compose.material3.TopAppBarState r1 = r0.getState()
        L_0x002c:
            if (r1 != 0) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            kotlin.jvm.internal.Ref$FloatRef r0 = r4.f6501h
            float r0 = r0.element
            kotlin.jvm.internal.Ref$FloatRef r2 = r4.f6502i
            float r2 = r2.element
            float r0 = r0 - r2
            r1.setHeightOffsetLimit(r0)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1.invoke():void");
    }
}
