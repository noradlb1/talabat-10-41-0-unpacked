package com.huawei.location.gnss.sdm;

import android.location.Location;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.sdm.Sdm;

class FB {
    @Nullable
    private Sdm Vw = null;

    /* renamed from: yn  reason: collision with root package name */
    private com.huawei.location.sdm.yn f50095yn = null;

    public interface Vw {
    }

    public class yn implements com.huawei.location.sdm.yn {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Vw f50096a;

        public yn(FB fb2, Vw vw2) {
            this.f50096a = vw2;
        }

        public void onLocationChanged(Location location) {
            Vw.a(((yn) this.f50096a).f50100a, location);
        }
    }

    public FB() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.Vw = new Sdm();
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION"})
    public void a() {
        Sdm sdm;
        com.huawei.location.sdm.yn ynVar = this.f50095yn;
        if (ynVar == null) {
            LogConsole.i("SdmWrapper", "no need stop");
        } else if (Build.VERSION.SDK_INT < 24 || (sdm = this.Vw) == null) {
            LogConsole.e("SdmWrapper", "no sdm to stop");
        } else {
            sdm.remove(ynVar);
            this.f50095yn = null;
            LogConsole.i("SdmWrapper", "sdm stop success");
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION"})
    public void b(@NonNull Vw vw2) {
        a();
        Sdm sdm = this.Vw;
        if (sdm == null) {
            LogConsole.e("SdmWrapper", "no sdm to start");
            return;
        }
        yn ynVar = new yn(this, vw2);
        this.f50095yn = ynVar;
        sdm.request(ynVar);
        LogConsole.i("SdmWrapper", "sdm start success");
    }

    public boolean c(long j11, float f11) {
        Sdm sdm = this.Vw;
        if (sdm != null && Build.VERSION.SDK_INT >= 24) {
            return sdm.support(j11, f11);
        }
        return false;
    }
}
