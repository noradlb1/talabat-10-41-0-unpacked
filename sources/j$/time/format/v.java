package j$.time.format;

import j$.time.b;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.s;
import java.util.Locale;

final class v {

    /* renamed from: a  reason: collision with root package name */
    private m f28395a;

    /* renamed from: b  reason: collision with root package name */
    private DateTimeFormatter f28396b;

    /* renamed from: c  reason: collision with root package name */
    private int f28397c;

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    v(j$.time.temporal.m r10, j$.time.format.DateTimeFormatter r11) {
        /*
            r9 = this;
            r9.<init>()
            j$.time.chrono.n r0 = r11.b()
            j$.time.x r1 = r11.e()
            if (r0 != 0) goto L_0x0011
            if (r1 != 0) goto L_0x0011
            goto L_0x0101
        L_0x0011:
            j$.time.temporal.s r2 = j$.time.temporal.p.e()
            java.lang.Object r2 = r10.v(r2)
            j$.time.chrono.n r2 = (j$.time.chrono.n) r2
            j$.time.temporal.s r3 = j$.time.temporal.p.k()
            java.lang.Object r3 = r10.v(r3)
            j$.time.x r3 = (j$.time.x) r3
            boolean r4 = java.util.Objects.equals(r0, r2)
            r5 = 0
            if (r4 == 0) goto L_0x002d
            r0 = r5
        L_0x002d:
            boolean r4 = java.util.Objects.equals(r1, r3)
            if (r4 == 0) goto L_0x0034
            r1 = r5
        L_0x0034:
            if (r0 != 0) goto L_0x003a
            if (r1 != 0) goto L_0x003a
            goto L_0x0101
        L_0x003a:
            if (r0 == 0) goto L_0x003e
            r4 = r0
            goto L_0x003f
        L_0x003e:
            r4 = r2
        L_0x003f:
            if (r1 == 0) goto L_0x00ad
            j$.time.temporal.a r6 = j$.time.temporal.a.INSTANT_SECONDS
            boolean r6 = r10.c(r6)
            if (r6 == 0) goto L_0x005e
            j$.time.chrono.u r0 = j$.time.chrono.u.f28321d
            if (r4 == 0) goto L_0x004e
            goto L_0x0054
        L_0x004e:
            java.lang.String r2 = "defaultObj"
            java.util.Objects.requireNonNull(r0, r2)
            r4 = r0
        L_0x0054:
            j$.time.Instant r10 = j$.time.Instant.C(r10)
            j$.time.chrono.k r10 = r4.x(r10, r1)
            goto L_0x0101
        L_0x005e:
            j$.time.zone.f r6 = r1.B()     // Catch:{ g -> 0x006f }
            boolean r7 = r6.i()     // Catch:{ g -> 0x006f }
            if (r7 == 0) goto L_0x006f
            j$.time.Instant r7 = j$.time.Instant.f28248c     // Catch:{ g -> 0x006f }
            j$.time.ZoneOffset r6 = r6.d(r7)     // Catch:{ g -> 0x006f }
            goto L_0x0070
        L_0x006f:
            r6 = r1
        L_0x0070:
            boolean r6 = r6 instanceof j$.time.ZoneOffset
            if (r6 == 0) goto L_0x00ad
            j$.time.temporal.a r6 = j$.time.temporal.a.OFFSET_SECONDS
            boolean r7 = r10.c(r6)
            if (r7 == 0) goto L_0x00ad
            int r6 = r10.f(r6)
            j$.time.zone.f r7 = r1.B()
            j$.time.Instant r8 = j$.time.Instant.f28248c
            j$.time.ZoneOffset r7 = r7.d(r8)
            int r7 = r7.I()
            if (r6 != r7) goto L_0x0091
            goto L_0x00ad
        L_0x0091:
            j$.time.b r11 = new j$.time.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unable to apply override zone '"
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r1 = "' because the temporal object being formatted has a different offset but does not represent an instant: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r11.<init>(r10)
            throw r11
        L_0x00ad:
            if (r1 == 0) goto L_0x00b0
            r3 = r1
        L_0x00b0:
            if (r0 == 0) goto L_0x00fb
            j$.time.temporal.a r1 = j$.time.temporal.a.EPOCH_DAY
            boolean r1 = r10.c(r1)
            if (r1 == 0) goto L_0x00bf
            j$.time.chrono.c r5 = r4.q(r10)
            goto L_0x00fb
        L_0x00bf:
            j$.time.chrono.u r1 = j$.time.chrono.u.f28321d
            if (r0 != r1) goto L_0x00c5
            if (r2 == 0) goto L_0x00fb
        L_0x00c5:
            j$.time.temporal.a[] r1 = j$.time.temporal.a.values()
            int r2 = r1.length
            r6 = 0
        L_0x00cb:
            if (r6 >= r2) goto L_0x00fb
            r7 = r1[r6]
            boolean r8 = r7.isDateBased()
            if (r8 == 0) goto L_0x00f8
            boolean r7 = r10.c(r7)
            if (r7 != 0) goto L_0x00dc
            goto L_0x00f8
        L_0x00dc:
            j$.time.b r11 = new j$.time.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unable to apply override chronology '"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = "' because the temporal object being formatted contains date fields but does not represent a whole date: "
            r1.append(r0)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r11.<init>(r10)
            throw r11
        L_0x00f8:
            int r6 = r6 + 1
            goto L_0x00cb
        L_0x00fb:
            j$.time.format.u r0 = new j$.time.format.u
            r0.<init>(r5, r10, r4, r3)
            r10 = r0
        L_0x0101:
            r9.f28395a = r10
            r9.f28396b = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.v.<init>(j$.time.temporal.m, j$.time.format.DateTimeFormatter):void");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f28397c--;
    }

    /* access modifiers changed from: package-private */
    public final y b() {
        return this.f28396b.c();
    }

    /* access modifiers changed from: package-private */
    public final Locale c() {
        return this.f28396b.d();
    }

    /* access modifiers changed from: package-private */
    public final m d() {
        return this.f28395a;
    }

    /* access modifiers changed from: package-private */
    public final Long e(q qVar) {
        if (this.f28397c <= 0 || this.f28395a.c(qVar)) {
            return Long.valueOf(this.f28395a.s(qVar));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Object f(s sVar) {
        Object v11 = this.f28395a.v(sVar);
        if (v11 != null || this.f28397c != 0) {
            return v11;
        }
        m mVar = this.f28395a;
        throw new b("Unable to extract " + sVar + " from temporal " + mVar);
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.f28397c++;
    }

    public final String toString() {
        return this.f28395a.toString();
    }
}
