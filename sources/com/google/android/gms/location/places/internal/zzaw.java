package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.places.zzbk;
import com.google.android.gms.internal.places.zzl;
import com.google.android.gms.internal.places.zzw;
import java.util.ArrayList;
import java.util.List;

public class zzaw extends DataBufferRef {
    public zzaw(DataHolder dataHolder, int i11) {
        super(dataHolder, i11);
    }

    private final byte[] zzb(String str, byte[] bArr) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getByteArray(str);
    }

    public final int zzc(String str, int i11) {
        return (!hasColumn(str) || hasNull(str)) ? i11 : getInteger(str);
    }

    public final float zzb(String str, float f11) {
        return (!hasColumn(str) || hasNull(str)) ? f11 : getFloat(str);
    }

    public final List<String> zzc(String str, List<String> list) {
        byte[] zzb = zzb(str, (byte[]) null);
        if (zzb == null) {
            return list;
        }
        try {
            zzl zzb2 = zzl.zzb(zzb);
            return zzb2.zzp() == 0 ? list : zzb2.zzo();
        } catch (zzbk e11) {
            if (Log.isLoggable("SafeDataBufferRef", 6)) {
                Log.e("SafeDataBufferRef", "Cannot parse byte[]", e11);
            }
            return list;
        }
    }

    public final List<Integer> zzb(String str, List<Integer> list) {
        byte[] zzb = zzb(str, (byte[]) null);
        if (zzb == null) {
            return list;
        }
        try {
            zzl zzb2 = zzl.zzb(zzb);
            return zzb2.zzr() == 0 ? list : zzb2.zzq();
        } catch (zzbk e11) {
            if (Log.isLoggable("SafeDataBufferRef", 6)) {
                Log.e("SafeDataBufferRef", "Cannot parse byte[]", e11);
            }
            return list;
        }
    }

    public final <E extends SafeParcelable> List<E> zzb(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] zzb = zzb(str, (byte[]) null);
        if (zzb == null) {
            return list;
        }
        try {
            zzl zzb2 = zzl.zzb(zzb);
            if (zzb2.zzt() == 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzb2.zzt());
            for (zzw byteArray : zzb2.zzs()) {
                arrayList.add(SafeParcelableSerializer.deserializeFromBytes(byteArray.toByteArray(), creator));
            }
            return arrayList;
        } catch (zzbk e11) {
            if (Log.isLoggable("SafeDataBufferRef", 6)) {
                Log.e("SafeDataBufferRef", "Cannot parse byte[]", e11);
            }
            return list;
        }
    }

    public final <E extends SafeParcelable> E zzb(String str, Parcelable.Creator<E> creator) {
        byte[] zzb = zzb(str, (byte[]) null);
        if (zzb == null) {
            return null;
        }
        return SafeParcelableSerializer.deserializeFromBytes(zzb, creator);
    }

    public final String zzb(String str, String str2) {
        return (!hasColumn(str) || hasNull(str)) ? str2 : getString(str);
    }
}
