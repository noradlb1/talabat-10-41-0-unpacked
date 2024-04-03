package com.google.android.gms.fido.u2f.api.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fido.u2f.api.common.ChannelIdValue;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Deprecated
public class ClientData {
    @NonNull
    public static final String KEY_CHALLENGE = "challenge";
    @NonNull
    public static final String KEY_CID_PUBKEY = "cid_pubkey";
    @NonNull
    public static final String KEY_ORIGIN = "origin";
    @NonNull
    public static final String KEY_TYPE = "typ";
    @NonNull
    public static final String TYPE_FINISH_ENROLLMENT = "navigator.id.finishEnrollment";
    @NonNull
    public static final String TYPE_GET_ASSERTION = "navigator.id.getAssertion";
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final ChannelIdValue zzd;

    public static class Builder implements Cloneable {
        private String zza;
        private String zzb;
        private String zzc;
        private ChannelIdValue zzd;

        public Builder() {
            this.zzd = ChannelIdValue.ABSENT;
        }

        public Builder(String str, String str2, String str3, ChannelIdValue channelIdValue) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = channelIdValue;
        }

        @NonNull
        public static Builder newInstance() {
            return new Builder();
        }

        @NonNull
        public ClientData build() {
            return new ClientData(this.zza, this.zzb, this.zzc, this.zzd);
        }

        @NonNull
        public Builder clone() {
            return new Builder(this.zza, this.zzb, this.zzc, this.zzd);
        }

        @NonNull
        public Builder setChallenge(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder setChannelId(@NonNull ChannelIdValue channelIdValue) {
            this.zzd = channelIdValue;
            return this;
        }

        @NonNull
        public Builder setOrigin(@NonNull String str) {
            this.zzc = str;
            return this;
        }

        @NonNull
        public Builder setType(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    public ClientData(String str, String str2, String str3, ChannelIdValue channelIdValue) {
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = (String) Preconditions.checkNotNull(str2);
        this.zzc = (String) Preconditions.checkNotNull(str3);
        this.zzd = (ChannelIdValue) Preconditions.checkNotNull(channelIdValue);
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientData)) {
            return false;
        }
        ClientData clientData = (ClientData) obj;
        if (!this.zza.equals(clientData.zza) || !this.zzb.equals(clientData.zzb) || !this.zzc.equals(clientData.zzc) || !this.zzd.equals(clientData.zzd)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.zza.hashCode() + 31) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd.hashCode();
    }

    @NonNull
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_TYPE, (Object) this.zza);
            jSONObject.put(KEY_CHALLENGE, (Object) this.zzb);
            jSONObject.put("origin", (Object) this.zzc);
            ChannelIdValue.ChannelIdValueType channelIdValueType = ChannelIdValue.ChannelIdValueType.ABSENT;
            int ordinal = this.zzd.getType().ordinal();
            if (ordinal == 1) {
                jSONObject.put(KEY_CID_PUBKEY, (Object) this.zzd.getStringValue());
            } else if (ordinal == 2) {
                jSONObject.put(KEY_CID_PUBKEY, (Object) this.zzd.getObjectValue());
            }
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }
}
