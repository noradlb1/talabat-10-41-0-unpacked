package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzfoj {
    @VisibleForTesting
    final zzfom zza;
    @VisibleForTesting
    final boolean zzb;

    private zzfoj(zzfom zzfom) {
        this.zza = zzfom;
        this.zzb = zzfom != null;
    }

    public static zzfoj zzb(Context context, String str, String str2) {
        zzfom zzfom;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzfom = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                if (queryLocalInterface instanceof zzfom) {
                    zzfom = (zzfom) queryLocalInterface;
                } else {
                    zzfom = new zzfok(instantiate);
                }
            }
            try {
                zzfom.zze(ObjectWrapper.wrap(context), str, (String) null);
                Log.i("GASS", "GassClearcutLogger Initialized.");
                return new zzfoj(zzfom);
            } catch (RemoteException | zzfnl | NullPointerException | SecurityException unused) {
                return new zzfoj(new zzfon());
            }
        } catch (Exception e11) {
            throw new zzfnl(e11);
        } catch (Exception e12) {
            throw new zzfnl(e12);
        }
    }

    public static zzfoj zzc() {
        return new zzfoj(new zzfon());
    }

    public final zzfoi zza(byte[] bArr) {
        return new zzfoi(this, bArr, (zzfoh) null);
    }
}
