package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@SafeParcelable.Class(creator = "GetTokenResponseCreator")
@SafeParcelable.Reserved({1})
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadr  reason: invalid package */
public final class zzadr extends AbstractSafeParcelable implements zzaba<zzadr> {
    public static final Parcelable.Creator<zzadr> CREATOR = new zzads();
    private static final String zza = "zzadr";
    @SafeParcelable.Field(getter = "getRefreshToken", id = 2)
    private String zzb;
    @SafeParcelable.Field(getter = "getAccessToken", id = 3)
    private String zzc;
    @SafeParcelable.Field(getter = "getExpiresIn", id = 4)
    private Long zzd;
    @SafeParcelable.Field(getter = "getTokenType", id = 5)
    private String zze;
    @SafeParcelable.Field(getter = "getIssuedAt", id = 6)
    private Long zzf;

    public zzadr() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    public static zzadr zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzadr zzadr = new zzadr();
            zzadr.zzb = jSONObject.optString("refresh_token", (String) null);
            zzadr.zzc = jSONObject.optString("access_token", (String) null);
            zzadr.zzd = Long.valueOf(jSONObject.optLong(AccessToken.EXPIRES_IN_KEY));
            zzadr.zze = jSONObject.optString("token_type", (String) null);
            zzadr.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzadr;
        } catch (JSONException e11) {
            throw new zzwh(e11);
        }
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLongObject(parcel, 4, Long.valueOf(zzb()), false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeLongObject(parcel, 6, Long.valueOf(this.zzf.longValue()), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("refresh_token"));
            this.zzc = Strings.emptyToNull(jSONObject.optString("access_token"));
            this.zzd = Long.valueOf(jSONObject.optLong(AccessToken.EXPIRES_IN_KEY, 0));
            this.zze = Strings.emptyToNull(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final long zzb() {
        Long l11 = this.zzd;
        if (l11 == null) {
            return 0;
        }
        return l11.longValue();
    }

    public final long zzc() {
        return this.zzf.longValue();
    }

    public final String zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zzb;
    }

    @Nullable
    public final String zzg() {
        return this.zze;
    }

    public final String zzh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", (Object) this.zzb);
            jSONObject.put("access_token", (Object) this.zzc);
            jSONObject.put(AccessToken.EXPIRES_IN_KEY, (Object) this.zzd);
            jSONObject.put("token_type", (Object) this.zze);
            jSONObject.put("issued_at", (Object) this.zzf);
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException e11) {
            throw new zzwh(e11);
        }
    }

    public final void zzi(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public final boolean zzj() {
        if (DefaultClock.getInstance().currentTimeMillis() + 300000 < this.zzf.longValue() + (this.zzd.longValue() * 1000)) {
            return true;
        }
        return false;
    }

    public zzadr(String str, String str2, Long l11, String str3) {
        this(str, str2, l11, str3, Long.valueOf(System.currentTimeMillis()));
    }

    @SafeParcelable.Constructor
    public zzadr(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) Long l11, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) Long l12) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l11;
        this.zze = str3;
        this.zzf = l12;
    }
}
