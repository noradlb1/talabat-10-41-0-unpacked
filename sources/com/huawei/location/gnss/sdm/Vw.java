package com.huawei.location.gnss.sdm;

import android.location.Location;
import android.location.LocationListener;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ReflectionUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Vw {
    private boolean FB = false;
    private final CopyOnWriteArrayList<yn> Vw = new CopyOnWriteArrayList<>();

    /* renamed from: yn  reason: collision with root package name */
    private FB f50097yn = null;

    public static class yn {
        /* access modifiers changed from: private */
        @NonNull
        public final LocationListener FB;
        private long LW = 0;
        private final float Vw;
        @NonNull
        private C0081yn dC = new C0081yn();

        /* renamed from: yn  reason: collision with root package name */
        private final long f50098yn;

        /* renamed from: com.huawei.location.gnss.sdm.Vw$yn$yn  reason: collision with other inner class name */
        public static class C0081yn {
            private final double Vw;

            /* renamed from: yn  reason: collision with root package name */
            private final double f50099yn;

            public C0081yn() {
                this(0.0d, 0.0d);
            }

            public C0081yn(double d11, double d12) {
                this.f50099yn = d11;
                this.Vw = d12;
            }

            public static float a(C0081yn ynVar, C0081yn ynVar2) {
                float[] fArr = new float[1];
                double d11 = ynVar.f50099yn;
                double d12 = ynVar2.Vw;
                Location.distanceBetween(d11, d12, ynVar2.f50099yn, d12, fArr);
                return fArr[0];
            }
        }

        public yn(long j11, float f11, @NonNull LocationListener locationListener) {
            this.f50098yn = j11;
            this.Vw = f11;
            this.FB = locationListener;
        }

        public void b(Location location) {
            long currentTimeMillis = System.currentTimeMillis();
            long abs = Math.abs(currentTimeMillis - this.LW);
            if (abs < this.f50098yn) {
                LogConsole.d("SdmProvider", "not need, interval check failed. timeDiff:" + abs);
                return;
            }
            C0081yn ynVar = new C0081yn(location.getLatitude(), location.getLongitude());
            float a11 = C0081yn.a(this.dC, ynVar);
            if (a11 < this.Vw) {
                LogConsole.d("SdmProvider", "not need, distance check failed. distanceDiff:" + a11);
                return;
            }
            this.LW = currentTimeMillis;
            this.dC = ynVar;
            this.FB.onLocationChanged(location);
        }
    }

    public Vw() {
        if (yn()) {
            this.f50097yn = new FB();
        }
    }

    public static void a(Vw vw2, Location location) {
        Iterator<yn> it = vw2.Vw.iterator();
        while (it.hasNext()) {
            it.next().b(location);
        }
    }

    private static boolean yn() {
        if (ReflectionUtils.isSupportClass("com.huawei.location.sdm.Sdm")) {
            LogConsole.i("SdmProvider", "support sdm");
            return true;
        }
        LogConsole.w("SdmProvider", "not support sdm");
        return false;
    }

    private boolean yn(@NonNull LocationListener locationListener) {
        Iterator<yn> it = this.Vw.iterator();
        yn ynVar = null;
        while (it.hasNext()) {
            yn next = it.next();
            if (next.FB == locationListener) {
                ynVar = next;
            }
        }
        if (ynVar == null) {
            return false;
        }
        return this.Vw.remove(ynVar);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION"})
    public void Vw(@NonNull LocationListener locationListener) {
        if (!yn(locationListener)) {
            LogConsole.d("SdmProvider", "not need remove");
            return;
        }
        if (this.FB && this.Vw.isEmpty()) {
            this.f50097yn.a();
            this.FB = false;
        }
        LogConsole.i("SdmProvider", "remove success");
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION"})
    public boolean yn(long j11, float f11, @NonNull LocationListener locationListener) {
        boolean z11;
        FB fb2 = this.f50097yn;
        if (fb2 == null) {
            LogConsole.d("SdmProvider", "not support sdm");
            z11 = false;
        } else {
            z11 = fb2.c(j11, f11);
        }
        if (!z11) {
            return false;
        }
        if (yn(locationListener)) {
            LogConsole.w("SdmProvider", "duplicate request");
        }
        this.Vw.add(new yn(j11, f11, locationListener));
        if (!this.FB && !this.Vw.isEmpty()) {
            this.f50097yn.b(new yn(this));
            this.FB = true;
        }
        LogConsole.i("SdmProvider", "request success");
        return true;
    }
}
