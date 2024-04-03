package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultMultiFactorResolverCreator")
public final class zzae extends MultiFactorResolver {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfoList", id = 1)
    private final List zza;
    @SafeParcelable.Field(getter = "getSession", id = 2)
    private final zzag zzb;
    @SafeParcelable.Field(getter = "getFirebaseAppName", id = 3)
    private final String zzc;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 4)
    public final zze zzd;
    @SafeParcelable.Field(getter = "getReauthUser", id = 5)
    private final zzx zze;
    @SafeParcelable.Field(getter = "getTotpMultiFactorInfoList", id = 6)
    private final List zzf;

    @SafeParcelable.Constructor
    public zzae(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) zzag zzag, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) @Nullable zze zze2, @SafeParcelable.Param(id = 5) @Nullable zzx zzx, @SafeParcelable.Param(id = 6) List list2) {
        this.zza = (List) Preconditions.checkNotNull(list);
        this.zzb = (zzag) Preconditions.checkNotNull(zzag);
        this.zzc = Preconditions.checkNotEmpty(str);
        this.zzd = zze2;
        this.zze = zzx;
        this.zzf = (List) Preconditions.checkNotNull(list2);
    }

    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo add : this.zza) {
            arrayList.add(add);
        }
        for (TotpMultiFactorInfo add2 : this.zzf) {
            arrayList.add(add2);
        }
        return arrayList;
    }

    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    public final Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc)).zzj(multiFactorAssertion, this.zzb, this.zze).continueWithTask(new zzad(this));
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i11, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i11, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
