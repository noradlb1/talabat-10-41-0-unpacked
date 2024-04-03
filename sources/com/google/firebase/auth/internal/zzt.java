package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzadi;
import com.google.android.gms.internal.p002firebaseauthapi.zzadw;
import com.google.android.gms.internal.p002firebaseauthapi.zzwh;
import com.google.firebase.auth.UserInfo;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.visa.checkout.Profile;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@SafeParcelable.Class(creator = "DefaultAuthUserInfoCreator")
public final class zzt extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    @SafeParcelable.Field(getter = "getUid", id = 1)
    @NonNull
    private final String zza;
    @SafeParcelable.Field(getter = "getProviderId", id = 2)
    @NonNull
    private final String zzb;
    @SafeParcelable.Field(getter = "getDisplayName", id = 3)
    @Nullable
    private final String zzc;
    @SafeParcelable.Field(getter = "getPhotoUrlString", id = 4)
    @Nullable
    private String zzd;
    @Nullable
    private Uri zze;
    @SafeParcelable.Field(getter = "getEmail", id = 5)
    @Nullable
    private final String zzf;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 6)
    @Nullable
    private final String zzg;
    @SafeParcelable.Field(getter = "isEmailVerified", id = 7)
    private final boolean zzh;
    @SafeParcelable.Field(getter = "getRawUserInfo", id = 8)
    @Nullable
    private final String zzi;

    public zzt(zzadi zzadi, String str) {
        Preconditions.checkNotNull(zzadi);
        Preconditions.checkNotEmpty("firebase");
        this.zza = Preconditions.checkNotEmpty(zzadi.zzo());
        this.zzb = "firebase";
        this.zzf = zzadi.zzn();
        this.zzc = zzadi.zzm();
        Uri zzc2 = zzadi.zzc();
        if (zzc2 != null) {
            this.zzd = zzc2.toString();
            this.zze = zzc2;
        }
        this.zzh = zzadi.zzs();
        this.zzi = null;
        this.zzg = zzadi.zzp();
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzc;
    }

    @Nullable
    public final String getEmail() {
        return this.zzf;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Nullable
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzb;
    }

    @NonNull
    public final String getUid() {
        return this.zza;
    }

    public final boolean isEmailVerified() {
        return this.zzh;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzh);
        SafeParcelWriter.writeString(parcel, 8, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.zzi;
    }

    @Nullable
    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt(Profile.DISPLAY_NAME, this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException e11) {
            throw new zzwh(e11);
        }
    }

    public zzt(zzadw zzadw) {
        Preconditions.checkNotNull(zzadw);
        this.zza = zzadw.zzd();
        this.zzb = Preconditions.checkNotEmpty(zzadw.zzf());
        this.zzc = zzadw.zzb();
        Uri zza2 = zzadw.zza();
        if (zza2 != null) {
            this.zzd = zza2.toString();
            this.zze = zza2;
        }
        this.zzf = zzadw.zzc();
        this.zzg = zzadw.zze();
        this.zzh = false;
        this.zzi = zzadw.zzg();
    }

    @VisibleForTesting
    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Param(id = 1) @NonNull String str, @SafeParcelable.Param(id = 2) @NonNull String str2, @SafeParcelable.Param(id = 5) @Nullable String str3, @SafeParcelable.Param(id = 4) @Nullable String str4, @SafeParcelable.Param(id = 3) @Nullable String str5, @SafeParcelable.Param(id = 6) @Nullable String str6, @SafeParcelable.Param(id = 7) boolean z11, @SafeParcelable.Param(id = 8) @Nullable String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z11;
        this.zzi = str7;
    }
}
