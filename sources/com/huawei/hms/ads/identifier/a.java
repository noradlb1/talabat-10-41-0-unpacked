package com.huawei.hms.ads.identifier;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadPoolExecutor f47827a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: b  reason: collision with root package name */
    boolean f47828b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f47829c = new LinkedBlockingQueue<>(1);

    public IBinder a() throws InterruptedException {
        if (!this.f47828b) {
            this.f47828b = true;
            return this.f47829c.take();
        }
        throw new IllegalStateException();
    }

    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f47827a.execute(new Runnable() {
            public void run() {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onServiceConnected ");
                    sb2.append(System.currentTimeMillis());
                    a.this.f47829c.offer(iBinder);
                } catch (Throwable th2) {
                    Log.w("PPSSerivceConnection", "onServiceConnected  " + th2.getClass().getSimpleName());
                }
            }
        });
    }

    public void onServiceDisconnected(ComponentName componentName) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onServiceDisconnected ");
        sb2.append(System.currentTimeMillis());
    }
}
