package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "DefaultFirebaseUserMetadataCreator")
public final class zzz implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    @SafeParcelable.Field(getter = "getLastSignInTimestamp", id = 1)
    private final long zza;
    @SafeParcelable.Field(getter = "getCreationTimestamp", id = 2)
    private final long zzb;

    @SafeParcelable.Constructor
    public zzz(@SafeParcelable.Param(id = 1) long j11, @SafeParcelable.Param(id = 2) long j12) {
        this.zza = j11;
        this.zzb = j12;
    }

    public final int describeContents() {
        return 0;
    }

    public final long getCreationTimestamp() {
        return this.zzb;
    }

    public final long getLastSignInTimestamp() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.zza);
            jSONObject.put("creationTimestamp", this.zzb);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
