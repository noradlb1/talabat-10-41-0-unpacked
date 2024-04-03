package com.huawei.location;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

public class FB {
    public static final Object Vw = new Object();

    /* renamed from: yn  reason: collision with root package name */
    public static volatile FB f49981yn;
    public yn FB;
    public Handler LW;
    public boolean dC = false;

    public static class yn extends HandlerThread {

        /* renamed from: yn  reason: collision with root package name */
        public FB f49982yn;

        public yn(String str, FB fb2) {
            super(str);
            this.f49982yn = fb2;
        }

        public void onLooperPrepared() {
            super.onLooperPrepared();
            if (this.f49982yn == null) {
                Log.i("LogPersistenceManager", "log persistence manager null");
            }
        }
    }

    public FB(yn ynVar) {
        Vw.yn();
        yn();
    }

    public static FB yn(Context context, yn ynVar) {
        if (f49981yn == null) {
            synchronized (Vw) {
                if (f49981yn == null) {
                    f49981yn = new FB(ynVar);
                }
            }
        }
        return f49981yn;
    }

    public final void yn() {
        if (!this.dC) {
            this.dC = true;
            yn ynVar = new yn("LogPersistenceManagerThread", this);
            this.FB = ynVar;
            ynVar.start();
            this.LW = new Handler(this.FB.getLooper());
        }
    }
}
