package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();
    @SafeParcelable.VersionField(id = 1)
    final int zaa;
    private final HashMap zab;
    private final SparseArray zac;

    @KeepForSdk
    public StringToIntConverter() {
        this.zaa = 1;
        this.zab = new HashMap();
        this.zac = new SparseArray();
    }

    @NonNull
    @KeepForSdk
    @CanIgnoreReturnValue
    public StringToIntConverter add(@NonNull String str, int i11) {
        this.zab.put(str, Integer.valueOf(i11));
        this.zac.put(i11, str);
        return this;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zab.keySet()) {
            arrayList.add(new zac(str, ((Integer) this.zab.get(str)).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zaa() {
        return 7;
    }

    public final int zab() {
        return 0;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zac(@NonNull Object obj) {
        Integer num = (Integer) this.zab.get((String) obj);
        if (num == null) {
            return (Integer) this.zab.get("gms_unknown");
        }
        return num;
    }

    @NonNull
    public final /* bridge */ /* synthetic */ Object zad(@NonNull Object obj) {
        String str = (String) this.zac.get(((Integer) obj).intValue());
        if (str != null || !this.zab.containsKey("gms_unknown")) {
            return str;
        }
        return "gms_unknown";
    }

    @SafeParcelable.Constructor
    public StringToIntConverter(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) ArrayList arrayList) {
        this.zaa = i11;
        this.zab = new HashMap();
        this.zac = new SparseArray();
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            zac zac2 = (zac) arrayList.get(i12);
            add(zac2.zab, zac2.zac);
        }
    }
}
