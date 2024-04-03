package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzcgc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcgc> CREATOR = new zzcgd();
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @SafeParcelable.Field(id = 3)
    public final String zzb;
    @SafeParcelable.Field(id = 4)
    public final boolean zzc;
    @SafeParcelable.Field(id = 5)
    public final boolean zzd;
    @SafeParcelable.Field(id = 6)
    public final List<String> zze;
    @SafeParcelable.Field(id = 7)
    public final boolean zzf;
    @SafeParcelable.Field(id = 8)
    public final boolean zzg;
    @SafeParcelable.Field(id = 9)
    public final List<String> zzh;

    @SafeParcelable.Constructor
    public zzcgc(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z11, @SafeParcelable.Param(id = 5) boolean z12, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) boolean z13, @SafeParcelable.Param(id = 8) boolean z14, @SafeParcelable.Param(id = 9) List<String> list2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z11;
        this.zzd = z12;
        this.zze = list;
        this.zzf = z13;
        this.zzg = z14;
        this.zzh = list2 == null ? new ArrayList<>() : list2;
    }

    @Nullable
    public static zzcgc zza(JSONObject jSONObject) throws JSONException {
        return new zzcgc(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzby.zzc(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzby.zzc(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeStringList(parcel, 6, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
