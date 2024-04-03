package com.huawei.location.lite.common.android.receiver;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.List;

public class ScreenStatusBroadcastReceiver extends SafeBroadcastReceiver {
    private static final long CONVERT_RATION_NS = 1000000000;
    private static final String LOCATION_BROADCAST_KIT = "Location_Lite_Broadcast";
    private static final int QUIT_THREAD_DELAY_TIME = 120000;
    private static final long REPORT_LATENCY_NS_SCREEN_OFF = 200000000000L;
    private static final long REPORT_LATENCY_NS_SCREEN_ON = 5000000000L;
    private static final int SCREEN_OFF_DELAY_MSG = 1005;
    private static final String TAG = "ScreenStatusBroadcastReceiver";
    private static volatile List<ScreenStatusCallback> callbackList = new ArrayList();
    private static long currentReportLatencyNs;
    private HandlerThread handlerThread;
    private Handler screenOffHandler = null;

    public interface ScreenStatusCallback {
        void onScreenOff();

        void onScreenOn();
    }

    public static long getCurrentReportLatencyNs() {
        long j11 = currentReportLatencyNs;
        return j11 == 0 ? isScreenOn() ? REPORT_LATENCY_NS_SCREEN_ON : REPORT_LATENCY_NS_SCREEN_OFF : j11;
    }

    public static boolean isScreenOn() {
        Object systemService = ContextUtil.getContext().getSystemService("power");
        boolean isScreenOn = systemService instanceof PowerManager ? ((PowerManager) systemService).isScreenOn() : false;
        LogConsole.d(TAG, "isCurScreenOn:" + isScreenOn);
        return isScreenOn;
    }

    private void onScreenOff() {
        setCurrentReportLatencyNs(REPORT_LATENCY_NS_SCREEN_OFF);
        LogConsole.i(TAG, "onScreenOff,report latency is:" + (currentReportLatencyNs / 1000000000) + "s");
        try {
            for (ScreenStatusCallback next : callbackList) {
                if (next != null) {
                    next.onScreenOff();
                }
            }
        } catch (Exception unused) {
            LogConsole.e(TAG, "exec callback onScreenOff exception", true);
        }
    }

    private void onScreenOn() {
        setCurrentReportLatencyNs(REPORT_LATENCY_NS_SCREEN_ON);
        LogConsole.i(TAG, "onScreenOn,report latency is:" + (currentReportLatencyNs / 1000000000) + "s");
        try {
            for (ScreenStatusCallback next : callbackList) {
                if (next != null) {
                    next.onScreenOn();
                }
            }
        } catch (Exception unused) {
            LogConsole.e(TAG, "exec callback onScreenOn exception", true);
        }
    }

    private void postDelayMsg() {
        if (this.handlerThread == null || this.screenOffHandler == null) {
            LogConsole.i(TAG, "postDelayMsg new handlerThread");
            HandlerThread handlerThread2 = new HandlerThread(LOCATION_BROADCAST_KIT);
            this.handlerThread = handlerThread2;
            handlerThread2.start();
            this.screenOffHandler = new Handler(this.handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    if (message == null || message.what != 1005) {
                        LogConsole.e(ScreenStatusBroadcastReceiver.TAG, "message error");
                        return;
                    }
                    boolean isScreenOn = ScreenStatusBroadcastReceiver.isScreenOn();
                    LogConsole.i(ScreenStatusBroadcastReceiver.TAG, "isScreenOn : " + isScreenOn);
                }
            };
        } else {
            LogConsole.i(TAG, "screen off remove Messages");
            this.screenOffHandler.removeMessages(1005);
        }
        boolean sendEmptyMessageDelayed = this.screenOffHandler.sendEmptyMessageDelayed(1005, 5000);
        LogConsole.i(TAG, "sendEmptyMessageDelayed 5 seconds for screenOff. the result is : " + sendEmptyMessageDelayed);
    }

    public static synchronized void registerCallback(ScreenStatusCallback screenStatusCallback) {
        synchronized (ScreenStatusBroadcastReceiver.class) {
            callbackList.add(screenStatusCallback);
        }
    }

    private void setCurrentReportLatencyNs(long j11) {
        currentReportLatencyNs = j11;
    }

    public static synchronized void unRegisterCallback(ScreenStatusCallback screenStatusCallback) {
        synchronized (ScreenStatusBroadcastReceiver.class) {
            callbackList.remove(screenStatusCallback);
        }
    }

    public void onSafeReceive(Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        LogConsole.i(TAG, "onReceive action : " + safeIntent.getAction());
        if ("android.intent.action.SCREEN_OFF".equals(safeIntent.getAction())) {
            onScreenOff();
            postDelayMsg();
        }
        if ("android.intent.action.SCREEN_ON".equals(safeIntent.getAction())) {
            onScreenOn();
            Handler handler = this.screenOffHandler;
            if (handler != null && handler.hasMessages(1005)) {
                LogConsole.i(TAG, "screen on remove Messages");
                this.screenOffHandler.removeMessages(1005);
            }
        }
    }

    public String receiveThreadName() {
        return "Loc-Screen-Receive";
    }

    public int threadExitDelayTime() {
        return QUIT_THREAD_DELAY_TIME;
    }
}
