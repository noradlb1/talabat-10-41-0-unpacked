package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PublicKeyCredentialUserEntityCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialUserEntity> CREATOR = new zzar();
    @SafeParcelable.Field(getter = "getId", id = 2)
    @NonNull
    private final byte[] zza;
    @SafeParcelable.Field(getter = "getName", id = 3)
    @NonNull
    private final String zzb;
    @SafeParcelable.Field(getter = "getIcon", id = 4)
    @Nullable
    private final String zzc;
    @SafeParcelable.Field(getter = "getDisplayName", id = 5)
    @NonNull
    private final String zzd;

    @SafeParcelable.Constructor
    public PublicKeyCredentialUserEntity(@SafeParcelable.Param(id = 2) @NonNull byte[] bArr, @SafeParcelable.Param(id = 3) @NonNull String str, @SafeParcelable.Param(id = 4) @NonNull String str2, @SafeParcelable.Param(id = 5) @NonNull String str3) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zzc = str2;
        this.zzd = (String) Preconditions.checkNotNull(str3);
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        if (!Arrays.equals(this.zza, publicKeyCredentialUserEntity.zza) || !Objects.equal(this.zzb, publicKeyCredentialUserEntity.zzb) || !Objects.equal(this.zzc, publicKeyCredentialUserEntity.zzc) || !Objects.equal(this.zzd, publicKeyCredentialUserEntity.zzd)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getDisplayName() {
        return this.zzd;
    }

    @Nullable
    public String getIcon() {
        return this.zzc;
    }

    @NonNull
    public byte[] getId() {
        return this.zza;
    }

    @NonNull
    public String getName() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getIcon(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
