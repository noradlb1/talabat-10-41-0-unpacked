package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
@ParametersAreNonnullByDefault
public final class zzcde extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcde> CREATOR = new zzcdf();
    @SafeParcelable.Field(id = 2)
    public final boolean zza;
    @SafeParcelable.Field(id = 3)
    @Nullable
    public final List<String> zzb;

    public zzcde() {
        this(false, Collections.emptyList());
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zza);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzcde(@SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) List<String> list) {
        this.zza = z11;
        this.zzb = list;
    }
}
