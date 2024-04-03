package com.huawei.location.nlp.scan.cell;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.scan.LW;
import com.huawei.location.nlp.scan.cell.yn;
import java.util.List;

public class Vw extends LW implements com.huawei.location.nlp.scan.yn {
    private boolean E5 = false;
    private Handler LW;
    /* access modifiers changed from: private */

    /* renamed from: d2  reason: collision with root package name */
    public boolean f50195d2 = true;
    private yn dC = new yn();

    /* renamed from: zp  reason: collision with root package name */
    private yn.Vw f50196zp = new yn();

    /* renamed from: com.huawei.location.nlp.scan.cell.Vw$Vw  reason: collision with other inner class name */
    public class C0085Vw extends Handler {
        public C0085Vw(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            LogConsole.i("OnlyCell", "msg.what=" + message.what);
            if (message.what == 0 && Vw.b(Vw.this)) {
                Vw.a(Vw.this);
            }
        }
    }

    public class yn implements yn.Vw {
        public yn() {
        }

        public void yn(List<CellInfo> list) {
            if (list == null || list.isEmpty()) {
                LogConsole.e("OnlyCell", "scan cell success, cellInfoList is empty");
                return;
            }
            LogConsole.i("OnlyCell", "cell scan success, result size is " + list.size());
            com.huawei.location.nlp.logic.yn.dC().yn(Vw.this.Vw(list));
            boolean unused = Vw.this.f50195d2 = false;
            Vw.this.f50193a.yn();
        }
    }

    public Vw(com.huawei.location.nlp.api.Vw vw2) {
        super(vw2);
        FB();
    }

    private void FB() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.LW = new C0085Vw(handlerThread.getLooper());
    }

    public static void a(Vw vw2) {
        String str;
        vw2.LW.removeMessages(0);
        vw2.LW.sendEmptyMessageDelayed(0, vw2.f50194b);
        if (!vw2.f50195d2 || !com.huawei.location.nlp.logic.yn.dC().yn()) {
            vw2.dC.yn(vw2.f50196zp);
            str = "requestScan cell";
        } else {
            str = "first scan, cached cell is valid";
        }
        LogConsole.i("OnlyCell", str);
    }

    public static boolean b(Vw vw2) {
        vw2.getClass();
        if (NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) && LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            return vw2.E5;
        }
        LogConsole.i("OnlyCell", "network and location enable is false");
        return false;
    }

    public void Vw() {
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        this.E5 = false;
        this.f50195d2 = true;
    }

    public void yn() {
        this.E5 = true;
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        this.LW.sendEmptyMessage(0);
    }

    public void yn(long j11) {
        this.f50194b = j11;
    }
}
