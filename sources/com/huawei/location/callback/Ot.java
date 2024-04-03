package com.huawei.location.callback;

import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import com.google.android.exoplayer2.C;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.huawei.location.utils.Vw;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class Ot extends d2 {

    /* renamed from: e  reason: collision with root package name */
    public Location f50007e;

    /* renamed from: f  reason: collision with root package name */
    public Location f50008f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f50009g = new AtomicBoolean(true);

    public Ot(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        this.f50011c = new Vw.yn().yn("Location_locationCallback").FB(requestLocationUpdatesRequest.getTid());
        this.f50014yn = ocVar;
        this.f50012d = requestLocationUpdatesRequest;
        this.f50010b.sendEmptyMessageDelayed(1002, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public void LW(HwLocationResult hwLocationResult) {
        String str;
        String str2;
        LogConsole.i("NLPCallback", "receive posEngine loc, isFirst is " + this.f50009g);
        if (!this.f50009g.get()) {
            Location location = hwLocationResult.getLocation();
            Location location2 = this.f50007e;
            if (location == null && location2 == null) {
                LogConsole.i("NLPCallback", "compareElapsedRealtimeNanos both is null");
                location = null;
            } else {
                if (location == null) {
                    str = "posEngineLoc is null";
                } else {
                    if (location2 == null) {
                        str2 = "nativeLoc is null";
                    } else if (location.getElapsedRealtimeNanos() > location2.getElapsedRealtimeNanos() + 20000000000L) {
                        str2 = "nativeNetworkLoc elapsedRealtimeNanos is invalid";
                    } else if (location2.getElapsedRealtimeNanos() > location.getElapsedRealtimeNanos() + 20000000000L) {
                        str = "posEngineLoc elapsedRealtimeNanos is invalid";
                    } else {
                        location = e(location, location2);
                    }
                    LogConsole.i("NLPCallback", str2);
                }
                LogConsole.i("NLPCallback", str);
                location = location2;
            }
            if (location == null) {
                LogConsole.i("NLPCallback", "onLocationChanged bestLoc is null ");
                return;
            }
            hwLocationResult.setLocation(location);
            f(hwLocationResult);
            return;
        }
        this.f50008f = hwLocationResult.getLocation();
        if (!this.f50010b.hasMessages(1002) || this.f50007e != null) {
            this.f50010b.removeMessages(1002);
            this.f50010b.sendEmptyMessage(1002);
        }
    }

    public void c(Message message) {
        LogConsole.i("NLPCallback", "handleFirstDelayMsg");
        Location e11 = e(this.f50008f, this.f50007e);
        if (e11 == null) {
            LogConsole.e("NLPCallback", "handleFirstDelayMsg, accLocation is null");
            return;
        }
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setCode(0);
        hwLocationResult.setLocation(e11);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        yn(bundle);
    }

    public Location e(Location location, Location location2) {
        String str;
        if (location == null && location2 == null) {
            LogConsole.i("NLPCallback", "posEngineLoc & nativeNetworkLoc is null");
            return null;
        }
        if (location == null) {
            str = "posEngineLoc is null";
        } else if (location2 == null) {
            LogConsole.i("NLPCallback", "nativeNetworkLoc is null");
            return location;
        } else if (!location.hasAccuracy()) {
            str = "posEngineLoc not hasAccuracy";
        } else if (!location2.hasAccuracy()) {
            LogConsole.i("NLPCallback", "nativeLoc not hasAccuracy");
            return location;
        } else if (location.getAccuracy() < location2.getAccuracy()) {
            LogConsole.i("NLPCallback", "posEngineLoc acc is better");
            return location;
        } else {
            str = "nativeLoc acc is better";
        }
        LogConsole.i("NLPCallback", str);
        return location2;
    }

    public void f(HwLocationResult hwLocationResult) {
        hwLocationResult.setCode(0);
        Message obtainMessage = this.f50010b.obtainMessage(1001);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        obtainMessage.setData(bundle);
        this.f50010b.sendMessage(obtainMessage);
    }

    public void onLocationChanged(Location location) {
        if (location == null) {
            LogConsole.e("NLPCallback", "receive native network loc is null");
            return;
        }
        SafeBundle safeBundle = new SafeBundle(location.getExtras());
        safeBundle.putInt(LogWriteConstants.VENDOR_TYPE, 32);
        location.setExtras(safeBundle.getBundle());
        location.setProvider(SDKCoreEvent.Network.TYPE_NETWORK);
        this.f50007e = location;
        LogConsole.i("NLPCallback", "receive native network loc, isFirst is " + this.f50009g);
        if (!this.f50009g.get()) {
            return;
        }
        if (!this.f50010b.hasMessages(1002) || this.f50008f != null) {
            this.f50010b.removeMessages(1002);
            this.f50010b.sendEmptyMessage(1002);
        }
    }

    public void yn(Bundle bundle) {
        HwLocationResult hwLocationResult = (HwLocationResult) new SafeBundle(bundle).getParcelable("hwLocationResult");
        if (!a(hwLocationResult) && d(hwLocationResult.getLocation())) {
            this.f50009g.set(false);
            yn(hwLocationResult);
        }
    }

    public void yn(boolean z11, boolean z12) {
        if (!z11) {
            yn(false);
        }
    }
}
