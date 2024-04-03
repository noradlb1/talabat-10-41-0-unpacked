package com.google.firebase.auth;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.autofill.HintConstants;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzwh;
import com.visa.checkout.Profile;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "PhoneMultiFactorInfoCreator")
public class PhoneMultiFactorInfo extends MultiFactorInfo {
    @NonNull
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzas();
    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    @Nullable
    private final String zzb;
    @SafeParcelable.Field(getter = "getEnrollmentTimestamp", id = 3)
    private final long zzc;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    public PhoneMultiFactorInfo(@SafeParcelable.Param(id = 1) @NonNull String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) long j11, @SafeParcelable.Param(id = 4) @NonNull String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = j11;
        this.zzd = Preconditions.checkNotEmpty(str3);
    }

    @androidx.annotation.Nullable
    public String getDisplayName() {
        return this.zzb;
    }

    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    @NonNull
    public String getFactorId() {
        return "phone";
    }

    @NonNull
    public String getPhoneNumber() {
        return this.zzd;
    }

    @NonNull
    public String getUid() {
        return this.zza;
    }

    @androidx.annotation.Nullable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "phone");
            jSONObject.putOpt(PushNotificationParser.PUSH_ID_KEY, this.zza);
            jSONObject.putOpt(Profile.DISPLAY_NAME, this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zzd);
            return jSONObject;
        } catch (JSONException e11) {
            throw new zzwh(e11);
        }
    }

    @SuppressLint({"FirebaseUnknownNullness"})
    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeLong(parcel, 3, getEnrollmentTimestamp());
        SafeParcelWriter.writeString(parcel, 4, getPhoneNumber(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
