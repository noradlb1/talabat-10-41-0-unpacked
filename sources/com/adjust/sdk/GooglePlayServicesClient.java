package com.adjust.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class GooglePlayServicesClient {

    public static final class GooglePlayServicesInfo {
        private final String gpsAdid;
        private final Boolean trackingEnabled;

        public GooglePlayServicesInfo(String str, Boolean bool) {
            this.gpsAdid = str;
            this.trackingEnabled = bool;
        }

        public String getGpsAdid() {
            return this.gpsAdid;
        }

        public Boolean isTrackingEnabled() {
            return this.trackingEnabled;
        }
    }

    public static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public long f39925a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39926b = false;

        /* renamed from: c  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f39927c = new LinkedBlockingQueue<>(1);

        public a(long j11) {
            this.f39925a = j11;
        }

        public final IBinder a() {
            if (!this.f39926b) {
                this.f39926b = true;
                return this.f39927c.poll(this.f39925a, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f39927c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static GooglePlayServicesInfo getGooglePlayServicesInfo(Context context, long j11) {
        Parcel obtain;
        Parcel obtain2;
        Parcel obtain3;
        Parcel obtain4;
        Boolean bool;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                boolean z11 = false;
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                a aVar = new a(j11);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, aVar, 1)) {
                    try {
                        IBinder a11 = aVar.a();
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        a11.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                        obtain3 = Parcel.obtain();
                        obtain4 = Parcel.obtain();
                        obtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        obtain3.writeInt(1);
                        a11.transact(2, obtain3, obtain4, 0);
                        obtain4.readException();
                        if (obtain4.readInt() != 0) {
                            z11 = true;
                        }
                        Boolean valueOf = Boolean.valueOf(z11);
                        obtain4.recycle();
                        obtain3.recycle();
                        if (valueOf != null) {
                            bool = Boolean.valueOf(!valueOf.booleanValue());
                        } else {
                            bool = null;
                        }
                        GooglePlayServicesInfo googlePlayServicesInfo = new GooglePlayServicesInfo(readString, bool);
                        context.unbindService(aVar);
                        return googlePlayServicesInfo;
                    } catch (Exception e11) {
                        try {
                            throw e11;
                        } catch (Throwable th2) {
                            context.unbindService(aVar);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        obtain4.recycle();
                        obtain3.recycle();
                        throw th3;
                    }
                } else {
                    throw new IOException("Google Play connection failed");
                }
            } catch (Exception e12) {
                throw e12;
            }
        } else {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
    }
}
