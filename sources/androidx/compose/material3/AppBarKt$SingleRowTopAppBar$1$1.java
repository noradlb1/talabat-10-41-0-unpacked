package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$SingleRowTopAppBar$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6420g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f6421h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$SingleRowTopAppBar$1$1(TopAppBarScrollBehavior topAppBarScrollBehavior, float f11) {
        super(0);
        this.f6420g = topAppBarScrollBehavior;
        this.f6421h = f11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r3 = this;
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r3.f6420g
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
            float r2 = r3.f6421h
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r0, (float) r2)
            if (r0 != 0) goto L_0x002d
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r3.f6420g
            if (r0 == 0) goto L_0x0025
            androidx.compose.material3.TopAppBarState r1 = r0.getState()
        L_0x0025:
            if (r1 != 0) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            float r0 = r3.f6421h
            r1.setHeightOffsetLimit(r0)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1.invoke():void");
    }
}
