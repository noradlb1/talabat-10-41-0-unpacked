package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@SafeParcelable.Class(creator = "FlagCreator")
@SafeParcelable.Reserved({1})
public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
    public static final Parcelable.Creator<zzi> CREATOR = new zzk();
    private static final Comparator<zzi> zzai = new zzj();
    @SafeParcelable.Field(id = 2)

    /* renamed from: name  reason: collision with root package name */
    public final String f44509name;
    @SafeParcelable.Field(id = 3)
    private final long zzab;
    @SafeParcelable.Field(id = 4)
    private final boolean zzac;
    @SafeParcelable.Field(id = 5)
    private final double zzad;
    @SafeParcelable.Field(id = 6)
    private final String zzae;
    @SafeParcelable.Field(id = 7)
    private final byte[] zzaf;
    @SafeParcelable.Field(id = 8)
    private final int zzag;
    @SafeParcelable.Field(id = 9)
    public final int zzah;

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j11, @SafeParcelable.Param(id = 4) boolean z11, @SafeParcelable.Param(id = 5) double d11, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) byte[] bArr, @SafeParcelable.Param(id = 8) int i11, @SafeParcelable.Param(id = 9) int i12) {
        this.f44509name = str;
        this.zzab = j11;
        this.zzac = z11;
        this.zzad = d11;
        this.zzae = str2;
        this.zzaf = bArr;
        this.zzag = i11;
        this.zzah = i12;
    }

    private static int compare(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 == i12 ? 0 : 1;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzi zzi = (zzi) obj;
        int compareTo = this.f44509name.compareTo(zzi.f44509name);
        if (compareTo != 0) {
            return compareTo;
        }
        int compare = compare(this.zzag, zzi.zzag);
        if (compare != 0) {
            return compare;
        }
        int i11 = this.zzag;
        if (i11 == 1) {
            int i12 = (this.zzab > zzi.zzab ? 1 : (this.zzab == zzi.zzab ? 0 : -1));
            if (i12 < 0) {
                return -1;
            }
            return i12 == 0 ? 0 : 1;
        } else if (i11 == 2) {
            boolean z11 = this.zzac;
            if (z11 == zzi.zzac) {
                return 0;
            }
            return z11 ? 1 : -1;
        } else if (i11 == 3) {
            return Double.compare(this.zzad, zzi.zzad);
        } else {
            if (i11 == 4) {
                String str = this.zzae;
                String str2 = zzi.zzae;
                if (str == str2) {
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                if (str2 == null) {
                    return 1;
                }
                return str.compareTo(str2);
            } else if (i11 == 5) {
                byte[] bArr = this.zzaf;
                byte[] bArr2 = zzi.zzaf;
                if (bArr == bArr2) {
                    return 0;
                }
                if (bArr == null) {
                    return -1;
                }
                if (bArr2 == null) {
                    return 1;
                }
                for (int i13 = 0; i13 < Math.min(this.zzaf.length, zzi.zzaf.length); i13++) {
                    int i14 = this.zzaf[i13] - zzi.zzaf[i13];
                    if (i14 != 0) {
                        return i14;
                    }
                }
                return compare(this.zzaf.length, zzi.zzaf.length);
            } else {
                int i15 = this.zzag;
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Invalid enum value: ");
                sb2.append(i15);
                throw new AssertionError(sb2.toString());
            }
        }
    }

    public final boolean equals(Object obj) {
        int i11;
        if (obj instanceof zzi) {
            zzi zzi = (zzi) obj;
            if (zzn.equals(this.f44509name, zzi.f44509name) && (i11 = this.zzag) == zzi.zzag && this.zzah == zzi.zzah) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return this.zzac == zzi.zzac;
                    }
                    if (i11 == 3) {
                        return this.zzad == zzi.zzad;
                    }
                    if (i11 == 4) {
                        return zzn.equals(this.zzae, zzi.zzae);
                    }
                    if (i11 == 5) {
                        return Arrays.equals(this.zzaf, zzi.zzaf);
                    }
                    int i12 = this.zzag;
                    StringBuilder sb2 = new StringBuilder(31);
                    sb2.append("Invalid enum value: ");
                    sb2.append(i12);
                    throw new AssertionError(sb2.toString());
                } else if (this.zzab == zzi.zzab) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Flag(");
        sb2.append(this.f44509name);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        int i11 = this.zzag;
        if (i11 == 1) {
            sb2.append(this.zzab);
        } else if (i11 == 2) {
            sb2.append(this.zzac);
        } else if (i11 != 3) {
            if (i11 == 4) {
                sb2.append("'");
                str = this.zzae;
            } else if (i11 != 5) {
                String str2 = this.f44509name;
                int i12 = this.zzag;
                StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 27);
                sb3.append("Invalid type: ");
                sb3.append(str2);
                sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb3.append(i12);
                throw new AssertionError(sb3.toString());
            } else if (this.zzaf == null) {
                sb2.append("null");
            } else {
                sb2.append("'");
                str = Base64.encodeToString(this.zzaf, 3);
            }
            sb2.append(str);
            sb2.append("'");
        } else {
            sb2.append(this.zzad);
        }
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.zzag);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.zzah);
        sb2.append(")");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f44509name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzab);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzac);
        SafeParcelWriter.writeDouble(parcel, 5, this.zzad);
        SafeParcelWriter.writeString(parcel, 6, this.zzae, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzaf, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzag);
        SafeParcelWriter.writeInt(parcel, 9, this.zzah);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
