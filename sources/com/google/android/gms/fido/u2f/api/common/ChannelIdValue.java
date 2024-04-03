package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@SafeParcelable.Class(creator = "ChannelIdValueCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class ChannelIdValue extends AbstractSafeParcelable {
    @NonNull
    public static final ChannelIdValue ABSENT = new ChannelIdValue();
    @NonNull
    public static final Parcelable.Creator<ChannelIdValue> CREATOR = new zzb();
    @NonNull
    public static final ChannelIdValue UNAVAILABLE = new ChannelIdValue("unavailable");
    @NonNull
    public static final ChannelIdValue UNUSED = new ChannelIdValue("unused");
    @SafeParcelable.Field(getter = "getTypeAsInt", id = 2, type = "int")
    private final ChannelIdValueType zza;
    @SafeParcelable.Field(getter = "getStringValue", id = 3)
    private final String zzb;
    @SafeParcelable.Field(getter = "getObjectValueAsString", id = 4)
    private final String zzc;

    public enum ChannelIdValueType implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);
        
        @NonNull
        public static final Parcelable.Creator<ChannelIdValueType> CREATOR = null;
        /* access modifiers changed from: private */
        public final int zzb;

        /* access modifiers changed from: public */
        static {
            CREATOR = new zza();
        }

        private ChannelIdValueType(int i11) {
            this.zzb = i11;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            parcel.writeInt(this.zzb);
        }
    }

    public static class UnsupportedChannelIdValueTypeException extends Exception {
        public UnsupportedChannelIdValueTypeException(int i11) {
            super(String.format("ChannelIdValueType %s not supported", new Object[]{Integer.valueOf(i11)}));
        }
    }

    private ChannelIdValue() {
        this.zza = ChannelIdValueType.ABSENT;
        this.zzc = null;
        this.zzb = null;
    }

    @NonNull
    public static ChannelIdValueType toChannelIdValueType(int i11) throws UnsupportedChannelIdValueTypeException {
        for (ChannelIdValueType channelIdValueType : ChannelIdValueType.values()) {
            if (i11 == channelIdValueType.zzb) {
                return channelIdValueType;
            }
        }
        throw new UnsupportedChannelIdValueTypeException(i11);
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelIdValue)) {
            return false;
        }
        ChannelIdValue channelIdValue = (ChannelIdValue) obj;
        if (!this.zza.equals(channelIdValue.zza)) {
            return false;
        }
        int ordinal = this.zza.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal == 1) {
            return this.zzb.equals(channelIdValue.zzb);
        }
        if (ordinal != 2) {
            return false;
        }
        return this.zzc.equals(channelIdValue.zzc);
    }

    @NonNull
    public JSONObject getObjectValue() {
        if (this.zzc == null) {
            return null;
        }
        try {
            return new JSONObject(this.zzc);
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }

    @NonNull
    public String getObjectValueAsString() {
        return this.zzc;
    }

    @NonNull
    public String getStringValue() {
        return this.zzb;
    }

    @NonNull
    public ChannelIdValueType getType() {
        return this.zza;
    }

    public int getTypeAsInt() {
        return this.zza.zzb;
    }

    public int hashCode() {
        int i11;
        int hashCode;
        int hashCode2 = this.zza.hashCode() + 31;
        int ordinal = this.zza.ordinal();
        if (ordinal == 1) {
            i11 = hashCode2 * 31;
            hashCode = this.zzb.hashCode();
        } else if (ordinal != 2) {
            return hashCode2;
        } else {
            i11 = hashCode2 * 31;
            hashCode = this.zzc.hashCode();
        }
        return i11 + hashCode;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getTypeAsInt());
        SafeParcelWriter.writeString(parcel, 3, getStringValue(), false);
        SafeParcelWriter.writeString(parcel, 4, getObjectValueAsString(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public ChannelIdValue(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        try {
            this.zza = toChannelIdValueType(i11);
            this.zzb = str;
            this.zzc = str2;
        } catch (UnsupportedChannelIdValueTypeException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    private ChannelIdValue(String str) {
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zza = ChannelIdValueType.STRING;
        this.zzc = null;
    }

    public ChannelIdValue(@NonNull JSONObject jSONObject) {
        this.zzc = (String) Preconditions.checkNotNull(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        this.zza = ChannelIdValueType.OBJECT;
        this.zzb = null;
    }
}
