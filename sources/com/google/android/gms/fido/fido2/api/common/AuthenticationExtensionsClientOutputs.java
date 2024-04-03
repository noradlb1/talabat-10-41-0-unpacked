package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

@SafeParcelable.Class(creator = "AuthenticationExtensionsClientOutputsCreator")
public class AuthenticationExtensionsClientOutputs extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AuthenticationExtensionsClientOutputs> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getUvmEntries", id = 1)
    @Nullable
    private final UvmEntries zza;
    @SafeParcelable.Field(getter = "getDevicePubKey", id = 2)
    @Nullable
    private final zzf zzb;
    @SafeParcelable.Field(getter = "getCredProps", id = 3)
    @Nullable
    private final AuthenticationExtensionsCredPropsOutputs zzc;
    @SafeParcelable.Field(getter = "getPrf", id = 4)
    @Nullable
    private final zzh zzd;

    public static final class Builder {
        @Nullable
        private UvmEntries zza;
        @Nullable
        private AuthenticationExtensionsCredPropsOutputs zzb;

        @NonNull
        public AuthenticationExtensionsClientOutputs build() {
            return new AuthenticationExtensionsClientOutputs(this.zza, (zzf) null, this.zzb, (zzh) null);
        }

        @NonNull
        public Builder setCredProps(@Nullable AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs) {
            this.zzb = authenticationExtensionsCredPropsOutputs;
            return this;
        }

        @NonNull
        public Builder setUserVerificationMethodEntries(@Nullable UvmEntries uvmEntries) {
            this.zza = uvmEntries;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public AuthenticationExtensionsClientOutputs(@SafeParcelable.Param(id = 1) @Nullable UvmEntries uvmEntries, @SafeParcelable.Param(id = 2) @Nullable zzf zzf, @SafeParcelable.Param(id = 3) @Nullable AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs, @SafeParcelable.Param(id = 4) @Nullable zzh zzh) {
        this.zza = uvmEntries;
        this.zzb = zzf;
        this.zzc = authenticationExtensionsCredPropsOutputs;
        this.zzd = zzh;
    }

    @NonNull
    public static AuthenticationExtensionsClientOutputs deserializeFromBytes(@NonNull byte[] bArr) {
        return (AuthenticationExtensionsClientOutputs) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AuthenticationExtensionsClientOutputs)) {
            return false;
        }
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = (AuthenticationExtensionsClientOutputs) obj;
        if (!Objects.equal(this.zza, authenticationExtensionsClientOutputs.zza) || !Objects.equal(this.zzb, authenticationExtensionsClientOutputs.zzb) || !Objects.equal(this.zzc, authenticationExtensionsClientOutputs.zzc) || !Objects.equal(this.zzd, authenticationExtensionsClientOutputs.zzd)) {
            return false;
        }
        return true;
    }

    @Nullable
    public AuthenticationExtensionsCredPropsOutputs getCredProps() {
        return this.zzc;
    }

    @Nullable
    public UvmEntries getUvmEntries() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUvmEntries(), i11, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredProps(), i11, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
