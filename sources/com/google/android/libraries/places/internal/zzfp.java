package com.google.android.libraries.places.internal;

import javax.annotation.CheckForNull;

abstract class zzfp extends zzex<String> {
    final CharSequence zzb;
    final zzfc zzc;
    int zzd = 0;
    int zze;

    public zzfp(zzfq zzfq, CharSequence charSequence) {
        this.zzc = zzfq.zza;
        this.zze = Integer.MAX_VALUE;
        this.zzb = "2.5.0";
    }

    @CheckForNull
    public final /* bridge */ /* synthetic */ Object zza() {
        int i11;
        int i12 = this.zzd;
        while (true) {
            int i13 = this.zzd;
            if (i13 != -1) {
                int zzd2 = zzd(i13);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zzd = -1;
                    i11 = -1;
                } else {
                    i11 = zzc(zzd2);
                    this.zzd = i11;
                }
                if (i11 == i12) {
                    int i14 = i11 + 1;
                    this.zzd = i14;
                    if (i14 > this.zzb.length()) {
                        this.zzd = -1;
                    }
                } else {
                    if (i12 < zzd2) {
                        this.zzb.charAt(i12);
                    }
                    if (i12 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    int i15 = this.zze;
                    if (i15 == 1) {
                        zzd2 = this.zzb.length();
                        this.zzd = -1;
                        if (zzd2 > i12) {
                            this.zzb.charAt(zzd2 - 1);
                        }
                    } else {
                        this.zze = i15 - 1;
                    }
                    return this.zzb.subSequence(i12, zzd2).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    public abstract int zzc(int i11);

    public abstract int zzd(int i11);
}
