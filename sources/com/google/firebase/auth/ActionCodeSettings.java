package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ActionCodeSettingsCreator")
public class ActionCodeSettings extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getUrl", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getIOSBundle", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getIOSAppStoreId", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getAndroidPackageName", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getAndroidInstallApp", id = 5)
    private final boolean zze;
    @SafeParcelable.Field(getter = "getAndroidMinimumVersion", id = 6)
    @Nullable
    private final String zzf;
    @SafeParcelable.Field(getter = "canHandleCodeInApp", id = 7)
    private final boolean zzg;
    @SafeParcelable.Field(getter = "getLocaleHeader", id = 8)
    private String zzh;
    @SafeParcelable.Field(getter = "getRequestType", id = 9)
    private int zzi;
    @SafeParcelable.Field(getter = "getDynamicLinkDomain", id = 10)
    private String zzj;

    public static class Builder {
        /* access modifiers changed from: private */
        public String zza;
        /* access modifiers changed from: private */
        public String zzb;
        /* access modifiers changed from: private */
        public String zzc;
        /* access modifiers changed from: private */
        public boolean zzd;
        /* access modifiers changed from: private */
        @Nullable
        public String zze;
        /* access modifiers changed from: private */
        public boolean zzf = false;
        /* access modifiers changed from: private */
        public String zzg;

        private Builder() {
        }

        public /* synthetic */ Builder(zza zza2) {
        }

        @NonNull
        public ActionCodeSettings build() {
            if (this.zza != null) {
                return new ActionCodeSettings(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        @NonNull
        @KeepForSdk
        public String getDynamicLinkDomain() {
            return this.zzg;
        }

        @KeepForSdk
        public boolean getHandleCodeInApp() {
            return this.zzf;
        }

        @KeepForSdk
        @Nullable
        public String getIOSBundleId() {
            return this.zzb;
        }

        @NonNull
        @KeepForSdk
        public String getUrl() {
            return this.zza;
        }

        @NonNull
        public Builder setAndroidPackageName(@NonNull String str, boolean z11, @Nullable String str2) {
            this.zzc = str;
            this.zzd = z11;
            this.zze = str2;
            return this;
        }

        @NonNull
        public Builder setDynamicLinkDomain(@NonNull String str) {
            this.zzg = str;
            return this;
        }

        @NonNull
        public Builder setHandleCodeInApp(boolean z11) {
            this.zzf = z11;
            return this;
        }

        @NonNull
        public Builder setIOSBundleId(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder setUrl(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    private ActionCodeSettings(Builder builder) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = null;
        this.zzd = builder.zzc;
        this.zze = builder.zzd;
        this.zzf = builder.zze;
        this.zzg = builder.zzf;
        this.zzj = builder.zzg;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder((zza) null);
    }

    @NonNull
    public static ActionCodeSettings zzb() {
        return new ActionCodeSettings(new Builder((zza) null));
    }

    public boolean canHandleCodeInApp() {
        return this.zzg;
    }

    public boolean getAndroidInstallApp() {
        return this.zze;
    }

    @Nullable
    public String getAndroidMinimumVersion() {
        return this.zzf;
    }

    @Nullable
    public String getAndroidPackageName() {
        return this.zzd;
    }

    @Nullable
    public String getIOSBundle() {
        return this.zzb;
    }

    @NonNull
    public String getUrl() {
        return this.zza;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUrl(), false);
        SafeParcelWriter.writeString(parcel, 2, getIOSBundle(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, getAndroidPackageName(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getAndroidInstallApp());
        SafeParcelWriter.writeString(parcel, 6, getAndroidMinimumVersion(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, canHandleCodeInApp());
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeString(parcel, 10, this.zzj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzi;
    }

    @NonNull
    public final String zzc() {
        return this.zzj;
    }

    @Nullable
    public final String zzd() {
        return this.zzc;
    }

    @NonNull
    public final String zze() {
        return this.zzh;
    }

    public final void zzf(@NonNull String str) {
        this.zzh = str;
    }

    public final void zzg(int i11) {
        this.zzi = i11;
    }

    @SafeParcelable.Constructor
    public ActionCodeSettings(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) boolean z11, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) boolean z12, @SafeParcelable.Param(id = 8) String str6, @SafeParcelable.Param(id = 9) int i11, @SafeParcelable.Param(id = 10) String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z11;
        this.zzf = str5;
        this.zzg = z12;
        this.zzh = str6;
        this.zzi = i11;
        this.zzj = str7;
    }
}
