package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.internal.zzi;
import com.huawei.agconnect.credential.Server;
import com.huawei.hms.framework.common.ContainerUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@SafeParcelable.Class(creator = "VerifyAssertionRequestCreator")
@SafeParcelable.Reserved({1})
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaes  reason: invalid package */
public final class zzaes extends AbstractSafeParcelable implements zzaaz {
    public static final Parcelable.Creator<zzaes> CREATOR = new zzaet();
    @SafeParcelable.Field(getter = "getRequestUri", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "getCurrentIdToken", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getIdToken", id = 4)
    private String zzc;
    @SafeParcelable.Field(getter = "getAccessToken", id = 5)
    private String zzd;
    @SafeParcelable.Field(getter = "getProviderId", id = 6)
    private String zze;
    @SafeParcelable.Field(getter = "getEmail", id = 7)
    @Nullable
    private String zzf;
    @SafeParcelable.Field(getter = "getPostBody", id = 8)
    private String zzg;
    @SafeParcelable.Field(getter = "getOauthTokenSecret", id = 9)
    private String zzh;
    @SafeParcelable.Field(getter = "getReturnSecureToken", id = 10)
    private boolean zzi;
    @SafeParcelable.Field(getter = "getAutoCreate", id = 11)
    private boolean zzj;
    @SafeParcelable.Field(getter = "getAuthCode", id = 12)
    private String zzk;
    @SafeParcelable.Field(getter = "getSessionId", id = 13)
    private String zzl;
    @SafeParcelable.Field(getter = "getIdpResponseUrl", id = 14)
    private String zzm;
    @SafeParcelable.Field(getter = "getTenantId", id = 15)
    private String zzn;
    @SafeParcelable.Field(getter = "getReturnIdpCredential", id = 16)
    private boolean zzo;
    @SafeParcelable.Field(getter = "getPendingToken", id = 17)
    @Nullable
    private String zzp;

    public zzaes() {
        this.zzi = true;
        this.zzj = true;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.writeString(parcel, 17, this.zzp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("idToken", (Object) str);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            jSONObject.put("postBody", (Object) str2);
        }
        String str3 = this.zzn;
        if (str3 != null) {
            jSONObject.put("tenantId", (Object) str3);
        }
        String str4 = this.zzp;
        if (str4 != null) {
            jSONObject.put("pendingToken", (Object) str4);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            jSONObject.put("sessionId", (Object) this.zzl);
        }
        if (!TextUtils.isEmpty(this.zzm)) {
            jSONObject.put("requestUri", (Object) this.zzm);
        } else {
            String str5 = this.zza;
            if (str5 != null) {
                jSONObject.put("requestUri", (Object) str5);
            }
        }
        jSONObject.put("returnIdpCredential", this.zzo);
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public final zzaes zzb(boolean z11) {
        this.zzj = false;
        return this;
    }

    public final zzaes zzc(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzaes zzd(boolean z11) {
        this.zzo = true;
        return this;
    }

    public final zzaes zze(boolean z11) {
        this.zzi = true;
        return this;
    }

    public final zzaes zzf(@Nullable String str) {
        this.zzn = str;
        return this;
    }

    public zzaes(zzi zzi2, String str) {
        Preconditions.checkNotNull(zzi2);
        this.zzl = Preconditions.checkNotEmpty(zzi2.zzd());
        this.zzm = Preconditions.checkNotEmpty(str);
        String checkNotEmpty = Preconditions.checkNotEmpty(zzi2.zzc());
        this.zze = checkNotEmpty;
        this.zzi = true;
        this.zzg = "providerId=".concat(String.valueOf(checkNotEmpty));
    }

    public zzaes(@Nullable String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        this.zza = Server.GW;
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.zzd) || !TextUtils.isEmpty(this.zzk)) {
            this.zze = Preconditions.checkNotEmpty(str3);
            this.zzf = null;
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(this.zzc)) {
                sb2.append("id_token=");
                sb2.append(this.zzc);
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(this.zzd)) {
                sb2.append("access_token=");
                sb2.append(this.zzd);
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                sb2.append("identifier=");
                sb2.append(this.zzf);
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(this.zzh)) {
                sb2.append("oauth_token_secret=");
                sb2.append(this.zzh);
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(this.zzk)) {
                sb2.append("code=");
                sb2.append(this.zzk);
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(str9)) {
                sb2.append("nonce=");
                sb2.append(str9);
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb2.append("providerId=");
            sb2.append(this.zze);
            this.zzg = sb2.toString();
            this.zzj = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    @SafeParcelable.Constructor
    public zzaes(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) boolean z11, @SafeParcelable.Param(id = 11) boolean z12, @SafeParcelable.Param(id = 12) String str9, @SafeParcelable.Param(id = 13) String str10, @SafeParcelable.Param(id = 14) String str11, @SafeParcelable.Param(id = 15) String str12, @SafeParcelable.Param(id = 16) boolean z13, @SafeParcelable.Param(id = 17) String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z11;
        this.zzj = z12;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z13;
        this.zzp = str13;
    }
}
