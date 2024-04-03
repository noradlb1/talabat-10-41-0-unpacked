package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SafeParcelable.Class(creator = "DefaultFirebaseUserCreator")
public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "getCachedTokenState", id = 1)
    private zzadr zza;
    @SafeParcelable.Field(getter = "getDefaultAuthUserInfo", id = 2)
    private zzt zzb;
    @SafeParcelable.Field(getter = "getFirebaseAppName", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getUserType", id = 4)
    private String zzd;
    @SafeParcelable.Field(getter = "getUserInfos", id = 5)
    private List zze;
    @SafeParcelable.Field(getter = "getProviders", id = 6)
    private List zzf;
    @SafeParcelable.Field(getter = "getCurrentVersion", id = 7)
    private String zzg;
    @SafeParcelable.Field(getter = "isAnonymous", id = 8)
    private Boolean zzh;
    @SafeParcelable.Field(getter = "getMetadata", id = 9)
    private zzz zzi;
    @SafeParcelable.Field(getter = "isNewUser", id = 10)
    private boolean zzj;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 11)
    private zze zzk;
    @SafeParcelable.Field(getter = "getMultiFactorInfoList", id = 12)
    private zzbd zzl;

    public zzx(FirebaseApp firebaseApp, List list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = ExifInterface.GPS_MEASUREMENT_2D;
        zzc(list);
    }

    public static FirebaseUser zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzx = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzx2 = (zzx) firebaseUser;
            zzx.zzg = zzx2.zzg;
            zzx.zzd = zzx2.zzd;
            zzx.zzi = zzx2.zzi;
        } else {
            zzx.zzi = null;
        }
        if (firebaseUser.zzd() != null) {
            zzx.zzh(firebaseUser.zzd());
        }
        if (!firebaseUser.isAnonymous()) {
            zzx.zzm();
        }
        return zzx;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Nullable
    public final String getEmail() {
        return this.zzb.getEmail();
    }

    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    public final /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Nullable
    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @NonNull
    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Nullable
    public final String getTenantId() {
        Map map;
        zzadr zzadr = this.zza;
        if (zzadr == null || zzadr.zze() == null || (map = (Map) zzba.zza(zzadr.zze()).getClaims().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @NonNull
    public final String getUid() {
        return this.zzb.getUid();
    }

    public final boolean isAnonymous() {
        String str;
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzadr zzadr = this.zza;
            if (zzadr != null) {
                str = zzba.zza(zzadr.zze()).getSignInProvider();
            } else {
                str = "";
            }
            boolean z11 = false;
            if (this.zze.size() <= 1 && (str == null || !str.equals("custom"))) {
                z11 = true;
            }
            this.zzh = Boolean.valueOf(z11);
        }
        return this.zzh.booleanValue();
    }

    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i11, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i11, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    public final /* bridge */ /* synthetic */ FirebaseUser zzb() {
        zzm();
        return this;
    }

    @NonNull
    public final synchronized FirebaseUser zzc(List list) {
        Preconditions.checkNotNull(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            UserInfo userInfo = (UserInfo) list.get(i11);
            if (userInfo.getProviderId().equals("firebase")) {
                this.zzb = (zzt) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzt) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = (zzt) this.zze.get(0);
        }
        return this;
    }

    @NonNull
    public final zzadr zzd() {
        return this.zza;
    }

    @NonNull
    public final String zze() {
        return this.zza.zze();
    }

    @NonNull
    public final String zzf() {
        return this.zza.zzh();
    }

    @Nullable
    public final List zzg() {
        return this.zzf;
    }

    public final void zzh(zzadr zzadr) {
        this.zza = (zzadr) Preconditions.checkNotNull(zzadr);
    }

    public final void zzi(List list) {
        Parcelable.Creator<zzbd> creator = zzbd.CREATOR;
        zzbd zzbd = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                    arrayList2.add((TotpMultiFactorInfo) multiFactorInfo);
                }
            }
            zzbd = new zzbd(arrayList, arrayList2);
        }
        this.zzl = zzbd;
    }

    @Nullable
    public final zze zzj() {
        return this.zzk;
    }

    public final zzx zzl(String str) {
        this.zzg = str;
        return this;
    }

    public final zzx zzm() {
        this.zzh = Boolean.FALSE;
        return this;
    }

    @Nullable
    public final List zzn() {
        zzbd zzbd = this.zzl;
        if (zzbd != null) {
            return zzbd.zza();
        }
        return new ArrayList();
    }

    public final List zzo() {
        return this.zze;
    }

    public final void zzp(@Nullable zze zze2) {
        this.zzk = zze2;
    }

    public final void zzq(boolean z11) {
        this.zzj = z11;
    }

    public final void zzr(zzz zzz) {
        this.zzi = zzz;
    }

    public final boolean zzs() {
        return this.zzj;
    }

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 1) zzadr zzadr, @SafeParcelable.Param(id = 2) zzt zzt, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) List list2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Boolean bool, @SafeParcelable.Param(id = 9) zzz zzz, @SafeParcelable.Param(id = 10) boolean z11, @SafeParcelable.Param(id = 11) zze zze2, @SafeParcelable.Param(id = 12) zzbd zzbd) {
        this.zza = zzadr;
        this.zzb = zzt;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzz;
        this.zzj = z11;
        this.zzk = zze2;
        this.zzl = zzbd;
    }
}
