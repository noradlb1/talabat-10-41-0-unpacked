package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.braze.Constants;
import com.braze.receivers.BrazeActionReceiver;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¨\u0006\u0011"}, d2 = {"Lbo/app/p1;", "", "Landroid/content/Context;", "context", "Landroid/app/PendingIntent;", "b", "a", "Lbo/app/e5;", "serverConfigStorageProvider", "", "", "Landroid/content/SharedPreferences;", "sharedPreferences", "", "Lcom/braze/models/BrazeGeofence;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class p1 {

    /* renamed from: a  reason: collision with root package name */
    public static final p1 f39168a = new p1();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39169b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences enabled in server configuration.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39170b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences explicitly disabled via server configuration.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39171b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences implicitly disabled via server configuration.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39172b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Did not find stored geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f39173b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to find stored geofence keys.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39174b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.f39174b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank serialized geofence string for geofence id " + this.f39174b + " from shared preferences. Not parsing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39175b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(0);
            this.f39175b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Encountered Json exception while parsing stored geofence: ", this.f39175b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39176b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(0);
            this.f39176b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Encountered unexpected exception while parsing stored geofence: ", this.f39176b);
        }
    }

    private p1() {
    }

    @JvmStatic
    public static final PendingIntent a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(Constants.BRAZE_ACTION_RECEIVER_GEOFENCE_LOCATION_UPDATE_INTENT_ACTION).setClass(context, BrazeActionReceiver.class);
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_A…tionReceiver::class.java)");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, IntentUtils.getMutablePendingIntentFlags() | C.BUFFER_FLAG_FIRST_SAMPLE);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(context, 0, geofenceIntent, flags)");
        return broadcast;
    }

    @JvmStatic
    public static final PendingIntent b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(Constants.BRAZE_ACTION_RECEIVER_GEOFENCE_UPDATE_INTENT_ACTION).setClass(context, BrazeActionReceiver.class);
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_A…tionReceiver::class.java)");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, IntentUtils.getMutablePendingIntentFlags() | C.BUFFER_FLAG_FIRST_SAMPLE);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(context, 0, geofenceIntent, flags)");
        return broadcast;
    }

    @JvmStatic
    public static final boolean a(e5 e5Var) {
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        if (!e5Var.q()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39168a, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) c.f39171b, 6, (Object) null);
            return false;
        } else if (e5Var.p()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39168a, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f39169b, 6, (Object) null);
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39168a, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) b.f39170b, 6, (Object) null);
            return false;
        }
    }

    @JvmStatic
    public static final int b(e5 e5Var) {
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        if (e5Var.g() > 0) {
            return e5Var.g();
        }
        return 20;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A[Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083 A[Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.braze.models.BrazeGeofence> a(android.content.SharedPreferences r15) {
        /*
            java.lang.String r0 = "sharedPreferences"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Map r1 = r15.getAll()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001b
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r4 = r2
            goto L_0x001c
        L_0x001b:
            r4 = r3
        L_0x001c:
            if (r4 == 0) goto L_0x002d
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.p1 r6 = f39168a
            bo.app.p1$d r10 = bo.app.p1.d.f39172b
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 7
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (boolean) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)
            return r0
        L_0x002d:
            java.util.Set r1 = r1.keySet()
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0047
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.p1 r6 = f39168a
            com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.W
            bo.app.p1$e r10 = bo.app.p1.e.f39173b
            r8 = 0
            r9 = 0
            r11 = 6
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (boolean) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)
            return r0
        L_0x0047:
            java.util.Iterator r1 = r1.iterator()
        L_0x004b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00b5
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            r5 = 0
            java.lang.String r5 = r15.getString(r4, r5)
            if (r5 == 0) goto L_0x006d
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r5)     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            if (r6 == 0) goto L_0x0065
            goto L_0x006d
        L_0x0065:
            r6 = r2
            goto L_0x006e
        L_0x0067:
            r4 = move-exception
            r9 = r4
            goto L_0x0091
        L_0x006a:
            r4 = move-exception
            r9 = r4
            goto L_0x00a3
        L_0x006d:
            r6 = r3
        L_0x006e:
            if (r6 == 0) goto L_0x0083
            com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            bo.app.p1 r8 = f39168a     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            r10 = 0
            r11 = 0
            bo.app.p1$f r12 = new bo.app.p1$f     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            r12.<init>(r4)     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            r13 = 6
            r14 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.Object) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (boolean) r11, (kotlin.jvm.functions.Function0) r12, (int) r13, (java.lang.Object) r14)     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            goto L_0x004b
        L_0x0083:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            r4.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            com.braze.models.BrazeGeofence r6 = new com.braze.models.BrazeGeofence     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            r6.<init>(r4)     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            r0.add(r6)     // Catch:{ JSONException -> 0x006a, Exception -> 0x0067 }
            goto L_0x004b
        L_0x0091:
            com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.p1 r7 = f39168a
            com.braze.support.BrazeLogger$Priority r8 = com.braze.support.BrazeLogger.Priority.E
            bo.app.p1$h r11 = new bo.app.p1$h
            r11.<init>(r5)
            r10 = 0
            r12 = 4
            r13 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r6, (java.lang.Object) r7, (com.braze.support.BrazeLogger.Priority) r8, (java.lang.Throwable) r9, (boolean) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)
            goto L_0x004b
        L_0x00a3:
            com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.p1 r7 = f39168a
            com.braze.support.BrazeLogger$Priority r8 = com.braze.support.BrazeLogger.Priority.E
            bo.app.p1$g r11 = new bo.app.p1$g
            r11.<init>(r5)
            r10 = 0
            r12 = 4
            r13 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r6, (java.lang.Object) r7, (com.braze.support.BrazeLogger.Priority) r8, (java.lang.Throwable) r9, (boolean) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)
            goto L_0x004b
        L_0x00b5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.p1.a(android.content.SharedPreferences):java.util.List");
    }
}
