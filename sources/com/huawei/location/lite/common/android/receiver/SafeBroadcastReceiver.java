package com.huawei.location.lite.common.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

public abstract class SafeBroadcastReceiver extends BroadcastReceiver {
    private static final String DEFAULT_RECEIVER_THREAD_NAME = "Loc-Safe-Receiver";
    private static final int QUIT_THREAD_DELAY_TIME = 0;
    private static final int QUIT_THREAD_MSG = 101;
    private static final int RECEIVE_MSG = 102;
    /* access modifiers changed from: private */
    public volatile Looper mReceiveLooper;
    private volatile ReceiverHandler mReceiverHandler;

    public final class ReceiverHandler extends Handler {
        public ReceiverHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 != 101) {
                if (i11 == 102) {
                    SafeBroadcastReceiver.this.onSafeReceive((Intent) message.obj);
                    removeMessages(101);
                    sendEmptyMessageDelayed(101, SafeBroadcastReceiver.this.threadExitDelayTime() > 0 ? (long) SafeBroadcastReceiver.this.threadExitDelayTime() : 0);
                }
            } else if (SafeBroadcastReceiver.this.mReceiveLooper != null) {
                SafeBroadcastReceiver.this.mReceiveLooper.quitSafely();
                Looper unused = SafeBroadcastReceiver.this.mReceiveLooper = null;
            }
        }
    }

    public boolean c() {
        return true;
    }

    public final void onReceive(Context context, Intent intent) {
        if (c()) {
            if (this.mReceiveLooper == null || this.mReceiverHandler == null) {
                HandlerThread handlerThread = new HandlerThread(!TextUtils.isEmpty(receiveThreadName()) ? receiveThreadName() : DEFAULT_RECEIVER_THREAD_NAME);
                handlerThread.start();
                this.mReceiveLooper = handlerThread.getLooper();
                this.mReceiverHandler = new ReceiverHandler(this.mReceiveLooper);
            }
            Message obtainMessage = this.mReceiverHandler.obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.obj = intent;
            this.mReceiverHandler.sendMessage(obtainMessage);
            return;
        }
        onSafeReceive(intent);
    }

    public abstract void onSafeReceive(Intent intent);

    public String receiveThreadName() {
        return DEFAULT_RECEIVER_THREAD_NAME;
    }

    public int threadExitDelayTime() {
        return 0;
    }
}
