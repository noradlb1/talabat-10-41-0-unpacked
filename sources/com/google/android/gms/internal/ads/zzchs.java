package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzchs extends zzaok implements zzcht {
    public zzchs() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzcht zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        if (queryLocalInterface instanceof zzcht) {
            return (zzcht) queryLocalInterface;
        }
        return new zzchr(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        zzchq zzchq = null;
        switch (i11) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzchx zzchx = (zzchx) zzaol.zza(parcel, zzchx.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    if (queryLocalInterface instanceof zzchq) {
                        zzchq = (zzchq) queryLocalInterface;
                    } else {
                        zzchq = new zzcho(readStrongBinder);
                    }
                }
                zze(asInterface, zzchx, zzchq);
                parcel2.writeNoException();
                return true;
            case 2:
                zzh(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzaol.zzf(parcel2, (IInterface) null);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzaol.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                zzj(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzccg.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zzi(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzccg.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                zzf((zzcco) zzaol.zza(parcel, zzcco.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zzg(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
