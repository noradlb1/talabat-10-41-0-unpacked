package com.huawei.location.callback;

import android.app.PendingIntent;
import com.huawei.location.callback.LW;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.router.interfaces.IRouterCallback;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class FB<T extends LW> {

    /* renamed from: yn  reason: collision with root package name */
    private List<T> f50005yn = new CopyOnWriteArrayList();

    public void Vw(T t11) {
        if (t11 == null) {
            LogConsole.i(yn(), "setCallBackInfo, null == locationCallBackInfo ");
            return;
        }
        LogConsole.i(yn(), "setCallBackInfo callBackInfoList size is " + this.f50005yn.size());
        if (this.f50005yn.isEmpty()) {
            this.f50005yn.add(t11);
            return;
        }
        boolean z11 = false;
        if (!this.f50005yn.isEmpty()) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.f50005yn.size()) {
                    break;
                } else if (((LW) this.f50005yn.get(i11)).equals(t11)) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
        }
        if (z11) {
            LogConsole.i(yn(), "setCallBackInfo, update");
            return;
        }
        this.f50005yn.add(t11);
        LogConsole.i(yn(), "setCallBackInfo end callBackInfoList size is " + this.f50005yn.size());
    }

    public LW yn(PendingIntent pendingIntent) {
        if (this.f50005yn.isEmpty()) {
            return null;
        }
        for (T t11 : this.f50005yn) {
            if (t11.yn() != null && t11.yn().equals(pendingIntent)) {
                LogConsole.i(yn(), "getInfoFromPendingIntent equals is true");
                return t11;
            }
        }
        return null;
    }

    public LW yn(IRouterCallback iRouterCallback) {
        if (this.f50005yn.isEmpty()) {
            return null;
        }
        for (T t11 : this.f50005yn) {
            if (t11.Vw() != null && t11.Vw().equals(iRouterCallback)) {
                LogConsole.i(yn(), "getInfoFromRouterCallback equals is true");
                return t11;
            }
        }
        return null;
    }

    public abstract String yn();

    public void yn(T t11) {
        String yn2 = yn();
        LogConsole.i(yn2, "removeCallback callBackInfoList size is " + this.f50005yn.size());
        if (!this.f50005yn.isEmpty()) {
            Iterator<T> it = this.f50005yn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (next instanceof LW) {
                    LW lw2 = (LW) next;
                    if (lw2.equals(t11)) {
                        LogConsole.i(yn(), "removeCallback true");
                        this.f50005yn.remove(lw2);
                        break;
                    }
                }
            }
            String yn3 = yn();
            LogConsole.i(yn3, "removeCallback end callBackInfoList size is " + this.f50005yn.size());
        }
    }
}
