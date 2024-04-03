package com.instabug.apm.networking;

import androidx.annotation.Nullable;
import com.instabug.apm.model.APMNetworkLog;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.util.threading.ThreadUtils;

public class APMNetworkLogger {
    /* access modifiers changed from: private */
    public final com.instabug.apm.logger.internal.a apmLogger = com.instabug.apm.di.a.f();
    /* access modifiers changed from: private */
    @Nullable
    public APMNetworkLog networkLog = new APMNetworkLog();

    public class a implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45511a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45512b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f45513c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f45514d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45516f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f45517g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45518h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45519i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f45520j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f45521k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ String f45522l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ long f45523m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ int f45524n;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ String f45525o;

        /* renamed from: p  reason: collision with root package name */
        public final /* synthetic */ String f45526p;

        /* renamed from: q  reason: collision with root package name */
        public final /* synthetic */ APMNetworkLogger f45527q;

        public a(APMNetworkLogger aPMNetworkLogger, String str, String str2, long j11, long j12, String str3, String str4, long j13, String str5, String str6, String str7, String str8, String str9, long j14, int i11, String str10, String str11) {
            this.f45527q = aPMNetworkLogger;
            this.f45511a = str;
            this.f45512b = str2;
            this.f45513c = j11;
            this.f45514d = j12;
            this.f45515e = str3;
            this.f45516f = str4;
            this.f45517g = j13;
            this.f45518h = str5;
            this.f45519i = str6;
            this.f45520j = str7;
            this.f45521k = str8;
            this.f45522l = str9;
            this.f45523m = j14;
            this.f45524n = i11;
            this.f45525o = str10;
            this.f45526p = str11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
            if (r1 == false) goto L_0x0084;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                com.instabug.apm.networking.APMNetworkLogger r0 = r7.f45527q
                com.instabug.apm.model.APMNetworkLog r0 = r0.networkLog
                if (r0 != 0) goto L_0x000d
                com.instabug.apm.model.APMNetworkLog r0 = new com.instabug.apm.model.APMNetworkLog
                r0.<init>()
            L_0x000d:
                java.lang.String r1 = r7.f45511a
                r2 = 0
                if (r1 == 0) goto L_0x0014
                r1 = 1
                goto L_0x0015
            L_0x0014:
                r1 = r2
            L_0x0015:
                com.instabug.apm.configuration.c r3 = com.instabug.apm.di.a.c()
                if (r3 == 0) goto L_0x001f
                boolean r2 = r3.f0()
            L_0x001f:
                java.lang.String r3 = r7.f45512b
                r4 = 0
                if (r3 == 0) goto L_0x002d
                boolean r3 = r3.isEmpty()
                if (r3 != 0) goto L_0x002d
                java.lang.String r3 = r7.f45512b
                goto L_0x002e
            L_0x002d:
                r3 = r4
            L_0x002e:
                long r5 = r7.f45513c
                java.lang.Long r5 = java.lang.Long.valueOf(r5)
                r0.setStartTime(r5)
                long r5 = r7.f45514d
                r0.setTotalDuration(r5)
                java.lang.String r5 = r7.f45515e
                r0.setRequestHeaders(r5)
                java.lang.String r5 = r7.f45516f
                r0.setRequestBody(r5)
                long r5 = r7.f45517g
                r0.setRequestBodySize(r5)
                java.lang.String r5 = r7.f45518h
                r0.setMethod(r5)
                java.lang.String r5 = r7.f45519i
                r0.setUrl(r5)
                java.lang.String r5 = r7.f45520j
                r0.setRequestContentType(r5)
                java.lang.String r5 = r7.f45521k
                r0.setResponseHeaders(r5)
                java.lang.String r5 = r7.f45522l
                r0.setResponseBody(r5)
                long r5 = r7.f45523m
                r0.setResponseBodySize(r5)
                int r5 = r7.f45524n
                r0.setResponseCode(r5)
                java.lang.String r5 = r7.f45525o
                r0.setResponseContentType(r5)
                java.lang.String r5 = r7.f45526p
                r0.setErrorMessage(r5)
                if (r2 == 0) goto L_0x0082
                if (r1 == 0) goto L_0x0082
                java.lang.String r1 = r7.f45511a
                r0.setGraphQlQueryName(r1)
                goto L_0x0084
            L_0x0082:
                if (r1 != 0) goto L_0x0087
            L_0x0084:
                r0.setServerSideErrorMessage(r3)
            L_0x0087:
                com.instabug.apm.networking.APMNetworkLogger r1 = r7.f45527q
                com.instabug.apm.model.APMNetworkLog unused = r1.networkLog = r0
                com.instabug.apm.networking.APMNetworkLogger r0 = r7.f45527q
                com.instabug.apm.model.APMNetworkLog r0 = r0.networkLog
                r0.insert(r4)
                com.instabug.apm.networking.APMNetworkLogger r0 = r7.f45527q
                com.instabug.apm.logger.internal.a r0 = r0.apmLogger
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "adding network log: "
                r1.append(r2)
                com.instabug.apm.networking.APMNetworkLogger r2 = r7.f45527q
                com.instabug.apm.model.APMNetworkLog r2 = r2.networkLog
                java.lang.String r2 = r2.toString()
                r1.append(r2)
                java.lang.String r2 = "\n"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.d(r1)
                com.instabug.apm.networking.APMNetworkLogger r0 = r7.f45527q
                com.instabug.apm.model.APMNetworkLog unused = r0.networkLog = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.networking.APMNetworkLogger.a.run():void");
        }
    }

    private void log(long j11, long j12, String str, String str2, long j13, String str3, String str4, String str5, String str6, String str7, long j14, int i11, String str8, String str9, @Nullable String str10, @Nullable String str11) {
        ThreadUtils.getCurrentThreadStackTrace();
        a aVar = r0;
        a aVar2 = new a(this, str10, str11, j11, j12, str, str2, j13, str3, str4, str5, str6, str7, j14, i11, str8, str9);
        APIChecker.checkAndRunInExecutor("APMNetworkLogger.log", aVar);
    }
}
