package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class BinderAdapter implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f47788a;

    /* renamed from: b  reason: collision with root package name */
    private final String f47789b;

    /* renamed from: c  reason: collision with root package name */
    private final String f47790c;

    /* renamed from: d  reason: collision with root package name */
    private BinderCallBack f47791d;

    /* renamed from: e  reason: collision with root package name */
    private IBinder f47792e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f47793f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private boolean f47794g = false;

    /* renamed from: h  reason: collision with root package name */
    private Handler f47795h = null;

    /* renamed from: i  reason: collision with root package name */
    private Handler f47796i = null;

    public interface BinderCallBack {
        void onBinderFailed(int i11);

        void onBinderFailed(int i11, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f47788a = context;
        this.f47789b = str;
        this.f47790c = str2;
    }

    private void c() {
        synchronized (this.f47793f) {
            Handler handler = this.f47795h;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.f47795h = null;
            }
        }
    }

    private void d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack b11 = BinderAdapter.this.f();
                if (b11 == null) {
                    return true;
                }
                b11.onTimedDisconnected();
                return true;
            }
        });
        this.f47796i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000);
    }

    private void e() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f47788a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack f11 = f();
            if (f11 != null) {
                f11.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e11) {
            HMSLog.e("BinderAdapter", "getBindFailPendingIntent failed " + e11.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public BinderCallBack f() {
        return this.f47791d;
    }

    private void g() {
        Handler handler = this.f47795h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f47795h = new Handler(Looper.getMainLooper(), new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.b();
                    return true;
                }
            });
        }
        this.f47795h.sendEmptyMessageDelayed(getConnTimeOut(), 10000);
    }

    private void h() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f47796i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack != null) {
            this.f47791d = binderCallBack;
            a();
        }
    }

    public int getConnTimeOut() {
        return 0;
    }

    public int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f47789b;
    }

    public IBinder getServiceBinder() {
        return this.f47792e;
    }

    public void onNullBinding(ComponentName componentName) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f47794g) {
            this.f47794g = false;
            return;
        }
        unBind();
        c();
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onNullBinding(componentName);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f47792e = iBinder;
        c();
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onServiceConnected(componentName, iBinder);
        }
        d();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onServiceDisconnected(componentName);
        }
        h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f47788a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f47796i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.f47796i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000);
            }
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.f47789b) || TextUtils.isEmpty(this.f47790c)) {
            e();
        }
        Intent intent = new Intent(this.f47789b);
        try {
            intent.setPackage(this.f47790c);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            e();
        }
        synchronized (this.f47793f) {
            if (this.f47788a.bindService(intent, this, 1)) {
                g();
                return;
            }
            this.f47794g = true;
            e();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onBinderFailed(-1);
        }
    }
}
