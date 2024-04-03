package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbqv;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzdfe;
import com.google.android.gms.internal.ads.zzdmd;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzehh;
import com.google.android.gms.internal.ads.zzfio;

@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    @SafeParcelable.Field(id = 2)
    public final zzc zza;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", id = 3, type = "android.os.IBinder")
    public final zzbes zzb;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", id = 4, type = "android.os.IBinder")
    public final zzo zzc;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", id = 5, type = "android.os.IBinder")
    public final zzcop zzd;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", id = 6, type = "android.os.IBinder")
    public final zzbqv zze;
    @RecentlyNonNull
    @SafeParcelable.Field(id = 7)
    public final String zzf;
    @SafeParcelable.Field(id = 8)
    public final boolean zzg;
    @RecentlyNonNull
    @SafeParcelable.Field(id = 9)
    public final String zzh;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", id = 10, type = "android.os.IBinder")
    public final zzw zzi;
    @SafeParcelable.Field(id = 11)
    public final int zzj;
    @SafeParcelable.Field(id = 12)
    public final int zzk;
    @RecentlyNonNull
    @SafeParcelable.Field(id = 13)
    public final String zzl;
    @SafeParcelable.Field(id = 14)
    public final zzcjf zzm;
    @RecentlyNonNull
    @SafeParcelable.Field(id = 16)
    public final String zzn;
    @SafeParcelable.Field(id = 17)
    public final zzj zzo;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", id = 18, type = "android.os.IBinder")
    public final zzbqt zzp;
    @RecentlyNonNull
    @SafeParcelable.Field(id = 19)
    public final String zzq;
    @SafeParcelable.Field(getter = "getOfflineDatabaseManagerAsBinder", id = 20, type = "android.os.IBinder")
    public final zzehh zzr;
    @SafeParcelable.Field(getter = "getCsiReporterAsBinder", id = 21, type = "android.os.IBinder")
    public final zzdyz zzs;
    @SafeParcelable.Field(getter = "getLoggerAsBinder", id = 22, type = "android.os.IBinder")
    public final zzfio zzt;
    @SafeParcelable.Field(getter = "getWorkManagerUtilAsBinder", id = 23, type = "android.os.IBinder")
    public final zzbv zzu;
    @RecentlyNonNull
    @SafeParcelable.Field(id = 24)
    public final String zzv;
    @RecentlyNonNull
    @SafeParcelable.Field(id = 25)
    public final String zzw;
    @SafeParcelable.Field(getter = "getAdFailedToShowEventEmitterAsBinder", id = 26, type = "android.os.IBinder")
    public final zzdfe zzx;
    @SafeParcelable.Field(getter = "getPhysicalClickListenerAsBinder", id = 27, type = "android.os.IBinder")
    public final zzdmd zzy;

    public AdOverlayInfoParcel(zzbes zzbes, zzo zzo2, zzbqt zzbqt, zzbqv zzbqv, zzw zzw2, zzcop zzcop, boolean z11, int i11, String str, zzcjf zzcjf, zzdmd zzdmd) {
        this.zza = null;
        this.zzb = zzbes;
        this.zzc = zzo2;
        this.zzd = zzcop;
        this.zzp = zzbqt;
        this.zze = zzbqv;
        this.zzf = null;
        this.zzg = z11;
        this.zzh = null;
        this.zzi = zzw2;
        this.zzj = i11;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = zzcjf;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdmd;
    }

    @RecentlyNonNull
    public static AdOverlayInfoParcel zza(@RecentlyNonNull Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i11, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzd).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zze).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i11, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i11, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeIBinder(parcel, 20, ObjectWrapper.wrap(this.zzr).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 21, ObjectWrapper.wrap(this.zzs).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 22, ObjectWrapper.wrap(this.zzt).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 23, ObjectWrapper.wrap(this.zzu).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 24, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzw, false);
        SafeParcelWriter.writeIBinder(parcel, 26, ObjectWrapper.wrap(this.zzx).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 27, ObjectWrapper.wrap(this.zzy).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(zzbes zzbes, zzo zzo2, zzbqt zzbqt, zzbqv zzbqv, zzw zzw2, zzcop zzcop, boolean z11, int i11, String str, String str2, zzcjf zzcjf, zzdmd zzdmd) {
        this.zza = null;
        this.zzb = zzbes;
        this.zzc = zzo2;
        this.zzd = zzcop;
        this.zzp = zzbqt;
        this.zze = zzbqv;
        this.zzf = str2;
        this.zzg = z11;
        this.zzh = str;
        this.zzi = zzw2;
        this.zzj = i11;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = zzcjf;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdmd;
    }

    public AdOverlayInfoParcel(zzbes zzbes, zzo zzo2, zzw zzw2, zzcop zzcop, int i11, zzcjf zzcjf, String str, zzj zzj2, String str2, String str3, String str4, zzdfe zzdfe) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzo2;
        this.zzd = zzcop;
        this.zzp = null;
        this.zze = null;
        this.zzf = str2;
        this.zzg = false;
        this.zzh = str3;
        this.zzi = null;
        this.zzj = i11;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = zzcjf;
        this.zzn = str;
        this.zzo = zzj2;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = str4;
        this.zzx = zzdfe;
        this.zzy = null;
    }

    public AdOverlayInfoParcel(zzbes zzbes, zzo zzo2, zzw zzw2, zzcop zzcop, boolean z11, int i11, zzcjf zzcjf, zzdmd zzdmd) {
        this.zza = null;
        this.zzb = zzbes;
        this.zzc = zzo2;
        this.zzd = zzcop;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z11;
        this.zzh = null;
        this.zzi = zzw2;
        this.zzj = i11;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = zzcjf;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdmd;
    }

    @SafeParcelable.Constructor
    public AdOverlayInfoParcel(@SafeParcelable.Param(id = 2) zzc zzc2, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) IBinder iBinder4, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) boolean z11, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) IBinder iBinder5, @SafeParcelable.Param(id = 11) int i11, @SafeParcelable.Param(id = 12) int i12, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) zzcjf zzcjf, @SafeParcelable.Param(id = 16) String str4, @SafeParcelable.Param(id = 17) zzj zzj2, @SafeParcelable.Param(id = 18) IBinder iBinder6, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 20) IBinder iBinder7, @SafeParcelable.Param(id = 21) IBinder iBinder8, @SafeParcelable.Param(id = 22) IBinder iBinder9, @SafeParcelable.Param(id = 23) IBinder iBinder10, @SafeParcelable.Param(id = 24) String str6, @SafeParcelable.Param(id = 25) String str7, @SafeParcelable.Param(id = 26) IBinder iBinder11, @SafeParcelable.Param(id = 27) IBinder iBinder12) {
        this.zza = zzc2;
        this.zzb = (zzbes) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcop) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbqt) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbqv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzf = str;
        this.zzg = z11;
        this.zzh = str2;
        this.zzi = (zzw) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzj = i11;
        this.zzk = i12;
        this.zzl = str3;
        this.zzm = zzcjf;
        this.zzn = str4;
        this.zzo = zzj2;
        this.zzq = str5;
        this.zzv = str6;
        this.zzr = (zzehh) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzs = (zzdyz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzt = (zzfio) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzu = (zzbv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder10));
        this.zzw = str7;
        this.zzx = (zzdfe) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder11));
        this.zzy = (zzdmd) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder12));
    }

    public AdOverlayInfoParcel(zzc zzc2, zzbes zzbes, zzo zzo2, zzw zzw2, zzcjf zzcjf, zzcop zzcop, zzdmd zzdmd) {
        this.zza = zzc2;
        this.zzb = zzbes;
        this.zzc = zzo2;
        this.zzd = zzcop;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzw2;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = zzcjf;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdmd;
    }

    public AdOverlayInfoParcel(zzo zzo2, zzcop zzcop, int i11, zzcjf zzcjf) {
        this.zzc = zzo2;
        this.zzd = zzcop;
        this.zzj = 1;
        this.zzm = zzcjf;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = null;
    }

    public AdOverlayInfoParcel(zzcop zzcop, zzcjf zzcjf, zzbv zzbv, zzehh zzehh, zzdyz zzdyz, zzfio zzfio, String str, String str2, int i11) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcop;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = i11;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = zzcjf;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzv = str2;
        this.zzr = zzehh;
        this.zzs = zzdyz;
        this.zzt = zzfio;
        this.zzu = zzbv;
        this.zzw = null;
        this.zzx = null;
        this.zzy = null;
    }
}
