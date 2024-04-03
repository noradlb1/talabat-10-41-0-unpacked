package bo.app;

import com.braze.support.DateTimeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\b\u0017\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lbo/app/q3;", "Lbo/app/h5;", "", "A", "", "toString", "", "value", "w", "()Ljava/lang/Double;", "a", "(Ljava/lang/Double;)V", "endTime", "Lbo/app/j5;", "sessionId", "startTimeSeconds", "endTimeSeconds", "", "sealed", "<init>", "(Lbo/app/j5;DLjava/lang/Double;Z)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class q3 extends h5 {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ q3(bo.app.j5 r4, double r5, java.lang.Double r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            bo.app.j5$a r4 = bo.app.j5.f38758d
            bo.app.j5 r4 = r4.a()
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0012
            double r5 = com.braze.support.DateTimeUtils.nowInSecondsPrecise()
        L_0x0012:
            r0 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0018
            r7 = 0
        L_0x0018:
            r10 = r7
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001e
            r8 = 0
        L_0x001e:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r0
            r9 = r10
            r10 = r2
            r5.<init>(r6, r7, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.q3.<init>(bo.app.j5, double, java.lang.Double, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void A() {
        a(true);
        a(Double.valueOf(DateTimeUtils.nowInSecondsPrecise()));
    }

    public void a(Double d11) {
        super.a(d11);
    }

    public String toString() {
        return "\nMutableSession(sessionId=" + n() + ", startTime=" + x() + ", endTime=" + w() + ", isSealed=" + y() + ", duration=" + v() + ')';
    }

    public Double w() {
        return super.w();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q3(j5 j5Var, double d11, Double d12, boolean z11) {
        super(j5Var, d11, d12, z11);
        Intrinsics.checkNotNullParameter(j5Var, "sessionId");
    }
}
