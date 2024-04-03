package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserProfileChangeRequestCreator")
@SafeParcelable.Reserved({1})
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzaw();
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    @Nullable
    private final String zza;
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 3)
    @Nullable
    private final String zzb;
    @SafeParcelable.Field(getter = "shouldRemoveDisplayName", id = 4)
    private final boolean zzc;
    @SafeParcelable.Field(getter = "shouldRemovePhotoUri", id = 5)
    private final boolean zzd;
    @Nullable
    private final Uri zze;

    public static class Builder {
        @Nullable
        private String zza;
        @Nullable
        private Uri zzb;
        private boolean zzc;
        private boolean zzd;

        @NonNull
        public UserProfileChangeRequest build() {
            String str;
            String str2 = this.zza;
            Uri uri = this.zzb;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toString();
            }
            return new UserProfileChangeRequest(str2, str, this.zzc, this.zzd);
        }

        @KeepForSdk
        @Nullable
        public String getDisplayName() {
            return this.zza;
        }

        @KeepForSdk
        @Nullable
        public Uri getPhotoUri() {
            return this.zzb;
        }

        @NonNull
        public Builder setDisplayName(@Nullable String str) {
            if (str == null) {
                this.zzc = true;
            } else {
                this.zza = str;
            }
            return this;
        }

        @NonNull
        public Builder setPhotoUri(@Nullable Uri uri) {
            if (uri == null) {
                this.zzd = true;
            } else {
                this.zzb = uri;
            }
            return this;
        }
    }

    @SafeParcelable.Constructor
    public UserProfileChangeRequest(@SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) @Nullable String str2, @SafeParcelable.Param(id = 4) boolean z11, @SafeParcelable.Param(id = 5) boolean z12) {
        Uri uri;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z11;
        this.zzd = z12;
        if (TextUtils.isEmpty(str2)) {
            uri = null;
        } else {
            uri = Uri.parse(str2);
        }
        this.zze = uri;
    }

    @Nullable
    public String getDisplayName() {
        return this.zza;
    }

    @Nullable
    public Uri getPhotoUri() {
        return this.zze;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
