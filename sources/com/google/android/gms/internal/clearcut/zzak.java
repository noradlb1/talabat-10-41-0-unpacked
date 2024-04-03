package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzak extends zzae<String> {
    public zzak(zzao zzao, String str, String str2) {
        super(zzao, str, str2, (zzai) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.zzds, (String) null);
        } catch (ClassCastException e11) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid string value in SharedPreferences for ".concat(valueOf) : new String("Invalid string value in SharedPreferences for "), e11);
            return null;
        }
    }

    public final /* synthetic */ Object zzb(String str) {
        return str;
    }
}
