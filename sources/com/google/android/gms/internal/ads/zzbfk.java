package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdValueParcelCreator")
@ParametersAreNonnullByDefault
public final class zzbfk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbfk> CREATOR = new zzbfl();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final int zzb;
    @SafeParcelable.Field(id = 3)
    public final String zzc;
    @SafeParcelable.Field(id = 4)
    public final long zzd;

    @SafeParcelable.Constructor
    public zzbfk(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) long j11) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = str;
        this.zzd = j11;
    }

    public static zzbfk zza(JSONObject jSONObject) throws JSONException {
        return new zzbfk(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
