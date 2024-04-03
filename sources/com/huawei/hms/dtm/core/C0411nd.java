package com.huawei.hms.dtm.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.dtm.core.safe.SafeIntent;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.m;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.dtm.core.nd  reason: case insensitive filesystem */
public class C0411nd {

    /* renamed from: com.huawei.hms.dtm.core.nd$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f48524a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f48525b;

        public a(String str, boolean z11) {
            this.f48524a = str;
            this.f48525b = z11;
        }

        public String a() {
            return this.f48524a;
        }

        public boolean b() {
            return this.f48525b;
        }
    }

    /* renamed from: com.huawei.hms.dtm.core.nd$b */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        long f48526a;

        /* renamed from: b  reason: collision with root package name */
        boolean f48527b = false;

        /* renamed from: c  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f48528c = new LinkedBlockingQueue<>(1);

        public b(long j11) {
            this.f48526a = j11;
        }

        public IBinder a() throws InterruptedException {
            if (!this.f48527b) {
                this.f48527b = true;
                return this.f48528c.poll(this.f48526a, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.debug("DTM-Execute", "GooglePlayServiceConnection onServiceConnected");
            try {
                this.f48528c.put(iBinder);
            } catch (InterruptedException e11) {
                Logger.warn("DTM-Execute", "GooglePlayServiceConnection onServiceConnected#" + e11.getMessage());
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Logger.debug("DTM-Execute", "GooglePlayServiceConnection onServiceDisconnected");
        }
    }

    /* renamed from: com.huawei.hms.dtm.core.nd$c */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private final IBinder f48529a;

        public c(IBinder iBinder) {
            this.f48529a = iBinder;
        }

        public boolean a(boolean z11) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z11 ? 1 : 0);
                boolean z12 = false;
                this.f48529a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z12 = true;
                }
                return z12;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f48529a;
        }

        public String b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f48529a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static a a(Context context) {
        if (!(context == null || Looper.myLooper() == Looper.getMainLooper())) {
            try {
                Object a11 = m.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class}, context);
                if (a11 == null) {
                    return null;
                }
                return new a((String) m.a(a11, "getId", (Class<?>[]) null, new Object[0]), ((Boolean) m.a(a11, "isLimitAdTrackingEnabled", (Class<?>[]) null, new Object[0])).booleanValue());
            } catch (Exception e11) {
                Logger.warn("DTM-Execute", "getGMSInfoByLibrary#" + e11.getMessage());
            }
        }
        return null;
    }

    public static a a(Context context, long j11) {
        a b11 = b(context, j11);
        return b11 == null ? a(context) : b11;
    }

    public static a b(Context context, long j11) {
        StringBuilder sb2;
        if (context == null || j11 <= 0 || Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 16384);
            b bVar = new b(j11);
            SafeIntent safeIntent = new SafeIntent(new Intent("com.google.android.gms.ads.identifier.service.START"));
            try {
                safeIntent.setPackage("com.google.android.gms");
                if (!context.bindService(safeIntent, bVar, 1)) {
                    return null;
                }
                try {
                    c cVar = new c(bVar.a());
                    a aVar = new a(cVar.b(), cVar.a(true));
                    try {
                        context.unbindService(bVar);
                    } catch (Exception e11) {
                        Logger.warn("DTM-Execute", "getGMSInfoByAIDL#unbindService failed:" + e11.getMessage());
                    }
                    return aVar;
                } catch (RemoteException | InterruptedException e12) {
                    Logger.warn("DTM-Execute", "getGMSInfoByAIDL#" + e12.getMessage());
                    try {
                        context.unbindService(bVar);
                    } catch (Exception e13) {
                        Logger.warn("DTM-Execute", "getGMSInfoByAIDL#unbindService failed:" + e13.getMessage());
                    }
                    return null;
                } catch (Throwable th2) {
                    try {
                        context.unbindService(bVar);
                    } catch (Exception e14) {
                        Logger.warn("DTM-Execute", "getGMSInfoByAIDL#unbindService failed:" + e14.getMessage());
                    }
                    throw th2;
                }
            } catch (IllegalArgumentException e15) {
                e = e15;
                sb2 = new StringBuilder();
                sb2.append("getGMSInfoByAIDL#");
                sb2.append(e.getMessage());
                Logger.warn("DTM-Execute", sb2.toString());
                return null;
            }
        } catch (Exception e16) {
            e = e16;
            sb2 = new StringBuilder();
            sb2.append("getGMSInfoByAIDL#");
            sb2.append(e.getMessage());
            Logger.warn("DTM-Execute", sb2.toString());
            return null;
        }
    }
}
