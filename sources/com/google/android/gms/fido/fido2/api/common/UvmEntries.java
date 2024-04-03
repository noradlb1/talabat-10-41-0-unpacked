package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SafeParcelable.Class(creator = "UvmEntriesCreator")
public class UvmEntries extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzaz();
    @SafeParcelable.Field(getter = "getUvmEntryList", id = 1)
    @Nullable
    private final List zza;

    public static final class Builder {
        private final List zza = new ArrayList();

        @NonNull
        public Builder addAll(@NonNull List<UvmEntry> list) {
            boolean z11;
            if (this.zza.size() + list.size() <= 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzam.zzc(z11);
            this.zza.addAll(list);
            return this;
        }

        @NonNull
        public Builder addUvmEntry(@Nullable UvmEntry uvmEntry) {
            if (this.zza.size() < 3) {
                this.zza.add(uvmEntry);
                return this;
            }
            throw new IllegalStateException();
        }

        @NonNull
        public UvmEntries build() {
            return new UvmEntries(this.zza);
        }
    }

    @SafeParcelable.Constructor
    public UvmEntries(@SafeParcelable.Param(id = 1) @Nullable List list) {
        this.zza = list;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        List list2 = this.zza;
        if ((list2 != null || uvmEntries.zza != null) && (list2 == null || (list = uvmEntries.zza) == null || !list2.containsAll(list) || !uvmEntries.zza.containsAll(this.zza))) {
            return false;
        }
        return true;
    }

    @Nullable
    public List<UvmEntry> getUvmEntryList() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(new HashSet(this.zza));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getUvmEntryList(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
