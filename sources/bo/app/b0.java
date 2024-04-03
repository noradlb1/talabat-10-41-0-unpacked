package bo.app;

import com.braze.support.BrazeLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB3\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\"\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\b\u001a\u00020\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u000bH\u0016R$\u0010\r\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\b\u0010\u000f\"\u0004\b\b\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016XD¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lbo/app/b0;", "Lbo/app/r;", "Lbo/app/j2;", "internalPublisher", "externalPublisher", "Lbo/app/d;", "apiResponse", "", "a", "", "", "Lcom/braze/communication/MutableHttpHeaders;", "existingHeaders", "userId", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "", "retryCount", "I", "t", "()I", "setRetryCount", "(I)V", "", "containsNoNewData", "Z", "b", "()Z", "Lorg/json/JSONObject;", "l", "()Lorg/json/JSONObject;", "payload", "urlBase", "", "lastCardUpdatedAt", "lastFullSyncAt", "<init>", "(Ljava/lang/String;JJLjava/lang/String;I)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class b0 extends r {

    /* renamed from: w  reason: collision with root package name */
    public static final a f38293w = new a((DefaultConstructorMarker) null);

    /* renamed from: r  reason: collision with root package name */
    private final long f38294r;

    /* renamed from: s  reason: collision with root package name */
    private final long f38295s;

    /* renamed from: t  reason: collision with root package name */
    private String f38296t;

    /* renamed from: u  reason: collision with root package name */
    private int f38297u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f38298v;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lbo/app/b0$a;", "", "", "BRAZE_CONTENT_CARDS_HEADER", "Ljava/lang/String;", "BRAZE_SYNC_RETRY_COUNT_KEY", "LAST_CARD_UPDATED_AT_KEY", "LAST_FULL_SYNC_AT_KEY", "RETRY_AFTER_HEADER_KEY", "URL_EXTENSION", "USER_ID_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38299b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(long j11) {
            super(0);
            this.f38299b = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "ContentCardsSyncRequest scheduled for retry in " + this.f38299b + " ms.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38300b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "ContentCardsSyncRequest executed successfully.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38301b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while creating Content Cards request. Returning null.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(String str, long j11, long j12, String str2, int i11) {
        super(new v4(Intrinsics.stringPlus(str, "content_cards/sync")));
        Intrinsics.checkNotNullParameter(str, "urlBase");
        this.f38294r = j11;
        this.f38295s = j12;
        this.f38296t = str2;
        this.f38297u = i11;
    }

    public String a() {
        return this.f38296t;
    }

    public boolean b() {
        return this.f38298v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ JSONException -> 0x0032 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject l() {
        /*
            r10 = this;
            org.json.JSONObject r0 = super.l()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r2 = "last_full_sync_at"
            long r3 = r10.f38295s     // Catch:{ JSONException -> 0x0032 }
            r0.put((java.lang.String) r2, (long) r3)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r2 = "last_card_updated_at"
            long r3 = r10.f38294r     // Catch:{ JSONException -> 0x0032 }
            r0.put((java.lang.String) r2, (long) r3)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r2 = r10.a()     // Catch:{ JSONException -> 0x0032 }
            if (r2 == 0) goto L_0x0025
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)     // Catch:{ JSONException -> 0x0032 }
            if (r2 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r2 = 0
            goto L_0x0026
        L_0x0025:
            r2 = 1
        L_0x0026:
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = "user_id"
            java.lang.String r3 = r10.a()     // Catch:{ JSONException -> 0x0032 }
            r0.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0032 }
        L_0x0031:
            return r0
        L_0x0032:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            bo.app.b0$d r7 = bo.app.b0.d.f38301b
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.b0.l():org.json.JSONObject");
    }

    public final int t() {
        return this.f38297u;
    }

    public void a(String str) {
        this.f38296t = str;
    }

    public void a(j2 j2Var, j2 j2Var2, d dVar) {
        Map<String, String> f11;
        String str;
        Long a11;
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        if (dVar == null || (f11 = dVar.f()) == null || (str = f11.get("retry-after")) == null || (a11 = v1.a(str)) == null) {
            j2Var.a(new w(), w.class);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) c.f38300b, 7, (Object) null);
            return;
        }
        long longValue = a11.longValue();
        j2Var.a(new x(longValue, t() + 1), x.class);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(longValue), 7, (Object) null);
    }

    public void a(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "existingHeaders");
        super.a(map);
        map.put("X-Braze-DataRequest", "true");
        map.put("X-Braze-ContentCardsRequest", "true");
        map.put("BRAZE-SYNC-RETRY-COUNT", String.valueOf(this.f38297u));
    }
}
