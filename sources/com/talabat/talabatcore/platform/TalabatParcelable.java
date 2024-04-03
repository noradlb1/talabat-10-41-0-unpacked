package com.talabat.talabatcore.platform;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcore/platform/TalabatParcelable;", "Landroid/os/Parcelable;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatParcelable extends Parcelable {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int describeContents(@NotNull TalabatParcelable talabatParcelable) {
            return 0;
        }
    }

    int describeContents();

    void writeToParcel(@NotNull Parcel parcel, int i11);
}
