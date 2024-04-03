package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;

final class zzdt extends zzdz {
    private final String zza;
    private final zzge<AutocompletePrediction> zzb;
    private final Place zzc;
    private final AutocompletePrediction zzd;
    private final Status zze;
    private final int zzf;

    public /* synthetic */ zzdt(int i11, String str, zzge zzge, Place place, AutocompletePrediction autocompletePrediction, Status status, zzds zzds) {
        this.zzf = i11;
        this.zza = str;
        this.zzb = zzge;
        this.zzc = place;
        this.zzd = autocompletePrediction;
        this.zze = status;
    }

    public final boolean equals(Object obj) {
        String str;
        zzge<AutocompletePrediction> zzge;
        Place place;
        AutocompletePrediction autocompletePrediction;
        Status status;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdz) {
            zzdz zzdz = (zzdz) obj;
            if (this.zzf != zzdz.zzf() || ((str = this.zza) != null ? !str.equals(zzdz.zze()) : zzdz.zze() != null) || ((zzge = this.zzb) != null ? !zzge.equals(zzdz.zzd()) : zzdz.zzd() != null) || ((place = this.zzc) != null ? !place.equals(zzdz.zzc()) : zzdz.zzc() != null) || ((autocompletePrediction = this.zzd) != null ? !autocompletePrediction.equals(zzdz.zzb()) : zzdz.zzb() != null) || ((status = this.zze) != null ? !status.equals(zzdz.zza()) : zzdz.zza() != null)) {
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
        int i15 = (this.zzf ^ 1000003) * 1000003;
        String str = this.zza;
        int i16 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i17 = (i15 ^ i11) * 1000003;
        zzge<AutocompletePrediction> zzge = this.zzb;
        if (zzge == null) {
            i12 = 0;
        } else {
            i12 = zzge.hashCode();
        }
        int i18 = (i17 ^ i12) * 1000003;
        Place place = this.zzc;
        if (place == null) {
            i13 = 0;
        } else {
            i13 = place.hashCode();
        }
        int i19 = (i18 ^ i13) * 1000003;
        AutocompletePrediction autocompletePrediction = this.zzd;
        if (autocompletePrediction == null) {
            i14 = 0;
        } else {
            i14 = autocompletePrediction.hashCode();
        }
        int i21 = (i19 ^ i14) * 1000003;
        Status status = this.zze;
        if (status != null) {
            i16 = status.hashCode();
        }
        return i21 ^ i16;
    }

    public final String toString() {
        String str;
        switch (this.zzf) {
            case 1:
                str = "START";
                break;
            case 2:
                str = "RESET";
                break;
            case 3:
                str = "LOADING";
                break;
            case 4:
                str = "TRY_AGAIN_PROGRESS_LOADING";
                break;
            case 5:
                str = "SUCCESS_PREDICTIONS";
                break;
            case 6:
                str = "FAILURE_NO_PREDICTIONS";
                break;
            case 7:
                str = "FAILURE_PREDICTIONS";
                break;
            case 8:
                str = "SUCCESS_SELECTION";
                break;
            case 9:
                str = "FAILURE_SELECTION";
                break;
            default:
                str = "FAILURE_UNRESOLVABLE";
                break;
        }
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String valueOf3 = String.valueOf(this.zzd);
        String valueOf4 = String.valueOf(this.zze);
        int length = str.length();
        int length2 = String.valueOf(str2).length();
        int length3 = valueOf.length();
        int length4 = valueOf2.length();
        StringBuilder sb2 = new StringBuilder(length + 76 + length2 + length3 + length4 + valueOf3.length() + valueOf4.length());
        sb2.append("AutocompleteState{type=");
        sb2.append(str);
        sb2.append(", query=");
        sb2.append(str2);
        sb2.append(", predictions=");
        sb2.append(valueOf);
        sb2.append(", place=");
        sb2.append(valueOf2);
        sb2.append(", prediction=");
        sb2.append(valueOf3);
        sb2.append(", status=");
        sb2.append(valueOf4);
        sb2.append("}");
        return sb2.toString();
    }

    @Nullable
    public final Status zza() {
        return this.zze;
    }

    @Nullable
    public final AutocompletePrediction zzb() {
        return this.zzd;
    }

    @Nullable
    public final Place zzc() {
        return this.zzc;
    }

    @Nullable
    public final zzge<AutocompletePrediction> zzd() {
        return this.zzb;
    }

    @Nullable
    public final String zze() {
        return this.zza;
    }

    public final int zzf() {
        return this.zzf;
    }
}
