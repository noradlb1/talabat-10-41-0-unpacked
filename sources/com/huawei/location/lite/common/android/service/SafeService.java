package com.huawei.location.lite.common.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

public abstract class SafeService extends Service {
    private static final String DEFAULT_SERVICE_THREAD_NAME = "Loc-Safe-Service";
    private static final int QUIT_THREAD_DELAY_TIME = 0;
    private static final int QUIT_THREAD_MSG = 101;
    private boolean mRedelivery;
    private volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;

    public final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 101) {
                SafeService.this.c((Intent) message.obj);
                removeMessages(101);
                sendEmptyMessageDelayed(101, SafeService.this.e() > 0 ? (long) SafeService.this.e() : 0);
                return;
            }
            SafeService.this.quitLooper();
        }
    }

    /* access modifiers changed from: private */
    public void quitLooper() {
        if (this.mServiceLooper != null) {
            this.mServiceLooper.quitSafely();
            this.mServiceLooper = null;
        }
    }

    public boolean b() {
        return true;
    }

    public abstract void c(Intent intent);

    public String d() {
        return DEFAULT_SERVICE_THREAD_NAME;
    }

    public int e() {
        return 0;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread(!TextUtils.isEmpty(d()) ? d() : DEFAULT_SERVICE_THREAD_NAME);
        handlerThread.start();
        this.mServiceLooper = handlerThread.getLooper();
        this.mServiceHandler = new ServiceHandler(this.mServiceLooper);
    }

    public void onDestroy() {
        if (this.mServiceHandler != null) {
            this.mServiceHandler.removeMessages(101);
            this.mServiceHandler = null;
        }
        quitLooper();
    }

    public void onStart(Intent intent, int i11) {
        if (!b() || this.mServiceHandler == null) {
            super.onStart(intent, i11);
            return;
        }
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.arg1 = i11;
        obtainMessage.obj = intent;
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        if (b()) {
            onStart(intent, i12);
        } else {
            c(intent);
        }
        return this.mRedelivery ? 3 : 2;
    }

    public void setIntentRedelivery(boolean z11) {
        this.mRedelivery = z11;
    }
}
