package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;

@SafeParcelable.Class(creator = "LargeParcelTeleporterCreator")
@SafeParcelable.Reserved({1})
public final class zzcdo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcdo> CREATOR = new zzcdp();
    @SafeParcelable.Field(id = 2)
    ParcelFileDescriptor zza;
    private Parcelable zzb = null;
    private boolean zzc = true;

    @SafeParcelable.Constructor
    public zzcdo(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = parcelFileDescriptor;
    }

    /* JADX INFO: finally extract failed */
    public final void writeToParcel(Parcel parcel, int i11) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        if (this.zza == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzb.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                ParcelFileDescriptor parcelFileDescriptor = null;
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
                    try {
                        zzcjm.zza.execute(new zzcdn(autoCloseOutputStream, marshall));
                        parcelFileDescriptor = createPipe[0];
                    } catch (IOException e11) {
                        e = e11;
                    }
                } catch (IOException e12) {
                    e = e12;
                    autoCloseOutputStream = null;
                    zzciz.zzh("Error transporting the ad response", e);
                    zzt.zzo().zzs(e, "LargeParcelTeleporter.pipeData.2");
                    IOUtils.closeQuietly((Closeable) autoCloseOutputStream);
                    this.zza = parcelFileDescriptor;
                    int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                    SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i11, false);
                    SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
                }
                this.zza = parcelFileDescriptor;
            } catch (Throwable th2) {
                obtain.recycle();
                throw th2;
            }
        }
        int beginObjectHeader2 = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader2);
    }

    /* JADX INFO: finally extract failed */
    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzc) {
            ParcelFileDescriptor parcelFileDescriptor = this.zza;
            if (parcelFileDescriptor == null) {
                zzciz.zzg("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                int readInt = dataInputStream.readInt();
                byte[] bArr = new byte[readInt];
                dataInputStream.readFully(bArr, 0, readInt);
                IOUtils.closeQuietly((Closeable) dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, readInt);
                    obtain.setDataPosition(0);
                    this.zzb = (Parcelable) creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.zzc = false;
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            } catch (IOException e11) {
                zzciz.zzh("Could not read from parcel file descriptor", e11);
                IOUtils.closeQuietly((Closeable) dataInputStream);
                return null;
            } catch (Throwable th3) {
                IOUtils.closeQuietly((Closeable) dataInputStream);
                throw th3;
            }
        }
        return (SafeParcelable) this.zzb;
    }
}
