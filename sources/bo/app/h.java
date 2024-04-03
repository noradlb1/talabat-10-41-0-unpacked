package bo.app;

import android.graphics.Bitmap;
import bo.app.n0;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Instrumented
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0014"}, d2 = {"Lbo/app/h;", "", "", "key", "c", "Landroid/graphics/Bitmap;", "b", "bitmap", "", "a", "", "Ljava/io/File;", "directory", "", "appVersion", "valueCount", "", "maxSize", "<init>", "(Ljava/io/File;IIJ)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final n0 f38545a;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38546b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38547c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(0);
            this.f38546b = str;
            this.f38547c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error while retrieving disk for key " + this.f38546b + " diskKey " + this.f38547c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38548b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38549c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(0);
            this.f38548b = str;
            this.f38549c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get bitmap from disk cache for key " + this.f38548b + " diskKey " + this.f38549c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38550b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38551c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, String str2) {
            super(0);
            this.f38550b = str;
            this.f38551c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to load image from disk cache: " + this.f38550b + '/' + this.f38551c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38552b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38553c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, String str2) {
            super(0);
            this.f38552b = str;
            this.f38553c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error while producing output stream or compressing bitmap for key " + this.f38552b + " diskKey " + this.f38553c;
        }
    }

    public h(File file, int i11, int i12, long j11) {
        n0 a11 = n0.a(file, i11, i12, j11);
        Intrinsics.checkNotNullExpressionValue(a11, "open(directory, appVersion, valueCount, maxSize)");
        this.f38545a = a11;
    }

    private final String c(String str) {
        return String.valueOf(str.hashCode());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r10, android.graphics.Bitmap r11) {
        /*
            r9 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = r9.c(r10)
            bo.app.n0 r1 = r9.f38545a     // Catch:{ all -> 0x0034 }
            bo.app.n0$c r1 = r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0034 }
            r2 = 0
            java.io.OutputStream r2 = r1.a((int) r2)     // Catch:{ all -> 0x0034 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x002d }
            r4 = 100
            r11.compress(r3, r4, r2)     // Catch:{ all -> 0x002d }
            r2.flush()     // Catch:{ all -> 0x002d }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002d }
            r11 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r11)     // Catch:{ all -> 0x0034 }
            r1.b()     // Catch:{ all -> 0x0034 }
            goto L_0x0046
        L_0x002d:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r11)     // Catch:{ all -> 0x0034 }
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r11 = move-exception
            r4 = r11
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.h$d r6 = new bo.app.h$d
            r6.<init>(r10, r0)
            r5 = 0
            r7 = 4
            r8 = 0
            r2 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.h.a(java.lang.String, android.graphics.Bitmap):void");
    }

    public final Bitmap b(String str) {
        Throwable th2;
        Intrinsics.checkNotNullParameter(str, "key");
        String c11 = c(str);
        try {
            n0.d b11 = this.f38545a.b(c11);
            try {
                Bitmap decodeStream = BitmapFactoryInstrumentation.decodeStream(b11.a(0));
                CloseableKt.closeFinally(b11, (Throwable) null);
                return decodeStream;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                CloseableKt.closeFinally(b11, th2);
                throw th4;
            }
        } catch (Throwable th5) {
            Throwable th6 = th5;
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.E, th6, false, (Function0) new b(str, c11), 4, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(str, c11), 7, (Object) null);
            return null;
        }
    }

    public final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String c11 = c(str);
        try {
            n0.d b11 = this.f38545a.b(c11);
            boolean z11 = b11 != null;
            CloseableKt.closeFinally(b11, (Throwable) null);
            return z11;
        } catch (Throwable th2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) new a(str, c11), 4, (Object) null);
            return false;
        }
    }
}
