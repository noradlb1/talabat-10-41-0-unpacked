package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzgt implements ServiceConnection {
    private volatile boolean connected;
    private final ConnectionTracker zzaqz;
    private volatile boolean zzara;
    private zzer zzarb;
    private final Context zzrm;

    public zzgt(Context context) {
        this(context, ConnectionTracker.getInstance());
    }

    @WorkerThread
    private static void zza(@Nullable zzeo zzeo, String str) {
        if (zzeo != null) {
            try {
                zzeo.zza(false, str);
            } catch (RemoteException e11) {
                zzev.zza("Error - local callback should not throw RemoteException", e11);
            }
        }
    }

    @WorkerThread
    private final boolean zzkz() {
        if (this.connected) {
            return true;
        }
        synchronized (this) {
            if (this.connected) {
                return true;
            }
            if (!this.zzara) {
                Intent intent = new Intent("ignored");
                intent.setAction((String) null);
                intent.setClassName(this.zzrm.getPackageName(), "com.google.android.gms.tagmanager.TagManagerService");
                if (!this.zzaqz.bindService(this.zzrm, intent, this, 1)) {
                    return false;
                }
                this.zzara = true;
            }
            while (this.zzara) {
                try {
                    wait();
                    this.zzara = false;
                } catch (InterruptedException e11) {
                    zzev.zzb("Error connecting to TagManagerService", e11);
                    this.zzara = false;
                }
            }
            boolean z11 = this.connected;
            return z11;
        }
    }

    @WorkerThread
    public final void dispatch() {
        if (zzkz()) {
            try {
                this.zzarb.dispatch();
            } catch (RemoteException e11) {
                zzev.zzb("Error calling service to dispatch pending events", e11);
            }
        }
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzer zzer;
        synchronized (this) {
            if (iBinder == null) {
                zzer = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.internal.ITagManagerService");
                if (queryLocalInterface instanceof zzer) {
                    zzer = (zzer) queryLocalInterface;
                } else {
                    zzer = new zzet(iBinder);
                }
            }
            this.zzarb = zzer;
            this.connected = true;
            this.zzara = false;
            notifyAll();
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this) {
            this.zzarb = null;
            this.connected = false;
            this.zzara = false;
        }
    }

    @WorkerThread
    public final void zzb(String str, @Nullable String str2, @Nullable String str3, @Nullable zzeo zzeo) {
        if (zzkz()) {
            try {
                this.zzarb.zza(str, str2, str3, zzeo);
            } catch (RemoteException e11) {
                zzev.zzb("Error calling service to load container", e11);
                zza(zzeo, str);
            }
        } else {
            zza(zzeo, str);
        }
    }

    @WorkerThread
    public final boolean zzla() {
        if (!zzkz()) {
            return false;
        }
        try {
            this.zzarb.zzkm();
            return true;
        } catch (RemoteException e11) {
            zzev.zzb("Error in resetting service", e11);
            return false;
        }
    }

    @VisibleForTesting
    private zzgt(Context context, ConnectionTracker connectionTracker) {
        this.connected = false;
        this.zzara = false;
        this.zzrm = context;
        this.zzaqz = connectionTracker;
    }

    @WorkerThread
    public final void zza(String str, Bundle bundle, String str2, long j11, boolean z11) {
        if (zzkz()) {
            try {
                this.zzarb.zza(str, bundle, str2, j11, z11);
            } catch (RemoteException e11) {
                zzev.zzb("Error calling service to emit event", e11);
            }
        }
    }
}
