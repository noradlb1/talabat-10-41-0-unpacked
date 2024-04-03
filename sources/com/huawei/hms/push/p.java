package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

public class p {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ServiceConnection f49780a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Messenger f49781b = null;

    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f49782a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f49783b;

        public a(Bundle bundle, Context context) {
            this.f49782a = bundle;
            this.f49783b = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("RemoteService", "remote service onConnected");
            Messenger unused = p.this.f49781b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f49782a);
            try {
                p.this.f49781b.send(obtain);
            } catch (RemoteException unused2) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f49783b.unbindService(p.this.f49780a);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            Messenger unused = p.this.f49781b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f49780a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f49780a, 1);
    }
}
