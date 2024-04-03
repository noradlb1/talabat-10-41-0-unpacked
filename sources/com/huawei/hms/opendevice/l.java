package com.huawei.hms.opendevice;

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

public class l {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ServiceConnection f49651a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Messenger f49652b = null;

    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f49653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f49654b;

        public a(Bundle bundle, Context context) {
            this.f49653a = bundle;
            this.f49654b = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("RemoteService", "remote service onConnected");
            Messenger unused = l.this.f49652b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f49653a);
            try {
                l.this.f49652b.send(obtain);
            } catch (RemoteException unused2) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f49654b.unbindService(l.this.f49651a);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            Messenger unused = l.this.f49652b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f49651a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f49651a, 1);
    }
}
