package com.google.android.libraries.places.api.model;

import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

abstract class zze extends AutocompletePrediction {
    private final String zza;
    private final Integer zzb;
    private final List<Place.Type> zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final List<zzbb> zzg;
    private final List<zzbb> zzh;
    private final List<zzbb> zzi;

    public zze(String str, @Nullable Integer num, List<Place.Type> list, String str2, String str3, String str4, @Nullable List<zzbb> list2, @Nullable List<zzbb> list3, @Nullable List<zzbb> list4) {
        if (str != null) {
            this.zza = str;
            this.zzb = num;
            if (list != null) {
                this.zzc = list;
                if (str2 != null) {
                    this.zzd = str2;
                    if (str3 != null) {
                        this.zze = str3;
                        if (str4 != null) {
                            this.zzf = str4;
                            this.zzg = list2;
                            this.zzh = list3;
                            this.zzi = list4;
                            return;
                        }
                        throw new NullPointerException("Null secondaryText");
                    }
                    throw new NullPointerException("Null primaryText");
                }
                throw new NullPointerException("Null fullText");
            }
            throw new NullPointerException("Null placeTypes");
        }
        throw new NullPointerException("Null placeId");
    }

    public final boolean equals(Object obj) {
        Integer num;
        List<zzbb> list;
        List<zzbb> list2;
        List<zzbb> list3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutocompletePrediction) {
            AutocompletePrediction autocompletePrediction = (AutocompletePrediction) obj;
            if (!this.zza.equals(autocompletePrediction.getPlaceId()) || ((num = this.zzb) != null ? !num.equals(autocompletePrediction.getDistanceMeters()) : autocompletePrediction.getDistanceMeters() != null) || !this.zzc.equals(autocompletePrediction.getPlaceTypes()) || !this.zzd.equals(autocompletePrediction.zza()) || !this.zze.equals(autocompletePrediction.zzb()) || !this.zzf.equals(autocompletePrediction.zzc()) || ((list = this.zzg) != null ? !list.equals(autocompletePrediction.zzd()) : autocompletePrediction.zzd() != null) || ((list2 = this.zzh) != null ? !list2.equals(autocompletePrediction.zze()) : autocompletePrediction.zze() != null) || ((list3 = this.zzi) != null ? !list3.equals(autocompletePrediction.zzf()) : autocompletePrediction.zzf() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer getDistanceMeters() {
        return this.zzb;
    }

    public final String getPlaceId() {
        return this.zza;
    }

    public final List<Place.Type> getPlaceTypes() {
        return this.zzc;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int i13;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        Integer num = this.zzb;
        int i14 = 0;
        if (num == null) {
            i11 = 0;
        } else {
            i11 = num.hashCode();
        }
        int hashCode2 = (((((((((hashCode ^ i11) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003;
        List<zzbb> list = this.zzg;
        if (list == null) {
            i12 = 0;
        } else {
            i12 = list.hashCode();
        }
        int i15 = (hashCode2 ^ i12) * 1000003;
        List<zzbb> list2 = this.zzh;
        if (list2 == null) {
            i13 = 0;
        } else {
            i13 = list2.hashCode();
        }
        int i16 = (i15 ^ i13) * 1000003;
        List<zzbb> list3 = this.zzi;
        if (list3 != null) {
            i14 = list3.hashCode();
        }
        return i16 ^ i14;
    }

    public final String toString() {
        String str = this.zza;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String str2 = this.zzd;
        String str3 = this.zze;
        String str4 = this.zzf;
        String valueOf3 = String.valueOf(this.zzg);
        String valueOf4 = String.valueOf(this.zzh);
        String valueOf5 = String.valueOf(this.zzi);
        int length = str.length();
        int length2 = valueOf.length();
        int length3 = valueOf2.length();
        int length4 = str2.length();
        int length5 = str3.length();
        int length6 = str4.length();
        int length7 = valueOf3.length();
        int length8 = valueOf4.length();
        StringBuilder sb2 = new StringBuilder(length + Opcodes.MONITOREXIT + length2 + length3 + length4 + length5 + length6 + length7 + length8 + valueOf5.length());
        sb2.append("AutocompletePrediction{placeId=");
        sb2.append(str);
        sb2.append(", distanceMeters=");
        sb2.append(valueOf);
        sb2.append(", placeTypes=");
        sb2.append(valueOf2);
        sb2.append(", fullText=");
        sb2.append(str2);
        sb2.append(", primaryText=");
        sb2.append(str3);
        sb2.append(", secondaryText=");
        sb2.append(str4);
        sb2.append(", fullTextMatchedSubstrings=");
        sb2.append(valueOf3);
        sb2.append(", primaryTextMatchedSubstrings=");
        sb2.append(valueOf4);
        sb2.append(", secondaryTextMatchedSubstrings=");
        sb2.append(valueOf5);
        sb2.append("}");
        return sb2.toString();
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    @Nullable
    public final List<zzbb> zzd() {
        return this.zzg;
    }

    @Nullable
    public final List<zzbb> zze() {
        return this.zzh;
    }

    @Nullable
    public final List<zzbb> zzf() {
        return this.zzi;
    }
}
