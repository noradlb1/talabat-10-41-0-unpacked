package bo.app;

import android.location.Location;
import com.braze.support.BrazeLogger;
import com.braze.support.ValidationUtils;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003R\u0014\u0010\u000f\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lbo/app/n;", "Lbo/app/a2;", "Lorg/json/JSONObject;", "e", "", "toString", "", "hashCode", "", "other", "", "equals", "", "getLatitude", "()D", "latitude", "getLongitude", "longitude", "w", "()Ljava/lang/Double;", "altitude", "v", "accuracy", "_latitude", "_longitude", "_altitude", "_accuracy", "<init>", "(DDLjava/lang/Double;Ljava/lang/Double;)V", "Landroid/location/Location;", "location", "(Landroid/location/Location;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class n implements a2 {

    /* renamed from: b  reason: collision with root package name */
    private final double f39002b;

    /* renamed from: c  reason: collision with root package name */
    private final double f39003c;

    /* renamed from: d  reason: collision with root package name */
    private final Double f39004d;

    /* renamed from: e  reason: collision with root package name */
    private final Double f39005e;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39006b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating location Json.";
        }
    }

    public n(double d11, double d12, Double d13, Double d14) {
        this.f39002b = d11;
        this.f39003c = d12;
        this.f39004d = d13;
        this.f39005e = d14;
        if (!ValidationUtils.isValidLocation(getLatitude(), getLongitude())) {
            throw new IllegalArgumentException("Unable to create BrazeLocation. Latitude and longitude values are bounded by ±90 and ±180 respectively".toString());
        }
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("latitude", getLatitude());
            jSONObject.put("longitude", getLongitude());
            if (w() != null) {
                jSONObject.put(Param.ALTITUDE, (Object) w());
            }
            if (v() != null) {
                jSONObject.put("ll_accuracy", (Object) v());
            }
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) a.f39006b, 4, (Object) null);
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.f39002b), (Object) Double.valueOf(nVar.f39002b)) && Intrinsics.areEqual((Object) Double.valueOf(this.f39003c), (Object) Double.valueOf(nVar.f39003c)) && Intrinsics.areEqual((Object) this.f39004d, (Object) nVar.f39004d) && Intrinsics.areEqual((Object) this.f39005e, (Object) nVar.f39005e);
    }

    public double getLatitude() {
        return this.f39002b;
    }

    public double getLongitude() {
        return this.f39003c;
    }

    public int hashCode() {
        int a11 = ((Double.doubleToLongBits(this.f39002b) * 31) + Double.doubleToLongBits(this.f39003c)) * 31;
        Double d11 = this.f39004d;
        int i11 = 0;
        int hashCode = (a11 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.f39005e;
        if (d12 != null) {
            i11 = d12.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "BrazeLocation(_latitude=" + this.f39002b + ", _longitude=" + this.f39003c + ", _altitude=" + this.f39004d + ", _accuracy=" + this.f39005e + ')';
    }

    public Double v() {
        return this.f39005e;
    }

    public Double w() {
        return this.f39004d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(double d11, double d12, Double d13, Double d14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(d11, d12, (i11 & 4) != 0 ? null : d13, (i11 & 8) != 0 ? null : d14);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n(Location location) {
        this(location.getLatitude(), location.getLongitude(), Double.valueOf(location.getAltitude()), Double.valueOf((double) location.getAccuracy()));
        Intrinsics.checkNotNullParameter(location, "location");
    }
}
