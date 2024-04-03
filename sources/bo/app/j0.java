package bo.app;

import com.appboy.enums.DeviceKey;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0002\u0019\u001aBs\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\t\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lbo/app/j0;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "Lbo/app/i2;", "w", "", "v", "e", "()Z", "isEmpty", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "", "androidVersion", "carrier", "model", "localeAndLanguage", "timeZone", "resolution", "isNotificationsEnabled", "isBackgroundRestricted", "googleAdvertisingId", "isAdTrackingEnabled", "<init>", "(Lcom/braze/configuration/BrazeConfigurationProvider;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "a", "b", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class j0 implements IPutIntoJson<JSONObject>, i2 {

    /* renamed from: m  reason: collision with root package name */
    public static final b f38714m = new b((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final BrazeConfigurationProvider f38715b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38716c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38717d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38718e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38719f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38720g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38721h;

    /* renamed from: i  reason: collision with root package name */
    private final Boolean f38722i;

    /* renamed from: j  reason: collision with root package name */
    private final Boolean f38723j;

    /* renamed from: k  reason: collision with root package name */
    private final String f38724k;

    /* renamed from: l  reason: collision with root package name */
    private final Boolean f38725l;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0006\u0010\u0012J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0004\u0010\u0012J\u0006\u0010\u0004\u001a\u00020\u0016¨\u0006\u001b"}, d2 = {"Lbo/app/j0$a;", "", "", "androidVersion", "a", "carrier", "b", "model", "e", "localeLanguageAndCountry", "d", "timeZoneId", "g", "resolution", "f", "", "notificationsEnabled", "c", "(Ljava/lang/Boolean;)Lbo/app/j0$a;", "isBackgroundRestricted", "googleAdvertisingId", "isAdTrackingEnabled", "Lbo/app/j0;", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "<init>", "(Lcom/braze/configuration/BrazeConfigurationProvider;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final BrazeConfigurationProvider f38726a;

        /* renamed from: b  reason: collision with root package name */
        private String f38727b;

        /* renamed from: c  reason: collision with root package name */
        private String f38728c;

        /* renamed from: d  reason: collision with root package name */
        private String f38729d;

        /* renamed from: e  reason: collision with root package name */
        private String f38730e;

        /* renamed from: f  reason: collision with root package name */
        private String f38731f;

        /* renamed from: g  reason: collision with root package name */
        private String f38732g;

        /* renamed from: h  reason: collision with root package name */
        private Boolean f38733h;

        /* renamed from: i  reason: collision with root package name */
        private Boolean f38734i;

        /* renamed from: j  reason: collision with root package name */
        private String f38735j;

        /* renamed from: k  reason: collision with root package name */
        private Boolean f38736k;

        public a(BrazeConfigurationProvider brazeConfigurationProvider) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            this.f38726a = brazeConfigurationProvider;
        }

        public final a a(String str) {
            this.f38727b = str;
            return this;
        }

        public final a b(String str) {
            this.f38728c = str;
            return this;
        }

        public final a c(Boolean bool) {
            this.f38733h = bool;
            return this;
        }

        public final a d(String str) {
            this.f38730e = str;
            return this;
        }

        public final a e(String str) {
            this.f38729d = str;
            return this;
        }

        public final a f(String str) {
            this.f38732g = str;
            return this;
        }

        public final a g(String str) {
            this.f38731f = str;
            return this;
        }

        public final a a(Boolean bool) {
            this.f38736k = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.f38734i = bool;
            return this;
        }

        public final a c(String str) {
            this.f38735j = str;
            return this;
        }

        public final j0 a() {
            return new j0(this.f38726a, this.f38727b, this.f38728c, this.f38729d, this.f38730e, this.f38731f, this.f38732g, this.f38733h, this.f38734i, this.f38735j, this.f38736k);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38739b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating device Json.";
        }
    }

    public j0(BrazeConfigurationProvider brazeConfigurationProvider, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Boolean bool3) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        this.f38715b = brazeConfigurationProvider;
        this.f38716c = str;
        this.f38717d = str2;
        this.f38718e = str3;
        this.f38719f = str4;
        this.f38720g = str5;
        this.f38721h = str6;
        this.f38722i = bool;
        this.f38723j = bool2;
        this.f38724k = str7;
        this.f38725l = bool3;
    }

    public boolean e() {
        return forJsonPut().length() == 0;
    }

    public final boolean v() {
        return forJsonPut().has(DeviceKey.NOTIFICATIONS_ENABLED.getKey());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0058 A[Catch:{ JSONException -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0065 A[Catch:{ JSONException -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079 A[Catch:{ JSONException -> 0x0083 }] */
    /* renamed from: w */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject forJsonPut() {
        /*
            r10 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            bo.app.j0$b r1 = f38714m     // Catch:{ JSONException -> 0x0083 }
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.ANDROID_VERSION     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = r10.f38716c     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.CARRIER     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = r10.f38717d     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.MODEL     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = r10.f38718e     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.RESOLUTION     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = r10.f38721h     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.LOCALE     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = r10.f38719f     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.NOTIFICATIONS_ENABLED     // Catch:{ JSONException -> 0x0083 }
            java.lang.Boolean r4 = r10.f38722i     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.IS_BACKGROUND_RESTRICTED     // Catch:{ JSONException -> 0x0083 }
            java.lang.Boolean r4 = r10.f38723j     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r2 = r10.f38724k     // Catch:{ JSONException -> 0x0083 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0055
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r2 = r3
            goto L_0x0056
        L_0x0055:
            r2 = r4
        L_0x0056:
            if (r2 != 0) goto L_0x0061
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r5 = com.appboy.enums.DeviceKey.GOOGLE_ADVERTISING_ID     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r6 = r10.f38724k     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r5, r6)     // Catch:{ JSONException -> 0x0083 }
        L_0x0061:
            java.lang.Boolean r2 = r10.f38725l     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x006c
            com.braze.configuration.BrazeConfigurationProvider r5 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r6 = com.appboy.enums.DeviceKey.AD_TRACKING_ENABLED     // Catch:{ JSONException -> 0x0083 }
            r1.a(r5, r0, r6, r2)     // Catch:{ JSONException -> 0x0083 }
        L_0x006c:
            java.lang.String r2 = r10.f38720g     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x0076
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x0077
        L_0x0076:
            r3 = r4
        L_0x0077:
            if (r3 != 0) goto L_0x0092
            com.braze.configuration.BrazeConfigurationProvider r2 = r10.f38715b     // Catch:{ JSONException -> 0x0083 }
            com.appboy.enums.DeviceKey r3 = com.appboy.enums.DeviceKey.TIMEZONE     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = r10.f38720g     // Catch:{ JSONException -> 0x0083 }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x0083 }
            goto L_0x0092
        L_0x0083:
            r1 = move-exception
            r5 = r1
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            bo.app.j0$c r7 = bo.app.j0.c.f38739b
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j0.forJsonPut():org.json.JSONObject");
    }

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J*\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u000f"}, d2 = {"Lbo/app/j0$b;", "", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lorg/json/JSONObject;", "jsonObject", "Lbo/app/j0;", "a", "deviceExport", "Lcom/appboy/enums/DeviceKey;", "exportKey", "value", "", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f38737a;

            static {
                int[] iArr = new int[DeviceKey.values().length];
                iArr[DeviceKey.TIMEZONE.ordinal()] = 1;
                iArr[DeviceKey.CARRIER.ordinal()] = 2;
                iArr[DeviceKey.ANDROID_VERSION.ordinal()] = 3;
                iArr[DeviceKey.RESOLUTION.ordinal()] = 4;
                iArr[DeviceKey.LOCALE.ordinal()] = 5;
                iArr[DeviceKey.MODEL.ordinal()] = 6;
                iArr[DeviceKey.NOTIFICATIONS_ENABLED.ordinal()] = 7;
                iArr[DeviceKey.IS_BACKGROUND_RESTRICTED.ordinal()] = 8;
                iArr[DeviceKey.GOOGLE_ADVERTISING_ID.ordinal()] = 9;
                iArr[DeviceKey.AD_TRACKING_ENABLED.ordinal()] = 10;
                f38737a = iArr;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.j0$b$b  reason: collision with other inner class name */
        public static final class C0025b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DeviceKey f38738b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0025b(DeviceKey deviceKey) {
                super(0);
                this.f38738b = deviceKey;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Not adding device key <" + this.f38738b + "> to export due to allowlist restrictions.";
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final j0 a(BrazeConfigurationProvider brazeConfigurationProvider, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            a aVar = new a(brazeConfigurationProvider);
            DeviceKey[] values = DeviceKey.values();
            int length = values.length;
            int i11 = 0;
            while (i11 < length) {
                DeviceKey deviceKey = values[i11];
                i11++;
                String key = deviceKey.getKey();
                switch (a.f38737a[deviceKey.ordinal()]) {
                    case 1:
                        aVar.g(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 2:
                        aVar.b(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 3:
                        aVar.a(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 4:
                        aVar.f(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 5:
                        aVar.d(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 6:
                        aVar.e(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 7:
                        if (!jSONObject.has(key)) {
                            break;
                        } else {
                            aVar.c(Boolean.valueOf(jSONObject.optBoolean(key, true)));
                            break;
                        }
                    case 8:
                        if (!jSONObject.has(key)) {
                            break;
                        } else {
                            aVar.b(Boolean.valueOf(jSONObject.optBoolean(key, false)));
                            break;
                        }
                    case 9:
                        aVar.c(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 10:
                        if (!jSONObject.has(key)) {
                            break;
                        } else {
                            aVar.a(Boolean.valueOf(jSONObject.optBoolean(key)));
                            break;
                        }
                }
            }
            return aVar.a();
        }

        public final void a(BrazeConfigurationProvider brazeConfigurationProvider, JSONObject jSONObject, DeviceKey deviceKey, Object obj) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            Intrinsics.checkNotNullParameter(jSONObject, "deviceExport");
            Intrinsics.checkNotNullParameter(deviceKey, "exportKey");
            if (!brazeConfigurationProvider.isDeviceObjectAllowlistEnabled() || brazeConfigurationProvider.getDeviceObjectAllowlist().contains(deviceKey)) {
                jSONObject.putOpt(deviceKey.getKey(), obj);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new C0025b(deviceKey), 6, (Object) null);
        }
    }
}
