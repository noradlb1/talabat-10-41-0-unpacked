package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzapg implements Parcelable {
    public static final Parcelable.Creator<zzapg> CREATOR = new zzapf();
    private int zzA;
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final zzatr zzd;
    public final String zze;
    public final String zzf;
    public final int zzg;
    public final List<byte[]> zzh;
    public final zzarf zzi;
    public final int zzj;
    public final int zzk;
    public final float zzl;
    public final int zzm;
    public final float zzn;
    public final int zzo;
    public final byte[] zzp;
    public final zzaxe zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final int zzu;
    public final int zzv;
    public final long zzw;
    public final int zzx;
    public final String zzy;
    public final int zzz;

    public zzapg(Parcel parcel) {
        this.zza = parcel.readString();
        this.zze = parcel.readString();
        this.zzf = parcel.readString();
        this.zzc = parcel.readString();
        this.zzb = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzj = parcel.readInt();
        this.zzk = parcel.readInt();
        this.zzl = parcel.readFloat();
        this.zzm = parcel.readInt();
        this.zzn = parcel.readFloat();
        this.zzp = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzo = parcel.readInt();
        this.zzq = (zzaxe) parcel.readParcelable(zzaxe.class.getClassLoader());
        this.zzr = parcel.readInt();
        this.zzs = parcel.readInt();
        this.zzt = parcel.readInt();
        this.zzu = parcel.readInt();
        this.zzv = parcel.readInt();
        this.zzx = parcel.readInt();
        this.zzy = parcel.readString();
        this.zzz = parcel.readInt();
        this.zzw = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzh = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            this.zzh.add(parcel.createByteArray());
        }
        this.zzi = (zzarf) parcel.readParcelable(zzarf.class.getClassLoader());
        this.zzd = (zzatr) parcel.readParcelable(zzatr.class.getClassLoader());
    }

    public static zzapg zzg(String str, String str2, String str3, int i11, int i12, int i13, int i14, List<byte[]> list, zzarf zzarf, int i15, String str4) {
        return zzh(str, str2, (String) null, -1, -1, i13, i14, -1, -1, -1, (List<byte[]>) null, zzarf, 0, str4, (zzatr) null);
    }

    public static zzapg zzh(String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, int i16, int i17, List<byte[]> list, zzarf zzarf, int i18, String str4, zzatr zzatr) {
        return new zzapg(str, (String) null, str2, (String) null, -1, i12, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzaxe) null, i13, i14, i15, -1, -1, i18, str4, -1, Long.MAX_VALUE, list, zzarf, (zzatr) null);
    }

    public static zzapg zzi(String str, String str2, String str3, int i11, List<byte[]> list, String str4, zzarf zzarf) {
        return new zzapg(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzaxe) null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzarf, (zzatr) null);
    }

    public static zzapg zzj(String str, String str2, String str3, int i11, zzarf zzarf) {
        return new zzapg(str, (String) null, MimeTypes.APPLICATION_CAMERA_MOTION, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzaxe) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, zzarf, (zzatr) null);
    }

    public static zzapg zzk(String str, String str2, String str3, int i11, int i12, String str4, int i13, zzarf zzarf, long j11, List<byte[]> list) {
        return new zzapg(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzaxe) null, -1, -1, -1, -1, -1, i12, str4, -1, j11, list, zzarf, (zzatr) null);
    }

    public static zzapg zzl(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, int i15, float f12, byte[] bArr, int i16, zzaxe zzaxe, zzarf zzarf) {
        return new zzapg(str, (String) null, str2, (String) null, -1, i12, i13, i14, -1.0f, i15, f12, bArr, i16, zzaxe, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, list, zzarf, (zzatr) null);
    }

    @TargetApi(16)
    private static void zzm(MediaFormat mediaFormat, String str, int i11) {
        if (i11 != -1) {
            mediaFormat.setInteger(str, i11);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzapg.class == obj.getClass()) {
            zzapg zzapg = (zzapg) obj;
            if (this.zzb == zzapg.zzb && this.zzg == zzapg.zzg && this.zzj == zzapg.zzj && this.zzk == zzapg.zzk && this.zzl == zzapg.zzl && this.zzm == zzapg.zzm && this.zzn == zzapg.zzn && this.zzo == zzapg.zzo && this.zzr == zzapg.zzr && this.zzs == zzapg.zzs && this.zzt == zzapg.zzt && this.zzu == zzapg.zzu && this.zzv == zzapg.zzv && this.zzw == zzapg.zzw && this.zzx == zzapg.zzx && zzaxb.zzo(this.zza, zzapg.zza) && zzaxb.zzo(this.zzy, zzapg.zzy) && this.zzz == zzapg.zzz && zzaxb.zzo(this.zze, zzapg.zze) && zzaxb.zzo(this.zzf, zzapg.zzf) && zzaxb.zzo(this.zzc, zzapg.zzc) && zzaxb.zzo(this.zzi, zzapg.zzi) && zzaxb.zzo(this.zzd, zzapg.zzd) && zzaxb.zzo(this.zzq, zzapg.zzq) && Arrays.equals(this.zzp, zzapg.zzp) && this.zzh.size() == zzapg.zzh.size()) {
                for (int i11 = 0; i11 < this.zzh.size(); i11++) {
                    if (!Arrays.equals(this.zzh.get(i11), zzapg.zzh.get(i11))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = this.zzA;
        if (i17 != 0) {
            return i17;
        }
        String str = this.zza;
        int i18 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i19 = (i11 + 527) * 31;
        String str2 = this.zze;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = str2.hashCode();
        }
        int i21 = (i19 + i12) * 31;
        String str3 = this.zzf;
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = str3.hashCode();
        }
        int i22 = (i21 + i13) * 31;
        String str4 = this.zzc;
        if (str4 == null) {
            i14 = 0;
        } else {
            i14 = str4.hashCode();
        }
        int i23 = (((((((((((i22 + i14) * 31) + this.zzb) * 31) + this.zzj) * 31) + this.zzk) * 31) + this.zzr) * 31) + this.zzs) * 31;
        String str5 = this.zzy;
        if (str5 == null) {
            i15 = 0;
        } else {
            i15 = str5.hashCode();
        }
        int i24 = (((i23 + i15) * 31) + this.zzz) * 31;
        zzarf zzarf = this.zzi;
        if (zzarf == null) {
            i16 = 0;
        } else {
            i16 = zzarf.hashCode();
        }
        int i25 = (i24 + i16) * 31;
        zzatr zzatr = this.zzd;
        if (zzatr != null) {
            i18 = zzatr.hashCode();
        }
        int i26 = i25 + i18;
        this.zzA = i26;
        return i26;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zze;
        String str3 = this.zzf;
        int i11 = this.zzb;
        String str4 = this.zzy;
        int i12 = this.zzj;
        int i13 = this.zzk;
        float f11 = this.zzl;
        int i14 = this.zzr;
        int i15 = this.zzs;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb2 = new StringBuilder(length + 100 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb2.append("Format(");
        sb2.append(str);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str2);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str3);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i11);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str4);
        sb2.append(", [");
        sb2.append(i12);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i13);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(f11);
        sb2.append("], [");
        sb2.append(i14);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i15);
        sb2.append("])");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int i12;
        parcel.writeString(this.zza);
        parcel.writeString(this.zze);
        parcel.writeString(this.zzf);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzg);
        parcel.writeInt(this.zzj);
        parcel.writeInt(this.zzk);
        parcel.writeFloat(this.zzl);
        parcel.writeInt(this.zzm);
        parcel.writeFloat(this.zzn);
        if (this.zzp != null) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        parcel.writeInt(i12);
        byte[] bArr = this.zzp;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzo);
        parcel.writeParcelable(this.zzq, i11);
        parcel.writeInt(this.zzr);
        parcel.writeInt(this.zzs);
        parcel.writeInt(this.zzt);
        parcel.writeInt(this.zzu);
        parcel.writeInt(this.zzv);
        parcel.writeInt(this.zzx);
        parcel.writeString(this.zzy);
        parcel.writeInt(this.zzz);
        parcel.writeLong(this.zzw);
        int size = this.zzh.size();
        parcel.writeInt(size);
        for (int i13 = 0; i13 < size; i13++) {
            parcel.writeByteArray(this.zzh.get(i13));
        }
        parcel.writeParcelable(this.zzi, 0);
        parcel.writeParcelable(this.zzd, 0);
    }

    public final int zza() {
        int i11;
        int i12 = this.zzj;
        if (i12 == -1 || (i11 = this.zzk) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzb() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzf);
        String str = this.zzy;
        if (str != null) {
            mediaFormat.setString(ConstantsKt.ADJUST_LANGUAGE, str);
        }
        zzm(mediaFormat, "max-input-size", this.zzg);
        zzm(mediaFormat, "width", this.zzj);
        zzm(mediaFormat, "height", this.zzk);
        float f11 = this.zzl;
        if (f11 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f11);
        }
        zzm(mediaFormat, "rotation-degrees", this.zzm);
        zzm(mediaFormat, "channel-count", this.zzr);
        zzm(mediaFormat, "sample-rate", this.zzs);
        zzm(mediaFormat, "encoder-delay", this.zzu);
        zzm(mediaFormat, "encoder-padding", this.zzv);
        for (int i11 = 0; i11 < this.zzh.size(); i11++) {
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append("csd-");
            sb2.append(i11);
            mediaFormat.setByteBuffer(sb2.toString(), ByteBuffer.wrap(this.zzh.get(i11)));
        }
        zzaxe zzaxe = this.zzq;
        if (zzaxe != null) {
            zzm(mediaFormat, "color-transfer", zzaxe.zzc);
            zzm(mediaFormat, "color-standard", zzaxe.zza);
            zzm(mediaFormat, "color-range", zzaxe.zzb);
            byte[] bArr = zzaxe.zzd;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final zzapg zzc(zzarf zzarf) {
        String str = this.zza;
        return new zzapg(str, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, zzarf, this.zzd);
    }

    public final zzapg zzd(int i11, int i12) {
        String str = this.zza;
        return new zzapg(str, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, i11, i12, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, this.zzd);
    }

    public final zzapg zze(int i11) {
        String str = this.zza;
        return new zzapg(str, this.zze, this.zzf, this.zzc, this.zzb, i11, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, this.zzd);
    }

    public final zzapg zzf(zzatr zzatr) {
        String str = this.zza;
        return new zzapg(str, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, zzatr);
    }

    public zzapg(String str, String str2, String str3, String str4, int i11, int i12, int i13, int i14, float f11, int i15, float f12, byte[] bArr, int i16, zzaxe zzaxe, int i17, int i18, int i19, int i21, int i22, int i23, String str5, int i24, long j11, List<byte[]> list, zzarf zzarf, zzatr zzatr) {
        this.zza = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzc = str4;
        this.zzb = i11;
        this.zzg = i12;
        this.zzj = i13;
        this.zzk = i14;
        this.zzl = f11;
        this.zzm = i15;
        this.zzn = f12;
        this.zzp = bArr;
        this.zzo = i16;
        this.zzq = zzaxe;
        this.zzr = i17;
        this.zzs = i18;
        this.zzt = i19;
        this.zzu = i21;
        this.zzv = i22;
        this.zzx = i23;
        this.zzy = str5;
        this.zzz = i24;
        this.zzw = j11;
        this.zzh = list == null ? Collections.emptyList() : list;
        this.zzi = zzarf;
        this.zzd = zzatr;
    }
}
