package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.dataflow.qual.Pure;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@SafeParcelable.Class(creator = "LastLocationRequestCreator")
public final class LastLocationRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzv();
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getMaxUpdateAgeMillis", id = 1)
    private final long zza;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.location.Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 2)
    private final int zzb;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 3)
    private final boolean zzc;
    @SafeParcelable.Field(getter = "getModuleId", id = 4)
    @Nullable
    private final String zzd;
    @SafeParcelable.Field(getter = "getImpersonation", id = 5)
    @Nullable
    private final zzd zze;

    public static final class Builder {
        private long zza;
        private int zzb;
        private boolean zzc;
        @Nullable
        private String zzd;
        @Nullable
        private zzd zze;

        public Builder() {
            this.zza = Long.MAX_VALUE;
            this.zzb = 0;
            this.zzc = false;
            this.zzd = null;
            this.zze = null;
        }

        public Builder(@NonNull LastLocationRequest lastLocationRequest) {
            this.zza = lastLocationRequest.getMaxUpdateAgeMillis();
            this.zzb = lastLocationRequest.getGranularity();
            this.zzc = lastLocationRequest.zzc();
            this.zzd = lastLocationRequest.zzb();
            this.zze = lastLocationRequest.zza();
        }

        @NonNull
        public LastLocationRequest build() {
            return new LastLocationRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        @NonNull
        public Builder setGranularity(int i11) {
            zzo.zza(i11);
            this.zzb = i11;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateAgeMillis(long j11) {
            boolean z11;
            if (j11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "maxUpdateAgeMillis must be greater than 0");
            this.zza = j11;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public LastLocationRequest(@SafeParcelable.Param(id = 1) long j11, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) boolean z11, @SafeParcelable.Param(id = 4) @Nullable String str, @SafeParcelable.Param(id = 5) @Nullable zzd zzd2) {
        this.zza = j11;
        this.zzb = i11;
        this.zzc = z11;
        this.zzd = str;
        this.zze = zzd2;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        if (this.zza == lastLocationRequest.zza && this.zzb == lastLocationRequest.zzb && this.zzc == lastLocationRequest.zzc && Objects.equal(this.zzd, lastLocationRequest.zzd) && Objects.equal(this.zze, lastLocationRequest.zze)) {
            return true;
        }
        return false;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Boolean.valueOf(this.zzc));
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LastLocationRequest[");
        if (this.zza != Long.MAX_VALUE) {
            sb2.append("maxAge=");
            zzdj.zzb(this.zza, sb2);
        }
        if (this.zzb != 0) {
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(zzo.zzb(this.zzb));
        }
        if (this.zzc) {
            sb2.append(", bypass");
        }
        if (this.zzd != null) {
            sb2.append(", moduleId=");
            sb2.append(this.zzd);
        }
        if (this.zze != null) {
            sb2.append(", impersonation=");
            sb2.append(this.zze);
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    @Pure
    public final zzd zza() {
        return this.zze;
    }

    @Deprecated
    @Nullable
    @Pure
    public final String zzb() {
        return this.zzd;
    }

    @Pure
    public final boolean zzc() {
        return this.zzc;
    }
}
