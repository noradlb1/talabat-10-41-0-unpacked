package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

abstract class zzbgn<T> {
    @Nullable
    private static final zzbhu zza;

    static {
        zzbhu zzbhs;
        zzbhu zzbhu = null;
        try {
            Object newInstance = zzbgm.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzciz.zzj("ClientApi class is not an instance of IBinder.");
            } else {
                IBinder iBinder = (IBinder) newInstance;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    if (queryLocalInterface instanceof zzbhu) {
                        zzbhs = (zzbhu) queryLocalInterface;
                    } else {
                        zzbhs = new zzbhs(iBinder);
                    }
                    zzbhu = zzbhs;
                }
            }
        } catch (Exception unused) {
            zzciz.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzbhu;
    }

    @Nullable
    private final T zze() {
        zzbhu zzbhu = zza;
        if (zzbhu == null) {
            zzciz.zzj("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zzb(zzbhu);
        } catch (RemoteException e11) {
            zzciz.zzk("Cannot invoke local loader using ClientApi class.", e11);
            return null;
        }
    }

    @Nullable
    private final T zzf() {
        try {
            return zzc();
        } catch (RemoteException e11) {
            zzciz.zzk("Cannot invoke remote loader.", e11);
            return null;
        }
    }

    @NonNull
    public abstract T zza();

    @Nullable
    public abstract T zzb(zzbhu zzbhu) throws RemoteException;

    @Nullable
    public abstract T zzc() throws RemoteException;

    public final T zzd(Context context, boolean z11) {
        boolean z12;
        boolean z13;
        T t11;
        if (!z11) {
            zzbgo.zzb();
            if (!zzcis.zzn(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzciz.zze("Google Play Services is not available.");
                z11 = true;
            }
        }
        boolean z14 = false;
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z12 = false;
        } else {
            z12 = true;
        }
        boolean z15 = z11 | (!z12);
        zzblj.zzc(context);
        if (zzbmt.zza.zze().booleanValue()) {
            z13 = false;
        } else if (zzbmt.zzb.zze().booleanValue()) {
            z13 = true;
            z14 = true;
        } else {
            z14 = z15;
            z13 = false;
        }
        if (z14) {
            t11 = zze();
            if (t11 == null && !z13) {
                t11 = zzf();
            }
        } else {
            T zzf = zzf();
            if (zzf == null) {
                if (zzbgo.zze().nextInt(zzbne.zza.zze().intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzbgo.zzb().zzi(context, zzbgo.zzc().zza, "gmob-apps", bundle, true);
                }
            }
            t11 = zzf == null ? zze() : zzf;
        }
        if (t11 == null) {
            return zza();
        }
        return t11;
    }
}
