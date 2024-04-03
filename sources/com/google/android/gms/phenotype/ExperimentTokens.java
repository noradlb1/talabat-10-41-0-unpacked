package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@KeepForSdk
@SafeParcelable.Class(creator = "ExperimentTokensCreator")
@SafeParcelable.Reserved({1})
public class ExperimentTokens extends AbstractSafeParcelable {
    @KeepForSdk
    public static final Parcelable.Creator<ExperimentTokens> CREATOR = new zzh();
    private static final zza zzaa = new zzg();
    private static final byte[][] zzn;
    private static final ExperimentTokens zzo;
    private static final zza zzx = new zzd();
    private static final zza zzy = new zze();
    private static final zza zzz = new zzf();
    @SafeParcelable.Field(id = 2)
    private final String zzp;
    @SafeParcelable.Field(id = 3)
    private final byte[] zzq;
    @SafeParcelable.Field(id = 4)
    private final byte[][] zzr;
    @SafeParcelable.Field(id = 5)
    private final byte[][] zzs;
    @SafeParcelable.Field(id = 6)
    private final byte[][] zzt;
    @SafeParcelable.Field(id = 7)
    private final byte[][] zzu;
    @SafeParcelable.Field(id = 8)
    private final int[] zzv;
    @SafeParcelable.Field(id = 9)
    private final byte[][] zzw;

    public interface zza {
    }

    static {
        byte[][] bArr = new byte[0][];
        zzn = bArr;
        zzo = new ExperimentTokens("", (byte[]) null, bArr, bArr, bArr, bArr, (int[]) null, (byte[][]) null);
    }

    @SafeParcelable.Constructor
    public ExperimentTokens(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) byte[][] bArr2, @SafeParcelable.Param(id = 5) byte[][] bArr3, @SafeParcelable.Param(id = 6) byte[][] bArr4, @SafeParcelable.Param(id = 7) byte[][] bArr5, @SafeParcelable.Param(id = 8) int[] iArr, @SafeParcelable.Param(id = 9) byte[][] bArr6) {
        this.zzp = str;
        this.zzq = bArr;
        this.zzr = bArr2;
        this.zzs = bArr3;
        this.zzt = bArr4;
        this.zzu = bArr5;
        this.zzv = iArr;
        this.zzw = bArr6;
    }

    private static List<Integer> zza(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<String> zza(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] encodeToString : bArr) {
            arrayList.add(Base64.encodeToString(encodeToString, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void zza(StringBuilder sb2, String str, byte[][] bArr) {
        String str2;
        sb2.append(str);
        sb2.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb2.append("(");
            int length = bArr.length;
            boolean z11 = true;
            int i11 = 0;
            while (i11 < length) {
                byte[] bArr2 = bArr[i11];
                if (!z11) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append("'");
                sb2.append(Base64.encodeToString(bArr2, 3));
                sb2.append("'");
                i11++;
                z11 = false;
            }
            str2 = ")";
        }
        sb2.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExperimentTokens) {
            ExperimentTokens experimentTokens = (ExperimentTokens) obj;
            return zzn.equals(this.zzp, experimentTokens.zzp) && Arrays.equals(this.zzq, experimentTokens.zzq) && zzn.equals(zza(this.zzr), zza(experimentTokens.zzr)) && zzn.equals(zza(this.zzs), zza(experimentTokens.zzs)) && zzn.equals(zza(this.zzt), zza(experimentTokens.zzt)) && zzn.equals(zza(this.zzu), zza(experimentTokens.zzu)) && zzn.equals(zza(this.zzv), zza(experimentTokens.zzv)) && zzn.equals(zza(this.zzw), zza(experimentTokens.zzw));
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("ExperimentTokens");
        sb2.append("(");
        String str2 = this.zzp;
        if (str2 == null) {
            str = "null";
        } else {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 2);
            sb3.append("'");
            sb3.append(str2);
            sb3.append("'");
            str = sb3.toString();
        }
        sb2.append(str);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        byte[] bArr = this.zzq;
        sb2.append(DevicePublicKeyStringDef.DIRECT);
        sb2.append("=");
        if (bArr == null) {
            sb2.append("null");
        } else {
            sb2.append("'");
            sb2.append(Base64.encodeToString(bArr, 3));
            sb2.append("'");
        }
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        zza(sb2, "GAIA", this.zzr);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        zza(sb2, "PSEUDO", this.zzs);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        zza(sb2, "ALWAYS", this.zzt);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        zza(sb2, "OTHER", this.zzu);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        int[] iArr = this.zzv;
        sb2.append("weak");
        sb2.append("=");
        if (iArr == null) {
            sb2.append("null");
        } else {
            sb2.append("(");
            int length = iArr.length;
            boolean z11 = true;
            int i11 = 0;
            while (i11 < length) {
                int i12 = iArr[i11];
                if (!z11) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(i12);
                i11++;
                z11 = false;
            }
            sb2.append(")");
        }
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        zza(sb2, "directs", this.zzw);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzp, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzq, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 4, this.zzr, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 5, this.zzs, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 6, this.zzt, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 7, this.zzu, false);
        SafeParcelWriter.writeIntArray(parcel, 8, this.zzv, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 9, this.zzw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
