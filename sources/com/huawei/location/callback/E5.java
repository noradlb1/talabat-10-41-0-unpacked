package com.huawei.location.callback;

import android.location.Location;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.logic.LW;
import com.huawei.location.utils.Vw;

public class E5 extends d2 {
    public E5(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        this.f50011c = new Vw.yn().yn("Location_locationCallbackEx").FB(requestLocationUpdatesRequest.getTid());
        this.f50014yn = ocVar;
        this.f50012d = requestLocationUpdatesRequest;
    }

    public void onLocationChanged(Location location) {
        LogConsole.i("HDLocationCallback", "gnss location successful");
        if (!com.huawei.location.activity.model.Vw.yn(this.f50012d)) {
            try {
                LW.yn().yn(this.f50012d.getUuid());
                LogConsole.i("HDLocationCallback", "request expiration and remove");
            } catch (LocationServiceException unused) {
                LogConsole.e("HDLocationCallback", "HDLocationCallback throw locationServiceException");
            }
        } else {
            HwLocationResult hwLocationResult = new HwLocationResult();
            hwLocationResult.setLocation(location);
            LW(hwLocationResult);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void yn(android.os.Bundle r6) {
        /*
            r5 = this;
            java.lang.String r0 = "handlerLocation"
            java.lang.String r1 = "HDLocationCallback"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            com.huawei.secure.android.common.intent.SafeBundle r0 = new com.huawei.secure.android.common.intent.SafeBundle
            r0.<init>(r6)
            java.lang.String r6 = "hwLocationResult"
            android.os.Parcelable r6 = r0.getParcelable(r6)
            com.huawei.hms.location.HwLocationResult r6 = (com.huawei.hms.location.HwLocationResult) r6
            boolean r0 = r5.a(r6)
            if (r0 == 0) goto L_0x001b
            return
        L_0x001b:
            android.location.Location r0 = r6.getLocation()
            if (r0 != 0) goto L_0x0027
            java.lang.String r0 = "modifySourceType location is Empty, modifySourceType fail."
        L_0x0023:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
            goto L_0x004d
        L_0x0027:
            android.os.Bundle r2 = r0.getExtras()
            if (r2 != 0) goto L_0x0030
            java.lang.String r0 = "modifySourceType extras is Empty, modifySourceType fail."
            goto L_0x0023
        L_0x0030:
            com.huawei.secure.android.common.intent.SafeBundle r1 = new com.huawei.secure.android.common.intent.SafeBundle
            r1.<init>(r2)
            java.lang.String r3 = "SourceType"
            boolean r4 = r1.containsKey(r3)
            if (r4 == 0) goto L_0x0046
            int r2 = r2.getInt(r3)
            r2 = r2 & 247(0xf7, float:3.46E-43)
            r1.putInt(r3, r2)
        L_0x0046:
            android.os.Bundle r1 = r1.getBundle()
            r0.setExtras(r1)
        L_0x004d:
            android.location.Location r0 = r6.getLocation()
            boolean r0 = r5.d(r0)
            if (r0 == 0) goto L_0x005a
            r5.yn((com.huawei.hms.location.HwLocationResult) r6)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.callback.E5.yn(android.os.Bundle):void");
    }

    public void yn(boolean z11, boolean z12) {
        if (!z11) {
            yn(false);
        }
    }
}
