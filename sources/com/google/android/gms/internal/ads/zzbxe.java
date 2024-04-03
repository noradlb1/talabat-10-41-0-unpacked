package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import java.util.Map;

public final class zzbxe extends zzbxg {
    private static final zzbzs zza = new zzbzs();
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzb;

    public final zzbxk zzb(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzbxe.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzbyl(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.zzb.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzbyg((com.google.android.gms.ads.mediation.MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } else {
                if (Adapter.class.isAssignableFrom(cls)) {
                    return new zzbyg((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 64);
                sb2.append("Could not instantiate mediation adapter: ");
                sb2.append(str);
                sb2.append(" (not a valid adapter).");
                zzciz.zzj(sb2.toString());
                throw new RemoteException();
            }
        } catch (Throwable th2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 43);
            sb3.append("Could not instantiate mediation adapter: ");
            sb3.append(str);
            sb3.append(". ");
            zzciz.zzk(sb3.toString(), th2);
        }
        throw new RemoteException();
    }

    public final zzbzo zzc(String str) throws RemoteException {
        try {
            return new zzbzz((RtbAdapter) Class.forName(str, false, zzbzs.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }

    public final void zzd(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzb = map;
    }

    public final boolean zze(String str) throws RemoteException {
        try {
            return Adapter.class.isAssignableFrom(Class.forName(str, false, zzbxe.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 104);
            sb2.append("Could not load custom event implementation class as Adapter: ");
            sb2.append(str);
            sb2.append(", assuming old custom event implementation.");
            zzciz.zzj(sb2.toString());
            return false;
        }
    }

    public final boolean zzf(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzbxe.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 88);
            sb2.append("Could not load custom event implementation class: ");
            sb2.append(str);
            sb2.append(", trying Adapter implementation class.");
            zzciz.zzj(sb2.toString());
            return false;
        }
    }
}
