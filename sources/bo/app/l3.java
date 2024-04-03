package bo.app;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\n"}, d2 = {"Lbo/app/l3;", "", "", "lat1", "lon1", "lat2", "lon2", "a", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class l3 {

    /* renamed from: a  reason: collision with root package name */
    public static final l3 f38912a = new l3();

    private l3() {
    }

    @JvmStatic
    public static final double a(double d11, double d12, double d13, double d14) {
        double radians = Math.toRadians(d13 - d11);
        double radians2 = Math.toRadians(d14 - d12);
        double d15 = (double) 2;
        return 6371000.0d * d15 * Math.asin(Math.sqrt(Math.pow(Math.sin(radians / d15), 2.0d) + (Math.pow(Math.sin(radians2 / d15), 2.0d) * Math.cos(Math.toRadians(d11)) * Math.cos(Math.toRadians(d13)))));
    }
}
