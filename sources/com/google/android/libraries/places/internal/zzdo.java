package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

abstract class zzdo extends zzdx {
    private final AutocompleteActivityMode zza;
    private final zzge<Place.Field> zzb;
    private final zzdv zzc;
    private final String zzd;
    private final String zze;
    private final LocationBias zzf;
    private final LocationRestriction zzg;
    private final zzge<String> zzh;
    private final TypeFilter zzi;
    private final int zzj;
    private final int zzk;

    public zzdo(AutocompleteActivityMode autocompleteActivityMode, zzge<Place.Field> zzge, zzdv zzdv, @Nullable String str, @Nullable String str2, @Nullable LocationBias locationBias, @Nullable LocationRestriction locationRestriction, zzge<String> zzge2, @Nullable TypeFilter typeFilter, int i11, int i12) {
        if (autocompleteActivityMode != null) {
            this.zza = autocompleteActivityMode;
            if (zzge != null) {
                this.zzb = zzge;
                if (zzdv != null) {
                    this.zzc = zzdv;
                    this.zzd = str;
                    this.zze = str2;
                    this.zzf = locationBias;
                    this.zzg = locationRestriction;
                    if (zzge2 != null) {
                        this.zzh = zzge2;
                        this.zzi = typeFilter;
                        this.zzj = i11;
                        this.zzk = i12;
                        return;
                    }
                    throw new NullPointerException("Null countries");
                }
                throw new NullPointerException("Null origin");
            }
            throw new NullPointerException("Null placeFields");
        }
        throw new NullPointerException("Null mode");
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        LocationBias locationBias;
        LocationRestriction locationRestriction;
        TypeFilter typeFilter;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdx) {
            zzdx zzdx = (zzdx) obj;
            if (!this.zza.equals(zzdx.zzh()) || !this.zzb.equals(zzdx.zzj()) || !this.zzc.equals(zzdx.zzf()) || ((str = this.zzd) != null ? !str.equals(zzdx.zzl()) : zzdx.zzl() != null) || ((str2 = this.zze) != null ? !str2.equals(zzdx.zzk()) : zzdx.zzk() != null) || ((locationBias = this.zzf) != null ? !locationBias.equals(zzdx.zzc()) : zzdx.zzc() != null) || ((locationRestriction = this.zzg) != null ? !locationRestriction.equals(zzdx.zzd()) : zzdx.zzd() != null) || !this.zzh.equals(zzdx.zzi()) || ((typeFilter = this.zzi) != null ? !typeFilter.equals(zzdx.zze()) : zzdx.zze() != null) || this.zzj != zzdx.zza() || this.zzk != zzdx.zzb()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int hashCode = (((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003;
        String str = this.zzd;
        int i15 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i16 = (hashCode ^ i11) * 1000003;
        String str2 = this.zze;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = str2.hashCode();
        }
        int i17 = (i16 ^ i12) * 1000003;
        LocationBias locationBias = this.zzf;
        if (locationBias == null) {
            i13 = 0;
        } else {
            i13 = locationBias.hashCode();
        }
        int i18 = (i17 ^ i13) * 1000003;
        LocationRestriction locationRestriction = this.zzg;
        if (locationRestriction == null) {
            i14 = 0;
        } else {
            i14 = locationRestriction.hashCode();
        }
        int hashCode2 = (((i18 ^ i14) * 1000003) ^ this.zzh.hashCode()) * 1000003;
        TypeFilter typeFilter = this.zzi;
        if (typeFilter != null) {
            i15 = typeFilter.hashCode();
        }
        return ((((hashCode2 ^ i15) * 1000003) ^ this.zzj) * 1000003) ^ this.zzk;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        String valueOf3 = String.valueOf(this.zzc);
        String str = this.zzd;
        String str2 = this.zze;
        String valueOf4 = String.valueOf(this.zzf);
        String valueOf5 = String.valueOf(this.zzg);
        String valueOf6 = String.valueOf(this.zzh);
        String valueOf7 = String.valueOf(this.zzi);
        int i11 = this.zzj;
        int i12 = this.zzk;
        int length = valueOf.length();
        int length2 = valueOf2.length();
        int length3 = valueOf3.length();
        int length4 = String.valueOf(str).length();
        int length5 = String.valueOf(str2).length();
        int length6 = valueOf4.length();
        int length7 = valueOf5.length();
        StringBuilder sb2 = new StringBuilder(length + 189 + length2 + length3 + length4 + length5 + length6 + length7 + valueOf6.length() + valueOf7.length());
        sb2.append("AutocompleteOptions{mode=");
        sb2.append(valueOf);
        sb2.append(", placeFields=");
        sb2.append(valueOf2);
        sb2.append(", origin=");
        sb2.append(valueOf3);
        sb2.append(", initialQuery=");
        sb2.append(str);
        sb2.append(", hint=");
        sb2.append(str2);
        sb2.append(", locationBias=");
        sb2.append(valueOf4);
        sb2.append(", locationRestriction=");
        sb2.append(valueOf5);
        sb2.append(", countries=");
        sb2.append(valueOf6);
        sb2.append(", typeFilter=");
        sb2.append(valueOf7);
        sb2.append(", primaryColor=");
        sb2.append(i11);
        sb2.append(", primaryColorDark=");
        sb2.append(i12);
        sb2.append("}");
        return sb2.toString();
    }

    public final int zza() {
        return this.zzj;
    }

    public final int zzb() {
        return this.zzk;
    }

    @Nullable
    public final LocationBias zzc() {
        return this.zzf;
    }

    @Nullable
    public final LocationRestriction zzd() {
        return this.zzg;
    }

    @Nullable
    public final TypeFilter zze() {
        return this.zzi;
    }

    public final zzdv zzf() {
        return this.zzc;
    }

    public final zzdw zzg() {
        return new zzdn(this, (zzdm) null);
    }

    public final AutocompleteActivityMode zzh() {
        return this.zza;
    }

    public final zzge<String> zzi() {
        return this.zzh;
    }

    public final zzge<Place.Field> zzj() {
        return this.zzb;
    }

    @Nullable
    public final String zzk() {
        return this.zze;
    }

    @Nullable
    public final String zzl() {
        return this.zzd;
    }
}
