package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzawc extends IOException {
    public final zzavy zza;

    public zzawc(IOException iOException, zzavy zzavy, int i11) {
        super(iOException);
        this.zza = zzavy;
    }

    public zzawc(String str, zzavy zzavy, int i11) {
        super(str);
        this.zza = zzavy;
    }

    public zzawc(String str, IOException iOException, zzavy zzavy, int i11) {
        super(str, iOException);
        this.zza = zzavy;
    }
}
