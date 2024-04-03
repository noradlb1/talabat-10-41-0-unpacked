package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzces extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzces> CREATOR = new zzcet();
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @SafeParcelable.Field(id = 3)
    public final int zzb;

    @SafeParcelable.Constructor
    public zzces(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i11) {
        this.zza = str;
        this.zzb = i11;
    }

    @Nullable
    public static zzces zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzces(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzces)) {
            zzces zzces = (zzces) obj;
            if (!Objects.equal(this.zza, zzces.zza) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzces.zzb))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb));
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
