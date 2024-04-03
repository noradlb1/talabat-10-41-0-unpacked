package com.braze.models;

import com.braze.support.JsonUtils;
import com.google.android.gms.location.Geofence;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b(\b\u0007\u0018\u0000 ;2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001<Bq\b\u0000\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0001\u0010\u001c\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010(\u001a\u00020\u0007\u0012\b\b\u0001\u0010*\u001a\u00020\u0007\u0012\b\b\u0001\u0010,\u001a\u00020\u0007\u0012\b\b\u0001\u0010.\u001a\u00020\r¢\u0006\u0004\b8\u00109B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b8\u0010:J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0011\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0000H\u0002R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\"\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0017\u0010$\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R\u0017\u0010*\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u0017\u0010,\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R\u0017\u0010.\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001fR(\u00100\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b0\u0010\u0017\u0012\u0004\b4\u00105\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u00103R\u0011\u00107\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b6\u0010\u0019¨\u0006="}, d2 = {"Lcom/braze/models/BrazeGeofence;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "", "Lcom/google/android/gms/location/Geofence;", "toGeofence", "otherGeofence", "", "equivalentServerData", "", "toString", "forJsonPut", "other", "", "compareTo", "jsonObject", "Lorg/json/JSONObject;", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "latitude", "D", "getLatitude", "()D", "longitude", "getLongitude", "radiusMeter", "I", "getRadiusMeter", "()I", "cooldownEnterSeconds", "getCooldownEnterSeconds", "cooldownExitSeconds", "getCooldownExitSeconds", "analyticsEnabledEnter", "Z", "getAnalyticsEnabledEnter", "()Z", "analyticsEnabledExit", "getAnalyticsEnabledExit", "enterEvents", "getEnterEvents", "exitEvents", "getExitEvents", "notificationResponsivenessMs", "getNotificationResponsivenessMs", "distanceFromGeofenceRefresh", "getDistanceFromGeofenceRefresh", "setDistanceFromGeofenceRefresh", "(D)V", "getDistanceFromGeofenceRefresh$annotations", "()V", "getRadiusMeters", "radiusMeters", "<init>", "(Lorg/json/JSONObject;Ljava/lang/String;DDIIIZZZZI)V", "(Lorg/json/JSONObject;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BrazeGeofence implements IPutIntoJson<JSONObject>, Comparable<BrazeGeofence> {
    private static final String ANALYTICS_ENABLED_ENTER = "analytics_enabled_enter";
    private static final String ANALYTICS_ENABLED_EXIT = "analytics_enabled_exit";
    private static final String COOLDOWN_ENTER_SECONDS = "cooldown_enter";
    private static final String COOLDOWN_EXIT_SECONDS = "cooldown_exit";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final int DEFAULT_NOTIFICATION_RESPONSIVENESS_MS = 30000;
    private static final String ENTER_EVENTS = "enter_events";
    private static final String EXIT_EVENTS = "exit_events";
    private static final String ID = "id";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String NOTIFICATION_RESPONSIVENESS_MS = "notification_responsiveness";
    private static final String RADIUS_METERS = "radius";
    private final boolean analyticsEnabledEnter;
    private final boolean analyticsEnabledExit;
    private final int cooldownEnterSeconds;
    private final int cooldownExitSeconds;
    private double distanceFromGeofenceRefresh;
    private final boolean enterEvents;
    private final boolean exitEvents;

    /* renamed from: id  reason: collision with root package name */
    private final String f43761id;
    private final JSONObject jsonObject;
    private final double latitude;
    private final double longitude;
    private final int notificationResponsivenessMs;
    private final int radiusMeter;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/braze/models/BrazeGeofence$a;", "", "", "ANALYTICS_ENABLED_ENTER", "Ljava/lang/String;", "ANALYTICS_ENABLED_EXIT", "COOLDOWN_ENTER_SECONDS", "COOLDOWN_EXIT_SECONDS", "", "DEFAULT_NOTIFICATION_RESPONSIVENESS_MS", "I", "ENTER_EVENTS", "EXIT_EVENTS", "ID", "LATITUDE", "LONGITUDE", "NOTIFICATION_RESPONSIVENESS_MS", "RADIUS_METERS", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BrazeGeofence(JSONObject jSONObject, String str, double d11, double d12, int i11, int i12, int i13, boolean z11, boolean z12, boolean z13, boolean z14, int i14) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "id");
        this.jsonObject = jSONObject;
        this.f43761id = str;
        this.latitude = d11;
        this.longitude = d12;
        this.radiusMeter = i11;
        this.cooldownEnterSeconds = i12;
        this.cooldownExitSeconds = i13;
        this.analyticsEnabledEnter = z11;
        this.analyticsEnabledExit = z12;
        this.enterEvents = z13;
        this.exitEvents = z14;
        this.notificationResponsivenessMs = i14;
        this.distanceFromGeofenceRefresh = -1.0d;
    }

    public static /* synthetic */ void getDistanceFromGeofenceRefresh$annotations() {
    }

    public final boolean equivalentServerData(BrazeGeofence brazeGeofence) {
        Intrinsics.checkNotNullParameter(brazeGeofence, "otherGeofence");
        try {
            return JsonUtils.isEqualTo(this.jsonObject, brazeGeofence.forJsonPut());
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean getAnalyticsEnabledEnter() {
        return this.analyticsEnabledEnter;
    }

    public final boolean getAnalyticsEnabledExit() {
        return this.analyticsEnabledExit;
    }

    public final int getCooldownEnterSeconds() {
        return this.cooldownEnterSeconds;
    }

    public final int getCooldownExitSeconds() {
        return this.cooldownExitSeconds;
    }

    public final double getDistanceFromGeofenceRefresh() {
        return this.distanceFromGeofenceRefresh;
    }

    public final boolean getEnterEvents() {
        return this.enterEvents;
    }

    public final boolean getExitEvents() {
        return this.exitEvents;
    }

    public final String getId() {
        return this.f43761id;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int getNotificationResponsivenessMs() {
        return this.notificationResponsivenessMs;
    }

    public final int getRadiusMeter() {
        return this.radiusMeter;
    }

    public final double getRadiusMeters() {
        return (double) this.radiusMeter;
    }

    public final void setDistanceFromGeofenceRefresh(double d11) {
        this.distanceFromGeofenceRefresh = d11;
    }

    public final Geofence toGeofence() {
        Geofence.Builder builder = new Geofence.Builder();
        builder.setRequestId(this.f43761id).setCircularRegion(this.latitude, this.longitude, (float) this.radiusMeter).setNotificationResponsiveness(this.notificationResponsivenessMs).setExpirationDuration(-1);
        boolean z11 = this.enterEvents;
        if (this.exitEvents) {
            z11 |= true;
        }
        builder.setTransitionTypes(z11 ? 1 : 0);
        Geofence build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public String toString() {
        return "BrazeGeofence{id=" + this.f43761id + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", radiusMeters=" + this.radiusMeter + ", cooldownEnterSeconds=" + this.cooldownEnterSeconds + ", cooldownExitSeconds=" + this.cooldownExitSeconds + ", analyticsEnabledEnter=" + this.analyticsEnabledEnter + ", analyticsEnabledExit=" + this.analyticsEnabledExit + ", enterEvents=" + this.enterEvents + ", exitEvents=" + this.exitEvents + ", notificationResponsivenessMs=" + this.notificationResponsivenessMs + ", distanceFromGeofenceRefresh=" + this.distanceFromGeofenceRefresh + " }";
    }

    public int compareTo(BrazeGeofence brazeGeofence) {
        Intrinsics.checkNotNullParameter(brazeGeofence, "other");
        double d11 = this.distanceFromGeofenceRefresh;
        if (!(d11 == -1.0d) && d11 < brazeGeofence.distanceFromGeofenceRefresh) {
            return -1;
        }
        return 1;
    }

    public JSONObject forJsonPut() {
        return this.jsonObject;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BrazeGeofence(org.json.JSONObject r17) {
        /*
            r16 = this;
            r1 = r17
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "id"
            java.lang.String r2 = r1.getString(r0)
            java.lang.String r0 = "jsonObject.getString(ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r0 = "latitude"
            double r3 = r1.getDouble(r0)
            java.lang.String r0 = "longitude"
            double r5 = r1.getDouble(r0)
            java.lang.String r0 = "radius"
            int r7 = r1.getInt(r0)
            java.lang.String r0 = "cooldown_enter"
            int r8 = r1.getInt(r0)
            java.lang.String r0 = "cooldown_exit"
            int r9 = r1.getInt(r0)
            java.lang.String r0 = "analytics_enabled_enter"
            boolean r10 = r1.getBoolean(r0)
            java.lang.String r0 = "analytics_enabled_exit"
            boolean r11 = r1.getBoolean(r0)
            java.lang.String r0 = "enter_events"
            r12 = 1
            boolean r13 = r1.optBoolean(r0, r12)
            java.lang.String r0 = "exit_events"
            boolean r14 = r1.optBoolean(r0, r12)
            java.lang.String r0 = "notification_responsiveness"
            r12 = 30000(0x7530, float:4.2039E-41)
            int r15 = r1.optInt(r0, r12)
            r0 = r16
            r12 = r13
            r13 = r14
            r14 = r15
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.models.BrazeGeofence.<init>(org.json.JSONObject):void");
    }
}
