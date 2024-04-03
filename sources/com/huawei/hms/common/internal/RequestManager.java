package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f48178a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile RequestManager f48179b;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f48180c;

    /* renamed from: d  reason: collision with root package name */
    private static Queue<HuaweiApi.RequestHandler> f48181d = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, HuaweiApi.RequestHandler> f48182e = new LinkedHashMap();

    private RequestManager(Looper looper) {
        f48180c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f48181d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f48180c != null) {
            HMSLog.i("RequestManager", "addToConnectedReqMap");
            f48180c.post(new Runnable() {
                public void run() {
                    RequestManager.f48182e.put(str, requestHandler);
                }
            });
        }
    }

    private void b() {
        while (!f48181d.isEmpty()) {
            HuaweiApi.RequestHandler poll = f48181d.poll();
            if (poll != null) {
                AnyClient client = poll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    poll.onConnected();
                }
            }
        }
    }

    private void c() {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f48181d.isEmpty()) {
            f48181d.poll().onConnectionSuspended(1);
        }
        d();
    }

    private void d() {
        HMSLog.i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f48182e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it = f48182e.entrySet().iterator();
        while (it.hasNext()) {
            try {
                ((HuaweiApi.RequestHandler) it.next().getValue()).onConnectionSuspended(1);
            } catch (RuntimeException e11) {
                HMSLog.e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e11.getMessage());
            }
            it.remove();
        }
    }

    public static Handler getHandler() {
        return f48180c;
    }

    public static RequestManager getInstance() {
        synchronized (f48178a) {
            if (f48179b == null) {
                HandlerThread handlerThread = new HandlerThread("RequestManager");
                handlerThread.start();
                f48179b = new RequestManager(handlerThread.getLooper());
            }
        }
        return f48179b;
    }

    public static void removeReqByTransId(final String str) {
        if (f48180c != null) {
            HMSLog.i("RequestManager", "removeReqByTransId");
            f48180c.post(new Runnable() {
                public void run() {
                    RequestManager.f48182e.remove(str);
                }
            });
        }
    }

    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case NOTIFY_CONNECT_SUCCESS /*10011*/:
                b();
                return true;
            case NOTIFY_CONNECT_FAILED /*10012*/:
                a(message);
                return true;
            case NOTIFY_CONNECT_SUSPENDED /*10013*/:
                c();
                return true;
            default:
                HMSLog.i("RequestManager", "handleMessage unknown msg:" + message.what);
                return false;
        }
    }

    private void a(Message message) {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f48181d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e11) {
            HMSLog.e("RequestManager", "<handleConnectFailed> handle Failed" + e11.getMessage());
        }
    }
}
