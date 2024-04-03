package com.uxcam.internals;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Request;
import okhttp3.Response;

public class eg {

    /* renamed from: a  reason: collision with root package name */
    public final int f13274a;

    /* renamed from: b  reason: collision with root package name */
    public final Request f13275b;

    /* renamed from: c  reason: collision with root package name */
    public final Response f13276c;

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f13277d;

    /* renamed from: e  reason: collision with root package name */
    public final aa f13278e;

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public final long f13279a;

        /* renamed from: b  reason: collision with root package name */
        public final long f13280b;

        public aa(long j11, long j12) {
            this.f13279a = j11;
            this.f13280b = j12;
        }
    }

    public eg(Response response, aa aaVar) {
        this.f13278e = aaVar;
        this.f13275b = response.request();
        this.f13276c = response;
        this.f13274a = response.code();
        if (!b()) {
            this.f13277d = new Throwable(response.code() + ": " + response.message() + ". Call was successful but the request was not.");
            return;
        }
        this.f13277d = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r0 != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f13277d
            r1 = 1
            if (r0 == 0) goto L_0x0015
            int r0 = r4.f13274a
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 0
            if (r0 < r2) goto L_0x0012
            r2 = 299(0x12b, float:4.19E-43)
            if (r0 > r2) goto L_0x0012
            r0 = r1
            goto L_0x0013
        L_0x0012:
            r0 = r3
        L_0x0013:
            if (r0 == 0) goto L_0x0016
        L_0x0015:
            r3 = r1
        L_0x0016:
            r0 = r3 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.eg.a():boolean");
    }

    public final boolean b() {
        int i11 = this.f13274a;
        return i11 >= 200 && i11 <= 299;
    }

    public String toString() {
        StringBuilder a11 = hl.a("[ ");
        a11.append(this.f13275b.hashCode());
        a11.append(" ] CallPair{request=");
        a11.append(this.f13275b.toString());
        a11.append(", response=");
        a11.append(this.f13276c);
        a11.append(AbstractJsonLexerKt.END_OBJ);
        return a11.toString();
    }

    public eg(Request request, Throwable th2, aa aaVar) {
        this.f13277d = th2;
        this.f13278e = aaVar;
        this.f13275b = request;
        this.f13276c = null;
        this.f13274a = -1;
    }
}
